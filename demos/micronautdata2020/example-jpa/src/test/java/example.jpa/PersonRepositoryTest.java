package example.jpa;

import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.inject.ExecutableMethod;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class PersonRepositoryTest {

    @Inject PersonRepository repository;

    @Inject
    BeanContext beanContext;

    @BeforeAll
    static void beforeAll(PersonRepository repository) {
        repository.saveAll(Arrays.asList(
                new Person("Fred", 15),
                new Person("Bob", 25),
                new Person("Joe", 34),
                new Person("Jeff", 50),
                new Person("James", 30)
        ));
    }

    @Test
    void testQuery() {
        BeanDefinition<PersonRepository> beanDefinition = beanContext.getBeanDefinition(PersonRepository.class);

        ExecutableMethod<PersonRepository, Object> method = beanDefinition.getRequiredMethod("findByName", String.class);


        String jpaQl = method
                .getAnnotationMetadata()
                .stringValue(Query.class).orElse(null);

        System.out.println("jpaQl = " + jpaQl);
    }

    @Test
    void testCount() {
        assertEquals(
                5,
                repository.count()
        );

        Person jeff = repository.findByName("Jeff");

        assertNotNull(jeff);
        assertEquals("Jeff", jeff.getName());

        Page<Person> page = repository.findAll(Pageable.from(1, 2));

        assertEquals(2, page.getContent().size());
    }
}
