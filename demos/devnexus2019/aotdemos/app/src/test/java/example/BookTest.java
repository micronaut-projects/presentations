package example;


import io.micronaut.core.beans.BeanIntrospection;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void testBook() {
        BeanIntrospection<Book> introspection = BeanIntrospection.getIntrospection(Book.class);


        Set<String> annotationNames = introspection.getAnnotationNames();

        System.out.println("annotationNames = " + annotationNames);
    }
}
