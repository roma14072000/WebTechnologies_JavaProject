<%--
  Created by IntelliJ IDEA.
  User: zaben
  Date: 18.11.2020
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <!-- подключаем файлы Bootstrap -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
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
            <a class="nav-link" href="statisticsServlet">Statistics</a>
        </div>

        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="#"><i class="fas fa-user-circle"></i></a>
        </div>

        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="logoutServlet"><i class="fas fa-sign-out-alt"></i></a>
        </div>
    </div>

</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Personal information</span>
            </h4>
            <ul class="list-group mb-3">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">FirstName</h6>
                    </div>
                    <span class="text-muted"><c:out value="${firstName}" /></span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">LastName</h6>
                    </div>
                    <span class="text-muted"><c:out value="${lastName}" /></span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Email</h6>
                    </div>
                    <span class="text-muted"><c:out value="${email}" /></span>
                </li>
                <li class="list-group-item d-flex justify-content-between ln-condensed">
                    <div>
                        <h6 class="my-0">Date of birth</h6>
                    </div>
                    <span class="text-muted"><c:out value="${dateOfBirth}" /></span>
                </li>
                <li class="list-group-item d-flex justify-content-between ln-condensed">
                    <div>
                        <h6 class="my-0">Address</h6>
                    </div>
                    <span class="text-muted"><c:out value="${address}" /></span>
                </li>
                <li class="list-group-item d-flex justify-content-between mb-12">
                    <a class="btn btn-success" href="views/apply.jsp" role="button">Apply</a>
                </li>
            </ul>
        </div>
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Personal information</h4>
            <form action="addEnrolleeInfServlet" method="post" class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label>First name</label>
                        <input type="text" class="form-control" name="firstName"required>
                        <div class="invalid-feedback">
                            Valid first name is required.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Last name</label>
                        <input type="text" class="form-control" name="lastName" required>
                        <div class="invalid-feedback">
                            Valid last name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <input type="email" class="form-control" name="email" placeholder="you@example.com" required>
                    <div class="invalid-feedback">
                        Please enter a valid email address for shipping updates and results.
                    </div>
                </div>

                <div class="mb-3">
                    <label>Date of Birth</label>
                    <input type="date" class="form-control" name="birth" min="1920-01-01" max="2011-12-31" required>
                    <div class="invalid-feedback">
                        Please enter your date of birth.
                    </div>
                </div>

                <div class="mb-3">
                    <label>Address</label>
                    <input type="text" class="form-control" name="address" placeholder="1234 Main St" required>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <hr class="mb-4">
                <input type="submit" class="btn btn-primary btn-lg btn-block" value="Save" />
            </form>
            <c:out value="${acceptMsg}" />
            <c:out value="${saveMsg}" />
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2020 Web Tech</p>
    </footer>
</div>
</body>
</html>