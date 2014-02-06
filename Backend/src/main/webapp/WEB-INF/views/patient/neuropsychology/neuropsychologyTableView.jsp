<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<div id="collapse-neuropsychology-${neuropsychology.id}" class="collapse <c:if test="${count == 0}">in</c:if> ">
<table class="table">
<tbody>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.intellect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.intellect.${neuropsychology.intellect}"/>
    </td>
</tr>
<c:choose>
    <c:when test="${neuropsychology.intellect == 1}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neurodevelopmentalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychology.neurodevelopmentalExamination}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.adaptability"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.neurodevelopmentalExaminationAdaptability}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechExpressively"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychology.neurodevelopmentalExaminationSpeechExpressively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechReceptively"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.neurodevelopmentalExaminationSpeechReceptively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fineMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.neurodevelopmentalExaminationFineMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.grossMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.neurodevelopmentalExaminationGrossMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.socialBehavior"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.neurodevelopmentalExaminationSocialBehavior}"/>
            </td>
        </tr>
    </c:when>
    <c:when test="${neuropsychology.neuropsychologicalProfile == 2}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformance"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.intellectualPerformance}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceVerbally"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.intellectualPerformanceVerbally}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalAbstraction"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychology.intellectualPerformanceNonverbalAbstraction}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalDesignCapabilities"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychology.intellectualPerformanceNonverbalDesignCapabilities}"/>
            </td>
        </tr>
    </c:when>
</c:choose>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.neuropsychologicalProfile"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.neuropsychologicalProfile.${neuropsychology.neuropsychologicalProfile}"/>
    </td>
</tr>
<c:if test="${neuropsychology.neuropsychologicalProfile == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.attention"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileAttention}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.executiveFunction"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileExecutiveFunction}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.cognitiveSpeed"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileCognitiveSpeed}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechExpressively"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.speechExpressively.${neuropsychology.neuropsychologicalProfileSpeechExpressively}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechUnderstanding"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileSpeechUnderstanding}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryOperating"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMemoryOperating}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryVerbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMemoryVerbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryNonverbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMemoryNonverbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryLearning"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMemoryLearning}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpeech"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.perceptionOfSpeech.${neuropsychology.neuropsychologicalProfilePerceptionSpeech}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionVisual"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfilePerceptionVisual}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpatial"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfilePerceptionSpatial}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorSkillsDexterity"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMotorSkillsDexterity}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorCoordination"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychology.neuropsychologicalProfileMotorCoordination}"/>
        </td>
    </tr>
</c:if>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.presenceOfChanges"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.presenceOfChanges.${neuropsychology.presenceOfChanges}"/>
    </td>
</tr>
<c:if test="${neuropsychology.presenceOfChanges == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.presenceOfChangesDetail"/>
        </th>
        <td class="col-xs-9">
            FIXME
        </td>
    </tr>
</c:if>


<tr>
    <th class="col-xs-3">
        <spring:message code="label.emotionalState"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.emotionalState.${neuropsychology.emotionalStatus}"/>
    </td>
</tr>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.comment"/>
    </th>
    <c:choose>
        <c:when test="${empty neuropsychology.comment}">
            <td class="col-xs-9">
                <spring:message code="label.noComments"/>
            </td>
        </c:when>
        <c:otherwise>
            <td class="col-xs-9">
                    ${neuropsychology.comment}
            </td>
        </c:otherwise>
    </c:choose>
</tr>

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