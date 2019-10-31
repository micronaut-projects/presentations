theme: OCI White
slidenumbers: false
[.hide-footer]

![original](images/oci-backgrounds/oci-intro.png)

```
```
```
```
```
```
# [FIT] **Micronaut**
# [FIT] **Deep Dive Workshop**



```
```

---

![original](images/oci-backgrounds/oci-white.png)

# About Me

* Graeme Rocher
* Creator of Grails and Micronaut
* Principal Engineer at Object Computing
* 2018 Oracle Groundbreaker Award Winner
* Java Champion

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

## Part 1 - 45 Minutes

* Introduction to Micronaut 
* Why Micronaut
* Micronaut Fundamentals
* Micronaut Test
* Bean Introspection
* Dependency Injection
* Configuration Management

![right, 35%](images/micronaut-stack-blue.png)

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

## Part 2 - 45 Minutes

* Micronaut AOP
* Bean Validation
* Bean Events and Listeners
* 10 Minute Break


![right, 35%](images/micronaut-stack-blue.png)

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

## Part 3 - 45 Minutes

* Micronaut HTTP Server
* Micronaut HTTP Client
* HTTP Filters
* Service Discovery
* Swagger / OpenAPI

![right, 35%](images/micronaut-stack-blue.png)

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

## Part 4 - 45 Minutes

* Introducing Micronaut Data
* Micronaut Data JPA
* Micronaut Data JDBC
* Micronaut & GraalVM Native Image

![right, 35%](images/micronaut-stack-blue.png)

---

![original](images/oci-backgrounds/oci-white.png)

# Part 1 - 45 Minutes

* Introduction to Micronaut 
* Why Micronaut
* Micronaut Fundamentals
* Micronaut Test
* Bean Introspection
* Dependency Injection
* Configuration Management

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Java's Problems for Frameworks

* Limited Annotation API
* Type Erasure
* Slow Reflection
* Reflective Data Caches
* Classpath Scanning
* Slow Dynamic Class Loading

![right](https://media3.giphy.com/media/dDCARfgGBQShq/giphy.gif?cid=790b7611b3cc1a79db27dfd49c6a4866a7308fb1555ba8e9&rid=giphy.gif)

----

![original](images/oci-backgrounds/oci-white.png)

# Java's Problems

* Greatly Exaggerated (Java has been dead forever)
* Java can be Fast! (see Android and Micronaut)
* However Most Existing Tools are based around
	* Reflection
	* Runtime Proxies 
	* Runtime Byte Code Generation (bytebuddy/cglib)
	

![right, 20%](images/java.png)

----

# Why is Reflection a Problem?

* Today the JDK is OpenJDK!
* Just take a look...

> http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/lang/Class.java#l2471

* **All** Reflective data initialized on first access and held in soft references (yes every field, method etc.)
* Won't be GC'ed until your application is low on memory!

----

# Avoid Reflection!

* Reflection usage increases memory usage
* Using reflection relatively slow
* Problem is most modern server-side frameworks and specifications
 are built on reflection
* Some of the Jarkarta specifications even mandate reflection

![right](https://media0.giphy.com/media/W4aKCI7mygvEQ/giphy.gif?cid=790b761196c0651be4ba29e250cd550f6a16f61685269e08&rid=giphy.gif)

---

# Just Like The Android World

* The Android Community already solved the problem
* Ahead of Time Compilation used extensively
* Google Dagger 2.x for DI
* Most Android Frameworks avoid reflection to 
 avoid paying the memory / performance cost

![right, 100%](images/andy-lg.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut

* A Microservices and Serverless Focused framework (hence the branding)
* Also a Complete Application Framework for any type of Application
* Dependency Injection, Aspect Oriented Programming (AOP), Configuration Management,
 Bean Introspection and more..


![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# With Micronaut You Can Build

* Microservices
* Serverless Applications
* Message-Driven Applications with Kafka/Rabbit
* CLI Applications
* Even Android Applications
* Anything with 
	`static void main(String..args)`


![right, 35%](images/micronaut-stack-blue.png)

----

# Micronaut's Solutions


Problem|Solution
---|---|
Limited Annotation API | Precomputed `AnnotationMetadata`
Type Erasure | Precomputed `Argument` Interface
Slow Reflection | Eliminate Reflection
Reflective Data Caches | Zero Data Caches
Classpath Scanning | No Classpath Scanning
Slow Dynamic Class Loading | No Dynamic Class Loaders

----

![original](images/oci-backgrounds/oci-white.png)

# [FIT] The Future Is 
# [FIT] Intelligent Compilers 
## Smaller, Leaner Runtimes

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Project Setup**

----

![original](images/oci-backgrounds/oci-white.png)

# Project Setup 

* The Quick Way with SDKMan! (https://sdkman.io/):

```bash
$ sdk install micronaut
## For Maven
$ mn create-app example --build maven
## For Gradle
$ mn create-app example --build gradle
```
* Can setup manually. CLI is just a handy helper

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Minimum Setup

* A Micronaut project is just a Java project with an additional annotation processor

```groovy
annotationProcessor "io.micronaut:micronaut-inject-java:1.2.5" // Gradle
```
```xml
<annotationProcessorPaths> <!-- Maven -->
      <path>
        <groupId>io.micronaut</groupId>
        <artifactId>micronaut-inject-java</artifactId>
        <version>1.2.5</version>
      </path>
      ...
```

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Test

* Testing library with support for Spock and JUnit 5

> https://github.com/micronaut-projects/micronaut-test

```groovy
testCompile "io.micronaut.test:micronaut-test-junit5" // Gradle
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

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Bean Introspection**


----

![original](images/oci-backgrounds/oci-white.png)

# `@Introspected` 

```java
@Introspected
class MyBean {
    private List<String> names; //getter/setter omitted
}
```
* AOT Reflection-Free replacement for `java.beans.Introspector`
* Set/get bean properties, create instances
* Includes `AnnotationMetadata`

----

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Annotation Metadata**


----

![original](images/oci-backgrounds/oci-white.png)

# `AnnotationMetadata` Why? 

* All the `Nullable` annotations!!!
* `javax.annotation.Nullable` (Java)
* `org.jetbrains.annotations.
	Nullable` (Kotlin)
* `edu.umd.cs.findbugs.
	annotations.Nullable` (Spotbugs)
* `org.springframework.
	lang.Nullable` (Spring)

![right, 90%](https://i.imgur.com/0BpqqmW.gif)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Dependency Injection**

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut DI

```
@Inject MyBean myBean;
@Named("someOther") MyBean someOther;	
```

* Supports and passes the `javax.inject` TCK
* Supports `@PostContruct` / `@PreDestroy`
* Completely reflection free and fast
* Constructor injection encouraged

----

![original](images/oci-backgrounds/oci-white.png)

# `BeanDefinition` 

```groovy
ApplicationContext ctx = ApplicationContext.run();

BeanDefinition<MyBean> definition 
	= ctx.getBeanDefinition(MyBean.class);
```

* Contains precomputed `AnnotationMetadata` and generic type info
* Used by `ApplicationContext` to instantiate beans

----

![original](images/oci-backgrounds/oci-white.png)

# `BeanDefinition` 

* Bean definitions produced for any `@Singleton`
* Constructor injection used by default
* Use `@Factory` for beans you cannot annotate
* Compliant with `javax.inject` spec and TCK

----

![original](images/oci-backgrounds/oci-white.png)

# `@ConfigurationProperties`
### Type Safe Configuration

```java
@ConfigurationProperties("example")
class ExampleConfiguration {
	// getters/setters omitted
	private String name; 
}


ApplicationContext context = ApplicationContext.run("example.name":"Demo");
FooConfiguration config = context.getBean(FooConfiguration);
assert config.name == 'Demo'
```

----

![original](images/oci-backgrounds/oci-white.png)

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

ApplicationContext context = ApplicationContext.run("example.enabled":"true")
Example example = context.getBean(Example)
```

---

![original](images/oci-backgrounds/oci-white.png)

# Part 2 - 45 Minutes

* Micronaut AOP
* Bean Validation
* Bean Events and Listeners
* 10 Minute Break


![right, 35%](images/micronaut-stack-blue.png)

---

![original](images/oci-backgrounds/oci-white.png)

# Micronaut AOP

* Designed to be reflection free
* No runtime generated proxies or byte code generation
* Fast and efficient thanks to smaller stack traces
* Allow for all the typical framework use cases: 
	`@Transactional`, `@Cacheable`, `@Validated` etc.


![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-white.png)

# Micronaut AOP 
## Annotation Stereotypes

* `@Around` - Allows decorating a method by **surrounding** it with new behaviour (caching, transactions etc.) 
* `@Introduction` - Allows **introducing** new behaviour to existing classes and interfaces
* `@Adapter` - Allows **adapting** a method to a Single Abstract Method (SAM) type.

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Around Advice**

----

![original](images/oci-backgrounds/oci-white.png)

# `@Around` 

```java
@Retryable // @Retryable is annotated with @Around
void invokeMe() {
    // do stuff
}
```
* Intercepts a method with a `MethodInterceptor`
* No runtime proxies (compile time proxies) or reflection needed
* No `FancyProxyFactoryBean` or containers needed!

----

![original](images/oci-backgrounds/oci-white.png)

# `@Around` 

```java
@Around
@Type(DefaultRetryInterceptor.class)
public @interface Retryable {
	// annotation attributes
}
```
* Use `@Type` to specify the implementation
* At compilation Micronaut applies the AOP advise

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Introduction Advice**

----

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-white.png)

# `@Introduction` 

```groovy
@Introduction
@Type(HttpClientIntroductionAdvice.class)
@Recoverable
@Singleton
public @interface Client {
}

```
* `@Type` used again to specify implementation
* Can apply other annotations as meta annotations

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Adapter Advice**

----

![original](images/oci-backgrounds/oci-white.png)

# `@Adapter` 

```java
@Singleton
public class Application {

    @EventListener
    void init(StartupEvent event) {
    	// on startup do something
    }
}

```
* `@EventListener` is a great example of adapter advice

----

![original](images/oci-backgrounds/oci-white.png)

# `@Adapter` 

```java
@Target(ElementType.METHOD)
@Adapter(ApplicationEventListener.class) 
public @interface EventListener {

}

```
* For every method annotated with `@EventListener` a new bean that implements `ApplicationEventListener` is created at compile time.

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Bean Validation**

---

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Validation

* Support for `javax.vallidation` annotations
* Partial implementation of spec without the parts that require reflection
* Reuses Bean Introspections to save memory


![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **BREAK TIME**
## **See you in 10 minutes**

---

![original](images/oci-backgrounds/oci-white.png)

# Part 3 - 45 Minutes

* Micronaut HTTP Server
* Micronaut HTTP Client
* HTTP Filters
* Service Discovery
* Swagger / OpenAPI

![right, 35%](images/micronaut-stack-blue.png)

---


![original](images/oci-backgrounds/oci-white.png)

# Micronaut Runtimes

Dependency|Runtime
---|---|
`micronaut-http-server-netty` | Default Netty Server
`micronaut-kafka` | Kafka Headless Server
`micronaut-picocli` | PicoCLI command line app
`micronaut-grpc` | GRPC Server
`micronaut-graphql` | GraphQL Server
`micronaut-ktor` | Kotlin KTOR Framework support
`micronaut-function-aws-api-proxy` | AWS Lambda

---

![original](images/oci-backgrounds/oci-white.png)

# Micronaut HTTP Server

* Default Netty-based Reactive Server
* Support for both blocking and non-blocking I/O
* Choose your reactive framework: RxJava2, Reactor etc.
* Any annotation model: Micronaut, Spring, JAX-RS (coming soon)
* Integrated Jackson with reflection-free extensions

![right, 35%](images/micronaut-stack-blue.png)


----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut HTTP Server**


----

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-white.png)

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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut HTTP Client**

---

![original](images/oci-backgrounds/oci-white.png)

# Micronaut HTTP Client

* Netty-Based HTTP Client
* Low-level API and declarative compile-time client
* Uses `@Introduction` advice to simplify writing clients
* Reactive, CompletableFuture and blocking support
* Built in Service Discovery support

![right, 35%](images/micronaut-stack-blue.png)

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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut HTTP Filters**

---

![original](images/oci-backgrounds/oci-white.png)

# Micronaut HTTP Filters

* Filters can apply to server and/or client
* Allow altering request/response before proceeding
* Useful for adding headers, authentication, tracing, 
  token propagation etc.

![right, 35%](images/micronaut-stack-blue.png)


----




# Micronaut Startup and Memory


Runtime|Memory|Startup
---|---|---|
JDK 11 | 75MB | 1.1s
JDK 13 | 75MB | 900ms
JDK 13 + CDS | 75MB | 400ms   
GraalVM Substrate | 15MB | 21ms   

----

# Summary

* Micronaut Provides an Awesome Set of Framework Primitives
* Sacrifices Compilation Speed to Gain so Much More
* Solves Problems with Spring, Jakarta EE and Java in General
* Opens the Door to GraalVM Native

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **Q & A**

----

![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
