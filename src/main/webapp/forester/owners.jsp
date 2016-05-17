<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.allOwners" var="allOwners"/>
    <fmt:message bundle="${loc}" key="local.ownerId" var="id"/>
    <fmt:message bundle="${loc}" key="local.firstName" var="fn"/>
    <fmt:message bundle="${loc}" key="local.lastName" var="ln"/>
    <fmt:message bundle="${loc}" key="local.parkName" var="parkName"/>
    <fmt:message bundle="${loc}" key="local.email" var="email"/>
    <fmt:message bundle="${loc}" key="local.logOut" var="logOut"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>

    <title>${allOwners}</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<h1>${allOwners}</h1>
<div  class = "foresters">
    <table>
        <tr>
            <th>${id}</th>
            <th>${fn}</th>
            <th>${ln}</th>
            <th>${parkName}</th>
            <th>${email}</th>
        </tr>
        <c:forEach items="${owners}" var="owners">
            <tr>
                <td>${owners.ownerId}</td>
                <td>${owners.firstName}</td>
                <td>${owners.lastName}</td>
                <td>${owners.parkName}</td>
                <td>${owners.email}</td>
            </tr>
        </c:forEach>
    </table>

</div>
<form action="/forester/task/all">
        <input type="submit" value="${back}"/>
</form>
<div class="logout">
<form action="/logout.jsp">
        <input type="submit" value="${logOut}"/>
</form>
</div>
</body>
</html>

