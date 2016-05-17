<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.signUpOwner" var="signUpOwner"/>
    <fmt:message bundle="${loc}" key="local.firstName" var="fn"/>
    <fmt:message bundle="${loc}" key="local.lastName" var="ln"/>
    <fmt:message bundle="${loc}" key="local.parkName" var="parkName"/>
    <fmt:message bundle="${loc}" key="local.email" var="email"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.signUp" var="signUp"/>
    <fmt:message bundle="${loc}" key="local.logIn" var="logIn"/>

    <title>${signUpOwner}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${signUpOwner}</h1>
<div>
    <form method="post" action='/owner/signUp' name="addUser">
        <input type="hidden" name="action" value="insert"/>
        <div class="sign">
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
                <td>${parkName}</td>
                <td><input type="text" name="park_name"/></td>
            </tr>
            <tr>
                <td>${email}</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
            <tr>
                <td>${password}</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        </div>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value='${signUp}'/>
    </form>
    <form action="/owner/login">
        <input type="submit" value="${logIn}">
    </form>
</div>
</body>
</html>
