<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.js" />"></script>
        <script src="<c:url value="/resources/custom/js/cardForm/customjs.js" />"></script>
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-12">
        <h2>
            <spring:message code="label.diagnosticTestScalpEeg"/>
        </h2>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<%-- mapping resource in action with c:url caused errors --%>
<form:form class="form-horizontal" role="form" method="POST"
           action="/GENEPI/patient/${patient.id}/diagnostic-test-scalp-eeg/save" commandName="diagnosticTestScalpEeg">

<div class="form-group">
    <label for="date" class="col-xs-3 control-label">
        <spring:message code="label.dateExamination"/>
    </label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"
                    autocomplete="off"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="done" class="col-xs-3 control-label">
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </label>

    <div class="col-xs-8">
        <form:select path="done" id="done" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done">

    <div class="form-group">
        <label for="basicEegActivity" class="col-xs-3 control-label">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select path="basicEegActivity" id="basicEegActivity" type="text" class="form-control">
                <form:option value="0">
                    Zvolte
                </form:option>
                <form:option value="1">
                    <spring:message code="label.basicEegActivity.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.basicEegActivity.2"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="eegSlow" class="col-xs-3 control-label">
            <spring:message code="label.eegSlow"/>
        </label>

        <div class="col-xs-8">
            <form:select path="eegSlow" id="eegSlow" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.eegSlow.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.eegSlow.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.eegSlow.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.eegSlow.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.eegSlow.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.eegSlow.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="interictalEegSpikes" class="col-xs-3 control-label">
            <spring:message code="label.interictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:select path="interictalEegSpikes" id="interictalEegSpikes" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.interictalEegSpikes.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.interictalEegSpikes.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.interictalEegSpikes.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.interictalEegSpikes.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.interictalEegSpikes.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.interictalEegSpikes.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.interictalEegSpikes.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="localizationInterictalEegSpikes" class="col-xs-3 control-label">
            <spring:message code="label.localizationInterictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationInterictalEegSpikes" id="localizationInterictalEegSpikes"
                           class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="eegStatusEpilepticus" class="col-xs-3 control-label">
            <spring:message code="label.EegStatusEpilepticus"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="eegStatusEpilepticus" id="eegStatusEpilepticus"/>
            <form:errors path="eegStatusEpilepticus" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="secondarySidedSynchrony" class="col-xs-3 control-label">
            <spring:message code="label.secondarySidedSynchrony"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="secondarySidedSynchrony" id="secondarySidedSynchrony"/>
            <form:errors path="secondarySidedSynchrony" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="ictalEegPatterns" class="col-xs-3 control-label">
            <spring:message code="label.ictalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:select path="ictalEegPatterns" id="ictalEegPatterns" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.ictalEegPatterns.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.ictalEegPatterns.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.ictalEegPatterns.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.ictalEegPatterns.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.ictalEegPatterns.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.ictalEegPatterns.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.ictalEegPatterns.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="localizationIctalEegPattern" class="col-xs-3 control-label">
            <spring:message code="label.localizationIctalEegPattern"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationIctalEegPattern" id="localizationIctalEegPattern"
                           class="form-control"/>
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
        <label for="descriptionVideoEeg" class="col-xs-3 control-label">
            <spring:message code="label.descriptionVideoEeg"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionVideoEeg" id="descriptionVideoEeg" class="form-control"/>
        </div>
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
</t:menuLVL2>