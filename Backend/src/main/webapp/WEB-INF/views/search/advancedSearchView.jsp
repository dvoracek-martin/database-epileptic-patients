<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.advancedSearch"/>
    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/advanced-search.js" />"></script>
    </jsp:attribute>

<jsp:body>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.advancedSearch"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/advanced-search/load" />">
                <spring:message code="label.load"/>
            </a>
        </h3>
    </div>
</div>

<form:form id="advancedSearchForm"
           class="form-horizontal"
           method="POST"
           action="/GENEPI/advanced-search"
           role="form"
           commandName="advancedSearch">


<%@include file="fieldsets/generalParametersSpecificPersonFieldset.jsp" %>

<%@include file="fieldsets/generalParametersFieldset.jsp" %>

<%@include file="fieldsets/includeParametersFromFieldset.jsp" %>

<%@include file="fieldsets/anamnesisFieldset.jsp" %>



<fieldset id="pharmacotherapyFieldset">
    <legend>
        <spring:message code="label.pharmacotherapy"/>
    </legend>

    <div class="form-group">
        <label for="pharmacotherapyAed" class="col-xs-4 control-label">
            <spring:message code="label.aed"/>
        </label>

        <div class="col-xs-8">
            <form:select path="pharmacotherapyAed" id="pharmacotherapyAed" type="text"
                         class="form-control input-sm" multiple="multiple">
                <form:option value="1">
                    <spring:message code="label.aed.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.aed.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.aed.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.aed.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.aed.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.aed.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.aed.7"/>
                </form:option>
                <form:option value="8">
                    <spring:message code="label.aed.8"/>
                </form:option>
                <form:option value="9">
                    <spring:message code="label.aed.9"/>
                </form:option>
                <form:option value="10">
                    <spring:message code="label.aed.10"/>
                </form:option>
                <form:option value="11">
                    <spring:message code="label.aed.11"/>
                </form:option>
                <form:option value="12">
                    <spring:message code="label.aed.12"/>
                </form:option>
                <form:option value="13">
                    <spring:message code="label.aed.13"/>
                </form:option>
                <form:option value="14">
                    <spring:message code="label.aed.14"/>
                </form:option>
                <form:option value="15">
                    <spring:message code="label.aed.15"/>
                </form:option>
                <form:option value="16">
                    <spring:message code="label.aed.16"/>
                </form:option>
                <form:option value="17">
                    <spring:message code="label.aed.17"/>
                </form:option>
                <form:option value="18">
                    <spring:message code="label.aed.18"/>
                </form:option>
                <form:option value="19">
                    <spring:message code="label.aed.19"/>
                </form:option>
                <form:option value="20">
                    <spring:message code="label.aed.20"/>
                </form:option>
                <form:option value="21">
                    <spring:message code="label.aed.21"/>
                </form:option>
                <form:option value="22">
                    <spring:message code="label.aed.22"/>
                </form:option>
                <form:option value="23">
                    <spring:message code="label.aed.23"/>
                </form:option>
                <form:option value="24">
                    <spring:message code="label.aed.24"/>
                </form:option>
                <form:option value="25">
                    <spring:message code="label.aed.25"/>
                </form:option>
            </form:select>
        </div>
    </div>

</fieldset>

<fieldset id="neurologicalFindingFieldset">
    <legend>
        <spring:message code="label.neurologicalFinding"/>
    </legend>

    <div class="form-group">
        <label for="hemisphereDominance" class="col-xs-4 control-label">
            <spring:message code="label.hemisphereDominance"/>
        </label>

        <div class="col-xs-8">
            <form:select path="neurologicalFindingHemisphereDominance" id="hemisphereDominance" type="text"
                         class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.hemisphereDominance.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.hemisphereDominance.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.hemisphereDominance.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.hemisphereDominance.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.hemisphereDominance.4"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="neurologicalFindingAbnormalNeurologicalFinding"/>
        <jsp:param name="messageCode" value="abnormalNeurologicalFinding"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="neurologicalFindingHemiparesis"/>
        <jsp:param name="messageCode" value="hemiparesis"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="neurologicalFindingVisualFieldDefects"/>
        <jsp:param name="messageCode" value="visualFieldDefect"/>
    </jsp:include>
</fieldset>

<fieldset id="neuropsychologyFieldset">
    <legend>
        <spring:message code="label.neuropsychology"/>
    </legend>

</fieldset>

<fieldset id="diagnosticTestScalpEegFieldset">
    <legend>
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </legend>

    <div class="form-group">
        <label for="basicEegActivity" class="col-xs-4 control-label">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestScalpEegBasicEegActivity" id="basicEegActivity" type="text"
                         class="input-sm form-control">
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
        <label for="eegSlow" class="col-xs-4 control-label">
            <spring:message code="label.eegSlow"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestScalpEegEegSlow" id="eegSlow" type="text" class="input-sm form-control">
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
        <label for="interictalEegSpikes" class="col-xs-4 control-label">
            <spring:message code="label.interictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestScalpEegInterictalEegSpikes" id="interictalEegSpikes" type="text"
                         class="input-sm form-control">
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

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestScalpEegEegStatusEpilepticus"/>
        <jsp:param name="messageCode" value="statusEpilepticus"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestScalpEegSecondarySidedSynchrony"/>
        <jsp:param name="messageCode" value="secondarySidedSynchrony"/>
    </jsp:include>

    <div class="form-group">
        <label for="ictalEegPatterns" class="col-xs-4 control-label">
            <spring:message code="label.ictalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestScalpEegIctalEegPatterns" id="ictalEegPatterns" type="text"
                         class="input-sm form-control">
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

</fieldset>

<fieldset id="diagnosticTestMriFieldset">
    <legend>
        <spring:message code="label.diagnosticTestMri"/>
    </legend>

    <jsp:include page="../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mriFinding"/>
        <jsp:param name="propertyName" value="diagnosticTestMriMriFinding"/>
    </jsp:include>

    <jsp:include page="../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="fdgPet"/>
        <jsp:param name="propertyName" value="diagnosticTestMriFdgPet"/>
    </jsp:include>

    <jsp:include page="../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="interictalSpect"/>
        <jsp:param name="propertyName" value="diagnosticTestMriInterictalSpect"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriSiscom"/>
        <jsp:param name="messageCode" value="siscom"/>
    </jsp:include>

    <div class="form-group">
        <label for="mrsProtocol" class="col-xs-4 control-label">
            <spring:message code="label.mrsProtocol"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestMriMrsProtocol" id="mrsProtocol" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.mrsProtocol.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.mrsProtocol.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.mrsProtocol.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.mrsProtocol.3"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mrsFinding"/>
        <jsp:param name="propertyName" value="diagnosticTestMriMrsFinding"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriDti"/>
        <jsp:param name="messageCode" value="dti"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriFmri"/>
        <jsp:param name="messageCode" value="fmri"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriWada"/>
        <jsp:param name="messageCode" value="wada"/>
    </jsp:include>
</fieldset>

<div class="form-group">
    <div class="col-xs-offset-4 col-xs-8">
        <button id="searchButton" class="btn btn-primary" type="submit">
            <spring:message code="label.search"/>
        </button>
    </div>
</div>


<fieldset>
    <legend>
        <spring:message code="label.saveParameters"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="saveName">
            <spring:message code="label.name"/>
        </label>

        <div class="col-xs-6">
            <form:input id="saveName"
                        class="form-control input-sm"
                        type="text"
                        path="name"/>

            <form:errors path="name"
                         cssClass="error">
            </form:errors>
        </div>

        <div class="col-xs-2">
            <button id="saveButton" class="btn btn-primary">
                <spring:message code="label.save"/>
            </button>
        </div>
    </div>
</fieldset>

</form:form>

</jsp:body>
</t:menuLVL1>