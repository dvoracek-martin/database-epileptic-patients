<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.neuropsychology"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.neuropsychology"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2><spring:message code="label.neuropsychology"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/neuropsychology/create" />"><spring:message code="label.addRecord"/></a>
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
 
			<c:if test="${empty patient.neuropsychologyList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:forEach items="${patient.neuropsychologyList}" var="neuropsychology">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${neuropsychology.id}">
					    	    <strong>Vyšetření dne:</strong> ${neuropsychology.date}
					    	</a>
						</div>

					    <div id="collapse${neuropsychology.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/neuropsychology/${neuropsychology.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/neuropsychology/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td>Neuropsychologické vyšetření</td>
											<c:if test="${neuropsychology.neuropsychologicalExamination==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${neuropsychology.neuropsychologicalExamination==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Věk při neuropsychologickém vyšetření</td>
											<td><strong>N/A</strong></td>
										</tr>
										<tr class="info">
											<td>Inteligenční úroveň</td>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==1}">
												<td>Mírná mentální retardace</td>
											</c:if>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==2}">
												<td>Naprůměrná inteligence</td>
											</c:if>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==3}">
												<td>Podprůměrná inteligence</td>
											</c:if>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==4}">
												<td>Průměrná inteligence</td>
											</c:if>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==5}">
												<td>Středně těžká mentální retardace</td>
											</c:if>
											<c:if test="${neuropsychology.intelligenceLevelIdcom==6}">
												<td>Těžká mentální retardace</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Specifická porucha učení</td>
											<c:if test="${neuropsychology.specificLearning==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${neuropsychology.specificLearning==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Vývojová porucha řeči</td>
											<c:if test="${neuropsychology.developmentalLanguageDisorders==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${neuropsychology.developmentalLanguageDisorders==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>ADHD syndrom</td>
											<c:if test="${neuropsychology.adhdSyndrome==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${neuropsychology.adhdSyndrome==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty neuropsychology.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${neuropsychology.comment}</td>
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


