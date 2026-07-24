# ToDo App (Java, Maven, and MySQL)

A console-based ToDo application built using Java, Maven, and MySQL.
This project demonstrates CRUD operations, JDBC connectivity, and a
clean layered architecture. It is designed mainly for learning and
practice purposes.

---

## Features

- Add new tasks
- View all tasks
- View pending tasks
- View completed tasks
- Update task status
- Delete tasks
- Data persistence using MySQL
- Maven-based project structure

---

## Tech Stack

- Java (JDK 21+)
- Maven
- MySQL
- JDBC

---

## Project Structure

ToDo-App
- src/main/java/org/prakash
  - dao/TaskDAO.java
  - model/Task.java
  - menu/TaskMenu.java
  - Main.java
- src/main/resources/application.properties
- pom.xml
- README.md

---

## Database Setup

### Step 1: Create Database

CREATE DATABASE todo_app;

---

### Step 2: Create Table

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

---

### Step 3: Configure Database Connection

Edit the file:

src/main/resources/db.properties

Add your database details:

db.url=jdbc:mysql://localhost:3306/todo_app  
db.username=your_username  
db.password=your_password  

---

## How to Run the Application

### Option 1: Using Maven

mvn clean install  
java -jar target/ToDo-App-1.0-SNAPSHOT.jar  

---

### Option 2: Using IDE

1. Import the project as a Maven project  
2. Configure the database in db.properties  
3. Run Main.java  

---

## Sample Menu Output

1. Add Task  
2. View All Tasks  
3. View Pending Tasks  
4. View Completed Tasks  
5. Update Task Status  
6. Delete Task  
0. Exit  

---

## Concepts Used

- JDBC connection handling
- DAO (Data Access Object) pattern
- Separation of concerns
- Maven dependency management
- SQL CRUD operations

---

## What I Learned

- How Java connects to MySQL using JDBC
- Structuring a Java project using Maven
- Writing clean DAO classes
- Handling SQL exceptions
- Externalizing database configuration

---

## Future Improvements

- GUI using JavaFX or Swing
- REST API using Spring Boot
- Authentication and authorization
- Task priorities and deadlines

---

## Contributing

Contributions are welcome.
Feel free to fork the repository and submit pull requests.

---

## License

This project is created for learning and educational purposes only.
