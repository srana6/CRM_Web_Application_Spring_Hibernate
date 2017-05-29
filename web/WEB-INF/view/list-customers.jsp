<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 5/16/17
  Time: 1:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List Customers</title>

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
            <a class="navbar-brand" href="list">Customer Relationship Management</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
</nav>

    <div class="row"></div>
    <div class="row"></div>
    <div class="row"></div>

    <!-- add a search box -->
    <form:form action="search" method="POST">
        Search Customer: <input type="text" name="theSearchName"/>

        <input type="submit" value="search" class="btn btn-primary">
    </form:form>

    <div class="row"></div>
    <div class="row"></div>
    <div class="row"></div>


    <div class="row">
        <a class="btn btn-primary" href="showformforadd">Add Customer</a>
    </div>

        <table class="table">

            <thead>
            <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
            </tr>
            </thead>

            <tbody>

            <!--loop over and print the customers-->
            <c:forEach var="tempCustomers" items="${customersList}">

                <!--Construct an update link with ids accociated with it-->

            <c:url var="updateLink" value="/customer/showformupdate">
                <c:param name="customerID" value="${tempCustomers.id}">

                </c:param>
            </c:url>

            <!--Construct an delete link with ids accociated with it-->
            <c:url var="deleteLink" value="/customer/deletedata">
                <c:param name="customerID" value="${tempCustomers.id}">

                </c:param>
            </c:url>

                <tr>
                <th scope="row">${tempCustomers.id}</th>
                    <td>${tempCustomers.firstName}</td>
                    <td>${tempCustomers.lastName}</td>
                    <td>${tempCustomers.email}</td>
                    <!-- display the update link-->
                    <td><a href="${updateLink}">update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this'))) return false">delete</a></td>
                </tr>
                <tr>


            </c:forEach>

            </tbody>
    </table>
    </div>


</body>
</html>
