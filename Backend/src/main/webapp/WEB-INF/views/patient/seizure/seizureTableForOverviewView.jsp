<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="seizureDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDisplayBO"/>

<div id="collapse-seizure-${seizureDisplayBO.id}"
     class="collapse in ">
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
</div>