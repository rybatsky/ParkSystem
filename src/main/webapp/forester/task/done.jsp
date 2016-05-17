<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.forester" var="forester"/>
    <fmt:message bundle="${loc}" key="local.owner" var="owner"/>
    <fmt:message bundle="${loc}" key="local.taskType" var="plant"/>
    <fmt:message bundle="${loc}" key="local.taskComments" var="type"/>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"/>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"/>
    <fmt:message bundle="${loc}" key="local.done" var="done"/>
    <fmt:message bundle="${loc}" key="local.editTask" var="editTask"/>
    <fmt:message bundle="${loc}" key="local.status" var="status"/>
    <fmt:message bundle="${loc}" key="local.checked" var="checked"/>
    <fmt:message bundle="${loc}" key="local.updateButton" var="update"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>

    <title>${editTask}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${editTask}</h1>
<div>
    <form method="post" action="/forester/task/done">
        <input type="hidden" name="action" value="edit"/>
        <select required name="done">
            <option selected>${tasks.done}</option>
            <option>Done</option>
            <option>Not done</option>
        </select>
        <input type="submit" value="${update}"/>
    </form>
    <form action="/forester/task/all">
        <input type="submit" value="${back}">
    </form>
</div>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>

