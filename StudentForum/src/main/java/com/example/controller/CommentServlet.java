package com.example.controller;


import com.example.dao.CommentDAO;
import com.example.model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        int postId = Integer.parseInt(request.getParameter("postId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));  // Assuming student is logged in and their ID is available

        // Create a Comment object
        Comment comment = new Comment(postId, studentId, content);

        // Save the comment using DAO
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.addComment(comment);

        // Redirect or forward to another page (like post details)
        response.sendRedirect("postDetails.jsp?postId=" + postId);
    }
}
