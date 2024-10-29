package com.example.controller;

import com.example.model.Post;
import com.example.dao.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreatePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int studentId = Integer.parseInt(request.getParameter("studentId"));  // Assuming student is logged in

        // Create a new Post object
        Post post = new Post(studentId, title, content);

        // Save the post using DAO
        PostDao postDAO = new PostDao();
        postDAO.addPost(post);

        // Redirect or forward to another page (like forum main page)
        response.sendRedirect("forum.jsp");
    }
}
