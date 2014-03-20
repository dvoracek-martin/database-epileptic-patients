<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

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
                        ${diagnosticTestMriDisplayVo.mriDescription}
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
                        ${diagnosticTestMriDisplayVo.descriptionPetHypometabolism}
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
                        ${diagnosticTestMriDisplayVo.descriptionSpectHypoperfuse}
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
                        ${diagnosticTestMriDisplayVo.descriptionSpectHyperperfuse}
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
                        ${diagnosticTestMriDisplayVo.descriptionMrsAbnormality}
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
                        ${diagnosticTestMriDisplayVo.detailsFmri}
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
                        ${diagnosticTestMriDisplayVo.detailsDtiStudy}
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
                        ${diagnosticTestMriDisplayVo.detailsWada}
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