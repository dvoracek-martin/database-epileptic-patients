<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>
    <jsp:attribute name="title">
      <spring:message code="label.outcome"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />"
           rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.outcome"/>
                </h2>
            </div>
        </div>

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty operationWithOutcomesDisplayVoList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count"
                       value="0"
                       scope="request"/>
                <div class="list-striped">
                    <c:forEach items="${operationWithOutcomesDisplayVoList}"
                               var="operationWithOutcomesDisplayVo">
                        <c:set var="operationWithOutcomesDisplayVo"
                               value="${operationWithOutcomesDisplayVo}"
                               scope="request"/>
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-12">
                                        <a data-toggle="collapse"
                                           href="#collapse-outcome-${operationWithOutcomesDisplayVo.id}">
                                            <spring:message
                                                    code="label.operationFromDay"/>: ${operationWithOutcomesDisplayVo.dateOperation}
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <jsp:include page="outcomeTableView.jsp"/>

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