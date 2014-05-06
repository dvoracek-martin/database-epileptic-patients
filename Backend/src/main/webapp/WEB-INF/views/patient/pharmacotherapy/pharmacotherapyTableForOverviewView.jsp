<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="pharmacotherapyDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.PharmacotherapyDisplayBO"/>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO"/>

<table class="record-head table">
    <tr>
        <td class="col-xs-2">
            <a data-toggle="collapse" href="#collapse-pharmacotherapy-${pharmacotherapyDisplayBO.id}">
                ${pharmacotherapyDisplayBO.date}
            </a>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.aed.${pharmacotherapyDisplayBO.aed}"/>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.efficiency.${pharmacotherapyDisplayBO.efficiency}"/>
        </td>
        <td class="col-xs-2">
            <spring:message code="label.boolean.${pharmacotherapyDisplayBO.duringSurgery}"/>
        </td>
    </tr>
</table>

<div id="collapse-pharmacotherapy-${pharmacotherapyDisplayBO.id}" class="collapse">
    <table class="table">
        <tr>
            <td class="col-xs-4">
                <spring:message code="label.comment"/>
            </td>
            <td colspan="3" class="col-xs-8">
                ${pharmacotherapyDisplayBO.comment}
            </td>
        </tr>
    </table>
</div>