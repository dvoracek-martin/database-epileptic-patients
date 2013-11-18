<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.complication"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.complication"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2><spring:message code="label.complication"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/complication/create" />"><spring:message code="label.addRecord"/></a>
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
 
			<!-- complications list START -->
			<div class="accordion">
				<c:set var="count" value="0" scope="page" />
				<c:forEach items="${patient.complicationList}" var="complication">
					<c:if test="${complication.status==0}">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<div>
							<div class="accordion-heading">
						    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${complication.id}">
						    	    <strong><spring:message code="label.dateOfContractAward"/>:</strong> ${complication.date}
						    	</a>
							</div>

						    <div id="collapse${complication.id}" class="accordion-body collapse">

						      	<div class="accordion-inner">
							      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patientID}/complication/${complication.id}/hide"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patientID}/complication/list"/>"><spring:message code="label.edit"/></a>
										</div>
										</br>
									</div>
									<table class="table">
					               		<tbody>
											<tr class="info">
												<td><spring:message code="label.process"/></td>
												<c:if test="${complication.withComplication==true}">
													<td><spring:message code="label.withComplications"/></td>
												</c:if>
												<c:if test="${complication.withComplication==false}">
													<td><spring:message code="label.withoutComplications"/></td>
												</c:if>
											</tr>
											<c:if test="${complication.withComplication==true}">
												<tr class="info">
													<td><spring:message code="label.typeComplication"/></td>
													<c:if test="${complication.complicationType==1}">
														<td><spring:message code="label.unexpectedPermanent"/></td>
													</c:if>
													<c:if test="${complication.complicationType==2}">
														<td><spring:message code="label.expectedPermanent"/></td>
													</c:if>
													<c:if test="${complication.complicationType==3}">
														<td><spring:message code="label.transitional"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.complication"/></td>
													<c:if test="${complication.complication==1}">
														<td><spring:message code="label.aphasia"/></td>
													</c:if>
													<c:if test="${complication.complication==2}">
														<td><spring:message code="label.edema"/></td>
													</c:if>
													<c:if test="${complication.complication==3}">
														<td><spring:message code="label.hemiparesis"/></td>
													</c:if>
													<c:if test="${complication.complication==4}">
														<td><spring:message code="label.hydrocefalus"/></td>
													</c:if>
													<c:if test="${complication.complication==5}">
														<td><spring:message code="label.ischemia"/></td>
													</c:if>
													<c:if test="${complication.complication==6}">
														<td><spring:message code="label.other"/></td>
													</c:if>
													<c:if test="${complication.complication==7}">
														<td><spring:message code="label.hemorrhage"/></td>
													</c:if>
													<c:if test="${complication.complication==8}">
														<td><spring:message code="label.paresisOfCranialNerves"/></td>
													</c:if>
													<c:if test="${complication.complication==9}">
														<td><spring:message code="label.visualFieldDefects"/></td>
													</c:if>
													<c:if test="${complication.complication==10}">
														<td><spring:message code="label.death"/></td>
													</c:if>
													<c:if test="${complication.complication==11}">
														<td><spring:message code="label.inflammation"/></td>
													</c:if>
												</tr>
												<tr class="info">
													<td><spring:message code="label.comment" /></td>
													<c:choose>
														<c:when test="${empty complication.comment}">
															<td><spring:message code="label.noComments"/></td>
														</c:when>
														<c:otherwise>
															<td>${complication.comment}</td>
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


