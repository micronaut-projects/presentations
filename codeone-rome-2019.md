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
# [FIT] **Evolving Software for the**
# [FIT] **Microservice and Serverless Era**

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

* Challenges Facing Java and Software in General
* Serverless vs. Traditional Models
* Emerging Solutions (Micronaut and GraalVM)
* Demos!

----


![original](images/oci-backgrounds/oci-white.png)

# Serverless Challenges

* Challenges to using Java in Serverless / Microservices scenarios
* Existing Tools and Frameworks Not Optimized for Cold Starts / Low Memory
* Go, Node etc. better in this regards
* Tim Bray (Amazon/AWS) and others not recommending Java 

>> https://youtu.be/IPOvrK3S3gQ?t=1109

![right, 20%](images/java.png)

----


![original](images/oci-backgrounds/oci-white.png)

# Adapting to Serverless 

* Optimize for cold starts
* Forget about connection pools
* Don't bother with local caches
* Choose technology based on your cold start requirements

![right, 50%](images/lambda.png)

---

# What Spring Does

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

Spring is an amazing technical achievement and does so many things, but does them at runtime.

* [Reads the byte code](https://github.com/spring-projects/spring-framework/tree/master/spring-core/src/main/java/org/springframework/core/type/classreading) of every bean it finds
* [Synthesizes new annotations](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/main/java/org/springframework/core/annotation/AnnotationUtils.java#L1428) for each annotation on each bean method, constructor, field etc. to support Annotation metadata
* [Builds Reflective Metadata](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/CachedIntrospectionResults.java) for each bean for every method, constructor, field etc.

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

---

![98%](images/frameworks.png)

[.hide-footer]

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

---

# Imagine if Kubernetes or Docker had been written in Spring or Jakarta EE instead of Go?


----

![FIT](https://assets.bwbx.io/images/users/iqjWHBFdfxIU/ihkrZAvegElw/v0/-1x-1.jpg)

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

# Java's Advantages

* Mature, Robust Ecosystem
* Outstanding IDEs
* Code Maintenance and Refactoring
* Developer Availability
* Build System Maturity
* Diversity (Mobile, IoT, Server Side)
* Languages (Java, Kotlin, Groovy, Scala)

![right, 20%](images/java.png)

---

# By the time Go has all the features of Java, Java's startup performance will match Go

---

# Already Solved Problem

* The Android Community already solved the problem
* Ahead of Time Compilation used extensively
* Google Dagger 2.x
	* Compile Time Dependency Injector
	* Reflection Free
	* Limited in Scope to just DI

![right, 100%](images/andy-lg.png)

---


![original](images/micronaut-bg.png)

[.hide-footer] 

<!-- # Introducing Micronaut -->

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

# Micronaut's Impact

* We announced Micronaut at Greach 2018
* Open Sourced 28th of May 2018
* Red Hat (with Quarkus) and Pivotal have been scrambling ever since
* Micronaut is changing the face of server side Java

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# GraalVM 

* A New Universal Virtual Machine from Oracle
* Features a `native-image` Tool 
	* Converts Java -> native machine code using AOT
* Works well with Micronaut
* Startup time 20ms and Memory Consumption 18MB!

> http://www.graalvm.org

![right, 100%](images/graal.png)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut and GraalVM**

----

![original](images/oci-backgrounds/oci-white.png)

# GraalVM 

* GraalVM is promising and a project to keep an eye on
* Still in beta and experimental
* Micronaut optimizes for GraalVM, but 
also optimizes for regular Java (what most people use today)

> http://www.graalvm.org

![right, 100%](images/graal.png)


----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut and Serverless**

----

# Summary

* Micronaut and GraalVM are leading the AOT revolution
* Sacrifices Compilation Speed to Gain so Much More
* Solves Problems with Spring, Jakarta EE and Java in General
* Opens the Door to GraalVM Native

----

![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
