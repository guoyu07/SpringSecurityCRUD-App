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
<table width="300px" style="padding: 1%">
    <spring:form modelAttribute="prod_from_ui" method="post" action="/springmvc/products/add">
        <tr>
            <td>Name:<td/>
            <td><spring:input path="name"/><td/>
        </tr>
        <tr>
            <td>Manufacturer:<td/>
            <td><spring:input path="manufacturer"/><td/>
        </tr>
        <tr>
            <td>Description:<td/>
            <td><spring:input path="description"/><td/>
        </tr>
        <tr>
            <td>Price:<td/>
            <td><spring:input path="price"/><td/>
        </tr>
        <tr>
            <td align="right" colspan="3" style="padding-top: 10px"><spring:button>Add</spring:button></td>
        </tr>
    </spring:form>
</table>
<a href="/springmvc/products/allprod" style="padding-left: 1%">All products</a>
</body>
</html>
