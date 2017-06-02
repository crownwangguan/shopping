<%--
  Created by IntelliJ IDEA.
  User: guan
  Date: 02/06/17
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="../resources/css/styles.css" />" type="text/css" >

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="<c:url value="../resources/js/scripts.js" />" type="text/javascript"></script>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <a href="<c:url value="/login" />" class="btn btn-danger btn-mini pull-right" >logout</a>
                <a href='<c:url value="/products" />' class="btn btn-success pull-right">products</a>

                <div class="pull-right" style="padding-right: 50px">
                    <a href="?lang=en">English</a>|<a href="?lang=fr">French</a>
                </div>
                <h1>Products</h1>
                <p>Add products</p>
            </div>
        </div>
    </section>

    <section class="container">
        <form action="<c:url value="/products/add"></c:url>" method="post" class="form-horizontal">
            <fieldset>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2"><spring:message code="addProduct.form.name.label" /></label>
                    <div class="col-lg-10">
                        <input class="form-control"
                               name='name' type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2"><spring:message code="addProduct.form.unitPrice.label" /></label>
                    <div class="col-lg-10">
                        <input class="form-control"
                               name='unitPrice' type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2"><spring:message code="addProduct.form.description.label" /></label>
                    <div class="col-lg-10">
                        <input class="form-control"
                               name='description' type="text">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary"
                               value="Add Product" />
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </fieldset>
        </form>
    </section>
</body>
</html>
