<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="neuropsychologyDisplayBO"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyDisplayBO"/>

<jsp:useBean id="count"
             scope="request"
             type="java.lang.String"/>

<div id="collapse-neuropsychology-${neuropsychologyDisplayBO.id}"
     class="collapse <c:if test="${count == 0}">in</c:if> ">
<table class="table">
<tbody>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.intellect"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.intellect.${neuropsychologyDisplayBO.intellect}"/>
    </td>
</tr>
<c:choose>
    <c:when test="${neuropsychologyDisplayBO.intellect == 1}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.neurodevelopmentalExamination"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExamination}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.adaptability"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationAdaptability}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechExpressively"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationSpeechExpressively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.speechReceptively"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationSpeechReceptively}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.fineMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationFineMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.grossMotorSkills"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationGrossMotorSkills}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.socialBehavior"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.neurodevelopmentalExaminationSocialBehavior}"/>
            </td>
        </tr>
    </c:when>
    <c:when test="${neuropsychologyDisplayBO.neuropsychologicalProfile == 2}">
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformance"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychologyDisplayBO.intellectualPerformance}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceVerbally"/>
            </th>
            <td class="col-xs-9">
                <spring:message code="label.deficit.${neuropsychologyDisplayBO.intellectualPerformanceVerbally}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalAbstraction"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.intellectualPerformanceNonverbalAbstraction}"/>
            </td>
        </tr>
        <tr>
            <th class="col-xs-3">
                <spring:message code="label.intellectualPerformanceNonverbalDesignCapabilities"/>
            </th>
            <td class="col-xs-9">
                <spring:message
                        code="label.deficit.${neuropsychologyDisplayBO.intellectualPerformanceNonverbalDesignCapabilities}"/>
            </td>
        </tr>
    </c:when>
</c:choose>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.neuropsychologicalProfile"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.neuropsychologicalProfile.${neuropsychologyDisplayBO.neuropsychologicalProfile}"/>
    </td>
</tr>
<c:if test="${neuropsychologyDisplayBO.neuropsychologicalProfile == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.attention"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileAttention}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.executiveFunction"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileExecutiveFunction}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.cognitiveSpeed"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileCognitiveSpeed}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechExpressively"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.speechExpressively.${neuropsychologyDisplayBO.neuropsychologicalProfileSpeechExpressively}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.speechUnderstanding"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileSpeechUnderstanding}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryOperating"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMemoryOperating}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryVerbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMemoryVerbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryNonverbal"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMemoryNonverbal}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.memoryLearning"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMemoryLearning}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpeech"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.perceptionOfSpeech.${neuropsychologyDisplayBO.neuropsychologicalProfilePerceptionSpeech}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionVisual"/>
        </th>
        <td class="col-xs-9">
            <spring:message code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfilePerceptionVisual}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.perceptionSpatial"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfilePerceptionSpatial}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorSkillsDexterity"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMotorSkillsDexterity}"/>
        </td>
    </tr>
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.motorCoordination"/>
        </th>
        <td class="col-xs-9">
            <spring:message
                    code="label.deficit.${neuropsychologyDisplayBO.neuropsychologicalProfileMotorCoordination}"/>
        </td>
    </tr>
</c:if>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.presenceOfChanges"/>
    </th>
    <td class="col-xs-9">
        <spring:message code="label.presenceOfChanges.${neuropsychologyDisplayBO.presenceOfChanges}"/>
    </td>
</tr>

<c:if test="${neuropsychologyDisplayBO.presenceOfChanges == 1}">
    <tr>
        <th class="col-xs-3">
            <spring:message code="label.presenceOfChangesDetail"/>
        </th>
        <c:choose>
            <c:when test="${empty neuropsychologyDisplayBO.presenceOfChangesDetail}">
                <td class="col-xs-9">
                    <spring:message code="label.noRecords"/>
                </td>
            </c:when>
            <c:otherwise>
                <td class="col-xs-9">
                    <c:forEach items="${neuropsychologyDisplayBO.presenceOfChangesDetail}"
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
        <spring:message code="label.emotionalState.${neuropsychologyDisplayBO.emotionalStatus}"/>
    </td>
</tr>

<tr>
    <th class="col-xs-3">
        <spring:message code="label.comment"/>
    </th>
    <c:choose>
        <c:when test="${empty neuropsychologyDisplayBO.comment}">
            <td class="col-xs-9">
                <spring:message code="label.noComments"/>
            </td>
        </c:when>
        <c:otherwise>
            <td class="col-xs-9">
                    ${neuropsychologyDisplayBO.comment}
            </td>
        </c:otherwise>
    </c:choose>
</tr>
</tbody>
</table>
</div>