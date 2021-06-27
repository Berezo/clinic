<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h3>Imię: ${patient.first_name}</h3>
<h3>Nazwisko: ${patient.surname}</h3>
<br>
<h2>Adres</h2>
<h3>Ulica: ${patient.address.house_number} ${patient.address.street}</h3>
<h3>Miasto: ${patient.address.city}</h3>
<h3>Kod pocztowy: ${patient.address.zip_code}</h3>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
