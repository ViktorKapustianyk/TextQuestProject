<%--
  Created by IntelliJ IDEA.
  User: alexandra
  Date: 21.11.2023
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>You win!</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>

    <style>
        .full-width-image {
            width: 100%;
            margin-bottom: 20px; /* Додайте відступ, якщо потрібно */
        }
    </style>

</head>
<body>

<div class="card">
    <div class="card-header">
        <h1>You win! </h1>
    </div>

    <img src="main/resources/images/2309.jpg" alt="Escaping from Island" class="full-width-image">

    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <form action="restart" method="post">
                <input type="hidden" name="restart" value="true">
                <button type="submit" class="btn btn-primary">Restart</button>
            </form>
        </blockquote>
    </div>
</div>

</body>
</html>
