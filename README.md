# Spring Boot CRUD Project

This is a Spring Boot project demonstrating basic **CRUD (Create, Read, Update, Delete)** operations using **Spring Data JPA**, **MySQL Database**, and **RESTful APIs**. This project serves as a foundation for learning and extending additional functionalities in Spring Boot.

---

## Table of Contents

- [Technologies Used](#technologies-used)  
- [Project Structure](#project-structure)  
- [Setup & Installation](#setup--installation)  
- [API Endpoints](#api-endpoints)  
- [Future Enhancements](#future-enhancements)  
- [Contributing](#contributing)  
- [License](#license)  

---

## Technologies Used

- Java 17 
- Spring Boot 3.x  
- Spring Data JPA  
- H2 / MySQL Database  
- Maven  
- Lombok (optional for boilerplate code reduction)  
- Postman (for API testing)  

---

## Project Structure
src/main/java
│
├─ controller # REST API Controllers
├─ service # Service layer for business logic
├─ repository # JPA Repositories
├─ model # Entity classes
├─ dto # Data Transfer Objects
├─ exception # Custom Exceptions & Global Exception Handler
└─ SpringBootCrudApplication.java

---

## Setup & Installation

1. **Clone the repository**  
```bash
git clone https://github.com/NandithaPadala/CRUD_Operations.git
cd springboot-crud

Configure the database
Update application.properties or application.yml file:


spring.datasource.url=jdbc:mysql://localhost:3306/crud
spring.datasource.username=root
spring.datasource.password=mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update	
spring.jpa.show-sql=true

2. **Run the application**
```bash
mvn spring-boot:run
-----

