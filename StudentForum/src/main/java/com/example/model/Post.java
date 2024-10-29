package com.example.model;

public class Post {
    private int id;
    private int studentId;
    private String title;
    private String content;

    // Constructor with id
    public Post(int id, int studentId, String title, String content) {
        this.id = id;
        this.studentId = studentId;
        this.title = title;
        this.content = content;
    }

    // Constructor without id (for creating new posts)
    public Post(int studentId, String title, String content) {
        this.studentId = studentId;
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
