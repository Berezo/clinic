<%@ page import="org.hibernate.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Add pre</title>
</head>
<body>
<form:form action="" modelAttribute="visit" method="POST">
    <br>
    <form:hidden path="id" id="id" value="${visit.id}"/>
    <form:hidden path="patient" id="patient" value="${visit.patient.id}"/>
    <form:hidden path="doctor" id="doctor" value="${visit.doctor.id}"/>
    <form:hidden path="examination" id="examination" value="${visit.examination}"/>
    <form:hidden path="patientDescription" id="patientDescription" value="${visit.patientDescription}"/>

    <td><label for="desc">Description:</label></td>
    <td><form:input path="prescription.description" id="desc"/></td>
    <td><label for="meds">Medicines:</label></td>
    <td><form:input path="prescription.medicines" id="meds"/></td>

    <form:hidden path="registrationDate" id="registrationDade" value="${visit.registrationDate}"/>
    <form:hidden path="visitDate" id="visitDate" value="${visit.visitDate}"/>
    <form:hidden path="visitMade" id="visitMade" value="true"/>
    <form:button type="submit">Save</form:button>
</form:form>
</body>
</html>
