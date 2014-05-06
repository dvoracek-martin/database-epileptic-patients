<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.invasiveTestIeeg"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />"
           rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
                       var="isAuthorized"/>

        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.invasiveTestsIeeg"/>
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

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty invasiveTestEegDisplayBOList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count"
                       value="0"
                       scope="request"/>
                <div class="list-striped">
                    <c:forEach items="${invasiveTestEegDisplayBOList}"
                               var="invasiveTestEegDisplayBO">
                        <c:set var="invasiveTestEegDisplayBO"
                               value="${invasiveTestEegDisplayBO}"
                               scope="request"/>
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a data-toggle="collapse"
                                           href="#collapse-invasive-test-eeg-${invasiveTestEegDisplayBO.id}">
                                            <spring:message code="label.dateAdded"/>: ${invasiveTestEegDisplayBO.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <c:if test="${isAuthorized}">
                                            <a class="pull-right"
                                               href="<c:url value="/patient/${patient.id}/invasive-test-eeg/${invasiveTestEegDisplayBO.id}/edit"/>">
                                                <span class="glyphicon glyphicon-edit"></span> <spring:message
                                                    code="label.edit"/>
                                            </a>
                                        </c:if>
                                    </th>
                                    <th class="col-xs-2">
                                        <c:if test="${isAuthorized}">
                                            <a class="pull-right"
                                               href="#delete-invasive-test-eeg-${invasiveTestEegDisplayBO.id}"
                                               data-toggle="modal">
                                                <span class="glyphicon glyphicon-remove-circle"></span>
                                                <spring:message code="label.delete"/>
                                            </a>
                                        </c:if>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <jsp:include page="invasiveTestEegTableView.jsp"/>

                            <jsp:include page="../../components/deleteModalComponentView.jsp">
                                <jsp:param name="modalId"
                                           value="delete-invasive-test-eeg-${invasiveTestEegDisplayBO.id}"/>
                                <jsp:param name="bodyMessage"
                                           value="reallyDeleteRecord"/>
                                <jsp:param name="deleteUrl"
                                           value="/patient/${patient.id}/invasive-test-eeg/${invasiveTestEegDisplayBO.id}/hide"/>
                            </jsp:include>

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