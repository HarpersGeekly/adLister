<%--
  Created by IntelliJ IDEA.
  User: RyanHarper
  Date: 1/30/17
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <label>Username</label>
        <input type="text" name="username">
        <label>Password</label>
        <input type="password" name="password">
        <input type="submit" value="login">
    </form>
</body>
</html>
