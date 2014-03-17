<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.neurologicalFinding"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.neurologicalFinding"/>
                </h2>

            </div>
            <div class="col-xs-6">
                <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DOCTOR,ROLE_SUPER_DOCTOR">
                    <h3 class="pull-right">
                        <a href="<c:url value="/patient/${patient.id}/neurological-finding/create" />">
                            <spring:message code="label.addRecord"/>
                        </a>
                    </h3>
                </sec:authorize>
            </div>
        </div>

        <%@ include file="../patientDetails.jsp" %>

        <!-- neurological finding list START -->

        <c:choose>
            <c:when test="${empty neurologicalFindingList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count" value="0" scope="page"/>
                <div class="list-striped">
                    <c:forEach items="${neurologicalFindingList}" var="neurologicalFinding">
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a data-toggle="collapse"
                                           href="#collapse-neurological-finding-${neurologicalFinding.id}">
                                            Zadano dne: ${neurologicalFinding.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/neurological-finding/${neurologicalFinding.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span> edit
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/neurological-finding/${neurologicalFinding.id}/hide"/>">
                                            <span class="glyphicon glyphicon-remove-circle"></span> delete
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <%@ include file="neurologicalFindingTableView.jsp" %>

                        </div>
                        <c:set var="count" value="1" scope="page"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- neurologicalFinding list END -->
    </jsp:body>
</t:menuLVL2>


