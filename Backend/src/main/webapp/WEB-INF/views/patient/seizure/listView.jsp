<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.seizures"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.seizures"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2><spring:message code="label.seizures"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"	
					href="<c:url value="/patient/${patient.id}/seizure/create"  />"><spring:message code="label.addRecord"/></a>
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

			<c:if test="${empty patient.seizureList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4><spring:message code="label.noRecords"/>!</h4>
				</div>
 			</c:if>

			<!-- Seizure list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.seizureList}" var="seizure">
					<c:if test="${anamnesis.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div >
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${seizure.id}">
						    	    <strong><spring:message code="label.examinationDate"/>:</strong> ${seizure.date}
						    	</a>
							</div>

						    <div id="collapse${seizure.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patient.id}/seizure/list"/>"><spring:message code="label.edit"/></a>
										</div>
										</br>
									</div>
									<table class="table">
			               		<tbody>
									<tr class="info">
										<td><spring:message code="label.seizureFrequency"/></td>
										<c:if test="${seizure.seizureFrequency==1}">
											<td><spring:message code="label.daily"/></td>
										</c:if>
										<c:if test="${seizure.seizureFrequency==2}">
											<td><spring:message code="label.weekly"/></td>
										</c:if>
										<c:if test="${seizure.seizureFrequency==3}">
											<td><spring:message code="label.monthly"/></td>
										</c:if>
										<c:if test="${seizure.seizureFrequency==4}">
											<td><spring:message code="label.lessThanMonthly"/></td>
										</c:if>
									</tr>
									
									<tr class="info">
										<td>Sekundárně generalizované</td>
										<c:if test="${seizure.secondarilyGeneralizedSeizure==true}">
											<td><spring:message code="label.yes"/></td>
										</c:if>
										<c:if test="${seizure.secondarilyGeneralizedSeizure==false}">
											<td><spring:message code="label.no"/></td>
										</c:if>
									</tr>
									
									<tr class="info">
										<td>Status epilepticus</td>
										<c:if test="${seizure.statusEpilepticus==true}">
											<td><spring:message code="label.yes"/></td>
										</c:if>
										<c:if test="${seizure.statusEpilepticus==false}">
											<td><spring:message code="label.no"/></td>
										</c:if>
									</tr>

									<tr class="info">
										<td>Neepileptické záchvaty</td>
										<c:if test="${seizure.nonepilepticSeizures==true}">
											<td><spring:message code="label.yes"/></td>
										</c:if>
										<c:if test="${seizure.nonepilepticSeizures==false}">
											<td><spring:message code="label.no"/></td>
										</c:if>
									</tr>

									<tr class="info">
										<td>Výskyt</td>
										<td style="color: red">Nedostupné</td>
										</c:if>
									</tr>

									<tr class="info">
										<td><spring:message code="label.comment" /></td>
										<c:choose>
											<c:when test="${empty seizure.comment}">
												<td><spring:message code="label.noComment"/></td>
											</c:when>
											<c:otherwise>
												<td>${seizure.comment}</td>
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
		<!-- Seizure list END -->
	</jsp:body>
</t:menuLVL3>


