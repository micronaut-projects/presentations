package example.jdbc;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class AttributesDTO {

    private final Person.HairColor hairColor;
    private final int age;

    public AttributesDTO(Person.HairColor hairColor, int age) {
        this.hairColor = hairColor;
        this.age = age;
    }

    public Person.HairColor getHairColor() {
        return hairColor;
    }

    public int getAge() {
        return age;
    }
}
