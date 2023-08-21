<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Category</title>
    </head>

    <body>
        <h1>Categories list</h1>
        <table border="1" cellpadding="5px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Desciption</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td>${category.getCategoryId()}</td>
                    <td>${category.getCategoryName()}</td>
                    <td>${category.getDescription()}</td>
                    <td><a href="/products/getProductsByCategoryID/${category.getCategoryId()}">Show product</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>

    </html>