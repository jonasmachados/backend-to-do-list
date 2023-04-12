# Backend To-Do List
This project is the backend for a to-do list application developed in Java with the Spring Boot framework. The project uses the Maven dependency manager and an 
H2 database.

Table of Contents
=================
<!--ts-->
   * [Description](#description)
   * [Technologies used](#technologies)
   * [Requirements](#requirements)
   * [Usage](#usage)
   * [Endpoints](#endpoints)
   * [Contributing](#contributing)
   * [Contact](#contact)
<!--te-->

# Description
This project is a backend for a Todo List application developed using Java and Spring Boot. It provides APIs for CRUD (Create, Read, Update, Delete) operations 
for both tasks and todo lists. With these APIs, users can create, read, update, and delete tasks, as well as create and manage their todo lists. <br>
The project is designed to be easy to use, and developers can quickly set up the application by following the instructions provided in the README file. The code is clean, 
well-structured, and follows best practices, making it easy for developers to understand and maintain the codebase.

# Technologies:
* Java
* Spring Boot
* Maven
* Postman
* H2 Database

# Requirements:

* Java 15 or higher
* Maven 3.6.0 or higher

# Usage:

1. Clone the repository: 
~~~
git clone https://github.com/jonasmachados/backend-to-do-list.git
~~~
2. The application will be available at http://localhost:8080.

# Endpoints:

The API has the following endpoints:
* GET /toDoLists: Returns all to-do lists
* GET /toDoLists/{id}: Returns the to-do list with the given id
* POST /toDoLists: Creates a new to-do list
* PUT /toDoLists/{id}: Updates the to-do list with the given id
* DELETE /toDoLists/{id}: Deletes the to-do list with the given id
* GET /tasks/{id}: Returns the task with the given id
* POST /tasks: Creates a new task

# Contributing:

Contributions are welcome! To contribute, follow these steps:

1. Fork this repository
2. Create a branch for your feature (git checkout -b feature/your-feature)
3. Commit your changes (git commit -am 'Add your feature')
3. Push to the branch (git push origin feature/your-feature)
4. Open a Pull Request

# Contact

If you want to contact me, you can reach me at:

* LinkedIn: https://www.linkedin.com/in/jonas-machados/
* Email: jonasmachado.ti@gmail.com


