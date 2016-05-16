<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.forester" var="forester"></fmt:message>
    <fmt:message bundle="${loc}" key="local.owner" var="owner"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskType" var="type"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskComments" var="comments"></fmt:message>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>
    <fmt:message bundle="${loc}" key="local.done" var="done"></fmt:message>
    <fmt:message bundle="${loc}" key="local.editTask" var="editTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.status" var="status"></fmt:message>
    <fmt:message bundle="${loc}" key="local.checked" var="checked"></fmt:message>
    <fmt:message bundle="${loc}" key="local.updateButton" var="update"></fmt:message>
    <fmt:message bundle="${loc}" key="local.back" var="back"></fmt:message>

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

<%--<div>--%>
    <%--<form method="post" action="/forester/task/done">--%>
        <%--<div class="done">--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<th>${owner}</th>--%>
                <%--<th>${forester}</th>--%>
                <%--<th>${type}</th>--%>
                <%--<th>${comments}</th>--%>
                <%--<th>${done}</th>--%>
                <%--<th>${confirmed}</th>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><input type="text" name="NamesOwner"--%>
                           <%--value='${owners.firstName} ${owners.lastName}' disabled/></td>--%>
                <%--<td><input type="text" name="NamesForester"--%>
                           <%--value='${foresters.firstName} ${foresters.lastName}' disabled/></td>--%>
                <%--<td><input type="text" name="taskType" value='${tasks.type}' disabled/></td>--%>
                <%--<td><input type="text" name="taskText" value='${tasks.comments}' disabled/></td>--%>
                <%--<td>--%>
                    <%--<select required name="done">--%>
                        <%--<option selected>${tasks.done}</option>--%>
                        <%--<option>Done</option>--%>
                        <%--<option>Not done</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
                <%--<td><input type="text" name="confirmed" value='${tasks.confirmed}' disabled/></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <%--</div>--%>
        <%--<input type="hidden" name="action" value="update"/>--%>
        <%--<input type="submit" value="${update}"/>--%>
    <%--</form>--%>
    <%--<form action="/forester/task/all">--%>
        <%--<input type="submit" value="${back}">--%>
    <%--</form>--%>
<%--</div>--%>
<%--<div class="logout">--%>
    <%--<form action="/logout.jsp">--%>
        <%--<input type="submit" value="${logOut}"/>--%>
    <%--</form>--%>
<%--</div>--%>
</body>
</html>

