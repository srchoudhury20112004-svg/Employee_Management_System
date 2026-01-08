-- Create the database
CREATE DATABASE IF NOT EXISTS employee_management;

-- Use the database
USE employee_management;

-- Departments table
CREATE TABLE departments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

-- Employees table
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    department_id INT,
    hire_date DATE,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- Salaries table
CREATE TABLE salaries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    effective_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);

-- Sample data
INSERT INTO departments (name, location) VALUES ('HR', 'New York'), ('IT', 'San Francisco');
INSERT INTO employees (name, email, phone, department_id, hire_date) VALUES
('John Doe', 'john@example.com', '1234567890', 1, '2023-01-01'),
('Jane Smith', 'jane@example.com', '0987654321', 2, '2023-02-01');
INSERT INTO salaries (employee_id, amount, effective_date) VALUES
(1, 50000.00, '2023-01-01'),
(2, 60000.00, '2023-02-01');