<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Outcome
    </jsp:attribute>
	<jsp:attribute name="header">
      Outcome
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

	<jsp:body>
			<div>
				<div class="span5">
					<h2>Outcome</h2>
				</div>
				<div>
					<h3 class="pull-right">
						<a id="export"
					href="<c:url value="/patient/${patientID}/outcome/create" />"><spring:message code="label.addRecord"/></a>
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

			<!-- Histology list START -->
			<div class="accordion">
				<c:forEach items="${patient.operationList}" var="operation">
					<div>
						<div class="accordion-heading">
					    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${operation.id}">
					    	    <strong><spring:message code="label.operationOf"/>:</strong> ${operation.date}
					    	</a>
						</div>

					    <div id="collapse${operation.id}" class="accordion-body collapse">

					      	<div class="accordion-inner">
						      	<table class="table">
						      			<thead>
						      				<tr class="success">
						      					<td></td>
						      					<td>Seizure outcome</td>
						      					<td>AED</td>
						      					<td>EEG</td>
						      					<td>MRI</td>
						      					<td>Neuropsychologie</td>
						      				</tr>
						      			</thead>
					              		<tbody>
					              				<td></td>
						      					<td>Seizure outcome</td>
						      					<td>AED</td>
						      					<td>EEG</td>
						      					<td>MRI</td>
						      					<td>Neuropsychologie</td>
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


