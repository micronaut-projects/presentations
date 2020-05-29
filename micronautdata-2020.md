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

# A History of Data Access Toolkits

* Rails' ActiveRecord Started it all
* GORM for Grails first to bring the pattern to the JVM in 2007
* Spring Data / DeltaSpike and others followed
* All use runtime analysis

![right, 20%](images/java.png)

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
* Solution for Static Queries
* Uses Micronaut's reflection-free AOP
* Zero runtime overhead database access solution
* Compilation time checking
* Smaller stack traces


![right, 50%](https://uc3456f2690d7fa57a150545bd99.previews.dropboxusercontent.com/p/thumb/AAzbc5KNbVmclMZ0zNc5Uz_yA89oAhEke6gvCj4M-WaCl94QZAM4xnMFNuvggYEwZ2C3u9crcye8ozNUOeUwBALRfnoGjPxg0O6ZFXfnAfQCfPo5PIqZ25YhOtEtr1wPGbOA7lF8X1QtNZP3cCJw0G_sQ7yENLkXWOnL6Sw6eMKzMkOKE8x6z7U7UeBrPd1bcJnJiRDdJEC__xfbozJLy1nciCAC8bHC9atI1w-SMVqPdB0MtbTaIwpdbz12Y8O0-_Hby92CFbJHLYuYS2rtpOFYlq-T_TtHpjRXue8-VlGM8XloEXz5vGpDovGeJJZV1BT_mL35m-FuvZrLbbQOQerxURsJDU4tXk-3eOZvo806HgaCVoGf3xkLzLqaI0p3ZSpsf75Z1zVAeWQ-meJ-P4DR/p.png?fv_content=true&size_mode=5)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Data JPA

* Support for Hibernate / JPA
* Precomputes JPA-QL queries
* For users who prefer full ORM
* Hibernate feature-rich with support for many dialects
* Still leans on reflection / runtime proxies



![right, 35%](https://hibernate.org/images/hibernate-logo.svg)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Data JDBC

* Support for native JDBC
* Pure data mapper (not an ORM!)
* Focused on DTOs and immutability
* Discourages Single Entity -> Table approach
* Lighter weight
* Reflection and Proxy Free


![right, 50%](https://uc3456f2690d7fa57a150545bd99.previews.dropboxusercontent.com/p/thumb/AAzbc5KNbVmclMZ0zNc5Uz_yA89oAhEke6gvCj4M-WaCl94QZAM4xnMFNuvggYEwZ2C3u9crcye8ozNUOeUwBALRfnoGjPxg0O6ZFXfnAfQCfPo5PIqZ25YhOtEtr1wPGbOA7lF8X1QtNZP3cCJw0G_sQ7yENLkXWOnL6Sw6eMKzMkOKE8x6z7U7UeBrPd1bcJnJiRDdJEC__xfbozJLy1nciCAC8bHC9atI1w-SMVqPdB0MtbTaIwpdbz12Y8O0-_Hby92CFbJHLYuYS2rtpOFYlq-T_TtHpjRXue8-VlGM8XloEXz5vGpDovGeJJZV1BT_mL35m-FuvZrLbbQOQerxURsJDU4tXk-3eOZvo806HgaCVoGf3xkLzLqaI0p3ZSpsf75Z1zVAeWQ-meJ-P4DR/p.png?fv_content=true&size_mode=5)

----

![original](images/oci-backgrounds/oci-white.png)

# JDBC vs JPA

JDBC|Hibernate/JPA
---|---
More Efficient | Greater Memory Requirements
Fewer Dialects | More Dialects
DTOs | Single Entity -> Table
Optimized Reads | Optimized Writes
Better for Serverless | Cold Starts an Issue

----
# Hello Micronaut Data JPA

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

* Each repository interface annotated with `@Repository`
* Can extend built in interface's like `CrudRepository`

```java
@Repository
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
## **Micronaut Data JPA**


----
##  Repository Methods

* Queries formed by analyzing method signatures
*
*

![inline,bottom	](https://micronaut-projects.github.io/micronaut-data/latest/img/finderpattern.svg)



----
# Hello Micronaut Data JDBC

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
# Data JDBC Dialect

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

* The dialect is specified on the interface
* Ensures compilation time computed queries use 
  the right dialect

```java
@JdbcRepository(dialect=Dialect.MYSQL)
interface PersonRepository 
	...
}
```

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut Data JDBC**

----
# Micronaut Data & Schema Migration

![original](images/oci-backgrounds/oci-white.png)


* You should always pair Micronaut Data with a schema migration tool
* Flyway or Liquibase
* Schema generation in Hibernate and Data JDBC only for experiments and quick demos

![right, 95%](https://flywaydb.org/assets/logo/flyway-logo-tm.png)


----
# Micronaut Data DTOs

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

* POJOs annotated with `@Introspected`
* Can be Immutable

```java
@Introspected
class PersonDTO
	private String name;
	private int age;
	// getters/setters
}
```

----
# Micronaut Data Transactions

![original](images/oci-backgrounds/oci-white.png)

[.hide-footer]

* Either Micronaut or Spring Tx Manager Supported
* Programmatic or declarative transactions

```java
Product save(String name, Manufacturer manufacturer) {
    return transactionManager.executeWrite(status -> { 
        final Product product = new Product(name, manufacturer);
        entityManager.persist(product);
        return product;
    });
}
```

----

![original](images/oci-backgrounds/oci-white.png)

# Static vs Dynamic Queries


![original](images/oci-backgrounds/oci-white.png)


* Micronaut Data's strength is in static queries
* For dynamic queries use JPA criteria for JPA
* When using JDBC consider pairing Micronaut Data 
 with JOOQ or JDBI for dynamic queries



![right, 50%](https://uc3456f2690d7fa57a150545bd99.previews.dropboxusercontent.com/p/thumb/AAzbc5KNbVmclMZ0zNc5Uz_yA89oAhEke6gvCj4M-WaCl94QZAM4xnMFNuvggYEwZ2C3u9crcye8ozNUOeUwBALRfnoGjPxg0O6ZFXfnAfQCfPo5PIqZ25YhOtEtr1wPGbOA7lF8X1QtNZP3cCJw0G_sQ7yENLkXWOnL6Sw6eMKzMkOKE8x6z7U7UeBrPd1bcJnJiRDdJEC__xfbozJLy1nciCAC8bHC9atI1w-SMVqPdB0MtbTaIwpdbz12Y8O0-_Hby92CFbJHLYuYS2rtpOFYlq-T_TtHpjRXue8-VlGM8XloEXz5vGpDovGeJJZV1BT_mL35m-FuvZrLbbQOQerxURsJDU4tXk-3eOZvo806HgaCVoGf3xkLzLqaI0p3ZSpsf75Z1zVAeWQ-meJ-P4DR/p.png?fv_content=true&size_mode=5)

----

![original](images/oci-backgrounds/oci-white.png)

# GraalVM Native 


![original](images/oci-backgrounds/oci-white.png)


* Both JPA and JDBC implementations support GraalVM native image
* Currently require a few tweaks when switching driver
	* https://micronaut-projects.github.io/micronaut-data/latest/guide/#graal
* Massive improvements coming to this support in Micronaut 2.0 / Micronaut Data 1.1

![right, 25%](https://www.graalvm.org/resources/img/home/logo-coloured.svg)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut Data Roadmap


![original](images/oci-backgrounds/oci-white.png)


* Micronaut Data 1.1 coming soon with UUID improvements, Oracle identity column support and better GraalVM support
* Micronaut Data 2.0 (Q4)
	* R2DBC Support
	* MongoDB Support
	* Neo4j Support


![right, 50%](https://uc3456f2690d7fa57a150545bd99.previews.dropboxusercontent.com/p/thumb/AAzbc5KNbVmclMZ0zNc5Uz_yA89oAhEke6gvCj4M-WaCl94QZAM4xnMFNuvggYEwZ2C3u9crcye8ozNUOeUwBALRfnoGjPxg0O6ZFXfnAfQCfPo5PIqZ25YhOtEtr1wPGbOA7lF8X1QtNZP3cCJw0G_sQ7yENLkXWOnL6Sw6eMKzMkOKE8x6z7U7UeBrPd1bcJnJiRDdJEC__xfbozJLy1nciCAC8bHC9atI1w-SMVqPdB0MtbTaIwpdbz12Y8O0-_Hby92CFbJHLYuYS2rtpOFYlq-T_TtHpjRXue8-VlGM8XloEXz5vGpDovGeJJZV1BT_mL35m-FuvZrLbbQOQerxURsJDU4tXk-3eOZvo806HgaCVoGf3xkLzLqaI0p3ZSpsf75Z1zVAeWQ-meJ-P4DR/p.png?fv_content=true&size_mode=5)

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
