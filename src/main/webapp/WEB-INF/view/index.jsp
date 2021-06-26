<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <li><a href="${contextPath}/office-hours/">Office Hours</a></li>
    <li><a href="${contextPath}/visits/">Visits</a></li>
    <li><a href="${contextPath}/patient-register">Register Patient</a></li>
    <li><a href="${contextPath}/doctor-register">Register Doctor</a></li>
    <li><a href="${contextPath}/login">Login</a></li>
</body>
</html>
