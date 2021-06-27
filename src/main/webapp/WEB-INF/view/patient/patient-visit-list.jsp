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
            <th>Prescription</th>
            <th>Registration Date</th>
            <th>Visit Date</th>
            <th>Odwołaj</th>
        </tr>
        <c:forEach var="visit" items="${visits}" >
            <c:url var="cancel" value="/cancel-visit">
                <c:param name="visitId" value="${visit.id}"/>
            </c:url>
            <c:url var="prescription" value="/prescription">
                <c:param name="prescriptionId" value="${visit.prescription.id}"/>
            </c:url>
            <tr>
                <td>${visit.doctor.first_name} ${visit.doctor.surname}</td>
                <td>${visit.patientDescription}</td>
                <td>${visit.doctorDescription}</td>
                <c:choose>
                    <c:when test="${visit.prescription != null}">
                        <td><a href="${prescription}">Recepta</a></td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td>${visit.registrationDate}</td>
                <td>${visit.visitDate}</td>
                <c:choose>
                    <c:when test="${visit.cancelCause != null || visit.visitMade == true}">
                        <td>${visit.cancelCause}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${cancel}">Odwołaj</a></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
