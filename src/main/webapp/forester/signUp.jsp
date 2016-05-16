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
    <form method="post" action='/forester/signUp' name="addUser">
        <input type="hidden" name="action" value="insert"/>
        <div class="login">
        <table>
            <tr>
                <td>${fn}</td>
                <td><input name="first_name" type="text"/></td>
            </tr>
            <tr>
                <td>${ln}</td>
                <td><input name="last_name" type="text"/></td>
            </tr>
            <tr>
                <td>${email}</td>
                <td><input name="email" type="text"/></td>
            </tr>
            <tr>
            <tr>
                <td>${password}</td>
                <td><input name="password" type="password"/></td>
            </tr>
        </table>
            </div>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value='${signUp}'/>
    </form>
    <form action="/forester/login">
        <input type="submit" value="${logIn}">
    </form>
</div>
</body>
</html>
