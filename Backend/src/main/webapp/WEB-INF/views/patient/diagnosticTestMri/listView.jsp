<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.diagnosticTestsMri"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.diagnosticTestsMri"/>
                </h2>

            </div>
            <div class="col-xs-6">
                <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DOCTOR,ROLE_SUPER_DOCTOR">
                    <h3 class="pull-right">
                        <a href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/create" />">
                            <spring:message code="label.addRecord"/>
                        </a>
                    </h3>
                </sec:authorize>
            </div>
        </div>

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVoList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count"
                       value="0"
                       scope="request"/>
                <div class="list-striped">
                    <c:forEach items="${diagnosticTestMriDisplayVoList}" var="diagnosticTestMriDisplayVo">
                        <c:set var="diagnosticTestMriDisplayVo"
                               value="${diagnosticTestMriDisplayVo}"
                               scope="request"/>
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a data-toggle="collapse"
                                           href="#collapse-diagnostic-test-mri-${diagnosticTestMriDisplayVo.id}">
                                            <spring:message code="label.dateAdded"/>: ${diagnosticTestMriDisplayVo.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/${diagnosticTestMriDisplayVo.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span>
                                            <spring:message code="label.edit"/>
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/diagnostic-test-mri/${diagnosticTestMriDisplayVo.id}/hide"/>">
                                            <span class="glyphicon glyphicon-remove-circle"></span>
                                            <spring:message code="label.delete"/>
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <jsp:include page="diagnosticTestMriTableView.jsp"/>

                        </div>
                        <c:set var="count"
                               value="1"
                               scope="request"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

    </jsp:body>
</t:menuLVL2>