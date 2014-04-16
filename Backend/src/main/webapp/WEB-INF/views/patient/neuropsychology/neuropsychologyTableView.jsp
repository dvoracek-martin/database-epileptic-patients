<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="neuropsychologyDisplayVo"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyDisplayVO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.Integer"/>

<div id="collapse-neuropsychology-${neuropsychologyDisplayVo.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
<table class="table">
<tbody>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.intellect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.intellect.${neuropsychologyDisplayVo.intellect}"/>
    </td>
</tr>
<c:choose>
    <c:when test="${neuropsychologyDisplayVo.intellect == 1}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neurodevelopmentalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExamination}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.adaptability"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationAdaptability}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechExpressively"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationSpeechExpressively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechReceptively"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationSpeechReceptively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fineMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationFineMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.grossMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationGrossMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.socialBehavior"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.neurodevelopmentalExaminationSocialBehavior}"/>
            </td>
        </tr>
    </c:when>
    <c:when test="${neuropsychologyDisplayVo.neuropsychologicalProfile == 2}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformance"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychologyDisplayVo.intellectualPerformance}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceVerbally"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychologyDisplayVo.intellectualPerformanceVerbally}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalAbstraction"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.intellectualPerformanceNonverbalAbstraction}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalDesignCapabilities"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayVo.intellectualPerformanceNonverbalDesignCapabilities}"/>
            </td>
        </tr>
    </c:when>
</c:choose>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.neuropsychologicalProfile"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.neuropsychologicalProfile.${neuropsychologyDisplayVo.neuropsychologicalProfile}"/>
    </td>
</tr>
<c:if test="${neuropsychologyDisplayVo.neuropsychologicalProfile == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.attention"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileAttention}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.executiveFunction"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileExecutiveFunction}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.cognitiveSpeed"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileCognitiveSpeed}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechExpressively"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.speechExpressively.${neuropsychologyDisplayVo.neuropsychologicalProfileSpeechExpressively}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechUnderstanding"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileSpeechUnderstanding}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryOperating"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMemoryOperating}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryVerbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMemoryVerbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryNonverbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMemoryNonverbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryLearning"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMemoryLearning}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpeech"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.perceptionOfSpeech.${neuropsychologyDisplayVo.neuropsychologicalProfilePerceptionSpeech}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionVisual"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfilePerceptionVisual}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpatial"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfilePerceptionSpatial}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorSkillsDexterity"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMotorSkillsDexterity}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorCoordination"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayVo.neuropsychologicalProfileMotorCoordination}"/>
        </td>
    </tr>
</c:if>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.presenceOfChanges"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.presenceOfChanges.${neuropsychologyDisplayVo.presenceOfChanges}"/>
    </td>
</tr>

<c:if test="${neuropsychologyDisplayVo.presenceOfChanges == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.presenceOfChangesDetail"/>
        </th>
        <c:choose>
            <c:when test="${empty neuropsychologyDisplayVo.presenceOfChangesDetail}">
                <td class="col-xs-9">
                    <spring:message code="label.noRecords"/>
                </td>
            </c:when>
            <c:otherwise>
                <td class="col-xs-9">
                    <c:forEach items="${neuropsychologyDisplayVo.presenceOfChangesDetail}"
                               var="presenceOfChangesDetail">
                        <spring:message code="label.deteriorace.${presenceOfChangesDetail}"/>,
                    </c:forEach>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</c:if>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.emotionalState"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.emotionalState.${neuropsychologyDisplayVo.emotionalStatus}"/>
    </td>
</tr>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.comment"/>
    </th>
    <c:choose>
        <c:when test="${empty neuropsychologyDisplayVo.comment}">
            <td class="col-xs-9">
                <spring:message code="label.noComments"/>
            </td>
        </c:when>
        <c:otherwise>
            <td class="col-xs-9">
                    ${neuropsychologyDisplayVo.comment}
            </td>
        </c:otherwise>
    </c:choose>
</tr>
</tbody>
</table>
</div>