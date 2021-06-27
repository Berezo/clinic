<%@ page import="org.hibernate.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Prescription</title>
</head>
<body>
<form:form action="" modelAttribute="prescription" method="POST">
    <form:hidden path="id" id="id" value="${prescription.id}"/>
    <td><label for="desc">Description:</label></td>
    <td><form:input path="description" id="desc"/></td>
    <td><label for="meds">Medicines:</label></td>
    <td><form:input path="medicines" id="meds"/></td>
    <td><form:button type="submit">Save</form:button></td>
</form:form>
</body>
</html>
