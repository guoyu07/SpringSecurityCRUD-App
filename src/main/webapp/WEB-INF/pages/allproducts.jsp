<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: КЕП
  Date: 05.08.2017
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>

<html>
<head>
    <title>Products</title>

    <style type="text/css">
    .tg {
    border-collapse: collapse;
    border-spacing: 0;
    border-color: #ccc;
    }
    .tg td {
    font-family: Arial, sans-serif;
    font-size: 14px;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #ccc;
    color: #333;
    background-color: #fff;
    }
    .tg th {
    font-family: Arial, sans-serif;
    font-size: 14px;
    font-weight: normal;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #ccc;
    color: #333;
    background-color: #f0f0f0;
    }
    .tg .tg-4eph {
    background-color: #f9f9f9
    }
    </style>
</head>
<body>

<%--@elvariable id="products" type="java.util.List<ua.spring.app.entity.Product>"--%>
<c:if test="${!empty products}">
    <table class="tg">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
                <td>${product.price}</td>
                <td><a href="delete/${product.id}">Delete</a></td>
                <td><a href="edit/${product.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty products}">Your list doesn't any products</c:if>
<br/>
<br/>
<a href="/springmvc">Go back</a>
</body>
</html>
