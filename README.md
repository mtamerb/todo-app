﻿## Spring Boot, MySQL, JPA, Hibernate Restful CRUD API

### Table of Content🚀️

1. What we will build
2. Tech Stack
3. Use Project
4. Package Structure
5. Dependency
6. API Test

---

## 1. What we will build

Build a TODO APP using Spring boot, React,  spring data JPA, Hibernate and MySQL database.


### 2. Tech Stack

<details>

- [Java](https://bell-sw.com/pages/downloads/) - Java is a powerful general-purpose programming language-
- [Spring](https://spring.io) - The Spring Framework is an application framework and inversion of control container for the Java platform.
- [React](https://react.dev/) - React is an open source javascript library for creating user interfaces.
- [MySQL](https://dev.mysql.com/downloads/installer/) - MySQL Database is a client/server system that consists of a multithreaded SQL server that supports different back ends, several different client programs and libraries, administrative tools, and a wide range of application-programming interfaces (APIs).
- [Jpa](https://spring.io/projects/spring-data-jpa) -The Java Persistence API (JPA) is a specification of Java. It is used to persist data between Java object and relational database.
- [Maven](https://maven.apache.org) - Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
- [Postman](https://www.postman.com) - Postman is an API platform for building and using APIs.
- [Lombok](https://projectlombok.org/download) - Project Lombok (from now on, Lombok) is an annotation-based Java
  library that allows you to reduce boilerplate code.
- [Intellij Idea](https://www.jetbrains.com/idea/) - IntelliJ IDEA is an Integrated Development Environment (IDE) for
  JVM languages designed to maximize developer productivity.

</details>

### 3. Use Project

1-The simplest way is to use clone this repository.

```sh
git clone https://github.com/mtamerb/todo-app.git
```
2-Then navigate to the path where the todo project is located in the Terminal
```sh
cd todo-app
```
3- Configure database:
go application properties file then :

```sh
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/{your-schema}
spring.datasource.username={your-username}
spring.datasource.password={your-password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```


### 4. Package Structure

![](assets/packages.png)

### 5. Dependency 

![](assets/maven.png)



<dependencies>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>

</dependencies>

> pom.xml


```sh
spring.datasource.url=jdbc:mysql://localhost:3306/testdb

spring.datasource.username=root

spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
```
> application.properties
### 6. Api Test

> go : https://www.postman.com

<details>

![](assets/mainpage.png)

![](assets/users1.png)

![](assets/post.png)

![](assets/users2.png)

![](assets/del.png)

![](assets/update.png)

![](assets/users3.png)

![](assets/mysql.png)

</details>

### References
[1] https://hemant-jain-42745.medium.com/restful-api-a7a19ca387d0
