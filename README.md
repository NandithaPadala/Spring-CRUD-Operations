# Spring Boot CRUD Project

This is a Spring Boot project demonstrating basic **CRUD (Create, Read, Update, Delete)** operations using **Spring Data JPA**, **MySQL Database**, and **RESTful APIs**. This project serves as a foundation for learning and extending additional functionalities in Spring Boot.

---

## Table of Contents

- [Technologies Used](#technologies-used)  
- [Project Structure](#project-structure)  
- [Setup & Installation](#setup--installation)  
- [API Endpoints](#api-endpoints)

---

## Technologies Used

- Java 17 
- Spring Boot 3.x  
- Spring Data JPA  
- MySQL Database  
- Maven  
- Lombok (optional for boilerplate code reduction)  
- Postman (for API testing)  

---

## Project Structure
<img width="619" height="323" alt="image" src="https://github.com/user-attachments/assets/a37da994-5817-49b3-939f-ed23b6bc215d" />

---

## Setup & Installation

Follow these steps to set up and run the project:

### 1. Clone the repository

```bash
git clone https://github.com/NandithaPadala/CRUD_Operations.git
cd crudOperations
```
### 2. Configure the database
Update the application.properties or application.yml file with your MySQL configuration:
```bash

spring.datasource.url=jdbc:mysql://localhost:3306/crud
spring.datasource.username=root
spring.datasource.password=mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080.

### API Endpoints
| Method | Endpoint      | Description             |
| ------ | ------------- | ----------------------- |
| POST   | `/users`      | Create a new user       |
| GET    | `/users`      | Retrieve all users      |
| GET    | `/users/{id}` | Retrieve a user by ID   |
| PUT    | `/users/{id}` | Update an existing user |
| DELETE | `/users/{id}` | Delete a user by ID     |
