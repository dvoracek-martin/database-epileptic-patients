<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="title">
      Advanced Search
    </jsp:attribute>
	<jsp:attribute name="header">
      
    </jsp:attribute>

	<jsp:body>
			<form:form class="form-horizontal" method="POST"
			action="/GENEPI/advanced-search" commandName="advancedSearch">

				<div class="control-group">
    				<label class="control-label" for="patientFirstname"><strong><spring:message
							code="label.firstname" /></strong></label>
    				<div class="controls">
    					<form:input path="patientFirstname" type="text"
						class="input-medium" />
						<form:errors path="patientFirstname" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="patientLastname"><strong><spring:message
							code="label.firstname" />patientLastname</strong></label>
    				<div class="controls">
    					<form:input path="patientLastname" type="text"
						class="input-medium" />
						<form:errors path="patientLastname" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="patientNin"><strong><spring:message
							code="label.firstname" />patientNin</strong></label>
    				<div class="controls">
    					<form:input path="patientNin" type="text" class="input-medium" />
						<form:errors path="patientNin" cssClass="error">
						</form:errors>
    				</div>
  				</div>  
  				
  				<div class="control-group">
    				<label class="control-label" for="patientTown"><strong><spring:message
							code="label.firstname" />patientTown</strong></label>
    				<div class="controls">
    					<form:input path="patientTown" type="text" class="input-medium" />
						<form:errors path="patientTown" cssClass="error">
						</form:errors>
    				</div>
  				</div>  		
  				
  				<div class="control-group">
    				<label class="control-label" for="patientCountry"><strong><spring:message
							code="label.firstname" />patientCountry</strong></label>
    				<div class="controls">
    					<form:input path="patientCountry" type="text"
						class="input-medium" />
						<form:errors path="patientCountry" cssClass="error">
						</form:errors>
    				</div>
  				</div>  			
  				
  				<div class="control-group">
    				<label class="control-label" for="patientGender"><strong><spring:message
							code="label.firstname" />patientGender</strong></label>
    				<div class="controls">
    					  	<form:radiobutton path="patientGender" value="M" />Male 
							<form:radiobutton path="patientGender" value="F" />Female
							<form:radiobutton path="patientGender" value="N" />Nerozlisovat
    				</div>
  				</div>    											  				  	
  				
				<div class="control-group">
    				<label class="control-label" for="patientAgeFilter"><strong><spring:message
							code="label.firstname" />patientAgeFilter</strong></label>
    				<div class="controls">
    					<form:select path="patientAgeFilter" id="patientAgeFilter"
						type="text" class="input-large">
							<form:option value="=">=</form:option>
							<form:option value=">">
							>
							</form:option>
							<form:option value="<">
								<
							</form:option>
							<form:option value=">=">
								>=
							</form:option>	
							<form:option value="<=">
								<=
							</form:option>
						</form:select>
    				</div>
  				</div>  				


  				<div class="control-group">
    				<label class="control-label" for="patientAge"><strong><spring:message
							code="label.firstname" />patientAge</strong></label>
    				<div class="controls">
    					<form:input path="patientAge" type="text" class="input-medium" />
						<form:errors path="patientAge" cssClass="error">
						</form:errors>
    				</div>
  				</div>
  				
  					<div class="control-group">
			    	<div class="controls">
			     		<button class="btn btn-primary" type="submit">
						<spring:message code="label.add" />
					</button>					
			    	</div>
			</div>
  				
		</form:form>
</jsp:body>
</t:menuLVL2>