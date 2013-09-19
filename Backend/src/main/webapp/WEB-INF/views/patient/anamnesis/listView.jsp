<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<td></td>

							<th>Adresa:</th>
							<td></td>

						</tr>
						<tr>
							<th>Telefon:</th>
							<td></td>

							<th>Věk:</th>
							<td></td>

							<th>Pohaví:</th>
							<td></td>
						</tr>

						<tr>
							<th>Email:</th>
							<td></td>

							<th>Věk při začátku epilepsie:</th>
							<td></td>

							<th>Ošetřující lékař:</th>
							<td></td>

						</tr>
					</tbody>
				</table>
				<!-- Anamnesis list START -->
				<table border="2">
					<c:forEach items="${anamnesisList}" var="anamnesis">
						<tr>
							<td>Vysetreni dne: ${anamnesis.date}</td>
							<td><a
						href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/delete"/>">Odstranit</a></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
				<!-- Anamnesis list END -->
	</jsp:body>
</t:menuLVL3>

