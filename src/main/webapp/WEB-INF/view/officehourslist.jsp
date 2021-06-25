<%--
  Created by IntelliJ IDEA.
  User: Krystian
  Date: 25.06.2021
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
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
<%--            <c:url var="update" value="/books/edit"><c:param name="bookId" value="${book.id}"/>--%>
<%--            </c:url>--%>
<%--                <c:url var="delete" value="/books/delete"><c:param name="bookId" value="${book.id}"/>--%>
<%--            </c:url>--%>
            <tr>
                <td>${officeHours.doctor.first_name} ${officeHours.doctor.surname}</td>
                <td>${officeHours.day}</td>
                <td>${officeHours.startHour}</td>
                <td>${officeHours.endHour}</td>
<%--                <sec:authorize access="hasRole('ADMIN')">--%>
<%--                    <td><a href="${update}">edytuj</a></td>--%>
<%--                    <td><a href="${delete}">usuń</a></td>--%>
<%--                </sec:authorize>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="${contextPath}">Back</a>
</div>
</body>
</html>
