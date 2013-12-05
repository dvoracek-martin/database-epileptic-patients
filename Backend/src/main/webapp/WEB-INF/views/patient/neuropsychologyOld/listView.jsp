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
					<h2><spring:message code="label.neuropsychology"/></h2>
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
 

			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.neuropsychologyOldList}" var="neuropsychologyOld">
					<c:if test="${neuropsychologyOld.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${neuropsychologyOld.id}">
						    	    <strong>Vyšetření dne:</strong> ${neuropsychologyOld.date}
						    	</a>
							</div>

						    <div id="collapse${neuropsychologyOld.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patient.id}/neuropsychology-old/${neuropsychologyOld.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<br>
									</div>
									<table class="table">
					               		<tbody>
											<tr class="info">
												<td>Neuropsychologické vyšetření</td>
												<c:if test="${neuropsychologyOld.neuropsychologicalExamination==true}">
													<td style="column-span: 2"><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${neuropsychologyOld.neuropsychologicalExamination==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Věk při neuropsychologickém vyšetření</td>
												<td><strong>N/A</strong></td>
											</tr>
											<tr class="info">
												<td>Inteligenční úroveň</td>
												<c:if test="${neuropsychologyOld.intelligenceLevel==1}">
													<td>Mírná mentální retardace</td>
												</c:if>
												<c:if test="${neuropsychologyOld.intelligenceLevel==2}">
													<td>Naprůměrná inteligence</td>
												</c:if>
												<c:if test="${neuropsychologyOld.intelligenceLevel==3}">
													<td>Podprůměrná inteligence</td>
												</c:if>
												<c:if test="${neuropsychologyOld.intelligenceLevel==4}">
													<td>Průměrná inteligence</td>
												</c:if>
												<c:if test="${neuropsychologyOld.intelligenceLevel==5}">
													<td>Středně těžká mentální retardace</td>
												</c:if>
												<c:if test="${neuropsychologyOld.intelligenceLevel==6}">
													<td>Těžká mentální retardace</td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Specifická porucha učení</td>
												<c:if test="${neuropsychologyOld.specificLearning==true}">
													<td style="column-span: 2"><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${neuropsychologyOld.specificLearning==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Vývojová porucha řeči</td>
												<c:if test="${neuropsychologyOld.developmentalLanguageDisorders==true}">
													<td style="column-span: 2"><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${neuropsychologyOld.developmentalLanguageDisorders==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td>ADHD syndrom</td>
												<c:if test="${neuropsychologyOld.adhdSyndrome==true}">
													<td style="column-span: 2"><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${neuropsychologyOld.adhdSyndrome==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.comment" /></td>
												<c:choose>
													<c:when test="${empty neuropsychologyOld.comment}">
														<td><spring:message code="label.noComments"/></td>
													</c:when>
													<c:otherwise>
														<td>${neuropsychologyOld.comment}</td>
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


