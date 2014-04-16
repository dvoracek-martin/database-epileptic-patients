<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="description" content="">
    <meta name="author" content="GENEPI team">
    <title>
        <spring:message code="label.loginPage"/>
    </title>
    <link href="<c:url value="/resources/custom/img/logoIcon.ico" />"
          type="image/png"
          rel="icon">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/custom/css/menu.css" />"
          rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-default"
     role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"
               href="<c:url value="/" />">
                <img src="<c:url value="/resources/custom/img/logo.ico" />">
                GENEPI
            </a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="?lang=cs">CZ</a>
                </li>
                <li>
                    <a href="?lang=en">EN</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-xs-2"></div>
        <div id="content"
             class="col-xs-8">

            <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
                <!-- shall go to the homepage or better logout the user? -->
                <c:redirect url="/"/>
            </sec:authorize>

            <sec:authorize var="loggedIn" access="isAuthenticated()"/>

            <h1 class="col-xs-offset-3">
                <spring:message code="label.login"/>
            </h1>

            <form class="form-horizontal"
                  action="j_spring_security_check"
                  method="post">

                <div class="form-group">

                    <label class="col-xs-3 control-label"
                           for="username">
                        <spring:message code="label.username"/>
                    </label>

                    <div class="col-xs-9">
                        <input id="username"
                               class="form-control"
                               type="text"
                               name="j_username"
                               placeholder="<spring:message code="label.username" />"
                               autofocus>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-xs-3 control-label"
                           for="password">
                        <spring:message code="label.password"/>
                    </label>

                    <div class="col-xs-9">
                        <input id="password"
                               class="form-control"
                               type="password"
                               name="j_password"
                               placeholder="<spring:message code="label.password" />">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="checkbox">
                            <label class="checkbox">
                                <input type="checkbox" name="_spring_security_remember_me"/>
                                <spring:message code="label.rememberMe"/>
                            </label>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <button class="btn btn-large btn-primary"
                                type="submit">
                            <spring:message code="label.login"/>
                        </button>
                    </div>
                </div>

            </form>

        </div>
    </div>
</div>
<div class="col-xs-2"></div>

<script src="<c:url value="/resources/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

</body>
</html>