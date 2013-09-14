<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Profil</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico"/>">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
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
				</a> <a class="brand" href="#">GENEPI - PROFIL</a>
			</div>

		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="<c:url value="/resources/img/logo.png"/>" alt="logo" />
				</a>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="patientsList">Kartotéka pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="#">Profil</a></li>
						<li><a href="j_spring_security_logout">Odhlásit</a></li>
						<li class="nav-header">Jazyk</li>
						<li><a href="?lang=cs">CZ</a></li>
						<li><a href="?lang=en">EN</a></li>
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
				<div style="border-bottom: 2px solid black">
					<h1>Profil</h1>
				</div>
				<div style="margin: 10px">
					<p>
						<b>Přihlašovací jméno:</b>
						</p>
					<p>
						<b>Jméno:</b>
					</p>
					<p>
						<b>Příjmení:</b>
					</p>
					<p>
						<b>E-mail:</b>
					</p>
					<p>
						<b>Telefon:</b>
					</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application.js"/>"></script>

</body>
</html>