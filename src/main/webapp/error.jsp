<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eora21
  Date: 2023/04/05
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<table>
    <tbody>
    <tr>
        <th>status_code</th>
        <td>${requestScope.get("status_code")}</td>
    </tr>
    <tr>
        <th>exception_type</th>
        <td>${requestScope.get("exception_type")}</td>
    </tr>
    <tr>
        <th>message</th>
        <td>${requestScope.get("message")}</td>
    </tr>
    <tr>
        <th>exception</th>
        <td>${requestScope.get("exception")}</td>
    </tr>
    <tr>
        <th>request_uri</th>
        <td>${requestScope.get("request_uri")}</td>
    </tr>
    </tbody>

</table>
</body>
</html>
