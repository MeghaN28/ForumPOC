package com.example.dao;

import com.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDao {
    private Connection connection;

    public LikeDao() {
        connection = DatabaseConnection.getConnection();  // Assuming you have a DatabaseConnection class
    }

    // Add a like to the post
    public void addLike(int postId, int studentId) {
        String sql = "INSERT INTO likes (postId, studentId) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, postId);
            stmt.setInt(2, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check if a student has already liked a post
    public boolean hasLiked(int postId, int studentId) {
        String sql = "SELECT * FROM likes WHERE postId = ? AND studentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, postId);
            stmt.setInt(2, studentId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // returns true if a like already exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
