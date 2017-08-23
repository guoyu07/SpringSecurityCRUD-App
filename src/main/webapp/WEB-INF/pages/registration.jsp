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
<table>
    <form:form action="${contextPath}/registration" method="POST" modelAttribute="userForRegist">
        <h2 class="form-signin-heading">Create your account</h2>

        <spring:bind path="login">
            <tr>
                <td><form:input type="text" path="login" placeholder="Login" autofocus="true"/></td>
            </tr>

        </spring:bind>

        <spring:bind path="password">
            <tr>
                <td><form:input type="password" path="password" placeholder="Password"/></td>
            </tr>
        </spring:bind>


        <tr>
            <td>
                <button type="submit">Submit</button>
            </td>
        </tr>
    </form:form></table>
</body>
</html>
