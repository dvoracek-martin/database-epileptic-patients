<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Pacient</title>
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
				</a> <a class="brand" href="#">GENEPI - PACIENT</a>
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
					<li><a href="<c:url value="/patientOverview/${patient.id}" />">Přehled</a></li>
					<li><a href="<c:url value="/anamnesis/${patient.id}" />">Anamnéza</a></li>
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
					<div class="span5">
						<h2>Přehled pacienta</h2>
					</div>
					<div>
						<h3 class="pull-right">
							<a href="<c:url value="/patientExport/${patient.id}" />">Export pacienta</a>
						</h3>
					</div>
				</div>

				<table style="border: 1px solid black">
					<tbody>
						<tr>
							<th>Číslo pacienta:</th>
							<td>${patient.id}</td>

							<th>Rodné číslo:</th>
							<td>${patient.nin}</td>

							<th>Adresa:</th>
							<td>${patient.contact.addressStreet}</td>

						</tr>
						<tr>
							<th>Telefon:</th>
							<td>${patient.contact.phoneNumber}</td>

							<th>Věk:</th>
							<td></td>

							<th>Pohaví:</th>
							<td>${patient.gender}</td>
						</tr>
						<tr>
							<th>Email:</th>
							<td>${patient.contact.email}</td>

							<th>Věk při začátku epilepsie:</th>
							<td></td>
							<th>Ošetřující lékař:</th>
							<td></td>
						</tr>
					</tbody>
				</table>

				<!-- print out latest anamnesis START -->
				<h3>Anamnéza</h3>
				<table border="2">
					<tr>
						<td>Vysetreni dne: ${anamnesis.date}</td>
						<td><a href="<c:url value="/anamnesis/${patient.id}" />">Zobrazit
								vsechny</a></td>
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
				</table>

				<!-- print out latest anamnesis END -->
				<%
					/*
					 int i = 1;
					 for (AnamnesisEntity anamnesis : anamnesises) {
					 out.println("<div>"
					 + "<h3>Anamnéza: "
					 + (i++)
					 + "</h3>"
					 + "<table style=\"border: 1px solid black\" class=\"span7\">"
					 + "<thead style=\"border: 1px solid black\">" + "<tr>"
					 + "<td>Zadáno dne: " + anamnesis.getDate() + " </td>"
					 + "</tr>" + "</thead>" + "<tbody>" + "<tr>"
					 + "<td colspan=\"2\">" + "<div>" + "<table>"
					 + "<tbody>" + "<tr>" + "<td>Epilepsie v rodině</td>"
					 + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getEpilepsyInFamily() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Prenatální rizika</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getPrenatalRisk() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Febrilní křeče</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getFibrilConvulsions() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Zánět CNS</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getInflammationCns() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Úraz CNS</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getInjuryCns() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Operace CNS</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getOperationCns() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Časná PMD retardace</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getEarlyPmdRetardation() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Začátek epilepsie</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else
					 out.println(anamnesis.getBeginningEpilepsy().toString());
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>První záchvat s horečkou</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getFirstFever() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Infantilní spasmy</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getInfantileSpasm() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Epileptický syndrom</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getSpecificSyndromeIdcom() == 1)
					 out.println("ano");
					 else
					 out.println("ne");
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Non CNS komorbidita</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getNonCnsComorbidity() == null)
					 out.println("nevyplněno");
					 else
					 out.println(anamnesis.getNonCnsComorbidity());
					 out.println("</td>" + "</tr>" +

					 "<tr>" + "<td>Komentář</td>" + "<td>");
					 if (anamnesis == null)
					 out.println("Nevyplněno");
					 else if (anamnesis.getComment() == null)
					 out.println("nevyplněno");
					 else
					 out.println(anamnesis.getComment());
					 out.println("</td>" + "</tr>" + "</tbody>" + "</table>"
					 + "</div>" + "</td>" + "</tr>" + "</tbody>"
					 + "</table>" + "</div>");

					 }*/
				%><!-- 
				<div>
					<h3>Záchvaty</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Četnost záchvatu</td>
												</tr>

												<tr>
													<td>Sekundárně generalizované</td>
												</tr>

												<tr>
													<td>Status epilepticus</td>
												</tr>

												<tr>
													<td>Neepileptické záchvaty</td>
												</tr>

												<tr>
													<td>Výskyt</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>

												<tr>
													<td colspan="2">1. typ záchvatu:</td>
												</tr>

												<tr>
													<td>Zadáno dne</td>
												</tr>

												<tr>
													<td>SSC klasifikace</td>
												</tr>

												<tr>
													<td>ILAE klasifikace</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>

												<tr>
													<td colspan="2">2. typ záchvatu:</td>
												</tr>

												<tr>
													<td colspan="2">3. typ záchvatu:</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Farmakoterapie</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Datum</td>
								<td>Léčivo</td>
								<td>Efektivita</td>
								<td>Při operaci</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Neurologický nález</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Dominance hemisféry</td>
												</tr>

												<tr>
													<td>Abnormální neurologický nález</td>
												</tr>

												<tr>
													<td>Hemiparéza</td>
												</tr>

												<tr>
													<td>Defekt zorného pole</td>
												</tr>

												<tr>
													<td>Detaily neurologického nálezu</td>
												</tr>
												<tr>
													<td>Komentář</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Neuropsychologie</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Neuropsychologické vyšetření</td>
												</tr>

												<tr>
													<td>Věk při neuropsychologickém vyšetření</td>
												</tr>

												<tr>
													<td>Inteligencní úroveň</td>
												</tr>

												<tr>
													<td>Specifická porucha učení</td>
												</tr>

												<tr>
													<td>Vývojová porucha řeči</td>
												</tr>

												<tr>
													<td>ADHD syndrom</td>
												</tr>

												<tr>
													<td>Komentář</td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Diagnostické testy - Skalpové EEG</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Diagnostický test - Skalpové EEG</td>
												</tr>

												<tr>
													<td>Základní EEG aktivita</td>
												</tr>

												<tr>
													<td>EEG zpomalení</td>
												</tr>

												<tr>
													<td>Interiktální EEG hroty</td>
												</tr>

												<tr>
													<td>Lokalizace interiktálních EEG hrotu</td>
												</tr>

												<tr>
													<td>EEG status epilepticus</td>
												</tr>

												<tr>
													<td>Sekundární bilaterální synchronie</td>
												</tr>

												<tr>
													<td>Iktální EEG vzorce</td>
												</tr>

												<tr>
													<td>Lokalizace iktálních EEG vzoru</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Diagnostické testy - Neurozobrazovací testy</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Diagnostický test - Neurozobrazovací test</td>
												</tr>

												<tr>
													<td>MRI protokol</td>
												</tr>

												<tr>
													<td>MRI nález</td>
												</tr>

												<tr>
													<td>MRI popis</td>
												</tr>

												<tr>
													<td>FDG PET</td>
												</tr>

												<tr>
													<td>Lokalizace PET hypometabolismu</td>
												</tr>

												<tr>
													<td>Interiktální SPECT</td>
												</tr>

												<tr>
													<td>Lokalizace SPECT hypoperfuse</td>
												</tr>

												<tr>
													<td>Iktální SPECT</td>
												</tr>

												<tr>
													<td>Lokalizace SPECT hyperperfuse</td>
												</tr>

												<tr>
													<td>SISCOM</td>
												</tr>

												<tr>
													<td>MRS protokol</td>
												</tr>

												<tr>
													<td>MRS nález</td>
												</tr>

												<tr>
													<td>Lokalizace MRS abnormality</td>
												</tr>

												<tr>
													<td>fMRI</td>
												</tr>

												<tr>
													<td>Detaily fMRI</td>
												</tr>

												<tr>
													<td>DTI</td>
												</tr>

												<tr>
													<td>Detaily DTI studie</td>
												</tr>

												<tr>
													<td>WADA</td>
												</tr>

												<tr>
													<td>Detaily WADA</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Invazivní testy - ECoG</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Invazivní test ECoG</td>
												</tr>

												<tr>
													<td>ECoG pokrytí</td>
												</tr>

												<tr>
													<td>ECoG vzorce</td>
												</tr>

												<tr>
													<td>ECoG po resekci</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Invazivní testy - iEEG</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Invazivní test iEEG</td>
												</tr>

												<tr>
													<td>Intrakraniální elektrody</td>
												</tr>

												<tr>
													<td>Lokalizace intrakraniálních elektrod</td>
												</tr>

												<tr>
													<td>Invazivní EEG zpomalení</td>
												</tr>

												<tr>
													<td>Invazivní EEG interiktální hroty</td>
												</tr>

												<tr>
													<td>Lokalizace invazivních EEG interiktálních hrotu</td>
												</tr>

												<tr>
													<td>Invazivní EEG status epilepticus</td>
												</tr>

												<tr>
													<td>Invazivní EEG iktální vzorce</td>
												</tr>

												<tr>
													<td>Lokalizce invazivních EEG iktálních vzorcu</td>
												</tr>

												<tr>
													<td>Komentář</td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Invazivní testy - Kortikalní mapovaní</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Invazivní test Kortikální mapování</td>
												</tr>

												<tr>
													<td>Kortikální mapování</td>
												</tr>

												<tr>
													<td>Komentář</td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Operace</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Zadáno dne:</td>
								<td class="pull-right"><a href="underConstruction">Zobrazit
										všechny záznamy</a></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">
									<div>
										<table>
											<tbody>
												<tr>
													<td>Datum operace</td>
												</tr>

												<tr>
													<td>Věk Při operaci</td>
												</tr>

												<tr>
													<td>Trvání epilepsie v době operace</td>
												</tr>

												<tr>
													<td>Typ operace</td>
												</tr>

												<tr>
													<td>Rozsah operace</td>
												</tr>

												<tr>
													<td>Lokalizace operace</td>
												</tr>

												<tr>
													<td>MST</td>
												</tr>

												<tr>
													<td>Kalostomie</td>
												</tr>

												<tr>
													<td>VNS</td>
												</tr>

												<tr>
													<td>Datum imlantace VNS</td>
												</tr>

												<tr>
													<td>Detaily operace</td>
												</tr>

												<tr>
													<td>Resekce kompletní</td>
												</tr>

												<tr>
													<td>Komentář</td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Histologie</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Datum</td>
								<td>Histopatologie</td>
								<td>Klasifikace FCD</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Komplikace</h3>
					<table style="border: 1px solid black" class="span7">
						<thead style="border: 1px solid black">
							<tr>
								<td>Datum</td>
								<td>Průběh</td>
								<td>Typ komplikace</td>
								<td>Komplikace</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div>
					<h3>Outcome</h3>
				</div>
				 -->
			</div>
		</div>
	</div>
	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
</body>
</html>


