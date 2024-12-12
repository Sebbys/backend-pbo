# Project Documentation

## Folder Structure

The project has the following folder structure:

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nightfall/
│   │   │           └── backend/
│   │   │               ├── controllers/
│   │   │               ├── models/
│   │   │               ├── repositories/
│   │   │               ├── services/
│   │   │               └── ProjectApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── project/
└── pom.xml
```

- `controller/`: Contains the REST controllers.
- `models/`: Contains the JPA entity classes.
- `repositories/`: Contains the Spring Data JPA repositories.
- `services/`: Contains the service layer classes.
- `resources/`: Contains the application properties and static resources.

## Creating an Entity Class

Entity classes should be created in the `src/main/java/com/example/project/models/` directory. An example of an entity class:

```java
package com.example.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExampleEntity {
    @Id
    private Long id;
    private String name;

    // Getters and setters
}
```

## Running the Spring Boot Application

To run the Spring Boot application, follow these steps:

1. Ensure you have JDK 11 or later installed.
2. Navigate to the project directory.
3. Use the following command to run the application:

```sh
./mvnw spring-boot:run
```

Alternatively, you can build the project and run the generated jar file:

```sh
./mvnw clean package
java -jar target/project-0.0.1-SNAPSHOT.jar
```

## Database Schema

Use the following SQL statements to create the database schema:

```sql
-- Create Table: person
CREATE TABLE person (
    id TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    contact TEXT
);

-- Create Table: "user"
CREATE TABLE "user" (
    user_id TEXT PRIMARY KEY,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    person_id TEXT REFERENCES person(id) ON DELETE CASCADE
);

-- Create Table: discount
CREATE TABLE discount (
    discount_id TEXT PRIMARY KEY,
    discount_type TEXT,
    value NUMERIC(10, 2)
);

-- Create Table: customer
CREATE TABLE customer (
    customer_id TEXT PRIMARY KEY,
    person_id TEXT REFERENCES person(id) ON DELETE CASCADE
);

-- Create Table: product
CREATE TABLE product (
    id TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL,
    discount_id TEXT REFERENCES discount(discount_id) ON DELETE SET NULL
);

-- Create Table: transaction
CREATE TABLE transaction (
    transaction_id TEXT PRIMARY KEY,
    customer_id TEXT REFERENCES customer(customer_id) ON DELETE CASCADE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total NUMERIC(10, 2),
    discount_id TEXT REFERENCES discount(discount_id) ON DELETE SET NULL
);

-- Create Table: transaction_product (Many-to-Many Relationship)
CREATE TABLE transaction_product (
    id TEXT PRIMARY KEY,
    transaction_id TEXT REFERENCES transaction(transaction_id) ON DELETE CASCADE,
    product_id TEXT REFERENCES product(id) ON DELETE CASCADE,
    quantity INT NOT NULL
);
```
