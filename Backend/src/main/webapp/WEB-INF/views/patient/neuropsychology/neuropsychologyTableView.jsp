<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${neuropsychology.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <c:choose>
            <c:when test="${neuropsychology.intellect == 1}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
            <c:when test="${neuropsychology.intellect == 2}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${neuropsychology.neuropsychologicalProfile == 1}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
            <c:when test="${neuropsychology.neuropsychologicalProfile == 2}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
            <c:when test="${neuropsychology.neuropsychologicalProfile == 3}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${neuropsychology.presenceOfChanges == 1}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
            <c:when test="${neuropsychology.presenceOfChanges == 2}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
            <c:when test="${neuropsychology.presenceOfChanges == 3}">
                <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                ...
            </c:when>
        </c:choose>
        depresivni poruchy
        komentar
<%--
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellect"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.intellect.${neuropsychology.intellect}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.abnormalNeurologicalFinding"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFinding.abnormalNeurologicalFinding}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.hemiparesis"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFinding.hemiparesis}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.visualFieldDefect"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.boolean.${neurologicalFinding.visualFieldDefects}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3"><spring:message code="label.comment"/></th>
            <c:choose>
                <c:when test="${empty neurologicalFinding.comment}">
                    <td class="col-xs-9"><spring:message code="label.noComments"/></td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">${neurologicalFinding.comment}</td>
                </c:otherwise>
            </c:choose>
        </tr> --%>
        </tbody>
    </table>
</div>