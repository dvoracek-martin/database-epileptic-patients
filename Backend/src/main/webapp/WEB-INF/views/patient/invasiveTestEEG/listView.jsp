<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
     	Invazivní testy - iEEG
    </jsp:attribute>
	<jsp:attribute name="header">
      	Invazivní testy - iEEG
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Invazivní testy - iEEG</h2>
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

			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.invasiveTestEEGList}" var="invasiveTestEEG">
					<c:if test="${invasiveTestEEG.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${invasiveTestEEG.id}">
						    	    <strong>Zadáno dne:</strong> ${invasiveTestEEG.date}
						    	</a>
							</div>

						    <div id="collapse${invasiveTestEEG.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestEEG/${invasiveTestEEG.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestEEG/list"/>"><spring:message code="label.edit"/></a>
										</div>
										</br>
									</div>
									<table class="table">
					               		<tbody>
											<tr class="info">
												<td>Invazivní test iEEG</td>
												<c:if test="${invasiveTestEEG.done==true}">
													<td style="column-span: 2"><spring:message code="label.done"/></td>
												</c:if>
												<c:if test="${invasiveTestEEG.done==false}">
													<td><spring:message code="label.notDone"/></td>
												</c:if>
											</tr>
											
											<tr class="info">
												<td>Intrakraniální elektrody</td>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==1}">
													<td>Intracereb. + subdur. stripy + gridy</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==2}">
													<td>Intracerebrální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==3}">
													<td>Intracerebrální + subdurální gridy</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==4}">
													<td>Intracerebrální + subdurální stripy</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==5}">
													<td>Subdurální stripy</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==6}">
													<td>Subdurání gridy</td>
												</c:if>
												<c:if test="${invasiveTestEEG.intracranialElectrodes==7}">
													<td>Subdurání stripy + gridy</td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Lokalizace intrakraniálních elektrod</td>
												<td>${invasiveTestEEG.localizationIntracranialElectrodes}</td>
											</tr>
											<tr class="info">
												<td>Invazivní EEG zpomalení</td>
												<c:if test="${invasiveTestEEG.invasiveEegSlow==1}">
													<td>Generalizované intermitentní</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegSlow==2}">
													<td>Generalizované kontinuální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegSlow==3}">
													<td>Lokalizované intermitentní</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegSlow==4}">
													<td>Lokalizované kontinuální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegSlow==5}">
													<td>Žádné</td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Invazivní EEG interiktální hroty</td>
												<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==1}">
													<td>Chybějící</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==2}">
													<td>Fokální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==3}">
													<td>Multiregionální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==4}">
													<td>Nelokalizované</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveEegInterictalSpikes==5}">
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
												<c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==1}">
													<td>Chybějící</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==2}">
													<td>Fokální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==3}">
													<td>Multiregionální</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==4}">
													<td>Nelokalizované</td>
												</c:if>
												<c:if test="${invasiveTestEEG.invasiveIctalEegPatterns==5}">
													<td>Regionální</td>
												</c:if>
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
		            </c:if>
	            </c:forEach>
	            <c:if test="${count==0}">
		            <div class="alert alert-block">
		  				<button type="button" class="close" data-dismiss="alert">&times;</button>
		  				<h4><spring:message code="label.noRecords"/></h4>
					</div>
		       	</c:if>
            </div>
        </br> 
	</jsp:body>
</t:menuLVL3>


