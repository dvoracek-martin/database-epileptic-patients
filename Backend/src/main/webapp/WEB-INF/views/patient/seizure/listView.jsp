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

			<!-- Seizure list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.seizureList}" var="seizure">
					<c:if test="${seizure.status==0}">
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
										<div>
											<a class="close" href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/create"/>">Přidat záchvat</a>
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
												<td></td>
											</tr>
											
											<tr class="info">
												<td>Sekundárně generalizované</td>
												<c:if test="${seizure.secondarilyGeneralizedSeizure==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${seizure.secondarilyGeneralizedSeizure==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
												<td></td>
											</tr>
											
											<tr class="info">
												<td>Status epilepticus</td>
												<c:if test="${seizure.statusEpilepticus==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${seizure.statusEpilepticus==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
												<td></td>
											</tr>

											<tr class="info">
												<td>Neepileptické záchvaty</td>
												<c:if test="${seizure.nonepilepticSeizures==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${seizure.nonepilepticSeizures==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
												<td></td>
											</tr>

											<tr class="info">
												<td>Výskyt</td>
												<td style="color: red">Nedostupné</td>
												<td></td>
											</tr>

											<tr class="info">
												<td><spring:message code="label.comment" /></td>
												<c:choose>
													<c:when test="${empty seizure.comment}">
														<td><spring:message code="label.noComments"/></td>
													</c:when>
													<c:otherwise>
														<td>${seizure.comment}</td>
													</c:otherwise>
												</c:choose>
												<td></td>
											</tr>
											<c:set var="count2" value="0" scope="page" />
											<c:forEach items="${seizure.seizureDetailList}" var="seizureDetail">
												<c:if test="${seizureDetail.status==0}">
													<c:set var="count2" value="${count2 + 1}" scope="page"/>

													<tr class="info">
														<td>${count2}. typ záchvatu</td>
														<td>(<a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/edit"/>"><spring:message code="label.edit"/></a>|<a href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/${seizureDetail.id}/hide"/>"><spring:message code="label.delete"/></a>)</td>
														<td></td>
													</tr>

													<tr class="info">
														<td></td>
														<td>Zadáno dne</td>
														<td>${seizureDetail.date}</td>
													</tr>

													<tr class="info">
														<td></td>
														<td><spring:message code="label.SSCClassification"/></td>
														<c:if test="${seizureDetail.sscClassification==1}">
															<td><spring:message code="label.epilepticSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==2}">
															<td><spring:message code="label.aura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==3}">
															<td><spring:message code="label.somatosenzoryAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==4}">
															<td><spring:message code="label.visualAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==5}">
															<td><spring:message code="label.auditoryAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==6}">
															<td><spring:message code="label.olfactoryAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==7}">
															<td><spring:message code="label.gustatoryAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==8}">
															<td><spring:message code="label.autonomicAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==9}">
															<td><spring:message code="label.epigastricAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==10}">
															<td><spring:message code="label.psychicAura"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==11}">
															<td><spring:message code="label.absence"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==12}">
															<td><spring:message code="label.autonomicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==13}">
															<td><spring:message code="label.psychomotorSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==14}">
															<td><spring:message code="label.motorSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==15}">
															<td><spring:message code="label.clonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==16}">
															<td><spring:message code="label.tonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==17}">
															<td><spring:message code="label.tonicClonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==18}">
															<td><spring:message code="label.atonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==19}">
															<td><spring:message code="label.akineticSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==20}">
															<td><spring:message code="label.versiveSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==21}">
															<td><spring:message code="label.myoclonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==22}">
															<td><spring:message code="label.hypermotorSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==23}">
															<td><spring:message code="label.hypomotorSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==24}">
															<td><spring:message code="label.negativeMyoclonicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==25}">
															<td><spring:message code="label.askatikSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==26}">
															<td><spring:message code="label.akineticSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==27}">
															<td><spring:message code="label.aphasicSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==28}">
															<td><spring:message code="label.gelasticSeizure"/></td>
														</c:if>
														<c:if test="${seizureDetail.sscClassification==29}">
															<td><spring:message code="label.paroxymalEvent"/></td>
														</c:if>
													</tr>

													<tr class="info">
														<td></td>
														<td><spring:message code="label.ILAEClassification"/></td>
														<c:if test="${seizureDetail.ilaeClassification==1}">
															<td><spring:message code="label.simplePartialMotor"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==2}">
															<td><spring:message code="label.simplePartialPsychic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==3}">
															<td><spring:message code="label.simplePartialAutonomic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==4}">
															<td><spring:message code="label.simplePartialSomatosensory"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==5}">
															<td><spring:message code="label.simplePartialSimple"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==6}">
															<td><spring:message code="label.simplePartialImpairment"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==7}">
															<td><spring:message code="label.simplePartialEvolving"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==8}">
															<td><spring:message code="label.generalizedTypical"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==9}">
															<td><spring:message code="label.generalizedAtypical"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==10}">
															<td><spring:message code="label.generalizedMyoclonic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==11}">
															<td><spring:message code="label.generalizedClonic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==12}">
															<td><spring:message code="label.generalizedTonic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==13}">
															<td><spring:message code="label.generalizedTonicClonic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==14}">
															<td><spring:message code="label.generalizedAtonic"/></td>
														</c:if>
														<c:if test="${seizureDetail.ilaeClassification==15}">
															<td><spring:message code="label.unclassified"/></td>
														</c:if>
													</tr>
												</c:if>
											</c:forEach>
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


