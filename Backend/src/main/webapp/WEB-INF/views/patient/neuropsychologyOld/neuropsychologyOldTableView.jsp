<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="neuropsychologyOldDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyOldDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-neuropsychology-old-${neuropsychologyOldDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neuropsychologicalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayBO.neuropsychologicalExamination}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                Věk při neuropsychologickém vyšetření
            </th>
            <td class="col-xs-9">
                <strong>N/A</strong>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intelligenceLevel"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.intelligenceLevel.${neuropsychologyOldDisplayBO.intelligenceLevel}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.specificLearning"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayBO.specificLearning}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.developmentalLanguageDisorders"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayBO.developmentalLanguageDisorders}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.adhdSyndrome"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neuropsychologyOldDisplayBO.adhdSyndrome}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty neuropsychologyOldDisplayBO.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${neuropsychologyOldDisplayBO.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>