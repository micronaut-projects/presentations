# Micronaut AOT Demos at Devnexus 2019

This project includes demo code for the Ahead of Time (AOT) compilation presentation given by Graeme Rocher at Devnexus 2019.

The `visitor` application includes a `AvroVisitor` that generates a schema for serialization of objects using [Avro](https://avro.apache.org), which is common in Kafka.

The `app` directory uses the `visitor` project to generate `.avro` files at compilation time.
