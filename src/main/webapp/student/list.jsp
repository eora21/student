<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eora21
  Date: 2023/04/05
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student-list</title>
    <link rel="stylesheet" href="../style/style.css" />
</head>
<body>
<h1>학생 리스트</h1>
<a href="${pageContext.request.contextPath}/student/register">학생 등록</a>
<table>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>cmd</th>
    </tr>
    <c:forEach var="student" items="${requestScope.get('students')}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
            <td><a href="/student/view?id=${student.id}">조회</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
