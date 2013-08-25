<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Kartotéka</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
<style type="text/css">
table.patients {
	width: 90%;
	margin: 0px auto;
}

table.patients td {
	padding: 0px 5px 0px 5px;
}

table.patients td.head {
	font-weight: bold;
	text-align: center;
}
</style>
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
				</a> <a class="brand" href="#">GENEPI - KARTOTÉKA</a>
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
				<div style="border-bottom: 2px solid black">
					<div class="span5">
						<h2>Kartotéka pacientů</h2>
					</div>
					<div>
						implement search field
						<h3>
							<a href="createPatient" style="text-decoration: none">Nový
								pacient</a>
						</h3>
					</div>
				</div>

				<table class="patients">
					<tr class="head">
						<td><b><spring:message code="label.lastname" /></b></td>
						<td><b><spring:message code="label.firstname" /></b></td>
						<td><b>Rodné číslo</b></td>
						<td><b>Ulice, č.p.</b></td>
						<td><b>Město</b></td>
					</tr>

					<c:forEach items="${patientList}" var="patient">
						<!-- add link to patient cardoverview -->
						<tr onclick="document.location = 'patientOverview/${patient.id}';">
							<td>${patient.contact.lastName}</td>
							<td>${patient.contact.firstName}</td>
							<td>${patient.birthday}</td>
							<td>${patient.birthday}</td>
							<td>${patient.birthday}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/application.js" />"></script>
</body>
</html>