<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

    <jsp:attribute name="title">
      <spring:message code="label.neuropsychology"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />"
           rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.neuropsychology"/>
                </h2>
            </div>
        </div>

        <jsp:include page="../patientDetails.jsp"/>

        <c:choose>
            <c:when test="${empty neuropsychologyOldDisplayVoList}">
                <div class="alert alert-info">
                    <spring:message code="label.noRecords"/>
                </div>
            </c:when>
            <c:otherwise>
                <c:set var="count"
                       value="0"
                       scope="request"/>
                <div class="list-striped">
                    <c:forEach items="${neuropsychologyOldDisplayVoList}" var="neuropsychologyOldDisplayVo">
                        <c:set var="neuropsychologyOldDisplayVo"
                               value="${neuropsychologyOldDisplayVo}"
                               scope="request"/>
                        <div>
                            <table class="record-head table">
                                <tbody>
                                <tr>
                                    <th class="col-xs-8">
                                        <a href="#collapse-neuropsychology-old-${neuropsychologyOldDisplayVo.id}"
                                           data-toggle="collapse">
                                            <spring:message
                                                    code="label.dateAdded"/>: ${neuropsychologyOldDisplayVo.date}
                                        </a>
                                    </th>
                                    <th class="col-xs-2">

                                    </th>
                                    <th class="col-xs-2">
                                        <a class="pull-right"
                                           href="#delete-neuropsychology-old-${neuropsychologyOldDisplayVo.id}"
                                           data-toggle="modal">
                                            <span class="glyphicon glyphicon-remove-circle"></span>
                                            <spring:message code="label.delete"/>
                                        </a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>

                            <jsp:include page="neuropsychologyOldTableView.jsp"/>

                            <jsp:include page="../../components/deleteModalComponentView.jsp">
                                <jsp:param name="modalId"
                                           value="delete-neuropsychology-old-${neuropsychologyOldDisplayVo.id}"/>
                                <jsp:param name="bodyMessage"
                                           value="reallyDeleteRecord"/>
                                <jsp:param name="deleteUrl"
                                           value="/patient/${patient.id}/neuropsychology-old/${neuropsychologyOldDisplayVo.id}/hide"/>
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