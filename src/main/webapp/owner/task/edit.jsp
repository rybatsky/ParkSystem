<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.editTask" var="editTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.ownerId" var="ownerId"></fmt:message>
    <fmt:message bundle="${loc}" key="local.forester" var="forester"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskType" var="type"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskComments" var="comments"></fmt:message>
    <fmt:message bundle="${loc}" key="local.addNewTask" var="addNewTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.done" var="done"></fmt:message>
    <fmt:message bundle="${loc}" key="local.back" var="back"></fmt:message>
    <fmt:message bundle="${loc}" key="local.addNewTask" var="addnewtask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.updateButton" var="update"></fmt:message>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>

    <title>${editTask}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${editTask}</h1>
<div>
    <form method="POST" action='/task/edit' name="EditTask">
        <div class="edit">
        <table>
            <tr>
                <th>${ownerId}</th>
                <th>${forester}</th>
                <th>${type}</th>
                <th>${comments}</th>
                <th>${done}</th>
                <th>${confirmed}</th>
            </tr>
            <tr>
                <td>
                    <select disabled required name="NamesOwner">
                        <option value='${owners.ownerId}'>
                            ${owners.firstName}
                            ${owners.lastName}
                        </option>
                    </select>
                </td>
                <td>
                    <select required name="NamesForester">
                        <c:forEach items="${foresters}" var="foresters">
                            <option value='${foresters.foresterId}'>
                                    ${foresters.lastName}
                                    ${foresters.firstName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="text" name="taskType" value='${tasks.type}'/>
                </td>
                <td>
                    <input type="text" name="taskText" value='${tasks.comments}'/>
                </td>
                <td>
                    <select required name="done">
                        <option selected>${tasks.done}</option>
                        <option>Done</option>
                        <option>Not done</option>
                    </select>
                </td>
                <td>
                    <select required name="confirmed">
                        <option selected>${tasks.confirmed}</option>
                        <option>Confirmed</option>
                        <option>Not confirmed</option>
                    </select>
                </td>
            </tr>
        </table>
        </div>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value="${update}"/>
    </form>
</div>
<form action="/owner/tasks">
    <input type="submit" value="${back}"/>
</form>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>

