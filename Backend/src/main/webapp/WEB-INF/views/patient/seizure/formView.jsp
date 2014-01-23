<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

	<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
   </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.seizures"/>
                </h2>
            </div>
        </div>

        <%@include file="../patientDetails.jsp" %>

        <form:form class="form-horizontal" role="form" method="POST"
                   action="/GENEPI/patient/${patient.id}/seizure/save" commandName="seizure">

            <div class="form-group">
                <label for="date" class="col-xs-3 control-label">
                    <spring:message code="label.dateOfContractAward"/>
                </label>

                <div class="col-xs-8">
                    <form:input path="date" id="date" type="text" class="form-control datepicker-today"
                                autocomplete="off"/>
                    <form:errors path="date" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="seizureFrequency" class="col-xs-3 control-label">
                    <spring:message code="label.seizureFrequency"/>
                </label>

                <div class="col-xs-8">
                    <form:select path="seizureFrequency" id="seizureFrequency" type="text" class="form-control">
                        <form:option value="1">
                            <spring:message code="label.seizureFrequency.1"/>
                        </form:option>
                        <form:option value="2">
                            <spring:message code="label.seizureFrequency.2"/>
                        </form:option>
                        <form:option value="3">
                            <spring:message code="label.seizureFrequency.3"/>
                        </form:option>
                        <form:option value="4">
                            <spring:message code="label.seizureFrequency.4"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label for="secondarilyGeneralizedSeizure" class="col-xs-3 control-label">
                    <spring:message code="label.secondarilyGeneralizedSeizure"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="secondarilyGeneralizedSeizure" id="secondarilyGeneralizedSeizure"/>
                    <form:errors path="secondarilyGeneralizedSeizure" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="statusEpilepticus" class="col-xs-3 control-label">
                    <spring:message code="label.stausEpilepticus"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="statusEpilepticus" id="statusEpilepticus"/>
                    <form:errors path="statusEpilepticus" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="nonepilepticSeizures" class="col-xs-3 control-label">
                    <spring:message code="label.nonepilepticSeizures"/>
                </label>

                <div class="col-xs-8">
                    <form:checkbox path="nonepilepticSeizures" id="nonepilepticSeizures"/>
                    <form:errors path="nonepilepticSeizures" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="seizureOccurrence" class="col-xs-3 control-label">
                    <spring:message code="label.occurrence"/>
                </label>

                <div class="col-xs-8">

                    <div class="radio">
                        <label>
                            <form:radiobutton path="seizureOccurrence" value="1" checked="true"/>
                            <spring:message code="label.seizureOccurence.1"/>
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <form:radiobutton path="seizureOccurrence" value="2"/>
                            <spring:message code="label.seizureOccurence.2"/>
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <form:radiobutton path="seizureOccurrence" value="3"/>
                            <spring:message code="label.seizureOccurence.3"/>
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="comment" class="col-xs-3 control-label">
                    <spring:message code="label.comment"/>
                </label>

                <div class="col-xs-8">
                    <form:textarea path="comment" id="comment" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-8">
                    <button class="btn btn-primary" type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>

    </jsp:body>
</t:menuLVL2.NEW303>


