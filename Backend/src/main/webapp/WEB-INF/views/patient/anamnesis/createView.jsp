<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2.NEW303>
	<jsp:attribute name="head">
      <link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
   </jsp:attribute>
	<jsp:body>

    <div class="row">
        <div class="col-xs-12">
            <h2>
                <spring:message code="label.anamnesis"/>
            </h2>
        </div>
    </div>


    <%@include file="../patientDetails.jsp" %>


			<!-- form for adding new record -->
			<%-- mapping resource in action with c:url caused errors --%>
			<form:form class="form-horizontal" role="form" method="POST"
						action="/GENEPI/patient/${patient.id}/anamnesis/create" commandName="anamnesis">

				<div class="form-group">
    				<label for="date" class="col-sm-2 control-label" ><spring:message code="label.dateOfContractAward"/></label>
    				<div class="col-sm-10">
    					<form:input path="date" id="date" type="text" class="form-control datepicker" />
						<form:errors path="date" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="epilepsyInFamily"><strong><spring:message code="label.epilepsyInFamily"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="epilepsyInFamily" input="epilepsyInFamily" class="input-block-level" />
						<form:errors path="epilepsyInFamily" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="prenatalRisk"><strong><spring:message code="label.prenatalRisk"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="prenatalRisk" input="prenatalRisk" class="input-block-level" />
						<form:errors path="prenatalRisk" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="fibrilConvulsions"><strong><spring:message code="label.fibrilConvulsions"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="fibrilConvulsions" input="fibrilConvulsions" class="input-block-level" />
						<form:errors path="fibrilConvulsions" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="inflammationCns"><strong><spring:message code="label.inflammationCNS"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="inflammationCns" input="inflammationCns" class="input-block-level" />
						<form:errors path="inflammationCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="injuryCns"><strong><spring:message code="label.injuryCNS"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="injuryCns" input="injuryCns" class="input-block-level" />
						<form:errors path="injuryCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="operationCns"><strong><spring:message code="label.operationCNS"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="operationCns" input="operationCns" class="input-block-level" />
						<form:errors path="operationCns" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="earlyPmdRetardation"><strong><spring:message code="label.earlyPMDRetardation"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="earlyPmdRetardation" input="earlyPmdRetardation" class="input-block-level" />
						<form:errors path="earlyPmdRetardation" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="beginningEpilepsy"><strong><spring:message code="label.beginningEpilepsy"/></strong></label>
    				<div class="controls">
    					<form:input path="beginningEpilepsy" id="beginningEpilepsy" type="text" class="input-medium datepicker" />
						<form:errors path="beginningEpilepsy" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="firstFever"><strong><spring:message code="label.firstFever"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="firstFever" input="firstFever" class="input-block-level" />
						<form:errors path="firstFever" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="infantileSpasm"><strong><spring:message code="label.infantileSpasm"/></strong></label>
    				<div class="controls">
    					<form:checkbox path="infantileSpasm" input="infantileSpasm" class="input-block-level" />
						<form:errors path="infantileSpasm" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="specificSyndrome"><strong><spring:message code="label.epilepticSyndrome"/></strong></label>
    				<div class="controls">
    					<form:select path="specificSyndrome" id="specificSyndrome" type="text" class="input-large">
							<form:option value="1">
								<spring:message code="label.extratemporalFocalEpilepsy"/>
							</form:option>
							<form:option value="2">
								<spring:message code="label.hemisphericSymptomaticEpilepsy"/>
							</form:option>
							<form:option value="3">
								<spring:message code="label.mesiotemporalEpilepsy"/>
							</form:option>
							<form:option value="4">
								<spring:message code="label.multifocalEpilepsy"/>
							</form:option>
							<form:option value="5">
								<spring:message code="label.temporalEpilepsy"/>
							</form:option>
						</form:select>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="nonCnsComorbidity"><strong><spring:message code="label.nonCNSComorbidity"/></strong></label>
    				<div class="controls">
    					<form:input path="nonCnsComorbidity" id="nonCnsComorbidity" type="text" class="input-medium"
    					value="porod per SC. pro gestrózu zjištěnou až během porodu" />
						<form:errors path="nonCnsComorbidity" cssClass="error">
						</form:errors>
    				</div>
  				</div>

  				<div class="control-group">
    				<label class="control-label" for="comment"><strong><spring:message code="label.comment"/></strong></label>
    				<div class="controls">
    					<form:textarea path="comment" id="comment" />
    				</div>
  				</div>

  				<div class="control-group">
			    	<div class="controls">
			     		<button class="btn btn-primary" type="submit"><spring:message code="label.add"/></button>
			    	</div>
			  	</div>
			</form:form>
	</jsp:body>
</t:menuLVL2.NEW303>


