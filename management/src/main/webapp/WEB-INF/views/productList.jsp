<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>Product List</h3>
    <br/>
    <table class="table">
        <tr>
            <th scope="col">Code</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
        <c:forEach items="${productList}" var="product">

            <tr>
                <td scope="row">${product.code}</td>
                <td scope="row">${product.name}</td>
                <td scope="row">${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
