<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.editTask" var="editTask"/>
    <fmt:message bundle="${loc}" key="local.taskId" var="taskId"/>
    <fmt:message bundle="${loc}" key="local.owner" var="ownerNames"/>
    <fmt:message bundle="${loc}" key="local.forester" var="forester"/>
    <fmt:message bundle="${loc}" key="local.plant" var="plant"/>
    <fmt:message bundle="${loc}" key="local.taskType" var="type"/>
    <fmt:message bundle="${loc}" key="local.taskComments" var="comments"/>
    <fmt:message bundle="${loc}" key="local.addNewTask" var="addNewTask"/>
    <fmt:message bundle="${loc}" key="local.done" var="done"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.addNewTask" var="addnewtask"/>
    <fmt:message bundle="${loc}" key="local.updateButton" var="update"/>
    <fmt:message bundle="${loc}" key="local.confirmed" var="confirmed"/>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"/>

    <title>${editTask}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${editTask}</h1>
<div>
    <form method="POST" action='/owner/task/edit' name="EditTask">
        <div class="edit">
        <table>
            <tr>
                <th>${taskId}</th>
                <th>${ownerNames}</th>
                <th>${forester}</th>
                <th>${plant}</th>
                <th>${type}</th>
                <th>${comments}</th>
                <th>${done}</th>
                <th>${confirmed}</th>
            </tr>
            <tr>
                <td><input disabled type="text" name="taskId" value='${task.taskId}'/></td>
                <td>
                    <select disabled required name="NamesOwner">
                        <option value='${owner.ownerId}'>
                            ${owner.firstName}
                            ${owner.lastName}
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
                    <input type="text" name="plant" value='${task.plant}'/>
                </td>
                <td>
                    <input type="text" name="taskType" value='${task.type}'/>
                </td>
                <td>
                    <input type="text" name="taskText" value='${task.comments}'/>
                </td>
                <td>
                    <select required name="done">
                        <option selected>${task.done}</option>
                        <option>Done</option>
                        <option>Not done</option>
                    </select>
                </td>
                <td>
                    <select required name="confirmed">
                        <option selected>${task.confirmed}</option>
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
<form action="/owner/task/all">
    <input type="submit" value="${back}"/>
</form>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>

