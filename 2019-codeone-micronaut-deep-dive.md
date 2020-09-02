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
# [FIT] **Micronaut Deep Dive**
# [FIT] **10 Things You Can Do with Micronaut**


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

* Brief Introduction to Micronaut
* 10 Things You Can Do with Micronaut
* Demos, Demos and more demos
* Summary
* Q & A

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


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **ONE**
## **Just Use Dependency Injection**

----

![original](images/oci-backgrounds/oci-white.png)

# Dependency Injection

* Reflection and Runtime Proxy Free
* Supports Configuration Injection
* Supports Aspect Oriented Programming (AOP)
* Constructor, field, method injection all supported

![right, 35%](images/micronaut-stack-blue.png)

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **TWO**
## **Build CLI Applications**

----

![original](images/oci-backgrounds/oci-white.png)

# CLI Apps

* Integration with PicoCLI
	> https://picocli.info/
* Can use any Micronaunt component,
	like the HTTP client.
* Supports going native with GraalVM 
	for ultra fast execution

![right, 35%](images/micronaut-stack-blue.png)


----



![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **THREE**
## **As an HTTP Client**

----

![original](images/oci-backgrounds/oci-white.png)

# HTTP Client

* Low level, flexible client
* Also declaring compile time client
* Just declare an interface and have 
   it implemented for you!
* Uses Micronaut's low overead AOP

![right, 35%](images/micronaut-stack-blue.png)

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **FOUR**
## **Build Microservices**

----


![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **FIVE**
## **Build a Native Image with Graal**


----

# Micronaut Startup and Memory


Runtime|Memory|Startup
---|---|---|
JDK 11 | 75MB | 1.1s
JDK 13 | 75MB | 900ms
JDK 13 + CDS | 75MB | 400ms   
GraalVM Substrate | 15MB | 21ms   

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **SIX**
## **Generate Swagger / Open API**

----

![original](images/oci-backgrounds/oci-white.png)

# Swagger / OpenAPI Support

* Compilation time computed
* Adds no overhead to the runtime
* Generated YAML can be imported into Swagger UI
* Or use AutoREST to generate a JS client

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **SEVEN**
## **Message Driven Microservices with Kafka**

----

![original](images/oci-backgrounds/oci-white.png)

# Kafka Support

* Write headless Microservices that just 
	listen for Kafka messages
* Great for real time processing
* Send Kafka messages with `@KafkaClient`, 
  implemented automatically for you.

![right, 35%](images/micronaut-stack-blue.png)


----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **EIGHT**
## **Query with Micronaut Data JDBC**

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Data

* Precomputed SQL or JPA-QL queries
* Uses Micronaut's zero overhead AOP
* The JDBC implementation completely reflection free
* Support for Oracle DB, MySQL, Postgres and SQL Server

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **NINE**
## **Schedule Jobs**

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **TEN**
## **Gather Metrics and Traces**

----

![original](images/oci-backgrounds/oci-white.png)

# Metrics and Tracing

* Tracing: Support for Open Tracing, Zipkin and Jaeger
* Metrics: Based on Micrometer with support for 
ever metric registry imaginable 
* Instrumentation for the whole framework (client and server requests)

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Where to Learn More

* Website: https://micronaut.io
* Github: https://github.com/micronaut-projects/micronaut-core
* Comprehensive Guides: https://guides.micronaut.io
* Talk to us on Gitter: https://gitter.im/micronautfw



![right, 35%](images/micronaut-stack-blue.png)

----

# Summary

* Micronaut provides a wealth of features 
* Tackles a range of uses cases
* General purpose for whatever your needs
* Optimizes for reduced memory usage and startup time
* Works well with Graal native image

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **Q & A**

----

![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
