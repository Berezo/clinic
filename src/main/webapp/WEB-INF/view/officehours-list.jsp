<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Office Hours</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>Doctor</th>
            <th>Day</th>
            <th>Start Hour</th>
            <th>End Hour</th>
        </tr>
        <c:forEach var="officeHours" items="${officeHours}" >
            <tr>
                <td>${officeHours.doctor.first_name} ${officeHours.doctor.surname}</td>
                <td>${officeHours.day}</td>
                <td>${officeHours.startHour}</td>
                <td>${officeHours.endHour}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
