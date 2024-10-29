<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Forum</title>
</head>
<body>
    <h1>Student Forum</h1>
    <h2>All Posts</h2>
    <ul>
        <c:forEach var="post" items="${posts}">
            <li>
                <h3>${post.title}</h3>
                <p>${post.content}</p>
            </li>
        </c:forEach>
    </ul>

    <h2>Create a New Post</h2>
    <form action="${pageContext.request.contextPath}/forum" method="post">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" required><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" required></textarea><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
