package com.example;

import com.example.dao.PostDao;
import com.example.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

@WebServlet("/forum")
public class ForumServlet extends HttpServlet {

    private PostDao postDao;

    @Override
    public void init() throws ServletException {
        postDao = new PostDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null || action.equals("/")) {
            List<Post> posts = postDao.getAllPosts();
            request.setAttribute("posts", posts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (title != null && content != null) {
            Post newPost = new Post(0, title, content); // ID is auto-generated
            postDao.addPost(newPost);
        }

        response.sendRedirect(request.getContextPath() + "/forum");
    }
}
