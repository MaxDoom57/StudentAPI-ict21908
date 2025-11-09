# Student Management API — Setup & Endpoints

This document provides instructions on how to set up, configure, and run the Student Management API, along with a detailed list of available endpoints.

# Project Setup Steps
## Prerequisites
Before starting, make sure you have:
 - Java 17+ installed
 - Maven installed
 - MySQL running locally
 - An IDE such as IntelliJ IDEA or VS Code

## Clone or Create Project
Clone your repository and open it in your IDE.
 - https://github.com/MaxDoom57/StudentAPI-ict21908.git
 - cd student-management-api

## Configure Database Connection
 - Edit the file: src/main/resources/application.properties

## Run the Application
  ### Clean and install dependencies
 - mvn clean install

  ### Run the Spring Boot application
 - mvn spring-boot:run

The backend will start at: http://localhost:8080

---

# API Endpoints

  ______________________________________________________________________________________
  Method   | Endpoint                               | Description                       | 
  ---------|----------------------------------------|-----------------------------------|
  GET      | /api/students                          | Get all students                  | 
  GET      | /api/students/{id}                     | Get a single student by ID        |
  POST     | /api/students                          | Add a new student                 | 
  PUT      | /api/students/{id}                     | Update an existing student        | 
  DELETE   | /api/students/{id}                     | Delete a student by ID            | 
  GET      | /api/students/search?keyword={text}    | Search students by name or course |
  --------------------------------------------------------------------------------------




