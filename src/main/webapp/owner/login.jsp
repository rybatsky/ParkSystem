<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.welcomeOwner" var="welcome"/>
    <fmt:message bundle="${loc}" key="local.email" var="email"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.logIn" var="logIn"/>
    <fmt:message bundle="${loc}" key="local.signUp" var="signUp"/>

    <title>${welcome}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${welcome}</h1>
<div>
    <form action="/owner/login" method="post">
        <div class="login">
            <table>
                <tr>
                    <td>${email}</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>${password}</td>
                    <td><input type="password" name="password"/></td>
                </tr>
            </table>
        </div>
        <input type="submit" value="${logIn}"/>
    </form>
    <form action="/owner/signUp">
        <input type="submit" value="${signUp}"/>
    </form>
</div>
</body>
</html>