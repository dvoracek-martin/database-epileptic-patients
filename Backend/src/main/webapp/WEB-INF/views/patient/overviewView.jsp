<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

 	<jsp:attribute name="script">
    <script src="<c:url value="/resources/custom/js/exportSubmit.js"/>"></script>
    </jsp:attribute>

<jsp:body>
<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DOCTOR,ROLE_SUPER_DOCTOR" var="isAuthorized"/>
<div class="row">
    <div class="col-xs-3 col-sm-6 col-lg-3">
        <h2>
            <spring:message code="label.patient"/>
        </h2>
    </div>
    <div class="col-xs-3 col-sm-6 col-lg-3">

        <form id="patientIds" action="<c:url value="/export" />" method="POST">
            <input type="hidden" name="patientId" value="${patient.id}">
            <input name="source" type="hidden" value="overview">
        </form>

        <h3 class="pull-right">
            <a id="postExport" class="cursor-pointer">
                <spring:message code="label.exportPatient"/>
            </a>
        </h3>
    </div>

    <div class="clearfix hidden-lg hidden-xs"></div>
    <div class="col-xs-2 col-sm-4 col-lg-2">
        <sec:authorize ifAnyGranted="ROLE_SUPER_DOCTOR,ROLE_ADMIN">
            <h3 class="pull-right">
                <a id="verify" href="<c:url value="/patient/${patient.id}/verify" />">
                    <spring:message code="label.verify"/>
                </a>
            </h3>
        </sec:authorize>
    </div>
    <div class="col-xs-2 col-sm-4 col-lg-2">
        <sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN">
            <h3 class="pull-right">
                <a id="edit" href="<c:url value="/patient/${patient.id}/edit" />">
                    <spring:message code="label.edit"/>
                </a>
            </h3>
        </sec:authorize>
    </div>
    <div class="col-xs-2 col-sm-4 col-lg-2 ">
        <sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN">
            <h3 class="pull-right">
                <a id="hide" href="<c:url value="/patient/${patient.id}/hide" />">
                    <spring:message code="label.delete"/>
                </a>
            </h3>
        </sec:authorize>
    </div>
</div>

<%@include file="patientDetails.jsp" %>

<%-- Anamnesis --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.anamnesis"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${empty anamnesisDisplayVo || isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty anamnesisDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-anamnesis-${anamnesisDisplayVo.id}">
                        Zadano dne: ${anamnesisDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/anamnesis/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="anamnesis/anamnesisTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Seizure --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.seizures"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/seizure/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty seizureDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-seizure-${seizureDisplayVo.id}">
                        Zadano dne: ${seizureDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/seizure/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="seizure/seizureTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Pharmacotherapy --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.pharmacotherapy"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty pharmacotherapyDisplayVoList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">

                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/pharmacotherapy/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>
        <div class="list-striped">

            <table class="record-head table">
                <tr>
                    <th class="col-xs-2">Datum
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.aed"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.efficiency"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.duringSurgery"/>
                    </th>
                    <th class="col-xs-4"></th>
                </tr>
            </table>
            <c:forEach items="${pharmacotherapyDisplayVoList}" var="pharmacotherapyDisplayVo">
                <div>

                    <%@ include file="pharmacotherapy/pharmacotherapyTableView.jsp" %>

                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<%-- Neurological Finding --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.neurologicalFinding"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/neurological-finding/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty neurologicalFindingDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-neurological-finding-${neurologicalFindingDisplayVo.id}">
                        Zadano dne: ${neurologicalFindingDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/neurological-finding/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="neurologicalFinding/neurologicalFindingTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Neuropsychology --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.neuropsychology"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/neuropsychology/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty neuropsychologyDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-neuropsychology-${neuropsychologyDisplayVo.id}">
                        Zadano dne: ${neuropsychologyDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="neuropsychology/neuropsychologyTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>


<%-- Diagnostic test scalp EEG --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.diagnosticTestScalpEeg"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/diagnostic-test-scalp-eeg/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty diagnosticTestScalpEegDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse"
                       href="#collapse-diagnostic-test-scalp-eeg-${diagnosticTestScalpEegDisplayVo.id}">
                        Zadano dne: ${diagnosticTestScalpEegDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/diagnostic-test-scalp-eeg/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="diagnosticTestScalpEeg/diagnosticTestScalpEegTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Diagnostic test MRI --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.diagnosticTestMri"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty diagnosticTestMriDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-diagnostic-test-mri-${diagnosticTestMriDisplayVo.id}">
                        Zadano dne: ${diagnosticTestMriDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="diagnosticTestMri/diagnosticTestMriTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>


<%-- Invasive test ECoG --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.invasiveTestECoG"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/invasive-test-ecog/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty invasiveTestEcogDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>

        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-invasive-test-ecog-${invasiveTestEcogDisplayVo.id}">
                        Zadano dne: ${invasiveTestEcogDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/invasive-test-ecog/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="invasiveTestEcog/invasiveTestEcogTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Invasive test EEG --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.invasiveTestIeeg"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/invasive-test-eeg/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty invasiveTestEegDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>

        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-invasive-test-eeg-${invasiveTestEegDisplayVo.id}">
                        Zadano dne: ${invasiveTestEegDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/invasive-test-eeg/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="invasiveTestEeg/invasiveTestEegTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Invasive test cortical mapping --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.invasiveTestCorticalMapping"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty invasiveTestCorticalMappingDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse"
                       href="#collapse-invasive-test-cortical-mapping-${invasiveTestCorticalMappingDisplayVo.id}">
                        Zadano dne: ${invasiveTestCorticalMappingDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="invasiveTestCorticalMapping/invasiveTestCorticalMappingTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>

<%-- Operation --%>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.operation"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/operation/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty operationDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-operation-${operationDisplayVo.id}">
                        Zadano dne: ${operationDisplayVo.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <%@include file="operation/operationTableView.jsp" %>

        <c:set var="count" value="1" scope="page"/>
    </c:otherwise>
</c:choose>


<%-- Histology --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.histology"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/histology/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty histologyDisplayVoList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">

                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/histology/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <div class="list-striped">

            <table class="record-head table">
                <tr>
                    <th class="col-xs-2">Datum
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.aed"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.efficiency"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.duringSurgery"/>
                    </th>
                    <th class="col-xs-4"></th>
                </tr>
            </table>
            <c:forEach items="${histologyDisplayVoList}" var="histologyDisplayVo">
                <div>

                    <%@ include file="histology/histologyTableView.jsp" %>

                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<%-- Complication --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.complication"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <c:if test="${isAuthorized}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/complication/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty complicationDisplayVoList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">

                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/complication/list" />">
                        <spring:message code="label.showAll"/>
                    </a>
                </th>
            </tr>
            </tbody>
        </table>

        <div class="list-striped">

            <table class="record-head table">
                <tr>
                    <th class="col-xs-3">Datum
                    </th>
                    <th class="col-xs-3">
                        <spring:message code="label.process"/>
                    </th>
                    <th class="col-xs-3">
                        <spring:message code="label.typeComplication"/>
                    </th>
                    <th class="col-xs-3">
                        <spring:message code="label.complication"/>
                    </th>
                </tr>
            </table>
            <c:forEach items="${complicationDisplayVoList}" var="complicationDisplayVo">
                <c:set var="complicationDisplayVo"
                       value="${complicationDisplayVo}"
                       scope="request"/>
                <div>
                    <jsp:include page="complication/complicationTableForOverviewView.jsp"/>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<%-- Outcome --%>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.outcome"/>
        </h2>

    </div>
</div>

<c:choose>
    <c:when test="${empty operationWithOutcomesDisplayVo}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <div class="list-striped">
            <div>
                <table class="record-head table">
                    <tbody>
                    <tr>
                        <th class="col-xs-12">
                            <a data-toggle="collapse" href="#collapse-outcome-${operationWithOutcomesDisplayVo.id}">
                                <spring:message
                                        code="label.operationFromDay"/>: ${operationWithOutcomesDisplayVo.dateOperation}
                            </a>
                        </th>
                    </tr>
                    </tbody>
                </table>

                <%@ include file="outcome/outcomeTableView.jsp" %>

            </div>
            <c:set var="count" value="1" scope="page"/>
        </div>
    </c:otherwise>
</c:choose>

</jsp:body>
</t:menuLVL2>