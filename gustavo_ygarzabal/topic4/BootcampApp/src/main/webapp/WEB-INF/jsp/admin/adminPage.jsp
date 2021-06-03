<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Gustavo
  Date: 6/1/2021
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Show Users</title>
</head>
<body >
<div class="row g-3">

    <c:if test="${id==null}">
       <c:set var="link" scope="session" value="makeInsert"/>
    </c:if>
    <c:if test="${id!=null}">
        <c:set var="link" scope="session" value="makeUpdate"/>
    </c:if>
    <form:form class="row g-3 ms-2" action="${pageContext.request.contextPath}/admin/${link}" modelAttribute="newUser">
        <div class="col-auto">
            <label for="id" class="">Id</label>
            <form:input path="id" readonly="true" class="form-control" id="id" placeholder="Id" value="${id}"/>
        </div>
        <div class="col-auto">
            <label for="name" class="">Name</label>
            <form:input path="name" class="form-control" id="name" placeholder="Name" value="${name}"/>
        </div>
        <div class="col-auto">
            <label for="email" class="">Email</label>
            <form:input path="email" class="form-control" id="email" placeholder="Email" value="${email}"/>
        </div>
        <div class="col-auto">
            <label for="address" class="">Address</label>
            <form:input path="address" class="form-control" id="address" placeholder="Address" value="${address}"/>
        </div>
        <div class="col-auto">
            <label for="password" class="">Password</label>
            <form:input path="password" class="form-control" id="password" placeholder="Password" value="${password}"/>
        </div>
        <c:if test="${id==null}">
            <div class="col-auto">
                <p class="label mb-0">Action</p>
                <a><button type="submit" class="btn btn-primary mb-3">Save</button> </a>
            </div>
        </c:if>
        <c:if test="${id!=null}">
            <div class="col-auto ">
                <p class="label mb-0">Action</p>
                <a><button type="submit" class="btn btn-primary">Accept</button> </a>
                <a href="${pageContext.request.contextPath}/admin"><input  type="button" class="btn btn-primary" value="Cancel"></a>
            </div>
        </c:if>

    </form:form>
</div>

<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Password</th>
        <th>Delete</th>
        <th>Update</th>

    </tr>
    <c:forEach items="${users}" var="user">

        <c:url var="deleteLink" value="/admin/delete">
            <c:param name="id" value="${user.id}"/>
        </c:url>
        <c:url var="updateLink" value="/admin/update">
            <c:param name="id" value="${user.id}"/>
            <c:param name="name" value="${user.name}"/>
            <c:param name="email" value="${user.email}"/>
            <c:param name="address" value="${user.address}"/>
            <c:param name="password" value="${user.password}"/>
        </c:url>

        <tr>
            <td >${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.password}</td>
            <td>
                <a href="${deleteLink}"><input  type="button" class="btn btn-primary" value="Delete"></a>
            </td>
            <td>
                <a href="${updateLink}"><input  type="button" class="btn btn-primary" value="Update"></a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
