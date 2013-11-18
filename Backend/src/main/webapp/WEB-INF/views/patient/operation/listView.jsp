<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.operation"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.operation"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2><spring:message code="label.operation"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/operation/create" />"><spring:message code="label.addRecord"/></a>
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


			<!-- operation list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.operationList}" var="operation">
					<c:if test="${operation.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${operation.id}">
						    	    <strong><spring:message code="label.dateOfContractAward"/>:</strong> ${operation.date}
						    	</a>
						    </div>
						    <div id="collapse${operation.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
						      			<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
											<div class="pull-right">
												<a class="close" href="<c:url value="/patient/${patientID}/operation/${operation.id}/hide"/>"><spring:message code="label.delete"/></a>
											</div>
											<div class="pull-left">
												<a class="close" href="<c:url value="/patient/${patientID}/operation/list"/>"><spring:message code="label.edit"/></a>
											</div>
											</br>
										</div>
					              		<table class="table">
						               		<tbody>
						               			<tr class="info">
						               				<td><spring:message code="label.dateOfOperation"/></td>
						               				<td>${operation.dateOperation}</td>
						               			</tr>
						               			<tr class="info">
						               				<td><spring:message code="label.ageAtSurgery"/></td>
						               				<td></td>
						               			</tr>
						               			<tr class="info">
						               				<td><spring:message code="label.durationOfEpilepsyAtTheTimeOfSurgery"/></td>
						               				<td></td>
						               			</tr>
												<tr class="info">
													<td><spring:message code="label.typeOperations"/></td>
													<c:if test="${operation.typeOperation==1}">
														<td>Diskonekce</td>
													</c:if>
													<c:if test="${operation.typeOperation==2}">
														<td><spring:message code="label.hemispherectomy"/></td>
													</c:if>
													<c:if test="${operation.typeOperation==3}">
														<td><spring:message code="label.individualResection"/></td>
													</c:if>
													<c:if test="${operation.typeOperation==4}">
														<td><spring:message code="label.corticalResection"/></td>
													</c:if>
													<c:if test="${operation.typeOperation==5}">
														<td>Lesionektomie</td>
													</c:if>
													<c:if test="${operation.typeOperation==6}">
														<td>Rozšíření Lesionektomie</td>
													</c:if>
													<c:if test="${operation.typeOperation==7}">
														<td><spring:message code="label.standardizedResection"/></td>
													</c:if>
													<c:if test="${operation.typeOperation==8}">
														<td><spring:message code="label.tailoredResection"/></td>
													</c:if>
													<c:if test="${operation.typeOperation==9}">
														<td><spring:message code="label.gammaKnifeSurgery"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.rangeOperations"/></td>
													<c:if test="${operation.rangeOperation==1}">
														<td><spring:message code="label.withoutResection"/></td>
													</c:if>
													<c:if test="${operation.rangeOperation==2}">
														<td><spring:message code="label.focalResection"/></td>
													</c:if>
													<c:if test="${operation.rangeOperation==3}">
														<td><spring:message code="label.hemispherectomy"/></td>
													</c:if>
													<c:if test="${operation.rangeOperation==4}">
														<td>Jednolobární <spring:message code="label.resection"/></td>
													</c:if>
													<c:if test="${operation.rangeOperation==5}">
														<td>Multilobární <spring:message code="label.resection"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.localizationOperations"/></td>
													<td>${operation.localizationOperation}</td>
												</tr>
												<tr class="info">
													<td>MST</td>
													<c:if test="${operation.mst==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${operation.mst==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.calostomy"/></td>
													<c:if test="${operation.colostomy==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${operation.colostomy==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td>VNS</td>
													<c:if test="${operation.vns==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${operation.vns==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.VNSImplantationDate"/></td>
													<td>${operation.VNSImplantationDate}</td>
												</tr>
												<tr class="info">
													<td><spring:message code="label.operationDetails"/></td>
													<td>${operation.operationDetails}</td>
												</tr>
												<tr class="info">
													<td><spring:message code="label.completeResection"/></td>
													<c:if test="${operation.completeResection==true}">
														<td style="column-span: 2"><spring:message code="label.yes"/></td>
													</c:if>
													<c:if test="${operation.completeResection==false}">
														<td><spring:message code="label.no"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.comment" /></td>
													<c:choose>
														<c:when test="${empty operation.comment}">
															<td><spring:message code="label.noComments" /></td>
														</c:when>
														<c:otherwise>
															<td>${operation.comment}</td>
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


