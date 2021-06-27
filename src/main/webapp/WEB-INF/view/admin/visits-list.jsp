<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <th>Cancel cause</th>
        </tr>
        <c:forEach var="visit" items="${visits}" >
            <tr>
                <td>${visit.doctor.first_name} ${visit.doctor.surname}</td>
                <td>${visit.patientDescription}</td>
                <td>${visit.doctorDescription}</td>
                <td>${visit.registrationDate}</td>
                <td>${visit.visitDate}</td>
                <td>${visit.cancelCause}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
