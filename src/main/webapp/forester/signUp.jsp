<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.signUpForester" var="signUp"></fmt:message>
    <fmt:message bundle="${loc}" key="local.firstName" var="fn"></fmt:message>
    <fmt:message bundle="${loc}" key="local.lastName" var="ln"></fmt:message>
    <fmt:message bundle="${loc}" key="local.email" var="email"></fmt:message>
    <fmt:message bundle="${loc}" key="local.password" var="password"></fmt:message>
    <fmt:message bundle="${loc}" key="local.signUp" var="signUp"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logIn" var="logIn"></fmt:message>

    <title>${signUp}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${signUp}</h1>
<div>
    <form method="post" action='/forester/sign' name="addUser">
        <input type="hidden" name="action" value="insert"/>
        <table>
            <tr>
                <td>${fn}</td>
                <td><input type="text" name="first_name"/></td>
            </tr>
            <tr>
                <td>${ln}</td>
                <td><input type="text" name="last_name"/></td>
            </tr>
            <tr>
                <td>${email}</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
            <tr>
                <td>${password}</td>
                <td><input type="text" name="password"/></td>
            </tr>
        </table>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value='${signUp}'/>
    </form>
    <form action="/forester/login">
        <input type="submit" value="${logIn}">
    </form>
</div>
</body>
</html>
