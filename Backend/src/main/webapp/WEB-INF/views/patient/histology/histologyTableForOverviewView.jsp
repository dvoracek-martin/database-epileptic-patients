<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="histologyDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.HistologyDisplayVO"/>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO"/>

<table class="record-head table">
    <tr>
        <td class="col-xs-4">
            <a href="#collapse-histology-${histologyDisplayVo.id}"
               data-toggle="collapse">
                ${histologyDisplayVo.date}
            </a>
        </td>
        <td class="col-xs-4">
            <spring:message code="label.histopathology.${histologyDisplayVo.histopathology}"/>
        </td>
        <td class="col-xs-4">
            <spring:message code="label.fcdClassification.${histologyDisplayVo.fcdClassification}"/>
        </td>
    </tr>
</table>

<div id="collapse-histology-${histologyDisplayVo.id}"
     class="collapse">
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