<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.anamnesis" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.anamnesis" />
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>

			<div>
				<div class="span5">
					<h2><spring:message code="label.anamnesis" /></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patient.id}/anamnesis/create" />"><spring:message code="label.addRecord"/></a>
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

			<!-- anamnesis list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.anamnesisList}" var="anamnesis">
					<c:if test="${anamnesis.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${anamnesis.id}">
						    	    <strong><spring:message code="label.dateOfContractAward"/>:</strong> ${anamnesis.date}
						    	</a>
							</div>

						    <div id="collapse${anamnesis.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patient.id}/anamnesis/list"/>"><spring:message code="label.edit"/></a>
										</div>
										<br>
									</div>
									<table class="table">
					              		<tbody>
											<tr class="info">
												<td><spring:message code="label.epilepsyInFamily" /></td>
												<c:if test="${anamnesis.epilepsyInFamily==true}">
													<td style="column-span: 2"><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.epilepsyInFamily==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.prenatalRisk" /></td>
												<c:if test="${anamnesis.prenatalRisk==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.prenatalRisk==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.fibrilConvulsions" /></td>
												<c:if test="${anamnesis.fibrilConvulsions==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.fibrilConvulsions==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.inflammationCNS" /></td>
												<c:if test="${anamnesis.inflammationCns==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.inflammationCns==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.injuryCNS" /></td>
												<c:if test="${anamnesis.injuryCns==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.injuryCns==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.operationCNS" /></td>
												<c:if test="${anamnesis.operationCns==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.operationCns==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.earlyPMDRetardation" /></td>
												<c:if test="${anamnesis.earlyPmdRetardation==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.earlyPmdRetardation==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.beginningEpilepsy" /></td>
												<td>${anamnesis.beginningEpilepsy}</td>
											</tr>
											<tr class="info">
												<td><spring:message code="label.firstFever" /></td>
												<c:if test="${anamnesis.firstFever==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.firstFever==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.infantileSpasm" /></td>
												<c:if test="${anamnesis.infantileSpasm==true}">
													<td><spring:message code="label.yes"/></td>
												</c:if>
												<c:if test="${anamnesis.infantileSpasm==false}">
													<td><spring:message code="label.no"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.epilepticSyndrome" /></td>
												<c:if test="${anamnesis.specificSyndrome==1}">
													<td><spring:message code="label.extratemporalFocalEpilepsy"/></td>
												</c:if>

												<c:if test="${anamnesis.specificSyndrome==2}">
													<td><spring:message code="label.hemisphericSymptomaticEpilepsy"/></td>
												</c:if>

												<c:if test="${anamnesis.specificSyndrome==3}">
													<td><spring:message code="label.mesiotemporalEpilepsy"/></td>
												</c:if>

												<c:if test="${anamnesis.specificSyndrome==4}">
													<td><spring:message code="label.multifocalEpilepsy"/></td>
												</c:if>

												<c:if test="${anamnesis.specificSyndrome==5}">
													<td><spring:message code="label.temporalEpilepsy"/></td>
												</c:if>
											</tr>
											<tr class="info">
												<td><spring:message code="label.nonCNSComorbidity" /></td>
												<td>${anamnesis.nonCnsComorbidity}</td>
											</tr>

											<tr class="info">
												<td><spring:message code="label.comment" /></td>
												<c:choose>
													<c:when test="${empty anamnesis.comment}">
														<td><spring:message code="label.noComments"/></td>
													</c:when>
													<c:otherwise>
														<td>${anamnesis.comment}</td>
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
			<!-- anamnesis list END -->
	</jsp:body>
</t:menuLVL3>


