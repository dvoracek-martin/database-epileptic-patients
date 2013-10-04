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

	<jsp:body>
		<div>
					<div class="span5">
						<h2>Přehled pacienta</h2>
					</div>
					<div>
						<a href="<c:url value="/patient/${patientID}/anamnesis/create" />">Přidat
							záznam</a>
					</div>
				</div>
				<table style="border: 1px solid black">
					<tbody>
						<tr>
							<th>Číslo pacienta: ${patient.id}</th>
							<td></td>

							<th>Rodné číslo:</th>
							<td>${patient.nin}</td>

							<th>Adresa:</th>
							<td>${patient.contact.addressStreet}</td>

						</tr>
						<tr>
							<th>Telefon:</th>
							<td>${patient.contact.phoneNumber}</td>

							<th>Věk:</th>
							<td></td>

							<th>Pohaví:</th>
							<td>${patient.gender}</td>
						</tr>

						<tr>
							<th>Email:</th>
							<td>${patient.contact.email}</td>

							<th>Věk při začátku epilepsie:</th>
							<td></td>

							<th>Ošetřující lékař:</th>
							<td></td>

						</tr>
					</tbody>
				</table>
				<!-- Anamnesis list START -->
				<table border="2">
					<c:forEach items="${patient.anamnesisList}" var="anamnesis">
						<tr>
							<td>Vysetreni dne: ${anamnesis.date}</td>
							<td><a
						href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/delete"/>">Odstranit</a></td>
						</tr>
						<tr>
							<td><spring:message code="label.epilepsyInFamily" /></td>
							<td>${anamnesis.epilepsyInFamily}</td>
						</tr>
						<tr>
							<td><spring:message code="label.prenatalRisk" /></td>
							<td>${anamnesis.prenatalRisk}</td>
						</tr>
						<tr>
							<td><spring:message code="label.fibrilConvulsions" /></td>
							<td>${anamnesis.fibrilConvulsions}</td>
						</tr>
						<tr>
							<td><spring:message code="label.inflammationCNS" /></td>
							<td>${anamnesis.inflammationCns}</td>
						</tr>
						<tr>
							<td><spring:message code="label.injuryCNS" /></td>
							<td>${anamnesis.injuryCns}</td>
						</tr>
						<tr>
							<td><spring:message code="label.operationCNS" /></td>
							<td>${anamnesis.operationCns}</td>
						</tr>
						<tr>
							<td><spring:message code="label.earlyPMDRetardation" /></td>
							<td>${anamnesis.earlyPmdRetardation}</td>
						</tr>
						<tr>
							<td><spring:message code="label.beginningEpilepsy" /></td>
							<td>${anamnesis.beginningEpilepsy}</td>
						</tr>
						<tr>
							<td><spring:message code="label.firstFever" /></td>
							<td>${anamnesis.firstFever}</td>
						</tr>
						<tr>
							<td><spring:message code="label.infantileSpasm" /></td>
							<td>${anamnesis.infantileSpasm}</td>
						</tr>
						<tr>
							<td><spring:message code="label.epilepticSyndrome" /></td>
							<td>${anamnesis.specificSyndromeIdcom}</td>
						</tr>
						<tr>
							<td><spring:message code="label.nonCNSComorbidity" /></td>
							<td>${anamnesis.nonCnsComorbidity}</td>
						</tr>
					</c:forEach>
				</table>
				<!-- Anamnesis list END -->
	</jsp:body>
</t:menuLVL3>


