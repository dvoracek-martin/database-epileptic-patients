<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      	Skryté záznamy
    </jsp:attribute>

	<jsp:attribute name="head">
    <link
            href="<c:url value="/resources/custom/css/clickable-row.css" />"
            rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="script">
 	<script src="<c:url value="/resources/custom/js/clickable-row.js"/>"></script>
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-6">
        <h2>
            Skryté záznamy
        </h2>
    </div>
</div>

<div class="row">
    <div class="col-xs-6">
        <h3>
            Pacient
        </h3>
    </div>
</div>

<div class="row">
    <div class="col-xs-12">
        <div class="table-responsive">
            <c:choose>
                <c:when test="${empty hiddenPatientList}">
                    <div class="text-center">
                        <h4>
                            Žádní skrytí pacienti.
                        </h4>
                    </div>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <td><b><spring:message
                                    code="label.firstname"/></b></td>
                            <td><b><spring:message
                                    code="label.lastname"/></b></td>
                            <td><b><spring:message
                                    code="label.birthIdentificationNumber"/></b></td>
                            <td><b><spring:message
                                    code="label.address"/></b></td>
                            <td><b><spring:message
                                    code="label.addressCity"/></b></td>
                            <td></td>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${hiddenPatientList}" var="patient">
                            <tr>
                                <td>${patient.contact.firstName}
                                </td>
                                <td>${patient.contact.lastName}
                                </td>
                                <td>${patient.nin}</td>
                                <td>${patient.contact.addressStreet}, ${patient.contact.addressHn}</td>
                                <td>${patient.contact.addressCity}</td>
                                <td>
                                    <a href="<c:url value="/patient/${patient.id}/unhide" />">
                                        <span class="glyphicon glyphicon-retweet"></span> recover&nbsp;
                                    </a>
                                </td>
                                <td>
                                    <a href="<c:url value="/patient/${patient.id}/delete" />">
                                        <span class="glyphicon glyphicon-fire"></span> permanent delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-12">
        <h3>
            <spring:message code="label.diagnosticTestScalpEeg"/>
        </h3>
    </div>
</div>
<div class="row">
    <div class="col-xs-12">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.lastname"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.firstname"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.dateOfContractAward"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${patientsWithHiddenRecordsList}" var="patient">
                <c:forEach items="${patient.diagnosticTestScalpEegList}" var="diagnosticTestScalpEeg">
                    <tr>
                        <td>
                            <div class="col-xs-2">
                                    ${patient.contact.lastName}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                    ${patient.contact.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                    ${diagnosticTestScalpEeg.date}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                recover
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                delete
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2"></div>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%-- WILL BE USED
<div class="row">
    <div class="col-xs-12">
        <h3>
            <spring:message code="label.neurologicalFinding"/>
        </h3>
    </div>
</div>
<div class="row">
    <div class="col-xs-12">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.lastname"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.firstname"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                        <spring:message code="label.dateOfContractAward"/>
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
                <th>
                    <div class="col-xs-2">
                    </div>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${patientsWithHiddenRecordsList}" var="patient">
                <c:forEach items="${patient.neurologicalFindingList}" var="neurologicalFinding">
                    <tr>
                        <td>
                            <div class="col-xs-2">
                                    ${patient.contact.lastName}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                    ${patient.contact.firstName}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                    ${neurologicalFinding.date}
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                recover
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2">
                                delete
                            </div>
                        </td>
                        <td>
                            <div class="col-xs-2"></div>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>--%>


<%--
<div class="row">
    <div class="col-xs-6">
        <h3>
            Anamnézy
        </h3>
    </div>
</div>




<div class="row">
    <div class="col-xs-12">
        <c:choose>
            <c:when test="${empty anamnesisList}">
                <div class="text-center">
                    <h4>
                        Žádné skryté anamnézy.
                    </h4>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${anamnesisList}" var="anamnesis">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse"
                                   href="#collapse${anamnesis.id}">
                                    Zadano dne: ${anamnesis.date}
                                </a>

                                <a class="pull-right"
                                   href="<c:url value="/patient/${anamnesis.patient.id}/anamnesis/${anamnesis.id}/unhide" />">
                                    <span class="glyphicon glyphicon-retweet"></span> recover&nbsp;
                                </a>

                                <a class="pull-right"
                                   href="<c:url value="/patient/${anamnesis.patient.id}/anamnesis/${anamnesis.id}/delete" />">
                                    <span class="glyphicon glyphicon-fire"></span> permanent delete
                                </a>
                            </h4>
                        </div>
                        <%@include file="patient/anamnesis/anamnesisTableView.jsp" %>
                    </div>
                    <c:set var="count" value="1" scope="page"/>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
--%>
</jsp:body>
</t:menuLVL1>
