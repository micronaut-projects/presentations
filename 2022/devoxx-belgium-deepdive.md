theme: OCI White
slidenumbers: false
[.hide-footer]



<!-- ```
```
```
```
```
```
# [FIT] **Micronaut® 3 & GraalVM**
# [FIT] **Deep Dive**



```
``` -->
![fit](images/intro.png)

---


# About Me

* Graeme Rocher
* Architect at Oracle Labs since 2020
* Creator of Grails and the Micronaut framework
* 2018 Oracle Groundbreaker Award Winner
* https://twitter.com/graemerocher
* https://linkedin.com/in/graemerocher/

---


# Agenda

## Part 1 - 30 Minutes

* Introduction to the Micronaut framework & GraalVM
* Why the Micronaut framework
* The Micronaut Framework Fundamentals
* Micronaut Test
* Bean Introspection
* Dependency Injection
* Configuration Management


---


# Agenda

## Part 2 - 30 Minutes

* Micronaut AOP
* Bean Validation
* Bean Events and Listeners
* Micronaut HTTP Server
* Micronaut HTTP Client

---

# Agenda

## Part 3 - 30 Minutes

* GraalVM Reflection Configuration
* Micronaut Serialization
* Building a Runnable JAR
* Building a Native Image
* Building Docker Images
* Building OpenAPI Specifications

---


# Agenda

## Part 4 - 30 Minutes

* Micronaut Data
* Micronaut Test Resources
* Micronaut Data JPA
* Micronaut Data JDBC
* Micronaut Data R2DBC
* Summary and Q & A


---

# Part 1 - 30 Minutes

* Introduction to the Micronaut Framework & GraalVM
* Why the Micronaut Framework
* The Micronaut Framework Fundamentals
* Micronaut Test
* Bean Introspection
* Dependency Injection
* Configuration Management

----


# Java's Problems for Frameworks

* Limited Annotation API
* Type Erasure
* Slow Reflection (Fixed in latest JDKs)
* Reflective Data Caches
* Classpath Scanning
* Complex Dynamic Class Loading

![right](https://media3.giphy.com/media/dDCARfgGBQShq/giphy.gif?cid=790b7611b3cc1a79db27dfd49c6a4866a7308fb1555ba8e9&rid=giphy.gif)


----

# Why is Reflection a Problem?

* Today the JDK is OpenJDK!
* Just take a look...

> https://github.com/openjdk/jdk/blob/6ed74ef654f0b3e5c748895654d6925e2b832732/src/java.base/share/classes/java/lang/Class.java#L3302

* **All** Reflective data initialized on first access and held in soft references (yes every field, method etc.)
* Won't be GC'ed until your application is low on memory!

----

# Avoid Reflection!

* Reflection usage increases memory usage
* Scanning reflection data slow
* Many modern server-side frameworks and specifications
 are built on reflection
* Reflection requires extra GraalVM Native Image configuration

![right](https://media0.giphy.com/media/W4aKCI7mygvEQ/giphy.gif?cid=790b761196c0651be4ba29e250cd550f6a16f61685269e08&rid=giphy.gif)


----


# The Micronaut Framework

* The Micronaut framework is an Open Source Java framework that is focused on Modern architectures like Serverless and Microservices
* Also a Complete Application Framework for any type of Application
* A Java annotation processor computes your framework infrastructure at compile time
* HTTP Client/Server based on Netty
* Improved Developer Productivity when building Cloud Native applications



![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

----

# Micronaut Solutions


Problem|Solution
---|---|
Limited Annotation API | Precomputed `AnnotationMetadata`
Type Erasure | Precomputed `Argument` Interface
Slow Reflection | Eliminate Reflection
Reflective Data Caches | Zero Data Caches
Classpath Scanning | No Classpath Scanning
Slow Dynamic Class Loading | No Dynamic Class Loaders

----


# [FIT] The Future Is
# [FIT] Intelligent Compilers
## Smaller, Leaner Runtimes

----

# Introduction to GraalVM

* High-performance JDK distribution

* Increases application throughput, reduces latency, reduces memory use

* Graal just-in-time (JIT) compiler that runs on top of HotSpot, written in Java

* native-image ahead-of-time (AoT) compiler compiles Java applications into small self-contained native binaries



![right, 500%](https://www.graalvm.org/resources/img/graalvm.png)


----

# The Micronaut Framework + GraalVM

* The Micronaut Framework + GraalVM Native Image are a match made in heaven

* Less work to configure Native Image because Micronaut eliminates reflection, runtime proxies, byte code generation and dynamic classloading

* Startup time 20ms and Memory Consumption 20MB!



![right, 500%](https://www.graalvm.org/resources/img/graalvm.png)

----

# GraalVM Cloud Native

* A set of examples and best practices for building Cloud portable applications built on the Micronaut framework and GraalVM
* Tested and verified to work with GraalVM Native Image
* Multicloud by Design – deploy to any Cloud vendor without fear of Cloud lock-in
* Find out more https://developer.oracle.com/java/graalvm/cloud-native/



![right, 100%](images/gcn.png)

----

# [FIT] **DEMO**
## **Getting Started**

----


# Project Setup

* The Quick Way with Micronaut Launch! (https://start.micronaut.io/):

```bash
$ curl https://start.micronaut.io/demo.zip -o demo.zip
```
* Integrated wizards available for IntelliJ Ultimate and VSCode
* Command line utility also available


----


# Micronaut Test

* Testing library with support for Spock, JUnit 5 and Kotest

> https://github.com/micronaut-projects/micronaut-test

```groovy
testImplementation "io.micronaut.test:micronaut-test-junit5" // Gradle
```
```xml
<dependency> <!-- Maven -->
      <groupId>io.micronaut.test</groupId>
      <artifactId>micronaut-test-junit5</artifactId>
      <scope>test</scope>
</dependency>
      ...
```

----


# Micronaut Test

* Allows DI directly into your tests
* Spins up server if present

```java
@MicronautTest
class MathServiceTest {
    @Inject
    MathService mathService;

    @Test
    void testCompute() {
        final Integer result = mathService.compute(4);
        Assertions.assertEquals(16,result);
    }
}
```

----

# [FIT] **DEMO**
## **Bean Introspections**


----

# `@Introspected`

```java
@Introspected
class MyBean {
    private String name; //getter/setter omitted
}
```
* AOT Reflection-Free replacement for `java.beans.Introspector`
* Set/get bean properties, create instances
* Includes `AnnotationMetadata`
* Works with Java 17 records

----


# `@Introspected`

```groovy
BeanIntrospection<MyBean> bi =
	BeanIntrospection.getIntrospection(MyBean.class);
MyBean bean = bi.instantiate();
bi.getRequiredProperty("name")
   .set(bean, "Some Value");
```
* Read/Write bean properties without reflection
* The foundation for Micronaut Serialization, Micronaut Data etc.

----


# `AnnotationMetadata`

```java
AnnotationMetadata metadata = BeanIntrospection.getIntrospection(MyBean.class)
				 							   .getAnnotationMetadata();

if (metadata.hasStereotype(SomeAnnotation.class)) {
	// do stuff
}				 							   
```
* AOT Computed / Merged Annotation Replacement for Reflection based API
* Includes knowledge of meta-annotations

----


# `AnnotationMapper`

* Map the value of one annotation to another at compilation time

```java
class KotlinNullableMapper implements NamedAnnotationMapper {
    public String getName() {
        return "org.jetbrains.annotations.Nullable";
    }
    public List<AnnotationValue<?>> map(
    	AnnotationValue<Annotation> annotation,
    	VisitorContext visitorContext) {
        return Collections.singletonList(
        	AnnotationValue.builder("javax.annotation.Nullable").build()
    	);
    }
}		 							   
```

----


# [FIT] **DEMO**
## **Micronaut Annotation Metadata**


----

# `AnnotationMetadata` Why?

* All the `Nullable` annotations!!!
  - `javax.annotation.Nullable`, `org.jetbrains.annotations.Nullable`,
    `edu.umd.cs.findbugs.annotations.Nullable` etc.
* Support both `javax` and `jakarta` simultaneously
* Interpret Spring, CDI etc. annotations
* Decouple the source code annotations from the runtime

![right, 90%](https://i.imgur.com/0BpqqmW.gif)

----

# [FIT] **DEMO**
## **Micronaut Dependency Injection**

----

# Micronaut DI

```
@Inject MyBean myBean;
@Named("someOther") MyBean someOther;
```

* Supports and passes the `jakarta.inject` TCK
* Supports `@PostContruct` / `@PreDestroy`
* Completely reflection free and fast
* Constructor injection encouraged
* We are working on passing the CDI 4.0 lite support and passing the TCK

----


# `ApplicationContext`

```groovy
ApplicationContext ctx = ApplicationContext.run();

MyBean myBean
	= ctx.getBean(MyBean.class);
```

* Container object and entry point into the framework
* Objects retrieved from the `ApplicationContext` are dependency injected

----


# `@ConfigurationProperties`
### Type Safe Configuration

```java
@ConfigurationProperties("example")
record ExampleConfiguration(
	String name
) {}


ApplicationContext context = ApplicationContext.run("example.name":"Demo");
var config = context.getBean(ExampleConfiguration.class);
assert config.name() == 'Demo'
```

----

# `@Requires`
### Conditional Beans Made Easy

```java
@Requires(property="example.enabled")
@Requires(beans=DataSource.class)
@Requires(missingBeans=Example.class)
@Singleton
class DefaultExampleBean implements Example {
	...
}

var context = ApplicationContext.run("example.enabled":"true")
Example example = context.getBean(Example.class)
```

---

# Part 2 - 30 Minutes

* Micronaut AOP
* Bean Validation
* Bean Events and Listeners
* Micronaut HTTP Server
* Micronaut HTTP Client


![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)


---


# Micronaut AOP

* Aspect Oriented Programming Concepts (Interceptors)
* Designed to be reflection free
* No runtime generated proxies or byte code generation
* Fast and efficient thanks to smaller stack traces
* Allow for all the typical framework use cases:
	`@Transactional`, `@Cacheable`, `@Validated` etc.


![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

----


# `@Executable`

```java
@Executable
void someMethod() {
    ...
}
```
* Replacement for `java.lang.reflect.Method`
* Only generate method handles where needed


```java
return beanDefinition.getRequiredMethod("someMethod")
   .invoke(someBean);
```
----



# Micronaut AOP
## Annotation Stereotypes

* `@Around` - Allows decorating a method by **surrounding** it with new behaviour (caching, transactions etc.)
* `@Introduction` - Allows **introducing** new behaviour to existing classes and interfaces
* `@Adapter` - Allows **adapting** a method to a Single Abstract Method (SAM) type.

<!-- ----




# [FIT] **DEMO**
## **Micronaut Around Advice** -->

----


# `@Around`

```java
@Retryable // @Retryable is annotated with @Around
void invokeMe() {
    // do stuff
}
```
* Intercepts a method with a `MethodInterceptor`
* No runtime proxies (compile time proxies) or reflection needed
* No `FancyProxyFactoryBean` or EE containers needed!

----



# `@Around`

```java
@Around
public @interface Retryable {
	// annotation attributes
}
```
* Meta-annotate an annotation with `@Around`

```java
@InterceptorBean(Retryable.class)
class DefaultRetryInterceptor implements MethodInterceptor<Object, Object> {}
```

* Define one or more `MethodInterceptor` beans that intercept the method execution

<!-- ----



# [FIT] **DEMO**
## **Micronaut Introduction Advice** -->

----



# `@Introduction`

```java
@Client("/hello") // @Client is annotated with @Introduction
public interface HelloClient {

    @Get("/")
    Single hello();
}

```
* Introduction AOP advise implements abstract behaviour
* Interfaces or abstract classes

----



# `@Introduction`

```groovy
@Introduction
public @interface Client {
}
```

```java
@InterceptorBean(Client.class)
class HttpClientIntroductionAdvice
    implements MethodInterceptor<Object, Object> {}
```

* `@Introduction` as a meta-annotation on the annotation you want to introduce behaviour
* Implement a `MethodInterceptor` that binds to the annotation

<!-- ----


# [FIT] **DEMO**
## **Micronaut Bean Validation** -->

---


# Micronaut Validation

* Support for `javax.vallidation` annotations (soon moving to `jakarta` in 4.0)
* Partial implementation of spec without the parts that require reflection
* We hope the spec evolves to decouple from reflection
* Reuses Bean Introspections to save memory


![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

----



# `@Validated`

```java
import javax.validation.constraints.NotBlank;

@Singleton
public class PersonService {
    public void sayHello(@NotBlank String name) {
        System.out.println("Hello " + name);
    }
}
```
* `@Validated` AOP advice implicitly added to any bean that uses `javax.validation`.

----



# Other Advice Types

* `@Cacheable` - cache operations (support for Redis, in-memory etc.)
* `@Transactional` - uses standard `javax.transactional` (`jakarta` namespace support coming soon)
* `@Retryable` - Built in retry support
* `@Circuit Ter` - Circuit breaker pattern
* `@Async` - Makes events execute asynchronously


---



# Micronaut Runtimes

Dependency|Runtime
---|---|
`micronaut-http-server-netty` | Default Netty Server
`micronaut-kafka` | Kafka Headless Server
`micronaut-picocli` | PicoCLI command line app
`micronaut-grpc` | gRPC Server
`micronaut-graphql` | GraphQL Server
`micronaut-ktor` | Kotlin KTOR Framework support
`micronaut-function-aws-api-proxy` | AWS Lambda

---



# Micronaut HTTP Server

* Default Netty-based Reactive Server
* Support for both blocking and non-blocking I/O
* Choose your reactive framework: RxJava2, Reactor etc.
* Any annotation model: Micronaut, Spring, JAX-RS
* Support for Jackson or Micronaut Serialization for JSON serialization/deserialization

![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)


----



# [FIT] **DEMO**
## **Micronaut HTTP Server**


----



# `EmbeddedServer`

```java
try( EmbeddedServer embeddedServer
    = ApplicationContext.run(EmbeddedServer.class) ) {
    System.out.println(embeddedServer.getPort());
}

```
* The `EmbeddedServer` interface allows easily spinning up the server
programmatically or in tests.

----



# Controller Hello World

```java
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Controller("/hello")
public class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }
}
```
* Use annotations in the `io.micronaut.http.annotation` package


----



# [FIT] **DEMO**
## **Micronaut HTTP Client**

---



# Micronaut HTTP Client

* Netty-Based HTTP Client
* Low-level API and declarative compile-time client
* Uses `@Introduction` advice to simplify writing clients
* Reactive, CompletableFuture and blocking support
* Built in Service Discovery support

![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

----

# Client Hello World

```java
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Client("/hello")
public interface HelloClient {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String hello();
}
```
* Use annotations in the `io.micronaut.http.annotation` package

----

# Micronaut + Observability

* Simply add `micronaut-management`

Endpoint|Description
---|---|
`/info` | Basic information about the app
`/health` | Health Check support
`/loggers` | View and Mutate log config
`/metrics` | Metrics with Micrometer
`/env` | Resolved configuration
`/refresh` | Refresh the app state
`/routes` | View active routes

----

# Micronaut + Observability

* Tracing - support for Zipkin, Open Telemetry, Open Tracing and more
  http://github.com/micronaut-projects/micronaut-tracing
* Metrics - support for Micrometer, prometheus and more
  http://github.com/micronaut-projects/micronaut-micrometer


----

# Micronaut + Cloud Native

* Micronaut provides Cloud portable abstractions for Secrets, distributed config, Object Storage etc.
* AWS - https://github.com/micronaut-projects/micronaut-aws
* GCP - https://github.com/micronaut-projects/micronaut-gcp
* Azure - https://github.com/micronaut-projects/micronaut-azure
* Oracle Cloud - https://github.com/micronaut-projects/micronaut-oracle-cloud


----

# Part 3 - 30 Minutes

* JSON serialization and deserialization
* GraalVM Reflection Configuration
* Micronaut Serialization
* Building a Runnable JAR
* Building a Native Image
* Building Docker Images
* Building OpenAPI Specifications

![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)



---

# Micronaut Serialization

* Build Time replacement for Jackson that eliminates reflection
* Supports most Jackson annotations
* Reduces memory footprint
* More secure as doesn't allow abitrary serialization of objects
* Automatically compatible with Native Image

    - https://micronaut-projects.github.io/micronaut-serialization/latest/guide/


----



# [FIT] **DEMO**
## **Micronaut Serialization**


----

# Micronaut Serialization

```java
import io.micronaut.serde.annotation.Serdeable;
@Serdeable
public record Person(
    String name,
    int age) {
}
```

* Annotate types you want to allow to be serialized or deserialized
* Use annotation API you prefer (Jackson Annotations or JSON-B)
* Use runtime you prefer (Jackson Parser or JSON-P)


----



# Building Native Images with GraalVM

Using Gradle...

```bash
./gradlew nativeCompile # compile a native image
./gradlew nativeTest # compile JUnit 5 unit tests natively and run them
./gradlew dockerBuildNative # build a docker image natively
./gradlew dockerPushNative # Push a native docker image
```

Using Maven...

```bash
./mvnw package -Dpackaging=native-image # compile a native image
./mvnw package -Dpackaging=docker-native # build a docker image natively
./mvnw deploy -Dpackaging=docker-native # push a native docker image
```

----



# [FIT] **DEMO**
## **Micronaut + GraalVM**




----


# Micronaut Startup and Memory


Runtime|Memory|Startup
---|---|---|
JDK 17 | 75MB | 650ms (Linux)
JDK 17 + CDS | 75MB | 400ms (Linux)    
GraalVM Native Image | 25MB | 22ms (Linux)   
GraalVM Native Image + Micronaut AOT | 25MB | 7ms (Linux)   


----

# Dealing with Missng Reflection Data

```java
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.http.annotation.TypeHint;

@ReflectiveAccess
@TypeHint(Foo.class)
public class MyType {
}
```

* Use annotations like `@ReflectiveAccess` or `@TypeHint` to declare missing reflection data
* Alternatively, run the tracing agent to generate configuration https://www.graalvm.org/22.1/reference-manual/native-image/Agent/


----

# Micronaut AOT

* Additional closed world optimizations for Micronaut
* Convert YAML to Java (eliminate SnakeYAML)
* Remove unused Beans
* Cache environment
* Convert Log4j XML to Java code (eliminate XML parser)
* https://github.com/micronaut-projects/micronaut-aot

----



# [FIT] **DEMO**
## **Micronaut OpenAPI**

----



# Micronaut OpenAPI Setup

* Just another annotation processor extension

```groovy
annotationProcessor "io.micronaut.configuration:micronaut-openapi" // Gradle
```
```xml
<annotationProcessorPaths> <!-- Maven -->
      <path>
        <groupId>io.micronaut.configuration</groupId>
        <artifactId>micronaut-openapi</artifactId>
        <version>${micronaut.openapi.version}</version>
      </path>
      ...
```

---




# Micronaut OpenAPI

* Produces `swagger.yml` at compilation time
* Easy to expose this static file to Swagger UI.
* Doing the work at compilation time == less memory consumption
* Uses Micronaut's compilation time APIs

![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

---



# Part 4 - 30 Minutes

* Micronaut Data
* Micronaut Test Resources
* Micronaut Data JPA
* Micronaut Data JDBC
* Micronaut Data R2DBC
* Summary and Q & A

![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

----



# Existing Data Access Solutions

* Spring Data, GORM etc.
* Rely heavily on reflection and runtime proxies
* Must compute queries at runtime
* Cost of computation grows as your application grows


----



# Micronaut Data

* Precomputes Queries at compilation time
* Uses Micronaut's reflection-free AOP
* Zero runtime overhead database access solution
* Compilation time checking
* Smaller stack traces


![right, 35%](https://micronaut.io/wp-content/uploads/2020/11/MIcronautLogo_Horizontal.svg)

---

# Micronaut Data

* Many different implementations available dependencing on requirements
* Micronaut Data JPA  (Hibernate)
* Micronaut Data JDBC (Synchronous)
* Micronaut Data R2DBC (Reactive)
* Micronaut Data MongoDB (built on Micronaut Serialization)
* Micronaut Data Oracle Coherence

    - https://micronaut-projects.github.io/micronaut-data/latest/guide/


---

# Micronaut Test Resources

* Testcontainers integration for automatic container provisioning
  https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/
* Gradle and Maven plugins that spin up a separate server to host containers
* Allows easy integration testing and reuse of containers with shared server
* Support for all major databases
* Supports automatic restarts without restarting the containers

----



# [FIT] **DEMO**
## **Micronaut Data**


----
# Hello Micronaut Data



[.hide-footer]

* Each repository interface annotated with `@JdbcRepository`
* Can extend built in interfacesl like `CrudRepository`

```java
@JdbcRepository(dialect=Dialect.MYSQL)
interface PersonRepository
	extends CrudRepository<Person,Long> {
    Person findByName(String name);
}

```

----
# CRUD Example



```java
// Create
personRepository.save(new Person("Fred"));

// Read
Person person = personRepository.findByName("Fred");

// Update
person.updatePerson(person.getId(), "Bob");

// deleteById
person.deleteById(person.getId());

```

----
# More Guides on Micronaut Data

* Access a Database with Micronaut Data JDBC - https://guides.micronaut.io/latest/micronaut-data-jdbc-repository.html
* Access a Database with Micronaut Data JPA - https://guides.micronaut.io/latest/micronaut-jpa-hibernate.html
* Access a Database with Micronaut Data MongoDB - https://guides.micronaut.io/latest/micronaut-mongodb-synchronous.html


---
# Where to Learn More

* Micronaut Docs (Reference Material and APIs) - https://docs.micronaut.io
* Micronaut Guides (Guided Tutorials with Sample Code) - https://guides.micronaut.io
* GraalVM Docs - https://www.graalvm.org/22.1/docs/
* Follow on Social https://twitter.com/micronautfw and https://twitter.com/graalvm


---



# What's Coming?

* Micronaut Framework 4.0
    - Java 17 baseline
    - Initial support for Virtual Threads (Loom)
    - Finish move to `jakarta` namespace
    - Upgrade Third-party libraries to major versions
    - More Micronaut Data awesomeness
    - Kotlin KSP Support

----


# [FIT] The Future Is
# [FIT] Intelligent Compilers
## Smaller, Leaner Runtimes

----

# Summary

* The Micronaut Framework Provides an Awesome Set of Framework Building Blocks
* Sacrifices Compilation Speed to Gain so Much More
* By reducing reflection the runtime is simpler allowing easier closed work static analysis
* Provides high productivity without the performance penalty

----


![fit](images/thankyou.png)

----



# [FIT] **Q & A**
