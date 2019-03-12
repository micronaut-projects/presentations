package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.annotation.AvroEntity;
import io.micronaut.core.annotation.AnnotationMetadata;
import io.micronaut.core.annotation.AnnotationValueBuilder;
import io.micronaut.inject.ast.ClassElement;
import io.micronaut.inject.ast.PropertyElement;
import io.micronaut.inject.visitor.TypeElementVisitor;
import io.micronaut.inject.visitor.VisitorContext;
import io.micronaut.inject.writer.GeneratedFile;

import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.function.Consumer;

public class AvroVisitor
        implements TypeElementVisitor<AvroEntity, Object> {

    private static final Map<String, String> TYPE_MAP = new LinkedHashMap<>();

    static {
        TYPE_MAP.put(String.class.getName(), "string");
    }
    private Map<ClassElement, Map> generatedJson = new HashMap<>();

    @Override
    public void visitClass(
            ClassElement element,
            VisitorContext context) {

        context.info("Generating Avro for type", element);

        element.annotate(
                "data.Query");

        LinkedHashMap json = new LinkedHashMap();
        json.put("namespace", element.getPackageName());
        json.put("type", "record");
        json.put("name", element.getSimpleName());
        ArrayList<Object> fields = new ArrayList<>();
        json.put("fields", fields);

        List<PropertyElement> beanProperties = element.getBeanProperties();
        for (PropertyElement beanProperty : beanProperties) {
            LinkedHashMap<Object, Object> fieldData = new LinkedHashMap<>();
            fieldData.put("name", beanProperty.getName());
            if (beanProperty.getType().isPrimitive()) {
                fieldData.put("type", beanProperty.getType().getName());
            } else {
                String v = TYPE_MAP.get(beanProperty.getType().getName());
                if (v != null) {
                    fieldData.put("type", v);
                } else {
                    context.fail(
                            "Sorry but the following type is not supported by Avro: " + beanProperty.getType().getName(),
                            beanProperty
                    );
                }
            }
            fields.add(fieldData);
        }
        generatedJson.put(
                element,
                json
        );
    }

    @Override
    public void finish(VisitorContext visitorContext) {
        ObjectMapper objectMapper = new ObjectMapper();
        for (ClassElement classElement : generatedJson.keySet()) {
            Map map = generatedJson.get(classElement);
            Optional<GeneratedFile> generatedFile = visitorContext.visitMetaInfFile(classElement.getSimpleName() + ".avro");

            generatedFile.ifPresent(generatedFile1 -> {
                visitorContext.info("Generating file " + generatedFile1.getName(), classElement);
                try( Writer w = generatedFile1.openWriter()) {
                    objectMapper.writeValue(
                            w,
                            map
                    );
                } catch (IOException e) {
                    visitorContext.fail("Bad stuff happened : " + e.getMessage(), classElement);
                }
            });
        }
    }
}
