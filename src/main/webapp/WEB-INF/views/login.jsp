<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body onload='document.loginForm.username.focus();'>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Login</h1>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>

                    <%--<c:if test="${not empty error}">--%>
                        <%--<div class="alert alert-danger">--%>
                            <%--<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"></spring:message><br />--%>
                        <%--</div>--%>
                    <%--</c:if>--%>
                    <form action="<c:url value="/login"></c:url>" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="User Name"
                                       name='username' type="text">
                            </div>

                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='password' type="password" value="">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<div id="login-box">--%>

    <%--<h2>Login with Username and Password</h2>--%>

    <%--<c:if test="${not empty error}">--%>
        <%--<div class="error">${error}</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${not empty msg}">--%>
        <%--<div class="msg">${msg}</div>--%>
    <%--</c:if>--%>

    <%--<form name='loginForm'--%>
          <%--action="<c:url value='/login' />" method='POST'>--%>

        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>User:</td>--%>
                <%--<td><input type='text' name='user' value=''></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Password:</td>--%>
                <%--<td><input type='password' name='pass' /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan='2'>--%>
                    <%--<input name="submit" type="submit" value="submit" />--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>

        <%--<input type="hidden"--%>
               <%--name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
    <%--</form>--%>
<%--</div>--%>

</body>
</html>