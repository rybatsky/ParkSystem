<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.taskDeleted" var="deleted"/>
    <fmt:message bundle="${loc}" key="local.seeAllTasks" var="allTasks"/>

    <title>${deleted}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>${deleted}</h1>
</header>
<form action="/owner/task/all">
    <input type="submit" value="${allTasks}">
</form>
</body>
</html>
