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
            <td><label for="username">Nazwa użytkownika:</label></td>
            <td><form:input path="username" id="username"  /></td>
        </tr>
        <tr>
            <td><label for="password">Hasło:</label></td>
            <td><form:password path="password" id="password"  /></td>
        </tr>
        <tr>
            <td><label for="first_name">Imię:</label></td>
            <td><form:input path="doctor.first_name" id="first_name"  /></td>
        </tr>
        <tr>
            <td><label for="surname">Nazwisko:</label></td>
            <td><form:input path="doctor.surname" id="surname"  /></td>
        </tr>
        <tr>
            <td><label for="is_specialist">Specialista:</label></td>
            <td><form:checkbox path="doctor.is_specialist" id="is_specialist"  /></td>
        </tr>
        <tr>
            <td><label for="city">Miast:</label></td>
            <td><form:input path="doctor.address.city" id="city"  /></td>
        </tr>
        <tr>
            <td><label for="house_number">Numer domu:</label></td>
            <td><form:input path="doctor.address.house_number" id="house_number"  /></td>
        </tr>
        <tr>
            <td><label for="street">Ulica:</label></td>
            <td><form:input path="doctor.address.street" id="street"  /></td>
        </tr>
        <tr>
            <td><label for="zip_code">Kod pocztowy:</label></td>
            <td><form:input path="doctor.address.zip_code" id="zip_code"  /></td>
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
