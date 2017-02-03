
<%--
  Created by IntelliJ IDEA.
  User: RyanHarper
  Date: 2/2/17
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>This is your new ad</title>
</head>
<body>
    <h1><c:out value="${ad.title}" /></h1>
    <p><c:out value="${ad.description}" /></p>
</body>
</html>
