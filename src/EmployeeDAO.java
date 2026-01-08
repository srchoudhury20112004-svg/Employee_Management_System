package src;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDAO {
    // Create (Add Employee)
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, email, phone, department_id, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getEmail());
            stmt.setString(3, employee.getPhone());
            stmt.setInt(4, employee.getDepartmentId());
            stmt.setDate(5, employee.getHireDate());
            stmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    // Read (Get All Employees with Department using JOIN)
    public void getAllEmployees() {
        String sql = "SELECT e.id, e.name, e.email, e.phone, d.name AS dept_name, e.hire_date FROM employees e LEFT JOIN departments d ON e.department_id = d.id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email") + ", Dept: " + rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }
    }

    // Update Employee
    public void updateEmployee(int id, String name, String email) {
        String sql = "UPDATE employees SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }

    // Get Employee Salary (using JOIN)
    public void getEmployeeSalary(int employeeId) {
        String sql = "SELECT s.amount FROM salaries s WHERE s.employee_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Salary: $" + rs.getDouble("amount"));
            } else {
                System.out.println("No salary found.");
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving salary: " + e.getMessage());
        }
    }
}