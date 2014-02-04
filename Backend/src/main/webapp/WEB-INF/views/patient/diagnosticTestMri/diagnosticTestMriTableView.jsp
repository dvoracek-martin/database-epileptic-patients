<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse${diagnosticTestMri.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
    <table class="table">
        <tbody>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.diagnosticTestMri"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.done.${diagnosticTestMri.done}"/>
            </td>
        </tr>
        <c:if test="${diagnosticTestMri.done==2}">
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.MRIFinding"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.resultType.${diagnosticTestMri.mriFinding}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionMRI"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.mriDescription}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.mRIFdgPet"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.resultType.${diagnosticTestMri.fdgPet}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionPetHypometabolism"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.descriptionPetHypometabolism}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.interictalSPECT"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.resultType.${diagnosticTestMri.interictalSpect}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionSPECTHypoperfuse"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.descriptionSpectHypoperfuse}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.interictalSPECT"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.resultType.${diagnosticTestMri.ictalSpect}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionSPECTHyperperfuse"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.descriptionSpectHyperperfuse}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.mriSiscom"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestMri.siscom}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.MrsProtocol"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.mrsProtocol.${diagnosticTestMri.mrsProtocol}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.MrsFinding"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.resultType.${diagnosticTestMri.mrsFinding}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.descriptionMrsAbnormality"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.descriptionMrsAbnormality}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.fmri"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestMri.fmri}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.FMRIDetails"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.detailsFmri}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.dti"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestMri.dti}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.DTIStudyDetails"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.detailsDtiStudy}
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.WADA"/>
                </th>
                <td class="col-xs-9">
                    <spring:message code="label.boolean.${diagnosticTestMri.wada}"/>
                </td>
            </tr>
            <tr>
                <th class="col-xs-3">
                    <spring:message code="label.WADADetails"/>
                </th>
                <td class="col-xs-9">
                        ${diagnosticTestMri.detailsWada}
                </td>
            </tr>
        </c:if>

        <tr>
            <th class="col-xs-3">
                <spring:message code="label.comment"/>
            </th>
            <c:choose>
                <c:when test="${empty diagnosticTestMri.comment}">
                    <td class="col-xs-9">
                        <spring:message code="label.noComments"/>
                    </td>
                </c:when>
                <c:otherwise>
                    <td class="col-xs-9">
                            ${diagnosticTestMri.comment}
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
        </tbody>
    </table>
</div>


<%--

<tr class="info">
    <td><spring:message code="label.MRIFinding"/></td>
    <c:if test="${diagnosticTestMRI.mriFinding==1}">
        <td><spring:message code="label.bilateral"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==2}">
        <td><spring:message code="label.focal"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==3}">
        <td><spring:message code="label.hemispheric"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==4}">
        <td><spring:message code="label.lobar"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==5}">
        <td><spring:message code="label.multilobar"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==6}">
        <td><spring:message code="label.notDone"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==7}">
        <td><spring:message code="label.normal"/></td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mriFinding==8}">
        <td><spring:message code="label.postoperative"/></td>
    </c:if>
</tr>


<tr class="info">
    <td><spring:message code="label.MrsProtocol"/></td>
    <c:if test="${diagnosticTestMRI.mrsProtocol==1}">
        <td>CSI</td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mrsProtocol==2}">
        <td>Single voxel</td>
    </c:if>
    <c:if test="${diagnosticTestMRI.mrsProtocol==3}">
        <td>Single voxel + CSI</td>
    </c:if>
</tr>


--%>