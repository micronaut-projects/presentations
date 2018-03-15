footer: © Object Computing Inc., 2018
slidenumbers: false

![original](images/oci-big-center-center.png)

[.hide-footer]

# [FIT] Launching the Micro Future
> Groovy, Grails and the Micro Future
-- by Graeme Rocher


---

![original](images/oci-bg.png)

[.hide-footer]

# Agenda

* How we got here
* Microservice Challenges
* Launching the Micro Future
* Grails Roadmap


---

![right,50%](images/2008.jpg)

[.hide-footer]

# Then and Now

- Since 2008, a lot has changed
- 10 years ago Grails 1.0 
was released!
- Everybody was building 
Monoliths
- No Angular, No React, 
No Docker, No Microservices

---

# So We Try to Adapt

![original](images/elephant-bg.png)

[.hide-footer]

* Let's try and fit 
Monolith focused framework 
into Micro environment!
* Spring and Grails were 
never designed for this
* ... No matter how much 
marketing you hear

---

# What to do, What to do?

Shall we:

1.  Try and convince people that something never designed for Microservices is still ok?
2. Go back to the drawing board


![left](images/decision.gif)

---

![original](images/oci-bg.png)

[.hide-footer]

# The Goal
* Create a New Framework designed from the ground-up for Microservices and Server-less Computing
* Blazing fast startup time
* Low Memory Footprint
* As Small As Possible JAR Sizes
* Zero Dependency
* 12 Factor - https://12factor.net



---

# The Analysis

To meet this goal we performed an analysis of Spring and Grails and the challenges to using them to develop Microservice applications

![right](images/analysis.gif)

---

# What Spring (and Grails) Do

![original](images/oci-bg.png)

[.hide-footer]

Spring is an amazing technical achievement and does so many things, but does them _at Runtime_.

* [Reads the byte code](https://github.com/spring-projects/spring-framework/tree/master/spring-core/src/main/java/org/springframework/core/type/classreading) of every bean it finds
* [Synthesizes new annotations](https://github.com/spring-projects/spring-framework/blob/master/spring-core/src/main/java/org/springframework/core/annotation/AnnotationUtils.java#L1428) for each annotation on each bean method, constructor, field etc. to support Annotation metadata
* [Builds Reflective Metadata](https://github.com/spring-projects/spring-framework/blob/master/spring-beans/src/main/java/org/springframework/beans/CachedIntrospectionResults.java) for each bean for every method, constructor, field etc.

---

![original](images/startup-graph.png)

[.hide-footer]

# So What's the Problem?


---

# The Micro Reality

![original](images/fatcat-bg.png)

[.hide-footer]

* With Spring (and Grails) anything 
beyond "Hello World" becomes 
fat quickly
* But we love the programming 
model and productivity so 
we live with it
* There must be a better way... 

---

![original](images/micronaut-bg.png)

[.hide-footer] 

<!-- # Introducing Micronaut -->

---

![original](images/micronaut-logo-right.png)

[.hide-footer]

# Introducing Micronaut
* Designed from the ground up 
with Microservices in mind
* Ultra-light weight and 
Reactive - Based on Netty
* Integrated AOP and 
Compile-Time DI
* HTTP Client & Server

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# [fit] DEMO

* Hello Micronaut 

---

# Hello Micronaut

![original](images/oci-micronaut-bg.png)

[.hide-footer]

```groovy
@Controller
class HelloController {
    @Get("/hello/{name}")
    String hello(String name) { "Hello $name!" }
}
@Client("/") // Client Generated at Compile Time
interface HelloClient {
  @Get("/hello/{name}")
  String hello(String name)
}
```

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# How Small?

* Micronaut Hello World JAR is 8MB when written Java or 12MB in Groovy
* Can be run with as little as 8mb Max Heap (12 for Groovy)
* Startup time is sub-second
* All Dependency Injection, AOP and Proxy generation happens at compile time

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# But... How?

* Compile Time Dependency Injection & AOP for Groovy, Java and Kotlin
* AST Transforms for Groovy. Annotation processors for Java/Kotlin
* Annotation metadata produced at Compile Time
* Reflection Free and No Reflection Data Caching

---

![original](images/facepalm-bg.png)

[.hide-footer]

# Not Another HTTP Server!?

* If all we had achieved was 
another HTTP server 
Micronaut wouldn't be very 
interesting
* So what else does it do?

---

# Natively Cloud Native

![original](images/oci-micronaut-bg.png)

[.hide-footer]

* Service Discovery - Consul and Eureka Supported; Route 53 Planned
* Configuration Sharing - Consul Supported; Amazon & GCP Planned
* Client Side Load Balancing - Integrated or Netflix Ribbon Supported
* Support for Serverless Computing via AWS Lambda

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# [fit] DEMO 

* Micronaut Pet Store

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# The HTTP Server

* Fully Reactive and non-blocking - Reactor and RxJava 2.x support
* Auto configuration for common databases

```groovy
@Get('/pets')
Single<List<Pet>> pets() {
    petClient.list()
            .onErrorReturnItem(Collections.emptyList())
}
```
---

# The HTTP Client

![original](images/oci-micronaut-bg.png)

[.hide-footer]

* Client Implementations Produced at Compile Time
* Service Discovery by Service ID
* Automatic Client Side Load Balancing & Fallback

```java, [.highlight: 1, 3-4]
@Client(id = "pets", path = "/v1")
interface PetClient {
    @Get('/pets')
    Single<List<Pet>> list()
}
```

---

# Serverless Computing

![original](images/oci-topright.png)

[.hide-footer]

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

![original](images/micronaut-logo-right.png)

[.hide-footer]

# Micronaut Roadmap

- First Milestones in Q2
- GA by the end of the year
- TODO: AWS Route 53, 
Google Metadata Server Support
* TODO: Metrics & Distributed Tracing

---

![original](images/grails-logo-right-bg.png)

[.hide-footer]

# What About Grails?

* Grails is _awesome_, *mature* and *robust*
... for Creating Monoliths
* Not every Application needs 
Microservices
* You will want parts of Micronaut 
in your Grails apps: 
HTTP Client, Discovery Client etc.

---

![original](images/grails-logo-right-bg.png)

[.hide-footer]

# Grails Status Update

* Grails 3.3.3 just released
* Users seeing measured improvement in Memory consumption in production
* More 3.3.x releases planned

---

![original](images/grails-logo-right-bg.png)

[.hide-footer]

# Grails 4.0 (Q4 2018)

* Java 8 minimum, Java 9 support, Groovy 2.5
* Spring Boot 2 and Spring 5
* GORM 7.0 (Hibernate 5.2 minimum)
* Micronaut Integration

---

![original](images/oci-micronaut-bg.png)

[.hide-footer]

# Summary

* Micronaut aims to provide the same wow factor for Microservices that Grails did for Monoliths
* Built by the people that made Grails, leveraging over 10 years experience in framework development
* Coming soon in 2018


---

![original](images/oci-big-center-bottom-bg.png)

[.hide-footer]

# [FIT] Q & A