## Spring Boot, React, MySQL, JPA, Hibernate TODO APP



## Preview

![](src/main/resources/static/todo-preview.gif)


## API Reference

#### Get all tasks

```http
  GET /api/list
```


#### Create a new task

```http
  POST /api/create
```


#### Update a task

```http
  PUT /api/update/{taskID}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `taskID` | `Integer` | **Required**. ID of the task to update |

#### Mark a task (completed/uncompleted)

```http
  PUT /api/update/check/{taskID}/{completed}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `taskID` | `Integer` | **Required**.  ID of the task to be marked |
| `completed` | `boolean` | **Required**. Status of the task (completed/uncompleted) |


#### Delete All Tasks
```http
  DELETE /api/deleteAll
```

#### Delete Specific Tasks

```http
  DELETE /api/delete/{taskID}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `taskID` | `Integer` | **Required**. ID of the task to delete |


## Frontend : https://github.com/mtamerb/react-todo 


### Table of Content🚀️

1. What we will build
2. Tech Stack
3. Use Project



## 1. What we will build

Build a TODO APP using Spring boot, React,  spring data JPA, Hibernate and MySQL database.


### 2. Tech Stack

<details>

- [Java](https://www.java.com/tr/) - Java is a powerful general-purpose programming language-
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





## Authors

- [@tamerb](https://github.com/mtamerb)


