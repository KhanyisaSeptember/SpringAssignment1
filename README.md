# Spring Assignment 1

A Java Spring Boot web application provides access to course information for different levels of study through Spring Boot HTTP endpoints. 
It uses a REST controller to serve static HTML pages containing information for Foundation, Undergraduate, and Honours courses.

## Features

* Spring Boot web application
* REST-based HTTP endpoints
* Foundation course information
* Undergraduate course information
* Honours course information
* Static HTML resource handling
* Gradle-based project configuration

## Application Endpoints

| Endpoint         | Description                               |
| ---------------- | ----------------------------------------- |
| `/foundation`    | Displays Foundation course information    |
| `/undergraduate` | Displays Undergraduate course information |
| `/honours`       | Displays Honours course information       |

The endpoints are implemented using Spring Boot's `@GetMapping` annotation.

For example:

```java
@GetMapping("/undergraduate")
public Resource undergraduate() throws IOException {
    Paths.get(new ClassPathResource(
        "static/undergraduateCourses.html"
    ).getURI());

    return new ClassPathResource(
        "static/undergraduateCourses.html"
    );
}
```

## Technologies Used

* Java
* Spring Boot
* Spring Web
* HTML
* Gradle

## Project Structure

```text
SpringAssignment1/
├── gradle/
│   └── wrapper/
├── src/
│   └── ...
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
```

The application serves course-related HTML resources from the application's static resources directory.

## Running the Application

### Prerequisites

A compatible Java Development Kit (JDK) is required.

### Clone the Repository

```bash
git clone https://github.com/KhanyisaSeptember/SpringAssignment1.git
```

Navigate to the project:

```bash
cd SpringAssignment1
```

### Run with Gradle

On Windows:

```bash
gradlew.bat bootRun
```

On macOS/Linux:

```bash
./gradlew bootRun
```

After the Spring Boot application starts, the available routes include:

```text
/foundation
/undergraduate
/honours
```

For example:

```text
http://localhost:8080/undergraduate
```

## Academic Context

This project was developed in 2024 as an academic exercise in building a Java web application with the Spring Boot framework.

It demonstrates the use of Spring Boot application configuration, REST controllers, HTTP GET mappings, classpath resources, static HTML content, and Gradle project management.
