<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="head">
     <link href="<c:url value="/resources/css/validation.css"/>"
			rel="stylesheet">
		<link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.edituser" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.edituser" />
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
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
		<div class="span9">	
			<div class="span3">
				<label>Dostupné role</label>
				<ul id="possibleRoles" class="connected sortable list" style="border-style:solid;
							border-width:5px; border-color:CornflowerBlue;">
			
					<c:forEach var="role" items="${listOfPossibleRoles}">
						<li draggable="true">${role.authority}</li>			
					</c:forEach>
				</ul>	
			</div>
			<div class="span3">
				<label>Moje role</label>
				<ul id="selectedRoles" class="connected sortable list" style="border-style:solid;
						border-width:5px; border-color:CornflowerBlue;">			
				</ul>
			</div>
			<div class="span3">
			<!--  tady pridat submitovaci button, kterej zavola nejakou funkci -->
				<form:form method="POST" modelAttribute="listOfSelectedRoles"
					action="/GENEPI/user/edit-roles" commandName="listOfSelectedRoles">
					<input type="submit" value="uložit" onclick="createSetOfRoles();" class="btn btn-primary">
				</form:form>
			</div>
		</div>
		<script>
		
		
		function createSetOfRoles(){
			
		}
		
		</script>

	</jsp:body>
</t:menuLVL2>
