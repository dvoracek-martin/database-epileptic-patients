<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.pharmacotherapy"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.pharmacotherapy"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2><spring:message code="label.pharmacotherapy"/></h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/pharmacotherapy/create" />"><spring:message code="label.addRecord"/></a>
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
 			
			<c:if test="${empty patient.pharmacotherapyList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4><spring:message code="label.noRecords"/></h4>
				</div>
 			</c:if>

			<!-- Seizure list START -->
			<div class="accordion">
				<c:forEach items="${patient.pharmacotherapyList}" var="pharmacotherapy">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${pharmacotherapy.id}">
					    	    <strong><spring:message code="label.dateOfContractAward"/>:</strong> ${pharmacotherapy.date}
					    	</a>
						</div>

					    <div id="collapse${pharmacotherapy.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/pharmacotherapy/${pharmacotherapy.id}/hide"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/pharmacotherapy/list"/>"><spring:message code="label.edit"/></a>
									</div>
									<br>
								</div>
								<table class="table">
			               			<tbody>
										<tr class="info">
											<td><spring:message code="label.medicines"/></td>
											<c:if test="${pharmacotherapy.aed==1}">
												<td>ACTH</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==2}">
												<td>CBZ</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==3}">
												<td>CLB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==4}">
												<td>CZP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==5}">
												<td>DZP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==6}">
												<td>ESL</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==7}">
												<td>ETS</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==8}">
												<td>FBM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==9}">
												<td>GBP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==10}">
												<td>LCM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==11}">
												<td>LEV</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==12}">
												<td>LTG</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==13}">
												<td>OXC</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==14}">
												<td>PB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==15}">
												<td>PGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==16}">
												<td>PHT</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==17}">
												<td>PRM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==18}">
												<td>RFM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==19}">
												<td>STM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==20}">
												<td>TGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==21}">
												<td>TPM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==22}">
												<td>VGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==23}">
												<td>VPA</td>
											</c:if>
											<c:if test="${pharmacotherapy.aed==24}">
												<td>ZNS</td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.efficiency"/></td>
											<c:if test="${pharmacotherapy.efficiency==1}">
												<td><spring:message code="label.resistant"/></td>
											</c:if>
											<c:if test="${pharmacotherapy.efficiency==2}">
												<td><spring:message code="label.effective"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.duringSurgery"/></td>
											<c:if test="${pharmacotherapy.duringSurgery==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${pharmacotherapy.duringSurgery==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty patient.pharmacotherapyList[0].comment}">
													<td><spring:message code="label.noComments" /></td>
												</c:when>
												<c:otherwise>
													<td>${patient.pharmacotherapyList[0].comment}</td>
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


