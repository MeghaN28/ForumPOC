package com.example;

import com.example.dao.PostDao;
import com.example.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/posts") // Change this to match the URL you want to access
public class PostServlet extends HttpServlet {

    private PostDao postDAO;

    @Override
    public void init() throws ServletException {
        // Initialize PostDao here to reuse in doGet and doPost
        postDAO = new PostDao();
    }

    // Handle GET requests to retrieve and display all posts
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = postDAO.getAllPosts();

        request.setAttribute("posts", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("forum.jsp"); // Ensure forum.jsp is in the correct path
        dispatcher.forward(request, response);
    }

    // Handle POST requests to create a new post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data for creating a new post
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int studentId = Integer.parseInt(request.getParameter("studentId")); // Assuming student ID is provided

        // Create a new post and save it to the database
        Post newPost = new Post(studentId, title, content);
        postDAO.addPost(newPost);

        // Redirect to the posts list
        response.sendRedirect("posts"); // Redirect to the same URL to see the updated posts list
    }
}
