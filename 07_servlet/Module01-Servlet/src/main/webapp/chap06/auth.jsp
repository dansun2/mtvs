<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>
    <%
        String loggedInUser = (String) session.getAttribute("loggedInUser");
    %>
    <%= loggedInUser %>
</h1>
</body>
</html>