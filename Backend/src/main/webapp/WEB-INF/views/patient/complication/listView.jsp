<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.complication"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
                       var="isAuthorized"/>

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

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty complicationDisplayBOList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <div class="list-striped">
                    <table class="record-head table">
                        <tr>
                            <th class="col-xs-2">
                                <spring:message code="label.date"/>
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
                            <th class="col-xs-4">
                            </th>
                        </tr>
                    </table>
                    <c:forEach items="${complicationDisplayBOList}"
                               var="complicationDisplayBO">
                        <c:set var="complicationDisplayBO"
                               value="${complicationDisplayBO}"
                               scope="request"/>
                        <div>
                            <jsp:include page="complicationTableView.jsp"/>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

    </jsp:body>
</t:menuLVL2>