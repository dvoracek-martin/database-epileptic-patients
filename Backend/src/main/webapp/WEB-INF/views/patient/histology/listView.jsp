<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.histology"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
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

        <%@ include file="../patientDetails.jsp" %>

        <!-- histology list START -->

        <c:choose>
            <c:when test="${empty histologyDisplayVoList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <div class="list-striped">

                    <table class="record-head table">
                        <tr>
                            <th class="col-xs-2">Datum
                            </th>
                            <th class="col-xs-2">
                                <spring:message code="label.histopathology"/>
                            </th>
                            <th class="col-xs-4">
                                <spring:message code="label.fcdClassification"/>
                            </th>
                            <th class="col-xs-4">

                            </th>
                        </tr>
                    </table>
                    <c:forEach items="${histologyDisplayVoList}" var="histologyDisplayVo">
                        <div>

                            <%@ include file="histologyTableView.jsp" %>

                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- histology list END -->
    </jsp:body>
</t:menuLVL2>