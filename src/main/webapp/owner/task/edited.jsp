<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.taskEdited" var="edited"></fmt:message>
    <fmt:message bundle="${loc}" key="local.seeAllTasks" var="allTasks"></fmt:message>

    <title>${edited}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>${edited}</h1>
</header>
<form action="/owner/task/all">
    <input type="submit" value="${allTasks}">
</form>
</body>
</html>
