theme: OCI White
slidenumbers: false
[.hide-footer]

![original](images/trainingbg.png)

```
```
# [FIT] Introduction to Micronaut
> Ultra-Lightweight Microservices for the JVM

```
```
-- by Graeme Rocher


---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# About Me - Graeme Rocher

* Creator of Grails (http://grails.org)
* Creator of Micronaut (http://micronaut.io)
* Author "The Definitive Guide to Grails"
* Senior Engineer at Object Computing (http://objectcomputing.com)
* 2018 Oracle Groundbreaker Award Winner

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Agenda

* How we got here
* Microservice Challenges
* Microservice Framework Lanscape
* Micronaut Demos


---

![original](images/trainingbg.png)

![right,50%](images/2008.jpg)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Then and Now

- Since 2008, a lot has changed
- 10 Years is a long time in technology
- Everybody was building 
Monoliths
- No Angular, No React, 
No Docker, No Microservices

---

# So We Try to Adapt

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

![right](images/elephant.jpg)

* Let's try adapt existing legacy technologies for Microservices
* Technologies like Spring, Jakarta EE etc were never optimized for low memory footprint Microservices

---

## What to do, 
## What to do?

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

Shall we:

1.  Try and convince people that something never designed for Microservices is still ok?
2. Go back to the drawing board


![left](images/decision.gif)

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# The Goal
* Create a New Framework designed from the ground-up for Microservices and Serverless Computing
* Blazing fast startup time
* Low Memory Footprint
* As Small As Possible JAR Sizes
* Zero Dependency
* 12 Factor - https://12factor.net

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# The Analysis

To meet this goal we performed an analysis of Spring and Grails and the challenges to using them to develop Microservice applications

![right](images/analysis.gif)

---

## What Spring and Jakarta EE Do

[.text: #000000,  text-scale(0.8), alignment(left)]

![original](images/trainingbg.png)

Spring is an amazing technical achievement and does so many things, but does them _at Runtime_.

* [Reads the byte code](https://github.com/spring-projects/spring-framework/tree/master/spring-core/src/main/java/org/springframework/core/type/classreading) of every bean it finds
* [Synthesizes new annotations](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/main/java/org/springframework/core/annotation/AnnotationUtils.java#L1428) for each annotation on each bean method, constructor, field etc. to support Annotation metadata
* [Builds Reflective Metadata](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/CachedIntrospectionResults.java) for each bean for every method, constructor, field etc.

---

# So What's the Problem?

![original](images/trainingbg.png)

![inline](images/startup-graph.png)

---

![original](images/trainingbg.png)

![inline 98%](images/frameworks.png)

---

[.text: #000000,  text-scale(0.8), alignment(left)]

# The Micro Reality

![original](images/trainingbg.png)

![right](images/fatcat.jpg)

* Frameworks based on reflection 
and annotations become fat
* But we love the programming 
model and productivity so 
we live with it
* So ... why should we be 
more efficient?

---

![original](images/trainingbg.png)

### Imagine if Kubernetes or Docker had been written in Spring or Jakarta EE instead of Go?

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

## Already Solved by 
## Ahead of Time (AOT) Compilation

* The Android Community already solved the problem
* Ahead of Time Compilation used extensively
* Google Dagger 2.x
	* Compile Time Dependency Injector
	* Reflection Free
	* Limited in Scope to just DI

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Introducing Micronaut
* Designed from the ground up 
with Microservices in mind
* Ultra-light weight and 
Reactive - Based on Netty
* Uses Ahead of Time Compilation 
* HTTP Client & Server
* Support for Java, Kotlin 
  and Groovy

---

![original](images/trainingbg.png)

```
```

# DEMO

* Hello Micronaut 

---

# Hello Micronaut

![original](images/trainingbg.png)

[.hide-footer]

```groovy
@Controller
class HelloController {
    @Get("/hello/{name}")
    String hello(String name) { return "Hello " + name; }
}
@Client("/") // Client Generated at Compile Time
interface HelloClient {
  @Get("/hello/{name}")
  String hello(String name);
}
```

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# How Small?

* Smallest Micronaut Hello World JAR is 10MB when written Java or 12MB in Groovy
* Can be run with as little as 10mb Max Heap with Kotlin or Java (22mb for Groovy)
* Startup time around a second for Kotlin or Java (a little more for Groovy)
* All Dependency Injection, AOP and Proxy generation happens at compile time

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# What Micronaut Computes
# Compile Time

* All Dependency & Configuration Injection
* Annotation Metadata (Meta annotations)
* AOP Proxies
* Essentially all framework infrastructure
* ie. What Spring/CDI do at runtime
* Essentially, Micronaut is a AOT framework

---

![original](images/trainingbg.png)

![right](images/facepalm.jpg)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Not Another Framework!?

* New Little HTTP Frameworks 
  appearing all the time
* If all we had achieved was 
another HTTP server 
Micronaut wouldn't be very 
interesting
* What else does it do?

---

[.text: #000000,  text-scale(0.8), alignment(left)]

# Natively Cloud Native

![original](images/trainingbg.png)

[.hide-footer]

* Service Discovery - Consul, Eureka, Route 53 and Kubernetes 
* Configuration Sharing - Consul Supported and Amazon ParameterStore 
* Client Side Load Balancing - Integrated or Netflix Ribbon Supported
* Support for Serverless Computing; AWS Lambda, OpenFaas, Fn Supported; Azure coming

---

![original](images/trainingbg.png)

```
```

# DEMO 

* Micronaut Pet Store

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Serverless Computing

* Write Functions and Run them locally or as regular server applications
* Deploy Functions to AWS Lambda - after warm-up functions execute in milliseconds

```java
@Field @Inject Twitter twitter

@CompileStatic
URL updateStatus(Message status) {
    Status s = twitter.updateStatus(status.text)
    String url = "https://twitter.com/$s.user.screenName/status/${s.id}"
    return new URL(url)
}
```

---

![original](images/trainingbg.png)

![right,99%](images/graal.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# GraalVM

* New Polyglot VM from Oracle
* Runs JS, Java, Ruby, R etc.
* Ability to turn Java code native
* https://www.graalvm.org 

---

[.text: #000000,  text-scale(0.8), alignment(left)]

![original](images/trainingbg.png)

![right,99%](images/graal.png)

# GraalVM Native

* Works well when:
	* Little or no runtime reflection is used
	* Limited or no dynamic classloading
	* You plan ahead
	* You use third party libraries selectively

---

![original](images/trainingbg.png)

![right,99%](images/graal.png)


```
```

# DEMO 


* Micronaut + GraalVM

---

[.text: #000000,  text-scale(0.8), alignment(left)]

![original](images/trainingbg.png)

![right,99%](images/graal.png)

# Micronaut + GraalVM 

* Like Graal itself at the Experimental Phase
* Mirconaut AOT compilation and refection free 
  model makes it easier
* A lot of Micronaut already working:
  * HTTP Server, Client & Serverless
  * Service Discovery
  * DI and AOP

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Micronaut 1.0 Out Now

- Compile Time DI & AOP
- HTTP Client & Server
- Service Discovery
- Distributed Tracing
- Serverless Functions
- Data Access: SQL, MongoDB, 
  Redis, Cassandra etc.

---

![original](images/trainingbg.png)

# Micronaut 1.0 on SDKman!

* The Micronaut CLI now available 
  via SDKman!

```bash
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk install micronaut
$ mn create-app hello-world
```

---

![original](images/trainingbg.png)

[.text: #000000,  text-scale(0.8), alignment(left)]

# Micronaut Resources

- Gitter Community: [https://gitter.im/micronautfw](https://gitter.im/micronautfw)
- User Guide: [http://micronaut.io/documentation.html](http://micronaut.io/documentation.html)
- Micronaut Guides: [http://guides.micronaut.io](http://guides.micronaut.io)
- FAQ: [http://micronaut.io/faq.html](http://micronaut.io/faq.html)
- Github: [https://github.com/micronaut-projects/micronaut-core](https://github.com/micronaut-projects/micronaut-core)
- Examples: [https://github.com/micronaut-projects/micronaut-examples](https://github.com/micronaut-projects/micronaut-examples)

---

[.text: #000000,  text-scale(0.8), alignment(left)]

![original](images/trainingbg.png)

# Micronaut Events 

- Loads of upcoming Events
- Checkout - http://micronaut.io/events.html
- Webinar 
  - https://objectcomputing.com/resources/events/webinars/introduction-to-micronaut
	
![right](images/events.png)

<!-- [.hide-footer] -->

---	

[.text: #000000,  text-scale(0.8), alignment(left)]

![original](images/trainingbg.png)

# Summary

* Micronaut aims to provide the same wow factor for Microservices that Grails did for Monoliths
* Built by the people that made Grails, leveraging over 10 years experience in framework development
* Uses Ahead of Time Compilation to support low-memory footprint 
* Micronaut 1.0 is available now


---

![original](images/trainingbg.png)

[.hide-footer]

# [FIT] Q & A