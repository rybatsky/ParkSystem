<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.seeAllForesters" var="foresters"></fmt:message >
    <fmt:message bundle="${loc}" key="local.seeAllTasks" var="allTasks"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskId" var="taskId"></fmt:message>
    <fmt:message bundle="${loc}" key="local.ownerId" var="ownerId"></fmt:message>
    <fmt:message bundle="${loc}" key="local.foresterId" var="foresterId"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskType" var="type"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskComments" var="comments"></fmt:message >
    <fmt:message bundle="${loc}" key="local.done" var="done"></fmt:message>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message >
    <fmt:message bundle="${loc}" key="local.yourTasks" var="yourTasks"></fmt:message >
    <fmt:message bundle="${loc}" key="local.editDone" var="editDone"></fmt:message >
    <fmt:message bundle="${loc}" key="local.deleteTask" var="deleteTask"></fmt:message >
    <fmt:message bundle="${loc}" key="local.editTask" var="editTask"></fmt:message >
    <fmt:message bundle="${loc}" key="local.addTask" var="addTask"></fmt:message >
    <fmt:message bundle="${loc}" key="local.done" var="done"></fmt:message >
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"></fmt:message >

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
        <th>${type}</th>
        <th>${comments}</th>
        <th>${done}</th>
        <th>${confirmed}</th>
        <th>${editTask}</th>
        <th>${deleteTask}</th>
    </tr>
        <c:forEach items="${tasks}" var="tasks">
    <tr>
        <td>${tasks.taskId}</td>
        <td>${tasks.ownerId}</td>
        <td>${tasks.foresterId}</td>
        <td>${tasks.type}</td>
        <td>${tasks.comments}</td>
        <td>${tasks.done}</td>
        <td>${tasks.confirmed}</td>
        <td><a href="/task/edit?taskId=${tasks.taskId}">${editTask}</a></td>
        <td><a href="/task/delete?taskId=${tasks.taskId}">${deleteTask}</a></td>
    </tr>
    </c:forEach>
</table>
</div>
<form action="/task/add">
    <input type="submit" value=${addTask}/>
</form>
<a href="/foresters">${foresters}</a>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>