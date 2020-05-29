package example.jpa;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;

import javax.validation.constraints.NotBlank;

@Repository
public interface PersonRepository
        extends PageableRepository<Person, Long> {

    @Executable
    Person findByName(@NotBlank String name);
}
