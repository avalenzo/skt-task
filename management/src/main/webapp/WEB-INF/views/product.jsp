<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register a Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h4>Enter the product details</h4>

    <form:form method="POST" action="product" modelAttribute="product">
        <table>
            <div class="form-group">
                <tr>
                    <td><form:label path="code">Code</form:label></td>
                    <td><form:input class="form-control" path="code"/></td>
                </tr>
            </div>

            <div class="form-group">
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input class="form-control" path="name"/></td>
                </tr>
            </div>

            <div class="form-group">
                <tr>
                    <td><form:label path="price">Price</form:label></td>
                    <td><form:input class="form-control" path="price"/></td>
                </tr>
            </div>

            <div class="form-group">
                <tr>
                    <td><input type="submit" class="btn btn-success" value="Save"/></td>
                </tr>
            </div>
        </table>
    </form:form>
</div>
</body>
</html>