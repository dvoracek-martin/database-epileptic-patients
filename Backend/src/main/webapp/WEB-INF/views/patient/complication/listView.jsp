<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Komplikace
    </jsp:attribute>
	<jsp:attribute name="header">
      Komplikace
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Komplikace</h2>
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
 
			<c:if test="${empty patient.complicationList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Histology list START -->
			<div class="accordion">
				<c:forEach items="${patient.complicationList}" var="complication">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${complication.id}">
					    	    <strong>Vyšetření dne:</strong> ${complication.date}
					    	</a>
						</div>

					    <div id="collapse${complication.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/complication/${complication.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/complication/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td><spring:message code="label.complication"/></td>
											<c:if test="${complication.complicationIdcom==1}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.0"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==2}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.aphasia"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==3}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.hemiparesis"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==4}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.other"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==5}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==6}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.visualFieldDefects"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==7}">
												<td><spring:message code="label.unexpectedPermanent"/> - <spring:message code="label.death"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==8}">
												<td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.0"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==9}">
												<td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.hemiparesis"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==10}">
												<td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.other"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==11}">
												<td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==12}">
												<td><spring:message code="label.expectedPermanent"/> - <spring:message code="label.visualFieldDefects"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==13}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.0"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==14}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.aphasia"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==15}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.edema"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==16}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.hemiparesis"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==17}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.hydrocefalus"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==18}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.ischemia"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==19}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.other"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==20}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.hemorrhage"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==21}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.paresisOfCranialNerves"/></td>
											</c:if>
											<c:if test="${complication.complicationIdcom==22}">
												<td><spring:message code="label.transitional"/> - <spring:message code="label.inflammation"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty complication.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${complication.comment}</td>
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


