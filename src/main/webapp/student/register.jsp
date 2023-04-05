<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eora21
  Date: 2023/04/05
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" href="../style/style.css"/>
</head>
<body>
<c:set var="student" value="${requestScope.get('student')}"/>
<c:choose>
    <c:when test="${empty student}">
        <c:set var="to" value="register"/>
        <c:set var="submit" value="등록"/>
        <c:set var="readonly" value=""/>
        <c:set var="man" value="checked"/>
        <c:set var="woman" value=""/>
    </c:when>
    <c:otherwise>
        <c:set var="to" value="update"/>
        <c:set var="submit" value="수정"/>
        <c:set var="readonly" value="readonly"/>
        <c:choose>
            <c:when test="${student.gender eq 'M'}">
                <c:set var="man" value="checked"/>
                <c:set var="woman" value=""/>
            </c:when>
            <c:otherwise>
                <c:set var="man" value=""/>
                <c:set var="woman" value="checked"/>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
    </c:choose>
<form method="post" action="${pageContext.request.contextPath}/student/${to}">
        <table>
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" name="id" value="${student.id}" ${readonly} required>
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" value="${student.name}" required>
                </td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" id="M" name="gender" value="M" ${man}><label for="M">남</label>
                    <input type="radio" id="F" name="gender" value="F" ${woman}><label for="F">여</label>
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="text" name="age" value="${student.age}" required>
                </td>
            </tr>
        </table>
        <button type="submit">${submit}</button>
    </form>
</body>
</html>
