<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.loggedOut" var="logOut"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.index" var="index"/>

    <title>${logOut}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${logOut}</h1>
<form action="/index">
    <input type="submit" value="${index}">
</form>
</body>
</html>
