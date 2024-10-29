<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Forum</title>
</head>
<body>
<h1>Student Forum</h1>

<!-- Form to create a new post -->
<form action="forum" method="post"> <!-- Ensure this points to your servlet -->
    <input type="hidden" name="studentId" value="1"> <!-- Placeholder for student ID -->
    <input type="text" name="title" placeholder="Post Title" required>
    <textarea name="content" placeholder="Post Content" required></textarea>
    <button type="submit">Create Post</button>
</form>

<h2>All Posts:</h2>
<ul>
    <c:forEach var="post" items="${posts}">
        <li>
            <h3>${post.title}</h3>
            <p>${post.content}</p>
            <small>Posted by Student ID: ${post.studentId}</small>
        </li>
    </c:forEach>
</ul>
</body>
</html>
