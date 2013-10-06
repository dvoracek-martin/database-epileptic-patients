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
				<table class="table">
				<tbody>
						<tr>
							<th>Pacient:</th>
							<td>${patient.contact.firstName}</td>

							<th>Rodné číslo:</th>
							<td>${patient.nin}</td>

							<th>Datum narození:</th>
							<td>${patient.birthday}</td>
							
						</tr>
						<tr>	
							<th>Adresa:</th>
							<td>${patient.contact.addressStreet}</td>
							
							<th>Telefon:</th>
							<td>${patient.contact.phoneNumber}</td>
							
							<th>Email:</th>
							<td>${patient.contact.email}</td>
												
							
						</tr>
						<tr>
							<th>Pohaví:</th>
							<td>${patient.gender}</td>
							
							<th>Věk při začátku epilepsie:</th>
							<td></td>
							
							<th>Ošetřující lékař:</th>
							<td></td>
							
						</tr>
					</tbody>
				</table>

				<!-- print out latest anamnesis START -->
				<h3>Anamnéza</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

            	<!-- print out latest  START -->
				<h3>Záchvaty</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Farmakoterapie</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Neurologické nálezy</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Neuropsychologie</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Diagnostické testy - EEG</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Diagnostické testy - MRI</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Invazivní testy - EEG</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Invazivní testy - ECoG</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Operace</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Histologie</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>

				<!-- print out latest  START -->
				<h3>Outcome</h3>
				<c:choose>
				    <c:when test="${empty patient.anamnesisList}">
				      	<div class="alert alert-block">
		  					<button type="button" class="close" data-dismiss="alert">&times;</button>
		  					<h4>Žádný záznam!</h4>
						</div>
				    </c:when>

			      	<c:otherwise>
						<table class="table">
		               		<tbody>
		                		<tr>
                					<div class="alert alert-info" style="margin: 0">
             					 		<strong>Vyšetření dne:</strong> ${patient.anamnesisList[0].date}
            						</div>	
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
            		</c:otherwise>
				</c:choose>
	</jsp:body>
</t:menuLVL3>

