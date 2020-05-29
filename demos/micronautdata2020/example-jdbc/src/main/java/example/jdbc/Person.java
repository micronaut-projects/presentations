package example.jdbc;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class Person {

    @GeneratedValue
    @Id
    private Long id;

    private final String name;
    private final int age;
    private final HairColor hairColor;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.hairColor = HairColor.BROWN;
    }

    public Person(String name, int age, HairColor hairColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    enum HairColor {
        BLONDE,
        RED,
        BROWN
    }
}
