<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.noSuchOwner" var="noSuch"/>
    <fmt:message bundle="${loc}" key="local.wrongData" var="wrongData"/>
    <fmt:message bundle="${loc}" key="local.signUpOwner" var="signUp"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>

    <title>${noSuch}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${noSuch}</h1>
<div>
    ${wrongData}
</div>
<a href="/owner/signUp.jsp">${signUp}</a>
<form action="/owner/login">
    <input type="submit" value="${back}">
</form>
</body>
</html>
