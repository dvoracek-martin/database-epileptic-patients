<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.diagnosticTestScalpEEG"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.diagnosticTestScalpEEG"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		
			<div>
				<div class="span5">
					<h2><spring:message code="label.diagnosticTestScalpEEG"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/diagnosticTestScalpEEG/create"  />"><spring:message code="label.addRecord"/></a>
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

			<!-- diagnosticTestScalpEEG list START -->
			<div class="accordion">
				<c:forEach items="${patient.diagnosticTestEEGList}" var="diagnosticTestEEG">
					<c:if test="${diagnosticTestEEG.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${diagnosticTestEEG.id}">
						    	    <strong>Zadáno dne:</strong> ${diagnosticTestEEG.date}
						    	</a>
							</div>

						    <div id="collapse${diagnosticTestEEG.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patientID}/diagnosticTestScalpEEG/${diagnosticTestEEG.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patientID}/diagnosticTestScalpEEG/list"/>"><spring:message code="label.edit"/></a>
										</div>
										</br>
									</div>
									<table class="table">
					               		<tbody>
					               			<tr class="info">
												<td><spring:message code="label.diagnosticTestScalpEEG"/></td>
												<c:if test="${diagnosticTestEEG.done==false}">
													<td><spring:message code="label.notDone"/></td>
												</c:if>
												<c:if test="${diagnosticTestEEG.done==true}">
													<td><spring:message code="label.done"/></td>
												</c:if>
											</tr>
											<c:if test="${diagnosticTestEEG.done==true}">
												<tr class="info">
													<td><spring:message code="label.basicEEGActivity"/></td>
													<c:if test="${diagnosticTestEEG.basicEegActivity==1}">
														<td><spring:message code="label.normal"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.basicEegActivity==2}">
														<td><spring:message code="label.slow"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.EEGSlow"/></td>
													<c:if test="${diagnosticTestEEG.eegSlow==1}">
														<td><spring:message code="label.generalizedContinuous"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.eegSlow==2}">
														<td><spring:message code="label.generalizedDiscontinuous"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.eegSlow==3}">
														<td><spring:message code="label.localizatedContinuous"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.eegSlow==4}">
														<td><spring:message code="label.localizatedDiscontinuous"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.eegSlow==5}">
														<td><spring:message code="label.none"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.interictalEEGSpikes"/></td>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==1}">
														<td><spring:message code="label.generalized"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==2}">
														<td><spring:message code="label.hemispheric"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==3}">
														<td><spring:message code="label.multiregional"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==4}">
														<td>Nelatralizovatelné</td>
													</c:if>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==5}">
														<td><spring:message code="label.regional"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.interictalEegSpikes==6}">
														<td><spring:message code="label.none"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.localizationInterictalEEGSpikes"/></td>
													<td>${diagnosticTestEEG.localizationInterictalEEGSpikes}</td>
												</tr>
												<tr class="info">
													<td><spring:message code="label.EEGStatusEpilepticus"/></td>
													<c:if test="${diagnosticTestEEG.eegStatusEpilepticus==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.eegStatusEpilepticus==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.secondarySidedSynchrony"/></td>
													<c:if test="${diagnosticTestEEG.secondarySidedSynchrony==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.secondarySidedSynchrony==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.ictalEEGPatterns"/></td>
													<c:if test="${diagnosticTestEEG.ictalEegPatterns==1}">
														<td><spring:message code="label.missing"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.ictalEegPatterns==2}">
														<td><spring:message code="label.focal"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.ictalEegPatterns==3}">
														<td><spring:message code="label.multiregional"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.ictalEegPatterns==4}">
														<td><spring:message code="label.notlocalizable"/></td>
													</c:if>
													<c:if test="${diagnosticTestEEG.ictalEegPatterns==5}">
														<td><spring:message code="label.regional"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.localizationIctalEEGPattern"/></td>
													<td>${diagnosticTestEEG.localizationIctalEegPattern}</td>
												</tr>
												<tr class="info">
													<td><spring:message code="label.comment" /></td>
													<c:choose>
														<c:when test="${empty diagnosticTestEEG.comment}">
															<td><spring:message code="label.noComments"/></td>
														</c:when>
														<c:otherwise>
															<td>${diagnosticTestEEG.comment}</td>
														</c:otherwise>
													</c:choose>
												</tr>
											</c:if>
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


