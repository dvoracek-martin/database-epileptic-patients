<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="invasiveTestEcogDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestEcogDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-invasive-test-ecog-${invasiveTestEcogDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.invasiveTestECoG"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${invasiveTestEcogDisplayBO.done}"/>
            </td>
        </tr>

        <c:if test="${invasiveTestEcogDisplayBO.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ecogCover"/>
                </th>
                <td class="col-xs-9">
                    <c:choose>
                        <c:when test="${empty invasiveTestEcogDisplayBO.ecogCover}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${invasiveTestEcogDisplayBO.ecogCover}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ecogPatterns"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.ecogPatterns.${invasiveTestEcogDisplayBO.ecogPatterns}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.ecogAfterResection"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.afterResectionEcog.${invasiveTestEcogDisplayBO.afterResectionEcog}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.comment"/>
                </th>
                <c:choose>
                    <c:when test="${empty invasiveTestEcogDisplayBO.comment}">
                        <td class="col-xs-9">
                            <spring:message code="label.noComments"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="col-xs-9">
                                ${invasiveTestEcogDisplayBO.comment}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>