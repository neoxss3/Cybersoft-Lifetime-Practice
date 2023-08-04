<%-- 
    Document   : webplay
    Created on : Aug 3, 2023, 4:18:53 PM
    Author     : anhbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="GameEngine" method="POST">
            <h1>You Guess:</h1>
            <input type="number" name="userguess" value="" required=""/>
            <input type="submit" value="Try"/>
        </form>
        <h5 style="color: red">${requestScope.LOWER_NUM}</h5>
        <h5 style="color: red">${requestScope.HIGHER_NUM}</h5>
        <c:if test="${requestScope.BINGO != null}">
            <h5 style="color: red">${requestScope.BINGO}</h5>
            <form action ="NumberGame.jsp" method="GET">
                <input type="submit" value="Play again"/>
            </form>
        </c:if>
    </body>
</html>
