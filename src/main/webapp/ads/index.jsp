
<%--
  Created by IntelliJ IDEA.
  User: RyanHarper
  Date: 1/31/17
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--always have this ^^^ to be able to use "c:"--%>

<html>
<head>
    <title>adsIndex</title>
</head>
<body>

<ul>
    <c:forEach var="ad" items="${ads}">
        <h1>${ad.title}</h1>
        <p>${ad.description}</p>
    </c:forEach>
</ul>

</body>
</html>
