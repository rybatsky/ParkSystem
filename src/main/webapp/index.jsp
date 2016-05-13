<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.welcome" var="welcome"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logInForester" var="logInForester"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logInOwner" var="logInOwner"></fmt:message>
    <fmt:message bundle="${loc}" key="local.signUpForester" var="signUpForester"></fmt:message>
    <fmt:message bundle="${loc}" key="local.signUpOwner" var="signUp"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>
    <fmt:message bundle="${loc}" key="local.updateLanguage" var="update"></fmt:message>

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
                <td class = "forester"><a href="forester/login.jsp">${logInForester}</a></td>
                <td class = "owner"><a href="owner/login.jsp">${logInOwner}</a></td>
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
<div class = "language">
    <form name="Language choose" action="/index" method="get">
        <select size="2" required name="local">
            <option value="ru">Русский (RU)</option>
            <option value="en">English (EN)</option>
        </select>
        <input type="submit" value="${update}"/>
    </form>
</div>
</div>
</body>
</html>
