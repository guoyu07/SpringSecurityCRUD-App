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
<form:form action="${contextPath}/registration"  method="POST" modelAttribute="userForRegist">
    <h2 class="form-signin-heading">Create your account</h2>
    <spring:bind path="login">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="login" placeholder="Login"
                        autofocus="true"/>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" placeholder="Password"/>
        </div>
    </spring:bind>


    <button type="submit">Submit</button>
</form:form>
</body>
</html>
