# To-Do API

A simple Spring Boot REST API for managing to-do items.

## Overview

This repository implements a basic CRUD to-do application using Spring Boot, Spring Data JPA, and MySQL.

## Prerequisites

- Java 21+ (configured in `pom.xml`)
- Maven (or use the included Maven wrapper `mvnw` / `mvnw.cmd`)
- **MySQL Server** running locally on `localhost:3306`
  - Database: `todo_db`
  - Username: `root`
  - Password: `rootpassword`

## Build

On Windows (from project root):

```powershell
mvnw.cmd clean package
```

On macOS/Linux:

```bash
./mvnw clean package
```

## Run

Run the application with the Maven plugin (Windows):

```powershell
mvnw.cmd spring-boot:run
```

Or run the built JAR:

```powershell
java -jar target/*.jar
```

The application listens on port 8080 by default. Change settings in `src/main/resources/application.properties`.

## API Endpoints

Assuming server at `http://localhost:8080`.

- GET /todos — list all to-dos
- GET /todos/{id} — get a to-do by id
- POST /todos — create a new to-do (JSON body)
- PUT /todos/{id} — update an existing to-do (JSON body)
- DELETE /todos/{id} — delete a to-do

Example: create a to-do

```bash
curl -X POST http://localhost:8080/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy milk","completed":false}'
```

Example: list to-dos

```bash
curl http://localhost:8080/todos
```

## Tests

Run unit tests:

```powershell
mvnw.cmd test
```

## Notes

- **Database:** MySQL at `localhost:3306` with database name `todo_db`
- **Database User:** `root` / `rootpassword`
- Database configuration is in `src/main/resources/application.properties`.
- Controller is implemented in `src/main/java/com/example/to_do_api/controller/ToDoController.java`.
