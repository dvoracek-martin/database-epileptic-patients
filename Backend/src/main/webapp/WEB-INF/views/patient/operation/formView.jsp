<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
        <script src="<c:url value="/resources/custom/js/customjs.js" />"></script>
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-12">
        <h2>
            <spring:message code="label.operation"/>
        </h2>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<%-- mapping resource in action with c:url caused errors --%>
<form:form class="form-horizontal" role="form" method="POST"
           action="/GENEPI/patient/${patient.id}/operation/save" commandName="operation">

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
    <label for="dateOfOperation" class="col-xs-3 control-label">
        <spring:message code="label.dateOfOperation"/>
    </label>

    <div class="col-xs-8">
        <form:input path="dateOfOperation" id="dateOfOperation" type="text"
                    class="form-control datepicker"/>
        <form:errors path="dateOfOperation" cssClass="error">
        </form:errors>
    </div>
</div>


<div id="section-done" class="section-hide">
<div class="form-group">
    <label for="operationType" class="col-xs-3 control-label">
        <spring:message code="label.typeOperations"/>
    </label>

    <div class="col-xs-8">
        <form:select path="typeOperations" id="operationType" type="text" class="form-control">
            <form:option value="0">
                <spring:message code="label.operationType.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.operationType.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.operationType.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.operationType.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.operationType.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.operationType.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.operationType.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.operationType.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.operationType.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.operationType.9"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="operationRange" class="col-xs-3 control-label">
        <spring:message code="label.rangeOperations"/>
    </label>

    <div class="col-xs-8">
        <form:select path="rangeOperations" id="operationRange" type="text" class="form-control">
            <form:option value="0">
                <spring:message code="label.operationRange.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.operationRange.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.operationRange.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.operationRange.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.operationRange.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.operationRange.5"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="localizationOperation" class="col-xs-3 control-label">
        <spring:message code="label.localizationOperations"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="localizationOperation" id="localizationOperation"
                       class="form-control"/>
    </div>
</div>


<div class="form-group">
    <label for="mst" class="col-xs-3 control-label">
        <spring:message code="label.mst"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="mst" id="mst"/>
        <form:errors path="mst" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="colostomy" class="col-xs-3 control-label">
        <spring:message code="label.colostomy"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="colostomy" id="colostomy"/>
        <form:errors path="colostomy" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="vns" class="col-xs-3 control-label">
        <spring:message code="label.VNS"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="vns" id="vns"/>
        <form:errors path="vns" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="vnsImplantationDate" class="col-xs-3 control-label">
        <spring:message code="label.VNSImplantationDate"/>
    </label>

    <div class="col-xs-8">
        <form:input path="vnsImplantationDate" id="vnsImplantationDate" type="text"
                    class="form-control datepicker"/>
        <form:errors path="vnsImplantationDate" cssClass="error">
        </form:errors>
    </div>
</div>
<div class="form-group">
    <label for="operationDetails" class="col-xs-3 control-label">
        <spring:message code="label.operationDetails"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="operationDetails" id="operationDetails" class="form-control"/>
    </div>
</div>

<div class="form-group">
    <label for="completeResection" class="col-xs-3 control-label">
        <spring:message code="label.completeResection"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="completeResection" id="completeResection"/>
        <form:errors path="completeResection" cssClass="error">
        </form:errors>
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