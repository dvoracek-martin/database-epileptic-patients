<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<table class="record-head table">
    <tr>
        <td class="col-xs-2">
            <a data-toggle="collapse" href="#collapse${complication.id}">
                ${complication.date}
            </a>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.process.${complication.withComplication}"/>
        </td>
        <td class="col-xs-2">
            <c:if test="${complication.withComplication == 2}">
                <spring:message code="label.complicationType.${complication.complicationType}"/>
            </c:if>
        </td>
        <td class="col-xs-2">
            <c:if test="${complication.withComplication == 2}">
                <spring:message code="label.complication.${complication.complication}"/>
            </c:if>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/complication/${complication.id}/edit"/>">
                <span class="glyphicon glyphicon-edit"></span><spring:message code="label.edit"/>
            </a>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/complication/${complication.id}/hide"/>">
                <span class="glyphicon glyphicon-remove-circle"></span><spring:message code="label.delete"/>
            </a>
        </td>
    </tr>
</table>

<div id="collapse${complication.id}" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td colspan="3" class="col-xs-8">
                ${complication.comment}
            </td>
        </tr>
    </table>
</div>