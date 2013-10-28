<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Diagnostické testy - EEG
    </jsp:attribute>
	<jsp:attribute name="header">
      Diagnostické testy - EEG
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Diagnostické testy - EEG</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/diagnosticTestEEG/create"  />"><spring:message code="label.addRecord"/></a>
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
 
			<c:if test="${empty patient.diagnosticTestEEGList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:forEach items="${patient.diagnosticTestEEGList}" var="diagnosticTestEEG">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${diagnosticTestEEG.id}">
					    	    <strong>Vyšetření dne:</strong> ${diagnosticTestEEG.date}
					    	</a>
						</div>

					    <div id="collapse${diagnosticTestEEG.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<a class="close" href="<c:url value="/patient/${patientID}/diagnosticTestEEG/${diagnosticTestEEG.id}/delete"/>">×</a>
								<table class="table">
				               		<tbody>

										<tr class="info">
											<td>Základní EEG aktivita</td>
											<c:if test="${diagnosticTestEEG.basicEegActivityIdcom==1}">
												<td>Normální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.basicEegActivityIdcom==2}">
												<td>Pomalá</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>EEG zpomalení</td>
											<c:if test="${diagnosticTestEEG.eegSlowIdcom==1}">
												<td>Generalizované kontinuální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.eegSlowIdcom==2}">
												<td>Generalizované přerušované</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.eegSlowIdcom==3}">
												<td>Lokalizované kontinuální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.eegSlowIdcom==4}">
												<td>Lokalizované přerušované</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.eegSlowIdcom==5}">
												<td>Žádné</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Interiktální EEG hroty</td>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==1}">
												<td>Generalizované</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==2}">
												<td>Hemisferální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==3}">
												<td>Multiregionální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==4}">
												<td>Nelatralizovatelné</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==5}">
												<td>Regionální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.interictalEegSpikesIdcom==6}">
												<td>Žádné</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Lokalizace interiktálních EEG hrotů</td>
											<td>${diagnosticTestEEG.localizationInterictalEEGSpikes}</td>
										</tr>
										<tr class="info">
											<td>EEG status epilepticus</td>
											<c:if test="${diagnosticTestEEG.eegStatusEpilepticus==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${diagnosticTestEEG.eegStatusEpilepticus==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Sekundární bilaterální synchronie</td>
											<c:if test="${diagnosticTestEEG.secondarySidedSynchrony==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${diagnosticTestEEG.secondarySidedSynchrony==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Iktální EEG vzorce</td>
											<c:if test="${diagnosticTestEEG.ictalEegPatternsIdcom==1}">
												<td>Chybějící</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.ictalEegPatternsIdcom==2}">
												<td>Fokální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.ictalEegPatternsIdcom==3}">
												<td>Multiregionální</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.ictalEegPatternsIdcom==4}">
												<td>Nelokalizovatelné</td>
											</c:if>
											<c:if test="${diagnosticTestEEG.ictalEegPatternsIdcom==5}">
												<td>Regionální</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Lokalizace iktálních EEG vzorů</td>
											<td>${diagnosticTestEEG.localizationIctalEegPattern}</td>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty diagnosticTestEEG.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${diagnosticTestEEG.comment}</td>
												</c:otherwise>
											</c:choose>
										</tr>
				              		</tbody>
	            				</table>
		            		</div>
					    </div>
	            	</div>
	            </c:forEach>
            </div>
        </br> 
	</jsp:body>
</t:menuLVL3>


