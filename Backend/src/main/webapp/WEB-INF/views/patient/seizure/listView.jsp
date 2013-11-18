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
					href="<c:url value="/patient/${patientID}/seizure/create"  />"><spring:message code="label.addRecord"/></a>
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
				<c:forEach items="${patient.seizureList}" var="seizure">
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
										<a class="close" href="<c:url value="/patient/${patientID}/seizure/${seizure.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/seizure/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
		               		<tbody>
								<tr class="info">
									<td><spring:message code="label.seizureFrequency"/></td>
									<c:if test="${seizure.seizureFrequencyIdcom==1}">
										<td><spring:message code="label.daily"/></td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==2}">
										<td><spring:message code="label.weekly"/></td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==3}">
										<td><spring:message code="label.monthly"/></td>
									</c:if>
									<c:if test="${seizure.seizureFrequencyIdcom==4}">
										<td><spring:message code="label.lessThanMonthly"/></td>
									</c:if>
								</tr>
								
								<tr class="info">
									<td>Status epilepticus</td>
									<c:if test="${seizure.statusEpilepticus==true}">
										<td style="column-span: 2"><spring:message code="label.yes"/></td>
									</c:if>
									<c:if test="${seizure.statusEpilepticus==false}">
										<td><spring:message code="label.no"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.SSCClassification"/></td>
									<c:if test="${seizure.sscClassificationIdcom==1}">
										<td><spring:message code="label.epilepticSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==2}">
										<td><spring:message code="label.aura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==3}">
										<td><spring:message code="label.somatosenzoryAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==4}">
										<td><spring:message code="label.visualAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==5}">
										<td><spring:message code="label.auditoryAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==6}">
										<td><spring:message code="label.olfactoryAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==7}">
										<td><spring:message code="label.gustatoryAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==8}">
										<td><spring:message code="label.autonomicAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==9}">
										<td><spring:message code="label.epigastricAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==10}">
										<td><spring:message code="label.psychicAura"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==11}">
										<td><spring:message code="label.absence"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==12}">
										<td><spring:message code="label.autonomicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==13}">
										<td><spring:message code="label.psychomotorSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==14}">
										<td><spring:message code="label.motorSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==15}">
										<td><spring:message code="label.clonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==16}">
										<td><spring:message code="label.tonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==17}">
										<td><spring:message code="label.tonicClonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==18}">
										<td><spring:message code="label.atonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==19}">
										<td><spring:message code="label.akineticSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==20}">
										<td><spring:message code="label.versiveSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==21}">
										<td><spring:message code="label.myoclonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==22}">
										<td><spring:message code="label.hypermotorSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==23}">
										<td><spring:message code="label.hypomotorSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==24}">
										<td><spring:message code="label.negativeMyoclonicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==25}">
										<td><spring:message code="label.askatikSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==26}">
										<td><spring:message code="label.akineticSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==27}">
										<td><spring:message code="label.aphasicSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==28}">
										<td><spring:message code="label.gelasticSeizure"/></td>
									</c:if>
									<c:if test="${seizure.sscClassificationIdcom==29}">
										<td><spring:message code="label.paroxymalEvent"/></td>
									</c:if>
								</tr>
								<tr class="info">
									<td><spring:message code="label.ILAEClassification"/></td>
									<c:if test="${seizure.ilaeClassificationIdcom==1}">
										<td><spring:message code="label.simplePartialMotor"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==2}">
										<td><spring:message code="label.simplePartialPsychic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==3}">
										<td><spring:message code="label.simplePartialMotor"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==4}">
										<td>spring:message code="label.simplePartialPsychic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==5}">
										<td><spring:message code="label.simplePartialSimple"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==6}">
										<td><spring:message code="label.simplePartialImpairment"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==7}">
										<td><spring:message code="label.simplePartialEvolving"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==8}">
										<td><spring:message code="label.generalizedTypical"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==9}">
										<td><spring:message code="label.generalizedAtypical"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==10}">
										<td><spring:message code="label.generalizedMyoclonic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==11}">
										<td><spring:message code="label.generalizedClonic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==12}">
										<td><spring:message code="label.generalizedTonic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==13}">
										<td><spring:message code="label.generalizedTonicClonic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==14}">
										<td><spring:message code="label.generalizedAtonic"/></td>
									</c:if>
									<c:if test="${seizure.ilaeClassificationIdcom==15}">
										<td><spring:message code="label.unclassified"/></td>
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
	            </c:forEach>
            </div>
        </br> 
		<!-- Seizure list END -->
	</jsp:body>
</t:menuLVL3>


