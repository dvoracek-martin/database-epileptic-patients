<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="diagnosticTestMriDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.DiagnosticTestMriDisplayVO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.Integer"/>

<div id="collapse-diagnostic-test-mri-${diagnosticTestMriDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
<table class="table">
<tbody>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.diagnosticTestMri"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.done.${diagnosticTestMriDisplayVo.done}"/>
    </td>
</tr>
<c:if test="${diagnosticTestMriDisplayVo.done==2}">
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mriFinding"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayVo.mriFinding}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionMri"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.mriDescription}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.mriDescription}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fdgPet"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayVo.fdgPet}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionPetHypometabolism"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.descriptionPetHypometabolism}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.descriptionPetHypometabolism}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.interictalSpect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayVo.interictalSpect}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionSpectHypoperfuse"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.descriptionSpectHypoperfuse}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.descriptionSpectHypoperfuse}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.interictalSpect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayVo.ictalSpect}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionSpectHyperperfuse"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.descriptionSpectHyperperfuse}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.descriptionSpectHyperperfuse}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.siscom"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayVo.siscom}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mrsProtocol"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.mrsProtocol.${diagnosticTestMriDisplayVo.mrsProtocol}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.mrsFinding"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.resultType.${diagnosticTestMriDisplayVo.mrsFinding}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.descriptionMrsAbnormality"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.descriptionMrsAbnormality}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.descriptionMrsAbnormality}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fmri"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayVo.fmri}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.fmriDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.detailsFmri}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.detailsFmri}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.dti"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayVo.dti}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.dtiStudyDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.detailsDtiStudy}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.detailsDtiStudy}
            </c:otherwise>
        </c:choose>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.wada"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.boolean.${diagnosticTestMriDisplayVo.wada}"/>
    </td>
</tr>
<tr>
    <th class="col-xs-3">
        <spring:message code="label.wadaDetails"/>
    </th>
    <td class="col-xs-9">
        <c:choose>
            <c:when test="${empty diagnosticTestMriDisplayVo.detailsWada}">
                -
            </c:when>
            <c:otherwise>
                ${diagnosticTestMriDisplayVo.detailsWada}
            </c:otherwise>
        </c:choose>
    </td>
</tr>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.comment"/>
    </th>
    <c:choose>
        <c:when test="${empty diagnosticTestMriDisplayVo.comment}">
            <td class="col-xs-9">
                <spring:message code="label.noComments"/>
            </td>
        </c:when>
        <c:otherwise>
            <td class="col-xs-9">
                    ${diagnosticTestMriDisplayVo.comment}
            </td>
        </c:otherwise>
    </c:choose>
</tr>
</c:if>
</tbody>
</table>
</div>