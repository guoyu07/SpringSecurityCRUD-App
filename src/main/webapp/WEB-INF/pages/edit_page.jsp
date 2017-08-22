<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 10.08.2017
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<table width="300px" style="padding: 1%">
    <spring:form modelAttribute="prod_for_edit" method="post" action="/springmvc/products/edit">
        <div hidden><spring:input readonly="true" path="id"/></div>
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
            <td align="right" colspan="3" style="padding-top: 10px"><spring:button>Edit</spring:button></td>
        </tr>
    </spring:form>
</table>
<a href="/springmvc/products/allprod" style="padding-left: 1%">Go back</a>
</body>
</html>
