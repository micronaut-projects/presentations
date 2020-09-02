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
# [FIT] **MICRONAUT AND AOT**
> _The Power of Ahead of Time (AOT) Compilation_

```
```

---

![original](images/oci-backgrounds/oci-white.png)

# About Me

* Graeme Rocher
* Creator of Grails and Micronaut
* Principal Engineer at Object Computing
* Oracle Groundbreaker Award Winner

> http://github.com/graemerocher
> https://twitter.com/graemerocher

---

![original](images/oci-backgrounds/oci-white.png)

# Agenda

* Introduction to Micronaut and AOT
* Micronaut and GraalVM
* Micronaut AOT Features
* Demos!

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut and AOT

* What separates Micronaut from other frameworks
* Majority of framework logic computed at compilation time
* Eliminates
	* Reflection
	* Runtime Proxies
	* Dynamic Class Loading
	* Type Erasure Problems

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Why AOT Compilation?

* The more you do at compilation time, the less you have to do at runtime
* The less you have to do at runtime means:
	* Faster startup
	* Less memory consumption
	* Better performance

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut and GraalVM and AOT

* A New Universal Virtual Machine from Oracle
* Features a `native-image` Tool 
	* Converts Java -> native machine code using AOT
* Works well with Micronaut

> http://www.graalvm.org

![right, 100%](images/graal.png)

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut AOT API

* Micronaut AST (Abstract Syntax Tree)
	* Package `io.micronaut.inject.ast`
* `TypeElementVisitor` API
	* Allows Visiting AST
* Works with all supported languages (Java, Groovy and Kotlin)

![right, 35%](images/micronaut-stack-blue.png)

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **DEMO**
## **Micronaut AOT in Action**

----

![original](images/oci-backgrounds/oci-white.png)

# `TypeElementVisitor` API
### Visits AST Nodes

```java
public class AvroVisitor 
    implements TypeElementVisitor<AvroEntity, Object> {
	...
}
```

* The above only visits classes annotated with `@AvroEntity`
* Use `visit*` methods to dictate which parts of the class to visit

----

![original](images/oci-backgrounds/oci-white.png)

# `ClassElement` API
### Represents a Class

```java
void visitClass(ClassElement element, 
				VisitorContext context) {
 	// process type
}	
```

* Provides API to inspect annotations,
resolve properties, handle generic types etc.

----

![original](images/oci-backgrounds/oci-white.png)

# `Element` Types

* `ClassElement` - represents a class
* `FieldElement` - a field of a class
* `PropertyElement` - a JavaBean property
* `MethodElement` - a method
* `ParameterElement` - a parameter to a method 

----

![original](images/oci-backgrounds/oci-white.png)

# Generating Files
### Use `finish` and `VisitorContext`

```java
void finish(VisitorContext context) {
 	context.visitMetaInfFile("example.avro").ifPresent(file -> {
 		try (Writer w = file.openWriter()) {
 			// write file
 		}
 	});
}	
```

* `VisitorContext` abstracts target directory etc.

----

![original](images/oci-backgrounds/oci-white.png)

# Reporting Errors
### Use `fail` and `VisitorContext`

```java
void visitMethod(MethodElement element, 
				VisitorContext context) {
 	if (!element.getReturnType().isPrimitive()) {
 		context.fail("Only primitive return types supported", element);
 	}
}	
```

* By passing in the element you generate a nice error

----

![original](images/oci-backgrounds/oci-white.png)

# Micronaut AOT Use Cases

* Pre-computing serialization formats
	* Avro, protobuf, JavaScript etc.
* Documentation generation
	* Swagger, Custom docs etc.
* Advanced - Byte Code generation
	* Example `IntrospectedTypeElementVisitor`

----

# Summary

* Micronaut is optimized for AOT compilation
* Provides an API and toolkit for AOT
* So much can be done by the compiler
* We're just getting started!

----

![original](images/oci-backgrounds/oci-demo-dark.png)

# [FIT] **Q & A**

----


![original](images/oci-backgrounds/oci-connect.png)

----

![original](images/oci-backgrounds/oci-training.png)
