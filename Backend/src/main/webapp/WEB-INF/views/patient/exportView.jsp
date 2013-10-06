<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:attribute name="script">
    <script>
					$(function() {
						$('a[data-auto-download]').each(function() {
							var $this = $(this);
							setTimeout(function() {
								window.location = $this.attr('href');
							}, 2000);
						});
					});
				</script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
					<script>
						$(function() {
							$('#sortable1, #sortable2').sortable();
							$('#sortable3').sortable({
								items : ':not(.disabled)'
							});
							$('#sortable-with-handles').sortable({
								handle : '.handle'
							});
							$('#sortable4, #sortable5').sortable({
								connectWith : '.connected'
							});
						});
					</script>
	</jsp:attribute>

	<jsp:body>
		<style>
#demos section {
	overflow: hidden;
}

.sortable {
	width: 310px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.sortable.grid {
	overflow: hidden;
}

.sortable li {
	list-style: none;
	border: 1px solid #CCC;
	background: #F6F6F6;
	color: #1C94C4;
	margin: 5px;
	padding: 5px;
	height: 22px;
}

.sortable.grid li {
	line-height: 80px;
	float: left;
	width: 80px;
	height: 80px;
	text-align: center;
}

.handle {
	cursor: move;
}

.sortable.connected {
	width: 200px;
	min-height: 100px;
	float: left;
}

li.disabled {
	opacity: 0.5;
}

li.highlight {
	background: #FEE25F;
}

li.sortable-placeholder {
	border: 1px dashed #CCC;
	background: none;
}
</style>
			<div>
					<div>
						<h2>
							<spring:message code="label.exportPatient" /> <a
						href="<c:url value="/patient/${patient.id}/overview" />"
						style="text-decoration: none">${patient.contact.firstName} ${patient.contact.lastName}</a>
						</h2>
					</div>
					
			<div class="span3">
				<label>Dostupné karty</label>
				<ul id="sortable4" class="connected sortable list"
					style="border-style: solid; border-width: 5px; border-color: CornflowerBlue;">
			
					<c:forEach var="possibleCard" items="${listOfPossibleCards}">
						<li draggable="true">${possibleCard}
						<input class="btn" type="hidden" name="cards"
							value="${possibleCard}">
						</li>			
					</c:forEach>
				</ul>	
			</div>
			
			<form:form method="POST" modelAttribute="patient"
				class="form-horizontal" action="/GENEPI/patient/export"
				commandName="patient">
	
			<div class="span3">
				<label>Vybrané karty</label>
				<ul id="sortable5" class="connected sortable list"
						style="border-style: solid; border-width: 5px; border-color: CornflowerBlue;">		
					
				</ul>
			</div>
			
						<div class="control-group span6">
						    <label class="control-label" for="pdfFormat">Formát</label>
						    <div class="controls">
						    	<input type="radio" id="pdfFormat" name="exportType"
							value="pdf" checked> pdf
								<input type="radio" id="xlsxFormat" name="exportType"
							value="xlsx"> xlsx
								<input type="radio" id="docxormat" name="exportType"
							value="docx"> docx
						    </div>
						</div>
						
						<div class="control-group span6">
						    <div class="controls">
						      	<button type="submit" class="btn btn-primary">
							<spring:message code="label.export" />
						</button>	
						    </div>
						</div>
											 
						<form:hidden path="id" id="id" />
						
					</form:form>

					<c:if test="${isReady==true}">
					
					<div style="display: none">
						<a data-auto-download
						href="/GENEPI/resources/downloads/patient${patient.id}.${exportType}"></a>
					</div>
					</c:if>
					
				</div>
	</jsp:body>
</t:menuLVL3>



