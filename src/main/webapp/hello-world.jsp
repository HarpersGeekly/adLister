<%--
  Created by IntelliJ IDEA.
  User: RyanHarper
  Date: 1/31/17
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- new library to use "<c: tags"--%>

<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h1>Hello ${name}!</h1> <%-- needs the above if statement...meh --%>
    <h2>Your age is ${age}!</h2> <%--*instead, this expression language syntax is shorter, but it's not referring to your local variable* --%>
    <p>
        <c:choose>
            <c:when test="${languages.isEmpty()}">
                <p>You still have to learn some programming languages.</p>
            </c:when>
            <c:otherwise>
            <p>
                And you know the following languages:
                <%--<%= Arrays.toString(languages.toArray())%>--%>
            </p>
            <ul>
                <c:forEach var="language" items="${languages}">
                    <li>${language}</li>
                </c:forEach>
            </ul>
            </c:otherwise>
        </c:choose>
    </p>
</body>
</html>
