<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.firstName" var="fn"></fmt:message>
    <fmt:message bundle="${loc}" key="local.lastName" var="ln"></fmt:message>
    <fmt:message bundle="${loc}" key="local.delTask" var="delTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.delTaskQuestion" var="delTaskQuestion"></fmt:message>
    <fmt:message bundle="${loc}" key="local.deleteTask" var="deleteTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.no" var="no"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>

    <title>${delTask}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${delTaskQuestion}</h1>
<div>
    <form method="POST" action='/task/delete' name="DelTask">
        <input type="hidden" name="action" value="delete"/>
        <input type="submit" value=${deleteTask}>
    </form>
    <a href="/owner/tasks">${no}</a>
</div>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>
