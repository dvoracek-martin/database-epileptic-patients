<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><spring:message code="label.allusers" /></title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">

</head>
<body>
	<!-- box of whole page -->
	<div class="container-fluid">
		<!--  it defines box with logo -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - <spring:message code="label.allusers" /></a>
			</div>

		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="<c:url value="resources/img/logo.png"/>" alt="logo" />
				</a>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="#">Kartotéka pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="myProfile">Profil</a></li>
						<li><a href="j_spring_security_logout">Odhlásit</a></li>
						<li class="nav-header">Jazyk</li>
					</ul>
				</div>
				<!--  It block with copyright -->
				<div class="span3">
					<div id="copyright">
						<p>GENEPI, &copy; 2013, FIT CVUT</p>
					</div>
				</div>
			</div>
		</div>

		<!--  it defines box with content -->
		<div class="span9">
			<div class="hero-unit">

					<div class="span5">
						<h2><spring:message code="label.allusers" /></h2>
					</div>
					<div>
						<h3>
							<a href="createUser" style="text-decoration: none"><spring:message code="label.newuser" /></a>
						</h3>
					</div>
				

					<c:forEach items="${userList}" var="user">
						
						
						<div class="navbar">
  							<div class="navbar-inner">
    							<a class="brand" href="#" onclick="document.location = 'userOverview/${user.id}';">${user.username}</a>
    							<ul class="nav">
      								<li><a href="#" onclick="document.location = 'userEdit/${user.id}';"><spring:message code="label.editdata" /></a></li>
      								<li><a href="#" onclick="document.location = 'userChangePassword/${user.id}';"><spring:message code="label.changePassword" /></a></li>
    							</ul>
  							</div>
						</div>
						
					</c:forEach>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/application.js" />"></script>
</body>
</html>