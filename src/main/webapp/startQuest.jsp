<jsp:useBean id="currentQuestion" scope="request" type="org.javarush.m3fp.quiz.Question"/>
<%@ page import="org.javarush.m3fp.quiz.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Text Quest</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<div class="card">
    <div class="card-header">
        <h1 class="p-3">Quest: Escape from a deserted island</h1>
    </div>

    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <%-- Display the question text --%>
                <form action="nextQuestion" method="post">
                <h2>${currentQuestion.question}</h2>

                <%-- Display the options as radio buttons --%>
                <jsp:useBean id="options" scope="request" type="java.util.List"/>
                <c:forEach var="option" items="${options}">
                    <label>
                        <input type="radio" name="answer" value="${option}">
                    </label> ${option}<br>
                </c:forEach>

                <input type="submit" value="Check">
            </form>
        </blockquote>
    </div>
    <div class="card-header">
        <h3>Player Information</h3>

        <c:if test="${not empty sessionScope.playerName}">
            <p>Welcome, ${sessionScope.playerName}!</p>
            <p>Games Played: ${sessionScope.gamesPlayed}</p>
        </c:if>
    </div>

</div>


</body>
</html>
