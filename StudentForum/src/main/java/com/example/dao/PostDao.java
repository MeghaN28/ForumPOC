package com.example.dao;

import com.example.DatabaseConnection;
import com.example.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private Connection connection;

    public PostDao() {
        connection = DatabaseConnection.getConnection();  // Assuming you have this class for DB connection
    }

    // Method to add a new post
    public void addPost(Post post) {
        String sql = "INSERT INTO posts (studentId, title, content) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, post.getStudentId());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getContent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all posts
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts"; // Adjust if you want specific fields

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int studentId = rs.getInt("studentId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                // Create a Post object and add it to the list
                posts.add(new Post(id, studentId, title, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
