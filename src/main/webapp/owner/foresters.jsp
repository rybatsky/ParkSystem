<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.allForesters" var="allForesters"></fmt:message>
    <fmt:message bundle="${loc}" key="local.foresterId" var="id"></fmt:message>
    <fmt:message bundle="${loc}" key="local.firstName" var="fn"></fmt:message>
    <fmt:message bundle="${loc}" key="local.lastName" var="ln"></fmt:message>
    <fmt:message bundle="${loc}" key="local.email" var="email"></fmt:message>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"></fmt:message>
    <fmt:message bundle="${loc}" key="local.back" var="back"></fmt:message>

    <title>${allForesters}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${allForesters}</h1>
<div  class = "foresters">
    <table>
        <tr>
            <th>${id}</th>
            <th>${fn}</th>
            <th>${ln}</th>
            <th>${email}</th>
        </tr>
        <c:forEach items="${foresters}" var="foresters">
            <tr>
                <td>${foresters.foresterId}</td>
                <td>${foresters.firstName}</td>
                <td>${foresters.lastName}</td>
                <td>${foresters.email}</td>
            </tr>
        </c:forEach>
    </table>

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

