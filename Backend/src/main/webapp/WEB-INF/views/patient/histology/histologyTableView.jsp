<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<table class="record-head table">
    <tr>
        <td class="col-xs-2">
            <a data-toggle="collapse" href="#collapse-histology-${histologyDisplayVo.id}">
                ${histology.date}
            </a>
        </td>
        <td class="col-xs-3">
            <spring:message code="label.histopathology.${histologyDisplayVo.histopathology}"/>
        </td>
        <td class="col-xs-3">
            <spring:message code="label.fcdClassification.${histologyDisplayVo.fcdClassification}"/>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/histology/${histologyDisplayVo.id}/edit"/>">
                <span class="glyphicon glyphicon-edit"></span><spring:message code="label.edit"/>
            </a>
        </td>
        <td class="col-xs-2">
            <a href="<c:url value="/patient/${patient.id}/histology/${histologyDisplayVo.id}/hide"/>">
                <span class="glyphicon glyphicon-remove-circle"></span><spring:message code="label.delete"/>
            </a>
        </td>
    </tr>
</table>

<div id="collapse-histology-${histologyDisplayVo.id}" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td colspan="3" class="col-xs-8">
                ${histologyDisplayVo.comment}
            </td>
        </tr>
    </table>
</div>