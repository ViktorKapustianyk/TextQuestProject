<%--
  Created by IntelliJ IDEA.
  User: OleksandrJR
  Date: 10/11/23
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TextQuestProject</title>
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
        <h1>Quest: Escape from a deserted island</h1>
    </div>

    <img src="main/resources/images/mdl1_3b5n_211228.jpg" alt="Deserted Island" class="full-width-image">

    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <p>
                For a long time you were alone on a deserted island, bordered by lagoons, dense forest and sandy beaches. In the beginning, it was an exciting adventure challenge, but now you need to find a way out and return to reality.

                Here, on this mysterious island, you find strange ruins and old artifacts that testify to the former population that may have once lived here. But now you've decided it's time to find your way home.

                Legends about this island are associated with stories about treasures, ancient secrets and mysterious caves. You will have to make difficult decisions as you explore it and make choices that will affect your future.

                And so, your goal is to get out of this mysterious island, overcome the challenges, find an opportunity to survive and return to the world you once used to call home. And so begins your adventure on the way to escape from this deserted paradise.
            </p>

            <!-- Добавлено поле для ввода имени -->
            <form action="start" method="get" class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <label for="playerName" class="sr-only">Type your Name:</label>
                    <input type="text" class="form-control" id="playerName" name="playerName" placeholder="Type your Name" required>
                </div>
                <button type="submit" class="btn btn-primary mb-2">Start quest</button>
            </form>
        </blockquote>
    </div>
</div>

</body>
</html>
