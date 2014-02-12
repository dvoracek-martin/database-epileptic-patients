<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.patient"/>
        </h2>

    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a id="export" href="<c:url value="/patient/${patient.id}/export" />">
                <spring:message code="label.exportPatient"/>
            </a>
        </h3>
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
        <c:if test="${displayAnamnesisCreate==true}">
            <h3 class="pull-right">
                <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />">
                    <spring:message code="label.addRecord"/>
                </a>
            </h3>
        </c:if>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.anamnesisList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="anamnesis" value="${patient.anamnesisList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-anamnesis-${anamnesis.id}">
                        Zadano dne: ${anamnesis.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/anamnesis/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/seizure/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.seizureList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="seizure" value="${patient.seizureList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-seizure-${seizure.id}">
                        Zadano dne: ${seizure.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/seizure/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/pharmacotherapy/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.pharmacotherapyList}">
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
                        Zobrazit vsechny
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
            <c:forEach items="${patient.pharmacotherapyList}" var="pharmacotherapy">
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/neurological-finding/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.neurologicalFindingList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="neurologicalFinding" value="${patient.neurologicalFindingList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-neurological-finding-${neurologicalFinding.id}">
                        Zadano dne: ${neurologicalFinding.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/neurological-finding/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/neuropsychology/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.neuropsychologyList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="neuropsychology" value="${patient.neuropsychologyList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-neuropsychology-${neuropsychology.id}">
                        Zadano dne: ${neuropsychology.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/neuropsychology/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/diagnostic-test-scalp-eeg/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.diagnosticTestScalpEegList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="diagnosticTestScalpEeg" value="${patient.diagnosticTestScalpEegList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-diagnostic-test-scalp-eeg-${diagnosticTestScalpEeg.id}">
                        Zadano dne: ${diagnosticTestScalpEeg.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/diagnostic-test-scalp-eeg/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.diagnosticTestMriList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="diagnosticTestMri" value="${patient.diagnosticTestMriList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-diagnostic-test-mri-${diagnosticTestMri.id}">
                        Zadano dne: ${diagnosticTestMri.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/invasive-test-ecog/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.invasiveTestEcogList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="invasiveTestEcog" value="${patient.invasiveTestEcogList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-invasive-test-ecog-${invasiveTestEcog.id}">
                        Zadano dne: ${invasiveTestEcog.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/invasive-test-ecog/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/invasive-test-eeg/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.invasiveTestEegList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="invasiveTestEeg" value="${patient.invasiveTestEegList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-invasive-test-eeg-${invasiveTestEeg.id}">
                        Zadano dne: ${invasiveTestEeg.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right" href="<c:url value="/patient/${patient.id}/invasive-test-eeg/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.invasiveTestCorticalMappingList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="invasiveTestCorticalMapping" value="${patient.invasiveTestCorticalMappingList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse"
                       href="#collapse-invasive-test-cortical-mapping-${invasiveTestCorticalMapping.id}">
                        Zadano dne: ${invasiveTestCorticalMapping.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/operation/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.operationList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <c:set var="operation" value="${patient.operationList[0]}" scope="page"/>
        <table class="record-head table">
            <tbody>
            <tr>
                <th class="col-xs-8">
                    <a data-toggle="collapse" href="#collapse-operation-${operation.id}">
                        Zadano dne: ${operation.date}
                    </a>
                </th>
                <th class="col-xs-4">
                    <a class="pull-right"
                       href="<c:url value="/patient/${patient.id}/invasive-test-cortical-mapping/list" />">
                        Zobrazit vsechny
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/histology/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.histologyList}">
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
                        Zobrazit vsechny
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
            <c:forEach items="${patient.histologyList}" var="histology">
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
        <h3 class="pull-right">
            <a href="<c:url value="/patient/${patient.id}/complication/create" />">
                <spring:message code="label.addRecord"/>
            </a>
        </h3>
    </div>
</div>

<c:choose>
    <c:when test="${empty patient.complicationList}">
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
                        Zobrazit vsechny
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
                        <spring:message code="label.process"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.typeComplication"/>
                    </th>
                    <th class="col-xs-2">
                        <spring:message code="label.complication"/>
                    </th>
                    <th class="col-xs-4"></th>
                </tr>
            </table>
            <c:forEach items="${patient.complicationList}" var="complication">
                <div>

                    <%@ include file="complication/complicationTableView.jsp" %>

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
    <c:when test="${empty patient.operationList}">
        <div class="alert alert-info">
            <spring:message code="label.noRecords"/>
        </div>
    </c:when>
    <c:otherwise>
        <c:set var="count" value="0" scope="page"/>
        <div class="list-striped">
            <c:set var="operation" value="${patient.operationList[0]}" scope="page"/>
            <div>
                <table class="record-head table">
                    <tbody>
                    <tr>
                        <th class="col-xs-12">
                            <a data-toggle="collapse" href="#collapse-outcome-${operation.id}">
                                <spring:message code="label.operationFromDay"/>: ${operation.dateOperation}
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
</t:menuLVL2.NEW303>