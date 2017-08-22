<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 30.07.2017
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<table width="300px" style="padding: 1%">
    <spring:form modelAttribute="prod_from_ui" method="post" action="${contextPath}/products/add">
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
<a href="${contextPath}/products/allprod" style="padding-left: 1%">All products</a>

<br/>
<br/>
<table>
    <tr><td>Search by ID</td></tr>
    <form action="${contextPath}/products/searching" method="get">
       <tr><td><input name="id" type="text" required></td></tr>
        <tr><td><button>Find</button></td></tr>
    </form>
</table>
<br/>
<br/>
<a href="${contextPath}/logout">LogOut</a>
</body>
</html>
