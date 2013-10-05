<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:body>
				<div>
					<div class="span5">
						<h2>Přehled pacienta</h2>
					</div>
					<div>
						<h3 class="pull-right">
							<a id="export"
						href="<c:url value="/patient/${patient.id}/export" />">Export
								pacienta</a>
						</h3>
					</div>
				</div>
				<table class="table table-bordered">
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
				
				<table class="table">
              <tbody>
                		<tr class="info">
							<td>Vysetreni dne:</td>
							<td>${patient.anamnesisList[0].date}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.epilepsyInFamily" /></td>
							<td>${patient.anamnesisList[0].epilepsyInFamily}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.prenatalRisk" /></td>
							<td>${patient.anamnesisList[0].prenatalRisk}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.fibrilConvulsions" /></td>
							<td>${patient.anamnesisList[0].fibrilConvulsions}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.inflammationCNS" /></td>
							<td>${patient.anamnesisList[0].inflammationCns}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.injuryCNS" /></td>
							<td>${patient.anamnesisList[0].injuryCns}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.operationCNS" /></td>
							<td>${patient.anamnesisList[0].operationCns}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.earlyPMDRetardation" /></td>
							<td>${patient.anamnesisList[0].earlyPmdRetardation}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.beginningEpilepsy" /></td>
							<td>${patient.anamnesisList[0].beginningEpilepsy}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.firstFever" /></td>
							<td>${patient.anamnesisList[0].firstFever}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.infantileSpasm" /></td>
							<td>${patient.anamnesisList[0].infantileSpasm}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.epilepticSyndrome" /></td>
							<td>${patient.anamnesisList[0].specificSyndromeIdcom}</td>
						</tr>
						<tr class="info">
							<td><spring:message code="label.nonCNSComorbidity" /></td>
							<td>${patient.anamnesisList[0].nonCnsComorbidity}</td>
						</tr>
              </tbody>
            </table>
            <a href="<c:url value="/patient/${patient.id}/anamnesis/list" />">Zobrazit vsechny</a>	


				<!-- print out latest anamnesis END -->

				<!-- Piece of mess START -->
				<!-- 
				<div>
					" + "
					<h3>Anamnéza: " + (i++) + "</h3>
					" + "
					<table style="" "border: 1px solid black\" class=\"span7\">
						" + "
						<thead style="""border: 1pxsolidblack\">
							" + "
							<tr>
								" + "
								<td>Zadáno dne: " + anamnesis.getDate() + "</td>" + "
							</tr>
							" + "
						</thead>
						" + "
						<tbody>
							" + "
							<tr>
								" + "
								<td colspan=\"2\">" + "
									<div>
										" + "
										<table>
											" + "
											<tbody>
												" + "
												<tr>
													" + "
													<td>Epilepsie v rodině</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getEpilepsyInFamily() == 1) out.println("ano");
														else out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Prenatální rizika</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getPrenatalRisk() == 1) out.println("ano");
														else out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Febrilní křeče</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getFibrilConvulsions() == 1)
														out.println("ano"); else out.println("ne"); out.println("</td>"
													+ "
												</tr>
												" + "
												<tr>
													" + "
													<td>Zánět CNS</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getInflammationCns() == 1) out.println("ano");
														else out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Úraz CNS</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getInjuryCns() == 1) out.println("ano"); else
														out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Operace CNS</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getOperationCns() == 1) out.println("ano");
														else out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Časná PMD retardace</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getEarlyPmdRetardation() == 1)
														out.println("ano"); else out.println("ne"); out.println("</td>"
													+ "
												</tr>
												" + "
												<tr>
													" + "
													<td>Začátek epilepsie</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else
														out.println(anamnesis.getBeginningEpilepsy().toString());
														out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>První záchvat s horečkou</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getFirstFever() == 1) out.println("ano"); else
														out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Infantilní spasmy</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getInfantileSpasm() == 1) out.println("ano");
														else out.println("ne"); out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Epileptický syndrom</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getSpecificSyndromeIdcom() == 1)
														out.println("ano"); else out.println("ne"); out.println("</td>"
													+ "
												</tr>
												" + "
												<tr>
													" + "
													<td>Non CNS komorbidita</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if
														(anamnesis.getNonCnsComorbidity() == null)
														out.println("nevyplněno"); else
														out.println(anamnesis.getNonCnsComorbidity());
														out.println("</td>" + "
												</tr>
												" + "
												<tr>
													" + "
													<td>Komentář</td>" + "
													<td>"); if (anamnesis == null)
														out.println("Nevyplněno"); else if (anamnesis.getComment()
														== null) out.println("nevyplněno"); else
														out.println(anamnesis.getComment()); out.println("</td>" + "
												</tr>
												" + "
											</tbody>
											" + "
										</table>
										" + "
									</div>" + "
								</td>" + "
							</tr>
							" + "
						</tbody>
						" + "
					</table>
					" + "
				</div>
				"); }*// %>
			
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
				<!-- Piece of mess END -->
	</jsp:body>
</t:menuLVL3>

