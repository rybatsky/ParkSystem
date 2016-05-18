<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="dt" uri="http://epam.com/rybatsky/custom"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.welcome" var="welcome"/>
    <fmt:message bundle="${loc}" key="local.logInForester" var="logInForester"/>
    <fmt:message bundle="${loc}" key="local.logInOwner" var="logInOwner"/>
    <fmt:message bundle="${loc}" key="local.signUpForester" var="signUpForester"/>
    <fmt:message bundle="${loc}" key="local.signUpOwner" var="signUp"/>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"/>
    <fmt:message bundle="${loc}" key="local.updateLanguage" var="update"/>
    <fmt:message bundle="${loc}" key="local.language" var="language"/>
    <fmt:message bundle="${loc}" key="local.date" var="date"/>
    <fmt:message bundle="${loc}" key="local.time" var="time"/>

    <title>${welcome}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <header>
        <h1>${welcome}</h1>
    </header>
    <div class="index">
    <table>
        <tr>
            <div>
                <td class = "forester"><a href="/forester/login.jsp">${logInForester}</a></td>
                <td class = "owner"><a href="/owner/login.jsp">${logInOwner}</a></td>
            </div>
        </tr>
        <tr>
            <div>
                <td class = "forester"><a href="forester/signUp.jsp">${signUpForester}</a></td>
                <td class = "owner"><a href="owner/signUp.jsp">${signUp}</a></td>
            </div>
        </tr>
    </table>
    </div>
    <div class = "time">
        <dt:today format="dd.MM.yyyy"/>
        <dt:today format="${time}"/>
    </div>
    <div class = "language">
        <form name="Language choose" action="/index" method="get">
            <label><input type="submit" value="${language}" name="local"/></label>
    </form>
    </div>
</div>
</body>
</html>
