<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.taskDone" var="done"/>
    <fmt:message bundle="${loc}" key="local.seeAllTasks" var="allTasks"/>

    <title>${done}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>${done}</h1>
</header>
<form action="/forester/task/all">
    <input type="submit" value="${allTasks}">
</form>
</body>
</html>
