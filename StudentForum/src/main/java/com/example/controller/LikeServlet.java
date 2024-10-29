package com.example.controller;

import com.example.dao.LikeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));  // Assuming student is logged in

        LikeDao likeDAO = new LikeDao();

        // Check if the student has already liked the post
        if (!likeDAO.hasLiked(postId, studentId)) {
            // If not already liked, add the like
            likeDAO.addLike(postId, studentId);
        }

        // Redirect or forward to the post page
        response.sendRedirect("postDetails.jsp?postId=" + postId);
    }
}
