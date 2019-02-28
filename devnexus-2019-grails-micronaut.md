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
# [FIT] **GRAILS 4 AND MICRONAUT**
> _Getting the best out of Grails 4 and Micronaut_

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
* Introduction to Grails 4
* Grails vs Micronaut
* Using Micronaut Features in Grails
* Demos

----

![original](images/oci-backgrounds/oci-white.png)

```
```
# Micronaut for Grails Developers

* Micronaut a Foundational Library for building applications of any type
* Focuses on Small Memory Footprint and Speed
* Eliminates Reflection, Runtime Proxies and Runtime Analysis

![right, 35%](images/micronaut-stack-blue.png)

----
![original](images/oci-backgrounds/oci-white.png)

# Micronaut vs Grails

| Micronaut | Grails |
| --- | --- | 
| Range of Runtimes | Servlet Only | 
| General Purpose | Traditional Servlet Web Apps | 
| DI, AOP etc. | Spring for DI, AOP etc. |
| Java, Kotlin, Groovy, GraalVM | Groovy Only |
| Client and Server | Server Only |
----
![original](images/oci-backgrounds/oci-white.png)
# What Can You Do 

* Build Configurations (Instead of Plugins)
* Declarative Clients
	- HTTP
	- Kafka
	- RabbitMQ


![right, 35%](images/micronaut-stack-blue.png)

----
![original](images/oci-backgrounds/oci-white.png)

# Configurations vs Plugins

* Consider Building Configurations instead of Plugins
* Work with Micronaut, Spring (with `micronaut-spring`) and Grails
* Plugins only work with Grails
* ... although some things only possible with Plugins

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Configurations with Grails**

----
![original](images/oci-backgrounds/oci-white.png)
# Micronaut Configurations

* Configuration with `@ConfigurationProperties`
* Beans with `@Singleton`, `@Factory` etc.
* Conditional Behaviour with `@Requires`
* Customization with `@Replaces` 


![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# `@ConfigurationProperties`

```java
@ConfigurationProperties("example")
class ExampleConfiguration {
	String name
}


ApplicationContext context = ApplicationContext.run("example.name":"Demo")
FooConfiguration config = context.getBean(FooConfiguration)
assert config.name == 'Demo'
```

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut HTTP Client**

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Kafka Client**

----

# Summary

* Micronaut Provides an Awesome Foundation
* Most Micronaut Features Available in Grails
* Build Micronaut Libraries not Plugins

----

![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
