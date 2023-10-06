package example;

import example.annotation.AvroEntity;

@AvroEntity
public record Person(String name, int age) {
}
