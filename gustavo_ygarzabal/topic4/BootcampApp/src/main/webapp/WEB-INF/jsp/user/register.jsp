<%--
  Created by IntelliJ IDEA.
  User: Gustavo
  Date: 5/26/2021
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Sign In</title>
</head>
<body class="col">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath }/resources/img/chickenIconPng.png" width="30" height="30" class="d-inline-block align-top" alt="">
            Egg Shop
        </a>
    </nav>
    <h1>Sign In</h1>

    <form class="col g-3" action="${pageContext.request.contextPath}/user/successSignIn" method="get">
        <div class="col-md-6">
            <label for="inputName" class="form-label">Name</label>
            <input type="text" class="form-control" name="userName" id="inputName">
        </div>
        <div class="col-md-6">
            <label for="inputEmail" class="form-label">Email</label>
            <input type="email" class="form-control" name="userEmail" id="inputEmail">
        </div>
        <div class="col-md-6">
            <label for="inputPassword" class="form-label">Password</label>
            <input type="password" class="form-control"  name="userPassword" id="inputPassword">
        </div>
        <div class="col-md-6">
            <label for="inputAddress" class="form-label">Address</label>
            <input type="text" class="form-control" name="userAddress" id="inputAddress" placeholder="Av. Sarmineto 1455">
        </div>
        <div class="col-md-12">
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </form>
</body>
</html>
