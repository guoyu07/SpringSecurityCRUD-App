<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 23.08.2017
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <style type="text/css">
        .white_block {
            padding: 10%;
            display: inline-block;
            background-color: white;
            font-family: monospace;
            font-size: 70px;
        }

        .black_block {
            padding: 10%;
            display: inline-block;
            background-color: white;
            font-family: monospace;
            font-size: 70px;

        }
    </style>
    <title>Welcome</title>
</head>
<body>
<div>
    <div class="white_block"><a href="${contextPath}/registration">Registration</a></div>
    <div class="black_block"><a href="${contextPath}/login">Login</a></div>
</div>
</body>
</html>
