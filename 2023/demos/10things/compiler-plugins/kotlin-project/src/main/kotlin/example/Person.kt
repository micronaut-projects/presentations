package example

import example.annotation.AvroEntity

@AvroEntity
data class Person(val name: String, val age: Int)
