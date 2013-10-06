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
  			$('a[data-auto-download]').each(function(){
   			 	var $this = $(this);
    		  	setTimeout(function() {
      			window.location = $this.attr('href');
    									}, 2000);
  			});
		});
	</script>
	</jsp:attribute>

	<jsp:body>
			<div>
					<div>
						<h2>
							<spring:message code="label.exportPatient" /> <a href="<c:url value="/patient/${patient.id}/overview" />"
						style="text-decoration: none">${patient.contact.firstName} ${patient.contact.lastName}</a>
						</h2>
					</div>
					
					<form:form method="POST" modelAttribute="patient" class="form-horizontal"
								action="/GENEPI/patient/export" commandName="patient">
						
						<div class="control-group">
						    <label class="control-label" for="pdfFormat">Formát</label>
						    <div class="controls">
						    	<input type="radio" id="pdfFormat" name="exportType" value="pdf" checked> pdf
								<input type="radio" id="xlsxFormat" name="exportType" value="xlsx"> xlsx
								<input type="radio" id="docxormat" name="exportType" value="docx"> docx
						    </div>
						</div>
						
						<div class="control-group">
						    <div class="controls">
						      	<button type="submit" class="btn btn-primary"><spring:message code="label.export"/></button>	
						    </div>
						</div>
											 
						<form:hidden path="id" id="id" />
						
					</form:form>

					<c:if test="${isReady==true}">
					${exportType}
					<div style="display: none">
						<a data-auto-download href="/GENEPI/resources/downloads/patient${patient.id}.${exportType}"></a>
					</div>
					</c:if>
					
				</div>
	</jsp:body>
</t:menuLVL3>



