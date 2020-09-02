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
# [FIT] **Micronaut Data**

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

* Introduction to Micronaut Data
* Technical Overview
* Micronaut Data Demos
* Q & A

----


![original](images/oci-backgrounds/oci-white.png)

# Existing Data Access Solutions

* Spring Data, GORM etc.
* Rely heavily on reflection and runtime proxies
* Must compute queries at runtime
* Cost of computation grows as your application grows

![right, 20%](images/java.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Data

* Precomputes Queries at compilation time
* Uses Micronaut's reflection-free AOP
* Zero runtime overhead database access solution
* Compilation time checking
* Smaller stack traces
* JPA-QL and SQL currently supported


![right, 35%](images/micronaut-stack-blue.png)

----
# Hello Micronaut Data

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

* Each repository interface annotated with `@JdbcRepository`
* Can extend built in interfacesl like `CrudRepository`

```java
@JdbcRepository(dialect=Dialect.MYSQL)
interface PersonRepository 
	extends CrudRepository<Person,Long> {
    Person findByName(String name);
}

```

----
# CRUD Example

![original](images/oci-backgrounds/oci-white.png)

```java
// Create
personRepository.save(new Person("Fred"));

// Read
Person person = personRepository.findByName("Fred");	

// Update
person.updatePerson(person.getId(), "Bob");

// deleteById
person.deleteById(person.getId());

```

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Data**


----


# Summary

* Micronaut Data fits naturally into Micronaut applications
* Zero overhead data access solution
* Reduces memory consumption, improved performance
* GraalVM native image support

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **Q & A**
## **Micronaut Data**
----


![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
