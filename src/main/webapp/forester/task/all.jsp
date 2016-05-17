<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.seeAllForesters" var="foresters"/>
    <fmt:message bundle="${loc}" key="local.seeAllTasks" var="allTasks"/>
    <fmt:message bundle="${loc}" key="local.taskId" var="taskId"/>
    <fmt:message bundle="${loc}" key="local.ownerId" var="ownerId"/>
    <fmt:message bundle="${loc}" key="local.foresterId" var="foresterId"/>
    <fmt:message bundle="${loc}" key="local.plant" var="plant"/>
    <fmt:message bundle="${loc}" key="local.taskType" var="type"/>
    <fmt:message bundle="${loc}" key="local.taskComments" var="comments"/>
    <fmt:message bundle="${loc}" key="local.done" var="done"/>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"/>
    <fmt:message bundle="${loc}" key="local.editDone" var="editDone"/>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"/>
    <fmt:message bundle="${loc}" key="local.allOwners" var="allOwners"/>

    <title>${allTasks}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${allTasks}</h1>
<div class = "tasks">
<table>
    <tr>
        <th>${taskId}</th>
        <th>${ownerId}</th>
        <th>${foresterId}</th>
        <th>${plant}</th>
        <th>${type}</th>
        <th>${comments}</th>
        <th>${done}</th>
        <th>${confirmed}</th>
        <th>${editDone}</th>
    </tr>
        <c:forEach items="${tasks}" var="tasks">
    <tr>
        <td>${tasks.taskId}</td>
        <td>${tasks.ownerId}</td>
        <td>${tasks.foresterId}</td>
        <td>${tasks.plant}</td>
        <td>${tasks.type}</td>
        <td>${tasks.comments}</td>
        <td>${tasks.done}</td>
        <td>${tasks.confirmed}</td>
        <td><a href="/forester/task/done?taskId=${tasks.taskId}">${editDone}</a></td>
    </tr>
        </c:forEach>
</table>
    <a href="/forester/owners">${allOwners}</a>
<div>
    <form class="logout" action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</div>
</body>
</html>