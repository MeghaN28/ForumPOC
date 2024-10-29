package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private Connection connection;

    public CommentDAO()
    {
        connection = DatabaseConnection.getConnection();  // Assuming you have a DatabaseConnection class
    }

    // Add a new comment to the database
    public void addComment(Comment comment) {
        String sql = "INSERT INTO comments (postId, studentId, content) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, comment.getPostId());
            stmt.setInt(2, comment.getStudentId());
            stmt.setString(3, comment.getContent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all comments for a specific post
    public List<Comment> getCommentsByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE postId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, postId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int studentId = rs.getInt("studentId");
                    String content = rs.getString("content");
                    comments.add(new Comment(id, postId, studentId, content));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
