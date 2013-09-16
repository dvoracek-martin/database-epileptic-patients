<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Přidat záznam</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico" />">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
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
				</a> <a class="brand" href="#">GENEPI - PŘIDAT ZÁZNAM</a>
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
					<li>
						<!-- WTF is this FORM??? START -->
						<form name="anamnesis" action="anamnesis" method="post"
							style="display: inline">
							<input type="hidden" id="id" name="id" value=""> <a
								href="javascript:;" onclick="parentNode.submit();">Anamnéza</a>
							<input type="hidden" name="mess" />
						</form> <!-- WTF is this FORM??? END -->
					</li>
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
						<li><a href="<c:url value="/patient/list" />">Kartotéka
								pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="<c:url value="/profile" />">Profil</a></li>
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

		<!-- box with content -->
		<div class="span9">
			<div class="hero-unit">
				<div>
					<h2>Přehled pacienta</h2>
				</div>
				<table style="border: 1px solid black">
					<tbody>
						<tr>
							<th>Číslo pacienta:</th>
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

				<!-- form for adding new record -->
				<div class="form" style="margin: 10px; width: 60%">
					<!-- form for adding new patient -->
					<!-- mapping resource in action with c:url caused errors -->
					<form:form method="POST"
						action="/GENEPI/patient/${patientID}/anamnesis/add"
						commandName="anamnesis">
						<form:label path="date">Datum</form:label>
						<form:input path="date" type="text"
							class="input-block-level datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>

						<form:label path="doctorId">Lekar</form:label>
						<form:select path="doctorId" type="text" class="input-block-level" />

						<form:label path="epilepsyInFamily">Epilepsie v rodině</form:label>
						<form:checkbox path="epilepsyInFamily" class="input-block-level" />
						<form:errors path="epilepsyInFamily" cssClass="error">
						</form:errors>

						<form:label path="prenatalRisk">Prenatální rizika</form:label>
						<form:checkbox path="prenatalRisk" class="input-block-level" />
						<form:errors path="prenatalRisk" cssClass="error">
						</form:errors>

						<form:label path="fibrilConvulsions">Fibrilní křeče</form:label>
						<form:checkbox path="fibrilConvulsions" class="input-block-level" />
						<form:errors path="fibrilConvulsions" cssClass="error">
						</form:errors>

						<form:label path="inflammationCns">Zánět CNS</form:label>
						<form:checkbox path="inflammationCns" class="input-block-level" />
						<form:errors path="inflammationCns" cssClass="error">
						</form:errors>

						<form:label path="injuryCns">Úraz CNS</form:label>
						<form:checkbox path="injuryCns" class="input-block-level" />
						<form:errors path="injuryCns" cssClass="error">
						</form:errors>

						<form:label path="operationCns">Operace CNS</form:label>
						<form:checkbox path="operationCns" class="input-block-level" />
						<form:errors path="operationCns" cssClass="error">
						</form:errors>

						<form:label path="earlyPmdRetardation">Časná PMD retardace</form:label>
						<form:checkbox path="earlyPmdRetardation"
							class="input-block-level" />
						<form:errors path="earlyPmdRetardation" cssClass="error">
						</form:errors>

						<form:label path="beginningEpilepsy">Začátek epilepsie</form:label>
						<form:input path="beginningEpilepsy" type="text"
							class="input-block-level datepicker" />
						<form:errors path="beginningEpilepsy" cssClass="error">
						</form:errors>

						<form:label path="firstFever">První záchvat s horečkou</form:label>
						<form:checkbox path="firstFever" class="input-block-level" />
						<form:errors path="firstFever" cssClass="error">
						</form:errors>

						<form:label path="infantileSpasm">Infantilní spasmy</form:label>
						<form:checkbox path="infantileSpasm" class="input-block-level" />
						<form:errors path="infantileSpasm" cssClass="error">
						</form:errors>

						<form:label path="specificSyndromeIdcom">Epileptický syndrom</form:label>
						<form:select path="specificSyndromeIdcom" type="text"
							class="input-block-level">
							<form:option value="0">Zvolte syndrom</form:option>
							<form:option value="1">Extratemporální
							fokální epilepsie</form:option>
							<form:option value="2">Hemisferální
							symtomaptická epilepsie</form:option>
							<form:option value="3">Meziotemporální
							epilepsie (MTLE)</form:option>
							<form:option value="4">Multifokální
							epilepsie</form:option>
						</form:select>

						<form:label path="nonCnsComorbidity">Non CNS komorbidita</form:label>
						<form:input path="nonCnsComorbidity" type="text"
							class="input-block-level" />
						<form:errors path="nonCnsComorbidity" cssClass="error">
						</form:errors>

						<form:label path="comment">Komentář</form:label>
						<form:textarea cols="40" rows="10" path="comment" />

						<button class="btn btn-small btn-primary" type="submit">Pridat</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
	<script>
		$(function() {
			$(".datepicker").datepicker({
				dateFormat : "dd/mm/yy",
				changeYear : true
			});

		});
	</script>

</body>
</html>
