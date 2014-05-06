<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="diagnosticTestMriDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.DiagnosticTestMriDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-diagnostic-test-mri-${diagnosticTestMriDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
<table class="table">
<tbody>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.diagnosticTestMri"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.done.${diagnosticTestMriDisplayBO.done}"/>
    </td>
</tr>
<c:if test="${diagnosticTestMriDisplayBO.done==2}">
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mriFinding"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayBO.mriFinding}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionMri"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.mriDescription}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.mriDescription}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fdgPet"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayBO.fdgPet}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionPetHypometabolism"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.descriptionPetHypometabolism}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.descriptionPetHypometabolism}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.interictalSpect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayBO.interictalSpect}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionSpectHypoperfuse"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.descriptionSpectHypoperfuse}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.descriptionSpectHypoperfuse}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.interictalSpect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayBO.ictalSpect}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionSpectHyperperfuse"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.descriptionSpectHyperperfuse}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.descriptionSpectHyperperfuse}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.siscom"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayBO.siscom}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mrsProtocol"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.mrsProtocol.${diagnosticTestMriDisplayBO.mrsProtocol}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mrsFinding"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayBO.mrsFinding}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionMrsAbnormality"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.descriptionMrsAbnormality}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.descriptionMrsAbnormality}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fmri"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayBO.fmri}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fmriDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.detailsFmri}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.detailsFmri}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.dti"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayBO.dti}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.dtiStudyDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.detailsDtiStudy}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.detailsDtiStudy}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.wada"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayBO.wada}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.wadaDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayBO.detailsWada}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayBO.detailsWada}
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.comment"/>
    </th>
    <c:choose>
        <c:when test="${empty diagnosticTestMriDisplayBO.comment}">
            <td class="col-xs-9">
                <spring:message code="label.noComments"/>
            </td>
        </c:when>
        <c:otherwise>
            <td class="col-xs-9">
                    ${diagnosticTestMriDisplayBO.comment}
            </td>
        </c:otherwise>
    </c:choose>
</tr>
</c:if>
</tbody>
</table>
</div>