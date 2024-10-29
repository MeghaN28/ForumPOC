package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection connection;

    public StudentDao()
    {
        connection = DatabaseConnection.getConnection();
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";  // Assumes you have a `students` table in your DB

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");  // Get password from DB
                students.add(new Student(id, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Add a new student
    public void addStudent(Student student)
    {
        String sql = "INSERT INTO students (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getPassword());  // Insert password
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
