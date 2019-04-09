<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 28/03/2019
  Time: 17:12
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<div class="container">
    <c:if test="${not empty inscription}">
        <div class="card bg-success mt-4">
            <article class="card-body mx-auto" style="max-width: 400px;">
                <h4 class="card-title mt-3 text-center text-white">Registration success</h4>
                <p class="text-center text-white">Your registration has been taken into account the <fmt:formatDate pattern="dd/MM/yyyy" value="${inscription.date}"/> at <fmt:formatDate pattern="HH:mm:ss" value="${inscription.date}"/> for the email address ${inscription.email}</p>
            </article>
        </div>
    </c:if>
</div>

<br><br>
<article class="bg-secondary mb-3">
    <div class="card-body text-center">
        <h3 class="text-white mt-3">JavaEE Registration</h3>
        <p class="h5 text-white">Servlet and JSP template  <br> Alexis Mourlanne - Nassim Nouara</p>   <br>
    </div>
    <br><br>
</article>
</body>
</html>

