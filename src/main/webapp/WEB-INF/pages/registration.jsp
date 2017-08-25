<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 23.08.2017
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<table align="center" style="padding-top: 10%; font-family: monospace">
    <form:form action="${contextPath}/registration" method="POST" modelAttribute="userForRegist">
        <tr><td><h2 align="center" style=" font-size: 20px; ">Create your account</h2></td></tr>

        <spring:bind path="login">
            <tr>
                <td align="center"><form:input cssStyle="font-size: 15px" type="text" path="login" placeholder="Login" autofocus="true"/></td>
            </tr>

        </spring:bind>

        <spring:bind path="password">
            <tr>
                <td align="center" style="padding-top: 5px"><form:input cssStyle="font-size: 15px" type="password" path="password" placeholder="Password"/></td>
            </tr>
        </spring:bind>


        <tr>
            <td align="center" style="padding-top: 10px">
                <button type="submit" style="height: 25px; width: 60px; font-family: monospace; font-size: 13px">Create</button>
            </td>
        </tr>
    </form:form></table>
</body>
</html>
