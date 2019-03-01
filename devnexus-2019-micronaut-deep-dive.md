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
# [FIT] **MICRONAUT DEEP DIVE**
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

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

* Introduction to Micronaut 
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

----

![original](images/oci-backgrounds/oci-white.png)

# Java's Problems

* Greatly Exaggerated (Java has been dead forever)
* Java can be Fast! (see Android and Micronaut)
* However Most Existing Tools are based around
	* Reflection
	* Runtime Proxies 
	* Runtime Byte Code Generation
	

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

# Java's Problems for Frameworks

* Limited Annotation API
* Type Erasure
* Slow Reflection
* Reflective Data Caches
* Classpath Scanning
* Slow Dynamic Class Loading

![right, 20%](images/java.png)


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

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Dependency Injection**

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Dependency Injection

* Precomputes 
	* Annotation Metadata (see `AnnotationMetadata` interface)
	* Generic Types (No Type Erasure!)
	* Class Loading Requirements (No Dynamic Class Loading!)



![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# `@Executable` 

```java
@Scheduled(fixedRate = "5m") // @Scheluded annotated with @Executable
void everyFiveMinutes() {
    messageService.sendMessage("Hello World");
}
```
* Common stereotype annotation
* Identifies  where framework invokes your code
* Processed with a `ExecutableMethodProcessor`

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut AOP**

----

# Summary

* Micronaut Provides an Awesome Foundation
* Sacrafice Compilation Speed to Gain so Much More
* Solves Problems with Spring and Jakarta EE
* Opens the Door to GraalVM native

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **Q & A**


----


![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
