<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>
    <jsp:attribute name="title">
      <spring:message code="label.invasiveTestECoG"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
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

        <%@ include file="../patientDetails.jsp" %>

        <!-- Invasive test ECOG list START -->

        <c:choose>
            <c:when test="${empty patient.invasiveTestEcogList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count" value="0" scope="page"/>
                <div class="list-striped">
                    <c:forEach items="${patient.invasiveTestEcogList}" var="invasiveTestEcog">
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a data-toggle="collapse" href="#collapse${invasiveTestEcog.id}">
                                            Zadano dne: ${invasiveTestEcog.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/invasive-test-ecog/${invasiveTestEcog.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span> edit
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/invasive-test-ecog/${invasiveTestEcog.id}/hide"/>">
                                            <span class="glyphicon glyphicon-remove-circle"></span> delete
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <%@ include file="invasiveTestEcogTableView.jsp" %>

                        </div>
                        <c:set var="count" value="1" scope="page"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- Invasive test ECOG list END -->
    </jsp:body>
</t:menuLVL2.NEW303>