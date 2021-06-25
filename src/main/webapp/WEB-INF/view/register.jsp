<%--
  Created by IntelliJ IDEA.
  User: Krystian
  Date: 25.06.2021
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty info}">
    <p><c:out value="${info}"/></p></c:if>
<form:form method="post" modelAttribute="user">
    <table>
        <tbody>
        <tr>
            <td><label for="username">Nazwa:</label></td>
            <td><form:input path="username" id="username"  /></td>
        </tr>
        <tr>
            <td><label for="first_name">Imię:</label></td>
            <td><form:input path="patient.first_name" id="first_name"  /></td>
        </tr>
        <tr>
            <td><label for="surname">Nazwa:</label></td>
            <td><form:input path="patient.surname" id="surname"  /></td>
        </tr>
        <tr>
            <td><label for="password">Hasło:</label></td>
            <td><form:password path="password" id="password"  /></td>
        </tr>
        <tr>
            <td>
                <button type="submit" >Zarejestruj</button>
            </td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
