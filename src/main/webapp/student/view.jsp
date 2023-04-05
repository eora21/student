<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eora21
  Date: 2023/04/05
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
    <link rel="stylesheet" href="../style/style.css"/>
</head>
<body>
<c:set var="student" value="${requestScope.get('student')}"/>
<table>
    <tr>
        <th>ID</th>
        <td>${student.id}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${student.name}</td>
    </tr>
    <tr>
        <th>성별</th>
        <td>${student.gender}</td>
    </tr>
    <tr>
        <th>나이</th>
        <td>${student.age}</td>
    </tr>
</table>
<a href="/student/list">리스트</a>
<a href="/student/update?id=${student.id}">수정</a>
<form method="post" action="/student/delete">
    <input type="text" name="id" value="${student.id}" hidden="hidden">
    <button type="submit">삭제</button>
</form>
</body>
</html>
