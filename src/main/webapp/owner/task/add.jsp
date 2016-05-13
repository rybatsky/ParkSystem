<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.owner" var="ownerNames"></fmt:message>
    <fmt:message bundle="${loc}" key="local.forester" var="foresterNames"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskType" var="taskType"></fmt:message>
    <fmt:message bundle="${loc}" key="local.taskComments" var="taskComments"></fmt:message>
    <fmt:message bundle="${loc}" key="local.addNewTask" var="addNewTask"></fmt:message>
    <fmt:message bundle="${loc}" key="local.submit" var="done"></fmt:message>
    <fmt:message bundle="${loc}" key="local.back" var="back"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>

    <title>${addNewTask}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${addNewTask}</h1>
<div>
    <form method="post" action='/owner/task/add' name="AddTask">
        <div class="add">
        <table>
            <tr>
                <td>${ownerNames}</td>
                <td>
                    <select disabled required name="NamesOwner">
                        <option value='${owner.ownerId}'>
                            ${owner.firstName}
                            ${owner.lastName}
                        </option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>${taskType}</td>
                <td><input type="text" name="type"/></td>
            </tr>
            <tr>
                <td>${taskComments}</td>
                <td><input type="text" name="comments"/></td>
            </tr>
            <tr>
                <td>${foresterNames}</td>
                <td><select required name="NamesForester">
                    <c:forEach var="forester" items="${foresters}">
                        <option value='${forester.foresterId}'>
                            ${forester.lastName}
                            ${forester.firstName}
                        </option>
                    </c:forEach>
                </select>
                </td>
            </tr>
        </table>
        </div>
        <input type="hidden" name="action" value="insert"/>
        <input type="submit" value='${done}'/>
    </form>
    <form action="/owner/task/all">
        <input type="submit" value="${back}"/>
    </form>
</div>
<div class="logout">
    <form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
    </form>
</div>
</body>
</html>
