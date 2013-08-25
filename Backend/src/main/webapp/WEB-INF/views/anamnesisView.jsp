<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Anamnéza</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
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
				</a> <a class="brand" href="#">GENEPI - ANAMNÉZA</a>
			</div>
		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="<c:url value="/resources/img/logo.png" />" alt="logo" />
				</a>
			</div>
			<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header">Číslo pacienta:</li>
					<li><a href="underConstruction">Přehled</a></li>
					<li><a href="#">Anamnéza</a></li>
					<li><a href="underConstruction">Farmakoterapie</a></li>
					<li><a href="underConstruction">Neurologické nálezy</a></li>
					<li><a href="underConstruction">Neuropsychologie</a></li>
					<li><a href="underConstruction">(Neuropsychologie - old)</a></li>
					<li><a href="underConstruction">Diagnostické testy</a></li>
					<li><a href="underConstruction">Neuropsychologie</a></li>
					<li>
						<ul>
							<li><a href="underConstruction">Skalpové EEG</a></li>
							<li><a href="underConstruction">Neurozobraz. testy</a></li>
						</ul>
					</li>
					<li><a href="underConstruction">Invazivní testy</a></li>
					<li>
						<ul>
							<li><a href="underConstruction">ECoG</a></li>
							<li><a href="underConstruction">iEEG</a></li>
							<li><a href="underConstruction">Kortikalní mapovaní</a></li>
						</ul>
					</li>
					<li><a href="underConstruction">Operace</a></li>
					<li><a href="underConstruction">Komplikace</a></li>
					<li><a href="underConstruction">Outcome</a></li>
				</ul>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="patientsList">Kartotéka pacientů</a></li>
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

		<!-- box with content -->
		<div class="span9">
			<div class="hero-unit">
				<div>
					<div class="span5">
						<h2>Přehled pacienta</h2>
					</div>
					<div>
						<a href="<c:url value="/patient/${patientID}/createAnamnesis" />">Přidat
							záznam</a>
					</div>
				</div>
				<table style="border: 1px solid black">
					<tbody>
						<tr>
							<th>Číslo pacienta: ${patient.id}</th>
							<td></td>

							<th>Rodné číslo:</th>
							<td></td>

							<th>Adresa:</th>
							<td></td>

						</tr>
						<tr>
							<th>Telefon:</th>
							<td></td>

							<th>Věk:</th>
							<td></td>

							<th>Pohaví:</th>
							<td></td>
						</tr>

						<tr>
							<th>Email:</th>
							<td></td>

							<th>Věk při začátku epilepsie:</th>
							<td></td>

							<th>Ošetřující lékař:</th>
							<td></td>

						</tr>
					</tbody>
				</table>
				<!-- Anamnesis list START -->
				<table border="2">
					<c:forEach items="${anamnesisList}" var="anamnesis">
						<tr>
							<td>Vysetreni dne: ${anamnesis.date}</td>
							<td><a
								href="<c:url value="/deleteAnamnesis/${anamnesis.id}"/>">Odstranit</a></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
				<!-- Anamnesis list END -->


			</div>
		</div>
	</div>
	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
</body>
</html>
