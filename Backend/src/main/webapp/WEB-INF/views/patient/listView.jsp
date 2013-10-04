<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      <spring:message code="label.cardFile" />
    </jsp:attribute>
	<jsp:attribute name="header">
     <spring:message code="label.cardFile" />
    </jsp:attribute>

	<jsp:body>
				<div>
					<div>
						<h2>
							<spring:message code="label.cardFile" />
						</h2>
					</div>
					<div class="span5">
						<form class="form-search">
  								<div class="input-append">
    								<input type="text" class="span2 search-query">
    								<button type="submit" class="btn">Search</button>
  								</div>
  						</form>
					</div>
					<div>
						<h3>
							<a href="<c:url value="/patient/create" />"
						style="text-decoration: none"><spring:message
							code="label.addpatient" /></a>
						</h3>
					</div>
						

				</div>


				<c:forEach items="${patientList}" var="patient">


					<div class="navbar">
						<div class="navbar-inner">
							<a class="brand"
						href="<c:url value="/patient/${patient.id}/overview" />">${patient.contact.firstName}
								${patient.contact.lastName}</a>
							<ul class="nav">
								<li class="divider-vertical"><a
							href="<c:url value="/patient/${patient.id}/anamnesis/list" />"><spring:message
									code="label.anamnesis" /></a></li>
								<li class="divider-vertical"><a id="export"
							href="<c:url value="/patient/${patient.id}/export" />" onclick="chooseFormat()"><spring:message
									code="label.export" /></a></li>
								<li class="divider-vertical"><a
							href="<c:url value="/patient/${patient.id}/edit" />"><spring:message
									code="label.edit" /></a></li>
								<li><a href="#patientDeleteConfirm${patient.id}" role="button" class="btn"
							data-toggle="modal"><spring:message
									code="label.deletePatient" /></a></li>
							</ul>
						</div>
					</div>
					<!-- Modal window>: user delete confirmation -->
					<div id="patientDeleteConfirm${patient.id}" class="modal hide fade" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
							<h3 id="myModalLabel">Patient deletion</h3>
						</div>
						<div class="modal-body">
							<p>Do you really want to delete this patient?</p>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">NO</button>
							<a class="btn btn-primary" href="<c:url value="/patient/${patient.id}/delete"/>">YES</a>

						</div>
					</div>
					<script>
						var patientID = ${patient.id};
						$('#patientDeleteConfirm'+patientID).modal({
						show: false})
					</script>
				</c:forEach>
	</jsp:body>
</t:menuLVL2>

<script>
var linkDelete = document.getElementById('delete').href;
function chooseFormat()
{
var format=prompt("Zvolte souborový formát, do kterého chcete exportovat:","pdf/csv");

while (format!="pdf" && format!="csv" && format!=null)
  {
	format=prompt("Takovýto formát není podporován. Prosím, zvolte podporovaný formát (pdf či csv).","pdf/csv");
  }
  if (format==null)
  	document.getElementById('export').href="#";
  else	
	  document.getElementById('export').href;
}

function deletePatient() {
	var answer = confirm("Opravdu chcete smazat pacienta?");
	if (answer==false)
		document.getElementById('delete').href = "#";
	else
		document.getElementById('delete').href = linkDelete;
}
</script>
