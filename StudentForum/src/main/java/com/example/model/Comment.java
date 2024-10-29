package com.example.model;

public class Comment {
    private int id;
    private int postId;
    private int studentId;
    private String content;

    // Constructor with id
    public Comment(int id, int postId, int studentId, String content) {
        this.id = id;
        this.postId = postId;
        this.studentId = studentId;
        this.content = content;
    }

    // Constructor without id
    public Comment(int postId, int studentId, String content) {
        this.postId = postId;
        this.studentId = studentId;
        this.content = content;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
