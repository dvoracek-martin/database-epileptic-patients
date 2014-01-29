<%@ tag description="Overall Page template" pageEncoding="UTF-8" %>

<%-- Taglib section --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>

<%-- Attribute section --%>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="menuLVL1" fragment="true" %>
<%@ attribute name="script" fragment="true" %>

<%-- Template section --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="description" content="">
    <meta name="author" content="GENEPI team">

    <%-- Hook for filling title of page --%>
    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <link rel="icon" type="image/png"
          href="<c:url value="/resources/img/logoIcon.ico" />">
    <link href="<c:url value="/resources/css/bootstrap.NEW303.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/css/menu.NEW303.css" />"
          rel="stylesheet">

    <%-- Hook for adding something to HEAD --%>
    <jsp:invoke fragment="head"/>

</head>
<body>
<%-- Navbar section --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/" />"><img
                    src="<c:url value="/resources/img/logo.ico" />">GENEPI</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">

                <%--<li class="dropdown"><a href="#" class="dropdown-toggle"
                    data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
                        Pepa Nový//send me UserEntity from BE</a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/profile" />"><spring:message code="label.profile" /></a></li>
                        <li><a
                            href="<c:url value="/user/BE give me ID/change-password" />"><spring:message code="label.changePassword" /></a></li>
                    </ul></li>--%>
                <li><a href="<c:url value="/profile"/>"><span class="glyphicon glyphicon-user"></span>
                    <sec:authentication property="principal.username"/></a>
                </li>
                <li><a href="<c:url value="/j_spring_security_logout"/>"><span
                        class="glyphicon glyphicon-off"></span>
                    <spring:message code="label.logOut"/></a></li>
                <li><a href="?lang=cs">CZ</a></li>
                <li><a href="?lang=en">EN</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- /nav-->

<%-- Body section --%>
<div class="container">
    <div class="row">
        <button id="menu-button" type="button"
                class="btn btn-default btn-lg btn-block visible-xs">menu/content
        </button>
        <br>
        <%-- Menu section --%>
        <div id="menu" class="hide-content col-sm-4 col-md-4 col-lg-3"
             role="navigation">
            <%-- Menu hook --%>
            <jsp:invoke fragment="menuLVL1"/>
        </div>

        <%-- Content section --%>
        <div id="content" class="col-sm-8 col-md-8 col-lg-9">
            <%-- Hook for body --%>
            <jsp:doBody/>
        </div>
    </div>

    <%-- Footer section --%>
    <hr>
    <footer>
        <p>&copy; GENEPI 2013</p>
    </footer>

</div>

<%-- Script section --%>
<script src="<c:url value="/resources/js/jquery.min.NEW303.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.NEW303.js"/>"></script>
<script src="<c:url value="/resources/js/menu.NEW303.js"/>"></script>

<%-- Hook for adding something to Script section --%>
<jsp:invoke fragment="script"/>
</body>
</html>