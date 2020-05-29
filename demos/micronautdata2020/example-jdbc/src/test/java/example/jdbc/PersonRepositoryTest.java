package example.jdbc;

import io.micronaut.context.BeanContext;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class PersonRepositoryTest {

    @Inject
    PersonRepository repository;

    @BeforeAll
    static void beforeAll(PersonRepository repository) {

        List<Person> people = Arrays.asList(
                new Person("Fred", 15),
                new Person("Bob", 25),
                new Person("Joe", 34),
                new Person("Jeff", 50),
                new Person("James", 30)
        );
        for (Person person : people) {
            repository.save(person);
        }
        repository.saveAll(people);
    }

    @Test
    void testCount() {
        assertEquals(
                5,
                repository.count()
        );

        AttributesDTO jeff = repository.findByName("Jeff");

        assertNotNull(jeff);
        assertEquals(Person.HairColor.BROWN, jeff.getHairColor());

    }
}
