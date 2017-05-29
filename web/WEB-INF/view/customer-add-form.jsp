<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/18/17
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Save New Customer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Customer Relationship Management</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </nav>

    <form:form action="savecustomer" modelAttribute="addNewCustomer" method="POST">

        <form:hidden path="id"/>
    <div class="form-group row">
        <label class="col-2 col-form-label">First Name</label>
        <div class="col-10">

        <form:input path="firstName"/>

        </div>
    </div>

    <div class="form-group row">
        <label class="col-2 col-form-label">Last Name</label>
        <div class="col-10">
            <form:input path="lastName"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-2 col-form-label">Email</label>
        <div class="col-10">
            <form:input path="email"/>
        </div>
    </div>

        <div class="form-group row">
            <input type="submit" value="save" class="save"/>
        </div>
    </form:form>


    <div class="row"></div>

    <div class="row">
        <a class="btn btn-primary" href="/customer/list">Back</a>
    </div>
</div>
</body>
</html>
