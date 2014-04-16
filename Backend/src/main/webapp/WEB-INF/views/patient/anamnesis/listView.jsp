<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

    <jsp:attribute name="title">
      <spring:message code="label.anamnesis"/>
    </jsp:attribute>

    <jsp:attribute name="head">
    </jsp:attribute>

    <jsp:body>
        <sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
                       var="isAuthorized"/>

        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.anamnesis"/>
                </h2>
            </div>
            <div class="col-xs-6">

                <c:if test="${empty anamnesisDisplayVo && isAuthorized}">
                    <h3 class="pull-right">
                        <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />">
                            <spring:message code="label.addRecord"/>
                        </a>
                    </h3>
                </c:if>
            </div>
        </div>

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty anamnesisDisplayVo}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <div class="list-striped">
                    <div>
                        <table class="record-head table">
                            <tbody>
                            <tr>
                                <th class="col-xs-8">
                                    <a href="#collapse-anamnesis-${anamnesisDisplayVo.id}"
                                       data-toggle="collapse">
                                        <spring:message code="label.dateAdded"/>: ${anamnesisDisplayVo.date}
                                    </a>
                                </th>
                                <th class="col-xs-4">
                                    <c:if test="${isAuthorized}">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesisDisplayVo.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span>
                                            <spring:message code="label.edit"/>
                                        </a>
                                    </c:if>
                                </th>
                            </tr>
                            </tbody>
                        </table>

                        <jsp:include page="anamnesisTableView.jsp"/>

                    </div>
                </div>
            </c:otherwise>
        </c:choose>

    </jsp:body>
</t:menuLVL2>