<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Rejestracja</h3>
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
            <td><form:input path="doctor.first_name" id="first_name"  /></td>
        </tr>
        <tr>
            <td><label for="surname">Nazwa:</label></td>
            <td><form:input path="doctor.surname" id="surname"  /></td>
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
