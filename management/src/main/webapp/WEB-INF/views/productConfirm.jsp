<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Product</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h4>Product Stored</h4>
    <br/>
    <div class="form-group">
        <label>You have successfully saved the Product ${product.code}
            - ${product.name}</label>
        <br/>
        <label>If you want to add more products <a href="/product">click here</a></label>
    </div>
</div>
</body>
</html>