<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eora21
  Date: 2023/04/17
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginInfo</title>
</head>
<body>
<form action="/user/logout" method="post">
    <c:set var="user" value="${sessionScope.get('user')}"/>
    아이디 : ${user.userId} 이름: ${user.userName}
    <button type="submit">로그아웃</button>
    <input type="hidden" name="${user.userId}">
</form>
</body>
</html>
