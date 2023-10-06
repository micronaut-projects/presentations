package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.annotation.AvroEntity;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.inject.ast.ClassElement;
import io.micronaut.inject.ast.PropertyElement;
import io.micronaut.inject.visitor.TypeElementVisitor;
import io.micronaut.inject.visitor.VisitorContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvroVisitor implements TypeElementVisitor<AvroEntity, Object> {
    @Override
    public @NonNull VisitorKind getVisitorKind() {
        return VisitorKind.ISOLATING;
    }

    @Override
    public void visitClass(ClassElement element, VisitorContext context) {
        List<PropertyElement> beanProperties = element.getBeanProperties();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> avro;
        try {
            avro = Map.of(
                    "namespace", element.getPackage().getName(),
                    "type", "record",
                    "name", element.getSimpleName(),
                    "fields", beanProperties.stream().map(p -> Map.of(
                            "name", p.getName(),
                            "type", getType(p)
                    )).collect(Collectors.toList())
            );
        } catch (Exception e) {
            context.fail("Unsupported Avro: " + e.getMessage(), element);
            return;
        }

        context.visitMetaInfFile("avro/" + element.getSimpleName() + ".avro", element)
                .ifPresent(f -> {
                    try {
                        objectMapper.writeValue(f.openOutputStream(), avro);
                    } catch (IOException e) {
                        context.fail("Failed to write Avro: " + e.getMessage(), element);
                    }
                });
    }

    private String getType(PropertyElement propertyElement) {
        ClassElement type = propertyElement.getType();
        return switch (type.getSimpleName()) {
            case "int", "short", "byte" -> "int";
            case "String" -> "string";
            default -> throw new IllegalStateException("Unexpected value: " + type.getName());
        };
    }
}
