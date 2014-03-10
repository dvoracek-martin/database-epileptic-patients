<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="description" content="">
    <meta name="author" content="GENEPI team">
    <title>Přihlašovací stránka</title>
    <link rel="icon" type="image/png"
          href="<c:url value="/resources/custom/img/logoIcon.ico" />">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/custom/css/menu.css" />"
          rel="stylesheet">
</head>
<style type="text/css">

    .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: transparent;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
    }

</style>

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
                    src="<c:url value="/resources/custom/img/logo.ico" />">GENEPI</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <%--  <div class="collapse navbar-collapse navbar-ex1-collapse">
              <ul class="nav navbar-nav navbar-right">


                  <li><a href="<c:url value="/profile"/>"><span class="glyphicon glyphicon-user"></span>
                      <sec:authentication property="principal.username"/></a>
                  </li>
                  <li><a href="<c:url value="/j_spring_security_logout"/>"><span
                          class="glyphicon glyphicon-off"></span>
                      <spring:message code="label.logOut"/></a></li>
                  <li><a href="?lang=cs">CZ</a></li>
                  <li><a href="?lang=en">EN</a></li>
              </ul>
          </div> --%>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- /nav-->

<%-- Body section --%>
<div class="container">
    <div class="row">


        <%-- Content section --%>
        <div id="content" class="col-xs-12">

            <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
                <td><a href="<c:url value="/login"/>"></a></td>
            </sec:authorize>
            <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
                <!-- shall go to the homepage or better logout the user? -->
                <c:redirect url="/"/>
            </sec:authorize>

            <sec:authorize var="loggedIn" access="isAuthenticated()"/>

            <form class="form-signin" name="f" action="j_spring_security_check" method="post">
                <h1>
                    <spring:message code="label.login"/>
                </h1>
                <input type="text" id="username" class="form-control"
                       name="j_username" placeholder="<spring:message code="label.username" />" autofocus>
                <input type="password" id="password" name="j_password"
                       class="form-control" placeholder="<spring:message code="label.password" />">
                <label class="checkbox">
                    <input type="checkbox" name="_spring_security_remember_me"/><spring:message
                        code="label.rememberMe"/>
                </label>
                <button class="btn btn-large btn-primary" type="submit"><spring:message code="label.login"/></button>


            </form>

            <%--
                            <input type="button" id="visibleLoginData" value="zobrazit přihlašovací údaje" onclick="loginDataVisibility()">
                            <table id="loginData" style="display: none">
                                <tr>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Role</th>
                                </tr>

                                <tr>
                                    <td>sue</td>
                                    <td>suepassword</td>
                                    <td>ROLE_USER</td>
                                </tr>
                                <tr>
                                    <td>hom</td>
                                    <td>hompassword</td>
                                    <td>ROLE_USER, ROLE_DOCTOR</td>
                                </tr>
                            </table>--%>

        </div>
    </div>

    <%--             Footer section
     <hr>
     <footer>
         <p>&copy; GENEPI 2013</p>
     </footer>

 </div>

 <%-- Script section --%>
    <script src="<c:url value="/resources/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
    <script>
        function loginDataVisibility() {
            if (document.getElementById("loginData").style.display == "none") {
                document.getElementById("loginData").style.display = "block";
                document.getElementById("visibleLoginData").value = "skrýt přihlašovací údaje";
            } else {
                document.getElementById("loginData").style.display = "none";
                document.getElementById("visibleLoginData").value = "zobrazit přihlašovací údaje";
            }
        }
    </script>
</body>
</html>

