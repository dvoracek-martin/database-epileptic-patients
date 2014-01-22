<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2.NEW303>

    <jsp:attribute name="title">
      <spring:message code="label.seizures"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
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

        <%@include file="../patientDetails.jsp" %>

        <!-- Seizure list START -->
        <c:choose>
            <c:when test="${empty patient.seizureList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count" value="0" scope="page"/>
                <div class="list-striped">
                    <c:forEach items="${patient.seizureList}" var="seizure">
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-5">
                                        <a data-toggle="collapse" href="#collapse${seizure.id}">
                                            Zadano dne: ${seizure.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-3">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/seizure-detail/create"/>">
                                            <span class="glyphicon glyphicon-edit"></span> add seizure detail&nbsp;
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span> edit&nbsp;
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/seizure/${seizure.id}/hide"/>">
                                            <span class="glyphicon glyphicon-remove-circle"></span> delete
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <%@include file="seizureTableView.jsp" %>
                        </div>
                        <c:set var="count" value="1" scope="page"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
        <!-- Seizure list END -->
    </jsp:body>
</t:menuLVL2.NEW303>


