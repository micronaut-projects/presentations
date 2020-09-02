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
# [FIT] **MICRONAUT STATUS UPDATE**
> _Building a Framework for the Future_

```
```

---

![original](images/oci-backgrounds/oci-white.png)

# About Me

* Graeme Rocher
* Creator of Grails and Micronaut
* Principal Engineer at Object Computing
* Oracle Groundbreaker Award Winner
* Former G2One Founder -> SpringSource -> Pivotal

---

# **Bergara, Basque Country**

![original](images/bergara.jpg)

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

* Introduction to Micronaut 
* What's new in Micronaut 1.1
* Challenges Facing Java
* Micronaut's Approach to Solving The Problems
* Demos!

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut is...

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

![original](images/oci-backgrounds/oci-white.png)

# So What is Micronaut? Really?

* An Application Framework for the Future
* Reflection Free, Runtime Proxy Free, 
  No Dynamic Classloading (in 1.1)
* Ahead of Time (AOT) Compilation AOT APIs
* ... oh and let's you build Microservices

![right, 35%](images/micronaut-stack-blue.png)

----


![original](images/oci-backgrounds/oci-white.png)

# Why Micronaut? Why Now?

* Challenges to using Java in Serverless / Microservices scenarios
* Existing Tools and Frameworks Not Optimized for Cold Starts / Low Memory
* Go, Node etc. better in this regards
* Tim Bray (Amazon/AWS) and others not recommending Java 

>> https://youtu.be/IPOvrK3S3gQ?t=1109

![right, 20%](images/java.png)

---

# The Micro Reality

![original](images/fatcat-bg-white.png)

[.hide-footer]

* Frameworks based on reflection 
and annotations become fat
* But we love the programming 
model and productivity so 
we live with it
* So ... why should we be 
more efficient?

---

![80%](images/startup-graph.png)

[.hide-footer]

----


![original](images/oci-backgrounds/oci-white.png)

# Micronaut's Impact

* We announced Micronaut at Greach 2018
* Open Sourced 28th of May 2018
* Red Hat and Pivotal have been scrambling ever since
* Micronaut is changing the face of server side Java

![right, 35%](images/micronaut-stack-blue.png)

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

![original](images/oci-backgrounds/oci-white.png)

# Micronaut and GraalVM 

* A New Universal Virtual Machine from Oracle
* Features a `native-image` Tool 
	* Converts Java -> native machine code using AOT
* Works well with Micronaut
* Startup time 20ms and Memory Consumption 18MB!

> http://www.graalvm.org

![right, 100%](images/graal.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut and GraalVM 

* GraalVM is cool and a project to keep an eye on
* Still in beta and experimental
* Micronaut optimizes for GraalVM, but 
also optimizes for regular Java (what most people use today)

> http://www.graalvm.org

![right, 100%](images/graal.png)


----

![original](images/oci-backgrounds/oci-white.png)

# Java's Problems for Frameworks

* Limited Annotation API
* Type Erasure
* Slow Reflection
* Reflective Data Caches
* Classpath Scanning
* Slow Dynamic Class Loading

![right, 20%](images/java.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut 1.1 Improvements

* BeanIntrospection API  - reflection-free replacement for `java.beans.Introspector`
* Complete elimination of framework level dynamic classloading 
* Modularization (loads of modules!)
* Testing Improvements `@MicronautTest`

![right, 35%](images/micronaut-stack-blue.png)


----

![original](images/oci-backgrounds/oci-white.png)

# New Micronaut 1.1 Modules

* GRPC - `micronaut-grpc`
* GraphQL - `micronaut-graphql`
* RabbitMQ - `micronaut-graphql`
* AWS - `micronaut-aws`
* GPC - `micronaut-gpc`

> https://github.com/micronaut-projects 

![right, 35%](images/micronaut-stack-blue.png)


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
* AOT Reflection-free replacement for `java.beans.Introspector`
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
* AOT Computed / Merged Annotation data from class/interface hierarchy
* Includes knowledge of meta-annotations

----

![original](images/oci-backgrounds/oci-white.png)

# `Argument` 

```java
BeanProperty<MyBean, List> property = 
	introspection.getRequireProperty("names", List.class);

// returns an Argument with an underlying type of String
Optional<Argument> typeVariable = property.asArgument()
										  .getFirstTypeVariable()
```
* AOT Computed Generic Type information
* No type erasure / crazly reflection logic to get the type argument

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Dependency Injection

* Precomputes Everything
* Annotation Metadata (see `AnnotationMetadata` interface)
* Generic Types (No Type Erasure!)
* Class Loading Requirements (No Dynamic Class Loading!)

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# `BeanDefinition` 

```groovy
ApplicationContext ctx = ApplicationContext.run();

BeanDefinition<MyBean> definition 
	= ctx.getBeanDefinition(MyBean.class);
```

* Contains precompuated `AnnotationMetadata` and generic type info
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

----

![original](images/oci-backgrounds/oci-white.png)

# `@Executable` 

```java
@Scheduled(fixedRate = "5m") // @Scheduled annotated with @Executable
void everyFiveMinutes() {
    messageService.sendMessage("Hello World");
}
```
* Common Stereotype annotation
* Identifies where framework invokes your code
* Produces reflection-free `ExectubleMethod` instance

----

![original](images/oci-backgrounds/oci-white.png)

# `@ExecutableMethodProcessor` 

```java
public class ScheduledMethodProcessor 
	implements ExecutableMethodProcessor<Scheduled> {
	public void process(BeanDefinition<?> beanDefinition, 
						ExecutableMethod<?, ?> method) {
		// do stuff with the bean
	}
}
```

* Processes only methods annotated by type argument
* In the above case setting up a scheduled job

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut AOP**

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

![original](images/oci-backgrounds/oci-white.png)

# Micronaut 1.2 & Roadmap

* OAuth 2 and OpenID Connect Support
* Reflection Free Bean Validation
* Data Access (codename "GORM for Java")
* Kotlin Coroutines
* JMS Support

![right, 35%](images/micronaut-stack-blue.png)

----



# Summary

* Micronaut Provides an Awesome Foundation
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
