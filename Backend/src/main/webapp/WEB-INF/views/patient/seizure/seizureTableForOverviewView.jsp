<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="seizureDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDisplayVO"/>

<div id="collapse-seizure-${seizureDisplayVo.id}"
     class="collapse in ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.seizureFrequency"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.seizureFrequency.${seizureDisplayVo.seizureFrequency}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.secondarilyGeneralizedSeizure"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.secondarilyGeneralizedSeizure}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.statusEpilepticus"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.statusEpilepticus}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.nonepilepticSeizures"/>
            </th>
            <td>
                <spring:message code="label.boolean.${seizureDisplayVo.nonepilepticSeizures}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.occurrence"/>
            </th>
            <td>
                <spring:message code="label.seizureOccurence.${seizureDisplayVo.seizureOccurrence}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3"><spring:message code="label.comment"/></th>
            <c:choose>
                <c:when test="${empty seizureDisplayVo.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                            ${seizureDisplayVo.comment}
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
                    <c:forEach items="${seizureDisplayVo.seizureDetailList}"
                               var="seizureDetailDisplayVo">
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
                                    ${seizureDetailDisplayVo.date}
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3">
                                <spring:message code="label.sscClassification"/>
                            </th>
                            <td class="col-xs-9">
                                <spring:message
                                        code="label.sscClassification.${seizureDetailDisplayVo.sscClassification}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3">
                                <spring:message code="label.ilaeClassification"/>
                            </th>
                            <td class="col-xs-9">
                                <spring:message
                                        code="label.ilaeClassification.${seizureDetailDisplayVo.ilaeClassification}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="col-xs-3"><spring:message code="label.comment"/></th>
                            <c:choose>
                                <c:when test="${empty seizureDetailDisplayVo.comment}">
                                    <td class="col-xs-9">
                                        <spring:message code="label.noComments"/>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                            ${seizureDetailDisplayVo.comment}
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