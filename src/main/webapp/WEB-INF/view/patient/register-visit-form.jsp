<%@ page import="org.hibernate.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form action="" modelAttribute="visit" method="POST">
            <table>
        <tbody>
        <tr>
            <td><label for="p_desc">Description:</label></td>
            <td><form:input path="patientDescription" id="p_desc"/></td>
        </tr>
        <tr>
            <td><form:hidden path="doctor" id="doctor" value="${doctor.id}"/></td>
        </tr>
        <tr>
            <td><label for="visitDate">Time:</label></td>
            <td>
                <form:select path="visitDate" id="visitDate">
                    <c:forEach items="${times}" var="time">
                        <option value="${time}">
                            <fmt:formatDate value="${time}" pattern="yyyy-MM-dd HH:mm" />
                        </option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:button type="submit">Save</form:button></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
