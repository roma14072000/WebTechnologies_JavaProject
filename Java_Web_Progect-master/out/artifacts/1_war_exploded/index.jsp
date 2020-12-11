<%--
  Created by IntelliJ IDEA.
  User: zaben
  Date: 18.11.2020
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" context="text/html; chartset=ISO-8859-1">
    <link rel="stylesheet" href="css/index.css">
    <title>Login</title>
  </head>
  <body>
  <div class="login-page">
    <div class="form">
      <form action="loginServlet" method="post" class="login-form">
        <input type="text" placeholder="Login" name="login"/>
        <input type="password" placeholder="Password" name="password"/>
        <input type="submit" value="Login"/>
        <p><c:out value="${loginMsg}" /></p>
        <p class="message">Not registered? <a href="register.jsp">Create an account</a></p>
      </form>
    </div>
  </div>
  </body>
</html>
