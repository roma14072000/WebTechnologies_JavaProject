<%--
  Created by IntelliJ IDEA.
  User: zaben
  Date: 05.12.2020
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Statistics</title>
    <!-- подключаем файлы Bootstrap -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Our university</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse my-2 my-lg-0" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

        </ul>
        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="#"><span class="sr-only">(current)</span>Statistics</a>
        </div>
        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="../main.jsp"><i class="fas fa-user-circle"></i></a>
        </div>
        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="/logoutServlet"><i class="fas fa-sign-out-alt"></i></a>
        </div>
    </div>
</nav>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Result</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="enrollee" items="${enrollees}">
        <th scope="row">1</th>
        <td><c:out value="${enrollee.firstName}"/></td>
        <td><c:out value="${enrollee.lastName}"/></td>
        <td><c:out value="${enrollee.pointsSum}"/></td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
