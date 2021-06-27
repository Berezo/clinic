<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Visits</title>
</head>
<body>
<h2>My Visits:</h2>
<div>
    <table border="1">
        <tr>
            <th>Doctor Name</th>
            <th>Patient Description</th>
            <th>Doctor Description</th>
            <th>Registration Date</th>
            <th>Visit Date</th>
        </tr>
        <tr>
            <td>${visit.doctor.first_name} ${visit.doctor.surname}</td>
            <td>${visit.patientDescription}</td>
            <td>${visit.doctorDescription}</td>
            <td>${visit.registrationDate}</td>
            <td>${visit.visitDate}</td>
        </tr>
    </table>
    <form:form action="" modelAttribute="visit" method="POST">
        <br>
        <label for="p_desc">Powód: </label>
        <form:hidden path="id" id="id" value="${visit.id}"/>
        <form:hidden path="patient" id="patient" value="${visit.patient.id}"/>
        <form:hidden path="doctor" id="doctor" value="${visit.doctor.id}"/>
        <form:hidden path="examination" id="examination" value="${visit.examination}"/>
        <form:hidden path="patientDescription" id="patientDescription" value="${visit.patientDescription}"/>
        <c:if test="${visit.prescription.id != null}">
            <form:hidden path="prescription" id="prescription" value="${visit.prescription.id}"/>
            <form:hidden path="prescription.description" id="pre_desc" value="${visit.prescription.description}"/>
            <form:hidden path="prescription.medicines" id="pre_meds" value="${visit.prescription.medicines}"/>
        </c:if>
        <form:hidden path="registrationDate" id="registrationDade" value="${visit.registrationDate}"/>
        <form:hidden path="visitDate" id="visitDate" value="${visit.visitDate}"/>
        <form:input path="cancelCause" id="p_desc"/>
        <form:hidden path="visitMade" id="visitMade" value="true"/>
        <form:button type="submit">Save</form:button>
    </form:form>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
