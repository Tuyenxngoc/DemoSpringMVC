<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Product list</title>
    </head>

    <body>
        <h1>Product list by category ID</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Desciption</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.getProductID()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getFormattedPrice()}</td>
                    <td>${product.getDescription()}</td>
                    <td><a href="../../products/changeCategory/${product.getProductID()}">
                            Update this product
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="../../categories">Go back to Category Page</a>
    </body>

    </html>