<%--
  Created by IntelliJ IDEA.
  User: Krystian
  Date: 09.06.2021
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <li><a href="${contextPath}/office-hours/">Office Hours</a></li>
    <li><a href="${contextPath}/register">Register</a></li>
    <li><a href="${contextPath}/login">Login</a></li>
</body>
</html>
