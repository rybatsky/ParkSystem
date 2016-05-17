<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.error" var="error"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>

    <title>${error}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${error}</h1>
<form action="/index">
    <input type="submit" value="${back}">
</form>
</body>
</html>
