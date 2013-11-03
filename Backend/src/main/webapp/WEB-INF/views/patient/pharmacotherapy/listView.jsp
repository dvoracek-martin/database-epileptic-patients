<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Farmakoterapie
    </jsp:attribute>
	<jsp:attribute name="header">
      Farmakoterapie
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Farmakoterapie</h2>
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
 
			<!-- Seizure list START -->
			<div class="accordion">
				<c:forEach items="${patient.pharmacotherapyList}" var="pharmacotherapy">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${pharmacotherapy.id}">
					    	    <strong>Vyšetření dne:</strong> ${pharmacotherapy.date}
					    	</a>
						</div>

					    <div id="collapse${pharmacotherapy.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/pharmacotherapy/${pharmacotherapy.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/pharmacotherapy/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
			               			<tbody>
										<tr class="info">
											<td>Léčivo</td>
											<c:if test="${pharmacotherapy.aedIdcom==1}">
												<td>ACTH</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==2}">
												<td>CBZ</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==3}">
												<td>CLB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==4}">
												<td>CZP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==5}">
												<td>DZP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==6}">
												<td>ESL</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==7}">
												<td>ETS</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==8}">
												<td>FBM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==9}">
												<td>GBP</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==10}">
												<td>LCM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==11}">
												<td>LEV</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==12}">
												<td>LTG</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==13}">
												<td>OXC</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==14}">
												<td>PB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==15}">
												<td>PGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==16}">
												<td>PHT</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==17}">
												<td>PRM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==18}">
												<td>RFM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==19}">
												<td>STM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==20}">
												<td>TGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==21}">
												<td>TPM</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==22}">
												<td>VGB</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==23}">
												<td>VPA</td>
											</c:if>
											<c:if test="${pharmacotherapy.aedIdcom==24}">
												<td>ZNS</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Efektivita</td>
											<c:if test="${pharmacotherapy.effective==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${pharmacotherapy.effective==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>Při operaci</td>
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
													<td>Žádný</td>
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


