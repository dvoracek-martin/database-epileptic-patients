<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="seizureDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
               var="isAuthorized"/>

<div id="collapse-seizure-${seizureDisplayBO.id}"
     class="collapse
     <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.seizureFrequency"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.seizureFrequency.${seizureDisplayBO.seizureFrequency}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.secondarilyGeneralizedSeizure"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayBO.secondarilyGeneralizedSeizure}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.statusEpilepticus"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayBO.statusEpilepticus}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonepilepticSeizures"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayBO.nonepilepticSeizures}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.occurrence"/>
            </th>
            <td>
                <spring:message code="label.seizureOccurence.${seizureDisplayBO.seizureOccurrence}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3"><spring:message code="label.comment"/></th>
            <c:choose>
                <c:when test="${empty seizureDisplayBO.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${seizureDisplayBO.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td colspan="2">

                <%-- seizure detail section START--%>

                <table class="table">
                    <c:set var="seizureDetailsCount"
                           value="0"
                           scope="page"/>
                    <c:forEach items="${seizureDisplayBO.seizureDetailList}"
                               var="seizureDetailDisplayBO">
                        <c:set var="seizureDetailsCount"
                               value="${seizureDetailsCount + 1}"
                               scope="page"/>
                        <tr>
                            <th colspan="2" class="col-xs-12">
                                    ${seizureDetailsCount}. <spring:message code="label.seizureType"/>
                                <c:if test="${isAuthorized}">
                                    (
                                    <a href="<c:url value="/patient/${patient.id}/seizure/${seizureDisplayBO.id}/seizure-detail/${seizureDetailDisplayBO.id}/edit"/>">
                                        <spring:message code="label.edit"/>
                                    </a>
                                    |
                                    <a href="#delete-seizure-detail-${seizureDetailDisplayBO.id}"
                                       data-toggle="modal">
                                        <spring:message code="label.delete"/>
                                    </a>
                                    )
                                </c:if>
                            </th>
                        </tr>
                        <tr>
                            <th class="col-xs-3">
                                <spring:message code="label.dateAdded"/>:
                            </th>
                            <td class="col-xs-9">
                                    ${seizureDetailDisplayBO.date}
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3">
                                <spring:message code="label.sscClassification"/>
                            </th>
                            <td class="col-xs-9">
                                <spring:message
                                        code="label.sscClassification.${seizureDetailDisplayBO.sscClassification}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3">
                                <spring:message code="label.ilaeClassification"/>
                            </th>
                            <td class="col-xs-9">
                                <spring:message
                                        code="label.ilaeClassification.${seizureDetailDisplayBO.ilaeClassification}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3"><spring:message code="label.comment"/></th>
                            <c:choose>
                                <c:when test="${empty seizureDetailDisplayBO.comment}">
                                    <td class="col-xs-9">
                                        <spring:message code="label.noComments"/>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                            ${seizureDetailDisplayBO.comment}
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </table>

                <%-- seizure detail section END--%>

            </td>
        </tr>
        </tbody>
    </table>
    <c:forEach items="${seizureDisplayBO.seizureDetailList}"
               var="seizureDetailDisplayBO">

        <jsp:include page="../../components/deleteModalComponentView.jsp">
            <jsp:param name="modalId"
                       value="delete-seizure-detail-${seizureDetailDisplayBO.id}"/>
            <jsp:param name="bodyMessage"
                       value="reallyDeleteRecord"/>
            <jsp:param name="deleteUrl"
                       value="/patient/${patient.id}/seizure/${seizureDisplayBO.id}/seizure-detail/${seizureDetailDisplayBO.id}/hide"/>
        </jsp:include>

    </c:forEach>
</div>