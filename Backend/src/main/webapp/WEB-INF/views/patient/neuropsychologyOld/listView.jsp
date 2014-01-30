<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>
    <jsp:attribute name="title">
      <spring:message code="label.neuropsychology"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/css/custom.NEW303.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.neuropsychology"/>
                </h2>
            </div>
        </div>

        <%@ include file="../patientDetails.jsp" %>

        <!-- neuropsychology old list START -->

        <c:choose>
            <c:when test="${empty patient.neuropsychologyOldList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count" value="0" scope="page"/>
                <div class="list-striped">
                    <c:forEach items="${patient.neuropsychologyOldList}" var="neuropsychologyOld">
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a data-toggle="collapse" href="#collapse${neuropsychologyOld.id}">
                                            Zadano dne: ${neuropsychologyOld.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/neuropsychology-old/${neuropsychologyOld.id}/edit"/>">
                                            <span class="glyphicon glyphicon-edit"></span> edit
                                        </a>
                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="<c:url value="/patient/${patient.id}/neuropsychology-old/${neuropsychologyOld.id}/hide"/>">
                                            <span class="glyphicon glyphicon-remove-circle"></span> delete
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <%@ include file="neuropsychologyOldTableView.jsp" %>

                        </div>
                        <c:set var="count" value="1" scope="page"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- neuropsychology list END -->
    </jsp:body>
</t:menuLVL2.NEW303>