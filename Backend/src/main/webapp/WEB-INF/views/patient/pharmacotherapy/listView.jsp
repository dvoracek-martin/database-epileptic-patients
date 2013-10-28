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
						      	<a class="close" href="<c:url value="/patient/${patientID}/pharmacotherapy/${pharmacotherapy.id}/delete"/>">×</a>
								<table class="table">
			               			<tbody>
										<tr class="info">
											<td>Léčivo</td>
											<td>${pharmacotherapy.aedIdcom}</td>
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
											<td>${pharmacotherapy.comment}</td>
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


