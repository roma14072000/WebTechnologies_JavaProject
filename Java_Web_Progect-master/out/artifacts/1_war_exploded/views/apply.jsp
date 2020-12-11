<%--
  Created by IntelliJ IDEA.
  User: zaben
  Date: 05.12.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apply Documents</title>
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
            <a class="nav-link" href="/statisticsServlet">Statistics</a>
        </div>
        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="../main.jsp"><i class="fas fa-user-circle"></i></a>
        </div>
        <div class="div-inline my-2 my-lg-0">
            <a class="nav-link" href="/logoutServlet"><i class="fas fa-sign-out-alt"></i></a>
        </div>
    </div>
</nav>
<div class="col-md-8 order-md-1">
    <h4 class="mb-3">Fill out the application</h4>
    <form method="post" action="../acceptServlet" class="needs-validation" novalidate>
        <div class="row">
            <div class="col-md-2 mb-3">
                <label>Language exam</label>
            </div>
            <div class="col-md-7 mb-3">
                <select class="custom-select d-block w-100" required>
                    <option value="">Choose...</option>
                    <option value="1">Russian</option>
                    <option value="2">Belarusian</option>
                </select>
                <div class="invalid-feedback">
                    Please select language.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <input type="number" class="form-control" name="langResult" placeholder="" required>
                <div class="invalid-feedback">
                    Result is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2 mb-3">
                <label>Mathematics exam</label>
            </div>
            <div class="col-md-7 mb-3">
                <input type="text" class="form-control" placeholder="Mathematics" readonly>
            </div>
            <div class="col-md-3 mb-3">
                <input type="number" class="form-control" name="mathResult" placeholder="" required>
                <div class="invalid-feedback">
                    Result is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2 mb-3">
                <label>Physics exam</label>
            </div>
            <div class="col-md-7 mb-3">
                <input type="text" class="form-control" placeholder="Physics" readonly>
            </div>
            <div class="col-md-3 mb-3">
                <input type="number" class="form-control" name="physResult" placeholder="" required>
                <div class="invalid-feedback">
                    Result is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2 mb-3">
                <label>Certificate</label>
            </div>
            <div class="col-md-7 mb-3">
                <select class="custom-select d-block w-100" name="certificateType" required>
                    <option value="">Choose...</option>
                    <option value="1">Gold / Silver</option>
                    <option value="0">Usual</option>
                </select>
                <div class="invalid-feedback">
                    Please select certificate type.
                </div>
            </div>
            <div class="col-md-3 mb-3">
                <input type="number" class="form-control" name="certificate" placeholder="" required>
                <div class="invalid-feedback">
                    Certificate average score is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2 mb-2">
                <label>Faculty</label>
            </div>
            <div class="col-md-10 mb-2">
                <select class="custom-select d-block w-100" name="faculty" required>
                    <option value="">Choose...</option>
                    <option value="1">Faculty of Computer Systems and Networks</option>
                    <option value="2">Faculty of Information Technologies and Control</option>
                    <option value="3">Faculty of Computer-Aided Design</option>
                    <option value="4">Faculty of Engineering and Economics</option>
                </select>
                <div class="invalid-feedback">
                    Please select certificate type.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <p>Once you click apply your application will be accepted and you will not be able to edit it.
                If you change your mind, you will need to pick up the application and resubmit it.
                If, based on the results of the admissions committee, you are enrolled in our university,
                you will receive a notification by e-mail that you indicated in your personal account.
                    You can track the progress of the selection committee in the <a href="statistics.jsp" class="alert-link"> Statistics </a>section.</p>
            </div>
        </div>

        <input type="submit" class="btn btn-primary btn-lg btn-block" value="Apply" />

    </form>
</div>
</div>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2020 Web Tech</p>
</footer>
</div>
</body>
</html>
