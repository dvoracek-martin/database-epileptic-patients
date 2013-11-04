<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Invazivní testy - ECoG
    </jsp:attribute>
	<jsp:attribute name="header">
      Invazivní testy - ECoG
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Invazivní testy - ECoG</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a href="<c:url value="/patient/${patient.id}/invasiveTestEEG/create" />"><spring:message code="label.addRecord"/></a>
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
 			
 			<c:if test="${empty patient.invasiveTestECOGList}">
 				<div class="alert alert-block">
		  			<button type="button" class="close" data-dismiss="alert">&times;</button>
		  			<h4>Žádné záznamy!</h4>
				</div>
 			</c:if>

			<div class="accordion">
				<c:forEach items="${patient.invasiveTestECOGList}" var="invasiveTestECOG">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${invasiveTestECOG.id}">
					    	    <strong>Vyšetření dne:</strong> ${invasiveTestECOG.date}
					    	</a>
						</div>

					    <div id="collapse${invasiveTestECOG.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<div class="label-info" style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
									<div class="pull-right">
										<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestECOG/${invasiveTestECOG.id}/delete"/>"><spring:message code="label.delete"/></a>
									</div>
									<div class="pull-left">
										<a class="close" href="<c:url value="/patient/${patientID}/invasiveTestECOG/list"/>"><spring:message code="label.edit"/></a>
									</div>
									</br>
								</div>
								<table class="table">
				               		<tbody>
										<tr class="info">
											<td>Intraoperační ECoG</td>
											<c:if test="${invasiveTestECOG.intraoperativeEcog==true}">
												<td style="column-span: 2"><spring:message code="label.yes"/></td>
											</c:if>
											<c:if test="${invasiveTestECOG.intraoperativeEcog==false}">
												<td><spring:message code="label.no"/></td>
											</c:if>
										</tr>
										<tr class="info">
											<td>ECoG pokrytí</td>
											<td>${invasiveTestECOG.ecogCover}</td>
										</tr>
										<tr class="info">
											<td>ECoG vzorce</td>
											<c:if test="${invasiveTestECOG.ecogPatternsIdcom==1}">
												<td>Bez hrotů</td>
											</c:if>
											<c:if test="${invasiveTestECOG.ecogPatternsIdcom==2}">
												<td>Burst-suppression</td>
											</c:if>
											<c:if test="${invasiveTestECOG.ecogPatternsIdcom==3}">
												<td>Kontinuální hroty</td>
											</c:if>
											<c:if test="${invasiveTestECOG.ecogPatternsIdcom==4}">
												<td>Nespecifická abnormalita</td>
											</c:if>
											<c:if test="${invasiveTestECOG.ecogPatternsIdcom==5}">
												<td>S hroty</td>
											</c:if>
										</tr>
										<tr class="info">
											<td>ECoG po resekci</td>
											<c:if test="${invasiveTestECOG.afterResectionEcogIdcom==1}">
												<td>Bez hrotů</td>
											</c:if>
											<c:if test="${invasiveTestECOG.afterResectionEcogIdcom==2}">
												<td>Neprovedena</td>
											</c:if>
											<c:if test="${invasiveTestECOG.afterResectionEcogIdcom==3}">
												<td>S hroty</td>
											</c:if>
										</tr>
										<tr class="info">
											<td><spring:message code="label.comment" /></td>
											<c:choose>
												<c:when test="${empty invasiveTestECOG.comment}">
													<td>Žádný</td>
												</c:when>
												<c:otherwise>
													<td>${invasiveTestECOG.comment}</td>
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


