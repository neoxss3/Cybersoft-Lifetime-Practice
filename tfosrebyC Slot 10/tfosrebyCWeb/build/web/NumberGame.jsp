<%-- 
    Document   : NumberGame
    Created on : Aug 3, 2023, 4:10:29 PM
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
        <h1>Welcome to Number guessing game !</h1>
        <form action="OnlineServlet" method="POST">
            <h3> Your Name: </h3>
            <input type="text" name="username" value="" required=""/>
            <input type="submit" value="Play"/>
        </form>
        <h1>Leader Board</h1>
        <c:if test="${sessionScope.USER_LIST == null}">
            <h5 style="color:red">No Player Data</h5>
        </c:if>
        <c:if test="${sessionScope.USER_LIST != null}">
            <c:set var="ul" scope="session" value="${sessionScope.USER_LIST}"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Guess Count</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${ul}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.name}</td>
                            <td>${dto.guess}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>


    </body>
</html>
