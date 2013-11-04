<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Operace
    </jsp:attribute>
	<jsp:attribute name="header">
      Operace
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Operace</h2>
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
 
			<c:if test="${empty patient.operationList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:forEach items="${patient.operationList}" var="operation">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${operation.id}">
					    	    <strong>Vyšetření dne:</strong> ${operation.date}
					    	</a>
					    </div>
					    <div id="collapse${operation.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
					      			<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
										<div class="pull-right">
											<a class="close" href="<c:url value="/patient/${patientID}/operation/${operation.id}/delete"/>"><spring:message code="label.delete"/></a>
										</div>
										<div class="pull-left">
											<a class="close" href="<c:url value="/patient/${patientID}/operation/list"/>"><spring:message code="label.edit"/></a>
										</div>
										</br>
									</div>
				              		<table class="table">
					               		<tbody>
											<tr class="info">
												<td>Typ operace</td>
												<c:if test="${operation.typeOperationsIdcom==1}">
													<td>Diskonekce</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==2}">
													<td>Hemisferektomie</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==3}">
													<td>Kortikální resekce</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==4}">
													<td>Lesionektomie</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==5}">
													<td>Rozšíření Lesionektomie</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==6}">
													<td>Standardizované resekce</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==7}">
													<td>Tailored resekce</td>
												</c:if>
												<c:if test="${operation.typeOperationsIdcom==8}">
													<td>Zákrok gamma nožem</td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Rozsah operace</td>
												<c:if test="${operation.rangeOperationsIdcom==1}">
													<td>Fokální resekce</td>
												</c:if>
												<c:if test="${operation.rangeOperationsIdcom==2}">
													<td>Hemisferektomie</td>
												</c:if>
												<c:if test="${operation.rangeOperationsIdcom==3}">
													<td>Jednolobární resekce</td>
												</c:if>
												<c:if test="${operation.rangeOperationsIdcom==4}">
													<td>Multilobární resekce</td>
												</c:if>
											</tr>
											<tr class="info">
												<td>Lokalizace operace</td>
												<td>${operation.localizationOperations}</td>
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
												<td>Kalostomie</td>
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
												<td>Datum imlantace VNS</td>
												<td>${operation.VNSImplantationDate}</td>
											</tr>
											<tr class="info">
												<td>Detail operace</td>
												<td>${operation.operationDetails}</td>
											</tr>
											<tr class="info">
												<td>Resekce kompletní</td>
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
														<td>Žádný</td>
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
	            </c:forEach>
            </div>
        </br> 
	</jsp:body>
</t:menuLVL3>


