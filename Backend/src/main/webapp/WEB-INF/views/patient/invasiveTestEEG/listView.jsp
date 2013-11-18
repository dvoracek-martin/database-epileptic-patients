<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
     <spring:message code="label.invasiveTestEEG"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.invasiveTestEEG"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2><spring:message code="label.invasiveTestEEG"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/create" />"><spring:message code="label.addRecord"/></a>
					</h3>
				</div>
			</div>
			<table class="table">
			<tbody>
					<tr>
						<th><spring:message code="label.patient"/>:</th>
						<td>${patient.contact.firstName}</td>

						<th><spring:message code="label.birthIdentificationNumber"/>:</th>
						<td>${patient.nin}</td>

						<th><spring:message code="label.birthdate"/>:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th><spring:message code="label.address"/>:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th><spring:message code="label.telephone"/>:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th><spring:message code="label.email"/>:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th><spring:message code="label.gender"/>:</th>
						<td>${patient.gender}</td>
							
						<th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
						<td></td>
							
						<th><spring:message code="label.assignedDoctor"/>:</th>
						<td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>
							
					</tr>
				</tbody>
			</table>
 
			<c:if test="${empty patient.invasiveTestEEGList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4><spring:message code="label.noRecords"/>!</h4>
				</div>
 			</c:if>

			<div class="accordion">
				<c:forEach items="${patient.invasiveTestEEGList}" var="invasiveTestEEG">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${invasiveTestEEG.id}">
					    	    <strong>Vyšetření dne:</strong> ${invasiveTestEEG.date}
					    	</a>
						</div>

					    <div id="collapse${invasiveTestEEG.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestEEG/${invasiveTestEEG.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestEEG/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td>Invazivní monitorace</td>
											<c:if test="${invasiveTestEEG.invasiveMonitoring==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveMonitoring==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Kortikální mapování</td>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==1}">
												<td>Awake craniotomy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==2}">
												<td>Extraoperační elektrická stimulace</td>
											</c:if>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==3}">
												<td>Importovane funkcni mapovani</td>
											</c:if>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==4}">
												<td>Intraoperační elektrická stimulace</td>
											</c:if>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==5}">
												<td>Intraoperační elektrická stimulace + sledování intaktnosti drah</td>
											</c:if>
											<c:if test="${invasiveTestEEG.corticalMappingIdcoml==6}">
												<td>Neprovedeno</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Intrakraniální elektrody</td>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==1}">
												<td>Intracereb. + subdur. stripy + gridy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==2}">
												<td>Intracerebrální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==3}">
												<td>Intracerebrální + subdurální gridy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==4}">
												<td>Intracerebrální + subdurální stripy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==5}">
												<td>Subdurální stripy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==6}">
												<td>Subdurání gridy</td>
											</c:if>
											<c:if test="${invasiveTestEEG.intracranialElectrodesIdcom==7}">
												<td>Subdurání stripy + gridy</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Lokalizace intrakraniálních elektrod</td>
											<td>${invasiveTestEEG.localizationIntracranialElectrodes}</td>
										</tr>
										<tr class="info">
											<td>Invazivní EEG zpomalení</td>
											<c:if test="${invasiveTestEEG.invasiveEegSlowingIdcom==1}">
												<td>Generalizované intermitentní</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegSlowingIdcom==2}">
												<td>Generalizované kontinuální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegSlowingIdcom==3}">
												<td>Lokalizované intermitentní</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegSlowingIdcom==4}">
												<td>Lokalizované kontinuální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegSlowingIdcom==5}">
												<td>Žádné</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Invazivní EEG interiktální hroty</td>
											<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikesIdcom==1}">
												<td>Chybějící</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikesIdcom==2}">
												<td>Fokální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikesIdcom==3}">
												<td>Multiregionální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikesIdcom==4}">
												<td>Nelokalizované</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikesIdcom==5}">
												<td>Regionální</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Lokalizace invazivních EEG interiktálních hrotů</td>
											<td>${invasiveTestEEG.localizationInvasiveEegInterictalSpikes}</td>
										</tr>
										<tr class="info">
											<td>Invazivní EEG status epilepticus</td>
											<c:if test="${invasiveTestEEG.invasiveEegStatusEpilepticus==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveEegStatusEpilepticus==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Invazivní EEG iktální vzorce</td>
											<c:if test="${invasiveTestEEG.invasiveIctalEegPatternsIdcom==1}">
												<td>Chybějící</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveIctalEegPatternsIdcom==2}">
												<td>Fokální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveIctalEegPatternsIdcom==3}">
												<td>Multiregionální</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveIctalEegPatternsIdcom==4}">
												<td>Nelokalizované</td>
											</c:if>
											<c:if test="${invasiveTestEEG.invasiveIctalEegPatternsIdcom==5}">
												<td>Regionální</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Lokalizce invazivních EEG iktálních vzorců</td>
											<td>${invasiveTestEEG.localizationInvasiveIctalEegPatterns}</td>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty invasiveTestEEG.comment}">
													<td><spring:message code="label.noComments"/></td>
												</c:when>
												<c:otherwise>
													<td>${invasiveTestEEG.comment}</td>
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


