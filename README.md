# Employee Management System

A CRUD-based Java application for managing employees, departments, and salaries using MySQL.

## Requirements
- JDK 11+
- MySQL Server 8.0+
- MySQL Connector/J JAR (place in `lib/` folder)

## Setup
1. Install JDK and MySQL.
2. Create a MySQL database: `CREATE DATABASE employee_management;`
3. Update database credentials in `DatabaseConnection.java`.
4. Compile and run: `javac -cp lib/mysql-connector-java-*.jar src/*.java` then `java -cp .;lib/mysql-connector-java-*.jar src.Main`

## Features
- Add, view, update, delete employees.
- Link employees to departments.
- Manage salaries with joins for reports.
- Exception handling and secure queries.