# spring-boot-utils

<img src="https://github.com/joseosuna-engineer/spring-boot-utils/blob/main/Java.png" align="left"  width="200" />

**Java** is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.
It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.
Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. <br /><br /><br />


# **Spring Boot**

**These Java examples cover Spring Boot.**

<img src="https://github.com/joseosuna-engineer/spring-boot-utils/blob/main/spring-boot.png" align="right"  width="300" />

**Spring** Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". <br />

You can use Spring Boot to create stand-alone Java applications that can be started using ```java -jar``` or more traditional WAR deployments. We also provide a command line tool that runs spring scripts.


## Setup
* Ubuntu 20.xx
* OpenJDK 11.xx
* set **JAVA_HOME** env var
* Apache Maven 3.6.x
* set **M2_HOME** env var
* install curl


## How to run
```mvn clean install```


```mvn spring-boot:run```


## Examples

- ### String HttpUtil.get()

Returns **Ok** when Http Response Code is 200 as a result of GET http.util.url?postId=1 <br />
**http.util.url** is located in application.properties <br />
  
#### Testing
```curl localhost:5151/get```

Answer **Ok**
