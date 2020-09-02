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
* Java Champion

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


# Why is Reflection a Problem?

* Today the JDK is OpenJDK!
* Just take a look...

> http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/lang/Class.java#l2471

* **All** Reflective data initialized on first access and held in soft references (yes every field, method etc.)
* Won't be GC'ed until your application is low on memory!

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut's Impact

* We announced Micronaut on March 2018
* Open Sourced 28th of May 2018 (a year ago!)
* Sparked industry wide improvements from Red Hat (with Quarkus) and Pivotal (Spring Boot 2.2)
* Micronaut is changing the face of server side Java

![right, 35%](images/micronaut-stack-blue.png)

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
* Micronaut optimizes for GraalVM, but 
also optimizes for regular Java (what most people use today)
* Completely eliminates reflection (good for GraalVM!)

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

![original](images/oci-backgrounds/oci-demo-grey.png)

# [FIT] **DEMO**
## **Micronaut Deep Dive**


---


![original](images/oci-backgrounds/oci-white.png)

# Micronaut 2.0

- Massive new release with GA on Friday
- New Native CLI
- Serverless Support for Azure and GCP
- Incremental compilation for Gradle
- New Maven Plugin

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut 2.0

- Servlet Support (deploy a WAR!)
- HTTP/2 Support
- Massive improvements to GraalVM support
- Much more: [https://docs.micronaut.io/2.0.x/guide/index.html#whatsNew](https://docs.micronaut.io/2.0.x/guide/index.html#whatsNew)

![right, 35%](images/micronaut-stack-blue.png)

---


![original](images/oci-backgrounds/oci-white.png)

# Micronaut Launch

- Generates Micronaut applications
- Fully serverless backend powered by GraalVM Native Image
- Accessable via the browser or `curl`
- Visit [https://launch.micronaut.io](https://launch.micronaut.io) to get started
- Contribute on Github: [https://github.com/micronaut-projects/micronaut-starter](https://github.com/micronaut-projects/micronaut-starter)

![right, 85%](images/micronaut-launch.png)


---

# Micronaut Project is Healthy

- ~3 years of development by several OCI engineers. 
- 200 contributors (19 from OCI).
- Contributions from Google, AWS, Oracle
- 3.8k stars on GitHub.
- ~8.3k commits.
- Star us! [https://github.com/micronaut-projects/micronaut-core](https://github.com/micronaut-projects/micronaut-core)

![right,90%](images/code-frequency.png)


---

# The Future of Java is
# Intelligent Compilers & Smaller, Faster Runtimes

---

# Micronaut Resources

- Gitter Community: [https://gitter.im/micronautfw](https://gitter.im/micronautfw)
- User Guide: [http://micronaut.io/documentation.html](http://micronaut.io/documentation.html)
- Micronaut Launch: [https://launch.micronaut.io](https://launch.micronaut.io)
- Micronaut Guides: [http://guides.micronaut.io](http://guides.micronaut.io)
- Twitter: [https://twitter.com/micronautfw](http://micronaut.io/faq.html)
- Github: [https://github.com/micronaut-projects/micronaut-core](https://github.com/micronaut-projects/micronaut-core)



# Summary

* Micronaut Provides an Awesome Foundation
* Sacrifices Compilation Speed to Gain so Much More
* Solves Problems with Spring, Jakarta EE and Java in General
* Opens the Door to GraalVM Native

----

![original](images/oci-backgrounds/oci-demo-grey.png)

# [FIT] **Q & A**

----

![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
