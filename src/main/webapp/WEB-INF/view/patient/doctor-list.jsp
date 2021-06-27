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
        </tr>
        <c:forEach var="doctor" items="${doctors}" >
            <c:url var="make" value="/make-visit">
                <c:param name="doctorId" value="${doctor.id}"/>
            </c:url>
            <tr>
                <td>${doctor.first_name} ${doctor.surname}</td>

                <td><a href="${make}">zapisz</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>