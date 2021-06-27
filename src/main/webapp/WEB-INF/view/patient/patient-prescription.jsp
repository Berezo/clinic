<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Prescription</title>
</head>
<body>
<h2>Prescription:</h2>
<div>
    <table border="1">
        <tr>
            <th>Description</th>
            <th>Medicines</th>
        </tr>
        <tr>
            <td>${prescription.description}</td>
            <td>${prescription.medicines}</td>
        </tr>
    </table>
</div>
<div>
    <a href="${contextPath}/visits">Back</a>
</div>
</body>
</html>