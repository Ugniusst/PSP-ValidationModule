<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mvc:resources mapping="/resources/**" location="/resources/static/" />
<%@ include file="common/navigation.jspf"%>

<html>
<head>
    <title>View users</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Inspect or manage addition info</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td><a type="button" href="/update-user/${user.id}">Inspect/manage</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <a href="add-user">ADD user</a>
</div>
</body>
</html>