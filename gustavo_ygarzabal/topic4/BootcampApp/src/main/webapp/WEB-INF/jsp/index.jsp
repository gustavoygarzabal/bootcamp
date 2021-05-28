<%--
  Created by IntelliJ IDEA.
  User: Gustavo
  Date: 5/25/2021
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/index.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Eggs Shop</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath }/resources/img/chickenIconPng.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Egg Shop
    </a>
</nav>


    <div class="d-grid gap-2 col-6 mx-auto">
        <a class="btn btn-primary" type="button" href="/user/signIn"> Sign In </a>
        <a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/user/logIn"> Log In </a>
        <a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/user/successSignIn">Complete</a>
        <a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/user/showForm">New register Form</a>

    </div>

</body>
</html>
