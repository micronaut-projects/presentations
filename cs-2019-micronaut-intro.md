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
# [FIT] **Evolving Java for the Microservice**
# [FIT] **and Serverless Era**



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

* Challenges Facing Java
* Introduction to Micronaut 
* Micronaut's Approach to Solving The Problems
* Demos!

----

![original](images/oci-backgrounds/oci-white.png)

# Java and Serverless

* Challenges to using Java in Serverless / Microservices scenarios
* Existing Tools and Frameworks Not Optimized for Cold Starts / Low Memory
* Go, Node etc. better in this regards
* Tim Bray (Amazon/AWS) and others not recommending Java 

>> https://youtu.be/IPOvrK3S3gQ?t=1109

![right, 20%](images/java.png)

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

# Micronaut and GraalVM 

* A New Universal Virtual Machine from Oracle
* Features a `native-image` Tool 
	* Converts Java -> native machine code using AOT
* Works well with Micronaut
* Startup time 15ms and Memory Consumption 14MB!

> http://www.graalvm.org

![right, 100%](images/graal.png)

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
* AOT Computed / Merged Annotation Replacement for Reflection based API
* Includes knowledge of meta-annotations

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

# `Argument` 
# Why?

* You think resolving generic types in simple?

> https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/main/java/org/springframework/core/ResolvableType.java

![right](https://66.media.tumblr.com/80ce2d4f77c4ddc5d9e395a43e37c532/tumblr_o5r3vkiaGo1qh9nffo3_250.gif)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Dependency Injection**

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
## **Micronaut**

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
