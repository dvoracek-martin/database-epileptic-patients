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
		<script src="<c:url value="/resources/custom/js/datepicker.NEW303.js" />"></script>
        <script src="<c:url value="/resources/custom/js/cardForm/customjs.js" />"></script>
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-12">
        <h2>
            <spring:message code="label.diagnosticTestsMri"/>
        </h2>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<%-- mapping resource in action with c:url caused errors --%>
<form:form class="form-horizontal" role="form" method="POST"
           action="/GENEPI/patient/${patient.id}/diagnostic-test-mri/save" commandName="diagnosticTestMri">

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
        <spring:message code="label.diagnosticTestMri"/>
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

    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mriFinding"/>
        <jsp:param name="propertyName" value="mriFinding"/>
    </jsp:include>

    <div class="form-group">
        <label for="mriDescription" class="col-xs-3 control-label">
            <spring:message code="label.descriptionMri"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="mriDescription" id="mriDescription" class="form-control"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="fdgPet"/>
        <jsp:param name="propertyName" value="fdgPet"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionPetHypometabolism" class="col-xs-3 control-label">
            <spring:message code="label.fdgPet"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionPetHypometabolism" id="descriptionPetHypometabolism" class="form-control"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="interictalSpect"/>
        <jsp:param name="propertyName" value="interictalSpect"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionSpectHypoperfuse" class="col-xs-3 control-label">
            <spring:message code="label.descriptionSpectHypoperfuse"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionSpectHypoperfuse" id="descriptionSpectHypoperfuse" class="form-control"/>
        </div>
    </div>


    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="ictalSpect"/>
        <jsp:param name="propertyName" value="ictalSpect"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionSpectHypoperfuse" class="col-xs-3 control-label">
            <spring:message code="label.descriptionSpectHyperperfuse"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionSpectHyperperfuse" id="descriptionSpectHyperperfuse" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="siscom" class="col-xs-3 control-label">
            <spring:message code="label.siscom"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="siscom" id="siscom"/>
            <form:errors path="siscom" cssClass="error">
            </form:errors>
        </div>
    </div>


    <div class="form-group">
        <label for="mrsProtocol" class="col-xs-3 control-label">
            <spring:message code="label.mrsProtocol"/>
        </label>

        <div class="col-xs-8">
            <form:select path="mrsProtocol" id="mrsProtocol" type="text" class="form-control">
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

    <jsp:include page="resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mrsFinding"/>
        <jsp:param name="propertyName" value="mrsFinding"/>
    </jsp:include>

    <div class="form-group">
        <label for="descriptionMrsAbnormality" class="col-xs-3 control-label">
            <spring:message code="label.descriptionMrsAbnormality"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionMrsAbnormality" id="descriptionMrsAbnormality" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="fmri" class="col-xs-3 control-label">
            <spring:message code="label.fmri"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="fmri" id="fmri"/>
            <form:errors path="fmri" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="detailsFmri" class="col-xs-3 control-label">
            <spring:message code="label.fmriDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsFmri" id="detailsFmri" class="form-control"/>
        </div>
    </div>


    <div class="form-group">
        <label for="fmri" class="col-xs-3 control-label">pro
            <spring:message code="label.dti"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="dti" id="dti"/>
            <form:errors path="dti" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="detailsDtiStudy" class="col-xs-3 control-label">
            <spring:message code="label.dtiStudyDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsDtiStudy" id="detailsDtiStudy" class="form-control"/>
        </div>
    </div>


    <div class="form-group">
        <label for="wada" class="col-xs-3 control-label">
            <spring:message code="label.dti"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="wada" id="wada"/>
            <form:errors path="wada" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="detailsWada" class="col-xs-3 control-label">
            <spring:message code="label.wadaDetails"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="detailsWada" id="detailsWada" class="form-control"/>
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