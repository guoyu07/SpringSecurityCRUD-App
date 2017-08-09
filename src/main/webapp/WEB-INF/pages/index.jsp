<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 30.07.2017
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<spring:form modelAttribute="prod_from_ui" method="post" action="/springmvc/products/add">
    <table width="350px">
        <tr><td>Name: <spring:input path="name"/></tr><td/>
        <tr><td>Manufacturer: <spring:input path="manufacturer"/></tr><td/>
        <tr><td>Description: <spring:input path="description"/></tr><td/>
        <tr><td>Price: <spring:input path="price"/></tr><td/>
        <tr><td><spring:button>Add</spring:button></tr><td/>
    </table>
</spring:form>
<a href="/springmvc/products/allprod">All products</a>
</body>
</html>
