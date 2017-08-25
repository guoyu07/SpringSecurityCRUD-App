<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 25.08.2017
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<table align="center" style="padding-top: 10%; font-family: monospace;">
    <form method="POST" action="${contextPath}/loginin">

        <tr>
            <td><h2 align="center" style="font-size: 24px">Log in</h2></td>
        </tr>

        <tr><td><span style="font: 13px Arial; color: green">${message}</span></td></tr>
        <tr><td><span style="font: 13px Arial; color: red">${error}</span></td></tr>

        <tr>
            <td><input style="font-size: 15px" name="username" type="text" placeholder="Username" autofocus="true"/></td>
        </tr>
        <tr><td style="padding-top: 5px"><input style="font-size: 15px" name="password" type="password" placeholder="Password" align="center"/></td></tr>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <tr>
            <td align="center" style="padding-top: 10px; padding-bottom: 14px">
                <button type="submit" style="height: 25px; width: 60px; font-family: monospace; font-size: 13px">Log In</button>
            </td>
        </tr>

        <tr>
            <td><h4 align="center"><a href="${contextPath}/registration" style="color: cadetblue; font-size: 12px">Create an account</a></h4></td>
        </tr>

    </form>
</table>

</body>
</html>
