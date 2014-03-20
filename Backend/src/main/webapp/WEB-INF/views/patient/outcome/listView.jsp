<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.outcome"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.outcome"/>
                </h2>

            </div>
        </div>

        <%@ include file="../patientDetails.jsp" %>

        <!-- Outcome list START -->

        <c:choose>
            <c:when test="${empty operationWithOutcomesDisplayVoList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count" value="0" scope="page"/>
                <div class="list-striped">
                    <c:forEach items="${operationWithOutcomesDisplayVoList}" var="operationWithOutcomesDisplayVo">
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-12">
                                        <a data-toggle="collapse" href="#collapse-outcome-${operationWithOutcomesDisplayVo.id}">
                                            <spring:message code="label.operationFromDay"/>: ${operationWithOutcomesDisplayVo.dateOperation}
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <%@ include file="outcomeTableView.jsp" %>

                        </div>
                        <c:set var="count" value="1" scope="page"/>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- Operation list END -->
    </jsp:body>
</t:menuLVL2>