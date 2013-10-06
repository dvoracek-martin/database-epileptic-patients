<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Anamnéza
    </jsp:attribute>
	<jsp:attribute name="header">
      Anamnéza
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
		<div>
			<div>
				<div class="span5">
					<h2>Anamnéza</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/anamnesis/create" />">Přidat
						záznam</a>
					</h3>
				</div>
			</div>
			<table class="table">
			<tbody>
					<tr>
						<th>Pacient:</th>
						<td>${patient.contact.firstName}</td>

						<th>Rodné číslo:</th>
						<td>${patient.nin}</td>

						<th>Datum narození:</th>
						<td>${patient.birthday}</td>
							
					</tr>
					<tr>	
						<th>Adresa:</th>
						<td>${patient.contact.addressStreet}</td>
							
						<th>Telefon:</th>
						<td>${patient.contact.phoneNumber}</td>
							
						<th>Email:</th>
						<td>${patient.contact.email}</td>
												
							
					</tr>
					<tr>
						<th>Pohaví:</th>
						<td>${patient.gender}</td>
							
						<th>Věk při začátku epilepsie:</th>
						<td></td>
							
						<th>Ošetřující lékař:</th>
						<td></td>
							
					</tr>
				</tbody>
			</table>
 
			<!-- Anamnesis list START -->
			<div class="accordion">
				<c:forEach items="${patient.anamnesisList}" var="anamnesis">
					<div >
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${anamnesis.id}">
					    	    <strong>Vyšetření dne:</strong> ${anamnesis.date}
					    	</a>
						</div>
					    <div id="collapse${anamnesis.id}" class="accordion-body collapse">
					      	<div class="accordion-inner">
						      	<a class="close" href="<c:url value="/patient/${patientID}/anamnesis/${anamnesis.id}/delete"/>">×</a>
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
											<td>${anamnesis.specificSyndromeIdcom}</td>
										</tr>
										<tr class="info">
											<td><spring:message code="label.nonCNSComorbidity" /></td>
											<td>${anamnesis.nonCnsComorbidity}</td>
										</tr>
				              		</tbody>
				            	</table>
		            		</div>
					    </div>
	            	</div>
	            </c:forEach>
            </div>
			<!-- Anamnesis list END -->
	</jsp:body>
</t:menuLVL3>


