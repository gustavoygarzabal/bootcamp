<%--
  Created by IntelliJ IDEA.
  User: Gustavo
  Date: 5/27/2021
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    This is a mvc tag--%>
    <form:form action="/user/processForm" modelAttribute="user">
<%--        This is asosiated with the setters of the class User--%>
        Name: <form:input path="name"/>
        <br>
        Nick: <form:input path="nick"/>
        <br>
        Email: <form:input path="email"/>
        <br>
        <input type="submit" value="Sign in">
    </form:form>

</body>
</html>
