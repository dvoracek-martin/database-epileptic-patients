<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.export"/>
    </jsp:attribute>

    <jsp:attribute name="head">
        <link href="<c:url value="/resources/custom/css/custom.css" />"
              rel="stylesheet">
           <link href="<c:url value="/resources/jquery-tree/jquery.tree.min.css" />"
                 rel="stylesheet">
          <link href="<c:url value="/resources/jquery-ui/css/ui-lightness/jquery-ui.min.css" />"
                rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/export.js" />"></script>
        <script src="<c:url value="/resources/jquery-ui/js/jquery-ui.min.js" />"></script>
        <script src="<c:url value="/resources/jquery-tree/jquery.tree.min.js" />"></script>
    </jsp:attribute>

<jsp:body>

<sec:authorize ifAnyGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
               var="isAuthorized"/>

<input id="exportParamsId"
       type="hidden"
       value="${exportParams.id}">

<div class="row">
    <div class="col-xs-6">
        <h2>
            <c:choose>
                <c:when test="${exportInfoWrapperVo.source == 'search'}">
                    <spring:message code="label.exportSearchResults"/>
                </c:when>
                <c:otherwise>
                    <spring:message code="label.exportPatient"/>
                </c:otherwise>
            </c:choose>
        </h2>
    </div>
    <div class="col-xs-6">

    </div>
</div>

<div class="row">
    <div class="col-xs-12">

        <fieldset>
            <legend>
                <spring:message code="label.load"/>
            </legend>

            <form id="genericConfigurationsForm"
                  class="form-horizontal"
                  action="<c:url value="/export/load"/>"
                  method="POST"
                  role="form">

                <div class="form-group">

                    <label class="col-xs-4 control-label"
                           for="genericConfigurations">
                        <spring:message code="label.genericConfigurations"/>
                    </label>

                    <div class="col-xs-3">
                        <select id="genericConfigurations"
                                class="input-sm form-control"
                                name="exportId">

                            <c:forEach items="${genericConfigurations}"
                                       var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>

                        </select>
                    </div>

                    <button class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.load"/>
                    </button>

                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <button id="genericConfigurationsDeleteButton"
                                class="btn btn-primary btn-sm"
                                type="submit">
                            <spring:message code="label.delete"/>
                        </button>
                    </sec:authorize>
                </div>
            </form>

            <form id="userConfigurationsForm"
                  class="form-horizontal"
                  action="<c:url value="/export/load"/>"
                  method="POST"
                  role="form">

                <div class="form-group">

                    <label class="col-xs-4 control-label"
                           for="userConfigurations">
                        <spring:message code="label.userConfigurations"/>
                    </label>

                    <div class="col-xs-3">
                        <select id="userConfigurations"
                                class="input-sm form-control"
                                name="exportId">

                            <c:forEach items="${userConfigurations}"
                                       var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.load"/>
                    </button>

                    <button id="userConfigurationsDeleteButton"
                            class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.delete"/>
                    </button>
                </div>
            </form>

        </fieldset>
    </div>
</div>

<div class="row">
<div class="col-xs-12">

<form:form id="exportForm"
           class="form-horizontal"
           action="/GENEPI/perform-export"
           method="POST"
           commandName="exportParams">

<fieldset>
<legend>
    <spring:message code="label.export"/>
</legend>

<div class="row">
    <div class="col-xs-offset-2 col-xs-10">
        <fieldset>
            <legend>
                <c:choose>
                    <c:when test="${fn:length(exportInfoWrapperVo.patientIds) gt 1}">
                        <spring:message code="label.patientsToExport"/>
                    </c:when>
                    <c:otherwise>
                        <spring:message code="label.patientToExport"/>
                    </c:otherwise>
                </c:choose>
            </legend>
            <c:forEach items="${exportInfoWrapperVo.patientIds}"
                       var="patientId">
                <a href="<c:url value="/patient/${patientId}/overview" />">
                        ${patientId}
                </a>
            </c:forEach>
        </fieldset>
    </div>
</div>

<div class="row">
    <div class="col-xs-offset-2 col-xs-10">
        <fieldset>
            <legend>
                <spring:message code="label.settings"/>
            </legend>

            <div class="form-group">
                <label class="col-xs-3 control-label"
                       for="chooseFormat">
                    <spring:message code="label.chooseFormat"/>
                </label>

                <div id="chooseFormat"
                     class="col-xs-9">
                    <input type="radio"
                           id="pdfFormat"
                           name="exportType"
                           value="pdf"
                           checked>
                    <label for="pdfFormat">pdf</label>

                    <input type="radio"
                           id="xlsxFormat"
                           name="exportType"
                           value="xlsx">
                    <label for="xlsxFormat">xlsx</label>

                    <input type="radio"
                           id="docxFormat"
                           name="exportType"
                           value="docx">
                    <label for="docxFormat">docx</label>

                    <input type="radio"
                           id="txtFormat"
                           name="exportType"
                           value="txt">
                    <label for="txtFormat">txt</label>

                    <input type="radio"
                           id="csvFormat"
                           name="exportType"
                           value="csv">
                    <label for="csvFormat">csv</label>
                </div>
            </div>

            <c:if test="${isAuthorized}">
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <div class="checkbox">
                            <label>
                                <form:checkbox id="anonymize"
                                               class="toCheck"
                                               path="anonymize"/>
                                <spring:message code="label.anonymize"/>
                            </label>
                        </div>
                    </div>
                </div>
            </c:if>

            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <button class="btn btn-primary"
                            type="submit">
                        <spring:message code="label.export"/>
                    </button>
                </div>
            </div>
        </fieldset>
    </div>
</div>

<div class="row">
<div class="col-xs-offset-2 col-xs-9">
<fieldset>
<legend>
    <spring:message code="label.parameters"/>
</legend>

<div id="tree"
     class=" col-xs-offset-1 col-xs-10">
<ul>

    <li class="collapsed">
        <form:checkbox id="anamnesis"
                       class="toCheck"
                       path="anamnesis"/>
        <form:label path="anamnesis">
            <spring:message code="label.anamnesis"/>
        </form:label>
        <ul>
            <li>
                <form:checkbox id="anamnesisBeginningEpilepsy" path="anamnesisBeginningEpilepsy"
                               class="input-block-level toCheck"/>
                <form:label
                        path="anamnesisBeginningEpilepsy"> <spring:message code="label.beginningEpilepsy"/></form:label>
            </li>
            <li>
                <form:checkbox id="anamnesisFirstFever" path="anamnesisFirstFever"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisFirstFever"> <spring:message code="label.firstFever"/></form:label>
            </li>
            <li>
                <form:checkbox id="anamnesisInfantileSpasm" path="anamnesisInfantileSpasm"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisInfantileSpasm"> <spring:message code="label.infantileSpasm"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisSpecificSyndrome" path="anamnesisSpecificSyndrome"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisSpecificSyndrome"> <spring:message code="label.epilepticSyndrome"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisEpilepsyInFamily" path="anamnesisEpilepsyInFamily"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisEpilepsyInFamily"> <spring:message code="label.epilepsyInFamily"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisParentalRisk" path="anamnesisParentalRisk"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisParentalRisk"> <spring:message code="label.prenatalRisk"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisFibrilConvulsions" path="anamnesisFibrilConvulsions"
                               class="input-block-level toCheck"/>
                <form:label
                        path="anamnesisFibrilConvulsions"><spring:message code="label.fibrilConvulsions"/></form:label>
            </li>
            <li>
                <form:checkbox id="anamnesisInflammationCns" path="anamnesisInflammationCns"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisInflammationCns"><spring:message code="label.inflammationCns"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisInjuryCns" path="anamnesisInjuryCns"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisInjuryCns"><spring:message code="label.injuryCns"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisOperationCns" path="anamnesisOperationCns"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisOperationCns"><spring:message code="label.operationCns"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisEarlyPmdRetardation" path="anamnesisEarlyPmdRetardation"
                               class="input-block-level toCheck"/>
                <form:label
                        path="anamnesisEarlyPmdRetardation"><spring:message code="label.earlyPmdRetardation"/></form:label>
            </li>

            <li>
                <form:checkbox id="anamnesisNonCnsComorbidity" path="anamnesisNonCnsComorbidity"
                               class="input-block-level toCheck"/>
                <form:label
                        path="anamnesisNonCnsComorbidity"><spring:message code="label.nonCnsComorbidity"/></form:label>
            </li>
            <li>
                <form:checkbox id="anamnesisComment" path="anamnesisComment"
                               class="input-block-level toCheck"/>
                <form:label path="anamnesisComment"><spring:message code="label.comment"/></form:label>
            </li>
        </ul>
    </li>
    <li class="collapsed">
        <form:checkbox id="seizure"
                       class="toCheck"
                       path="seizure"/>
        <form:label path="seizure">
            <spring:message code="label.seizures"/>
        </form:label>
        <ul>
            <li>
                <form:checkbox id="seizureFrequency" path="seizureFrequency"
                               class="input-block-level toCheck"/>
                <form:label
                        path="seizureFrequency"> <spring:message code="label.seizureFrequency"/>
                </form:label>
            </li>
            <li>
                <form:checkbox id="seizureSecondarilyGeneralizedSeizure" path="seizureSecondarilyGeneralizedSeizure"
                               class="input-block-level toCheck"/>
                <form:label path="seizureSecondarilyGeneralizedSeizure"> <spring:message code="label.secondarilyGeneralizedSeizure"/></form:label>
            </li>

            <li>
                <form:checkbox id="seizureStatusEpilepticus" path="seizureStatusEpilepticus"
                               class="input-statusEpilepticus-level toCheck"/>
                <form:label path="seizureStatusEpilepticus"> <spring:message code="label.statusEpilepticus"/></form:label>
            </li>

            <li>
                <form:checkbox id="seizureComment" path="seizureComment"
                               class="input-block-level toCheck"/>
                <form:label path="seizureComment"> <spring:message code="label.comment"/></form:label>
            </li>

            <li>
                <form:checkbox id="seizureSSCClassification" path="seizureSSCClassification"
                               class="input-block-level toCheck"/>
                <form:label path="seizureSSCClassification"> <spring:message code="label.sscClassification"/></form:label>
            </li>

            <li>
                <form:checkbox id="seizureILAEClassification" path="seizureILAEClassification"
                               class="input-block-level toCheck"/>
                <form:label
                        path="seizureILAEClassification"><spring:message code="label.ilaeClassification"/></form:label>
            </li>
            <li>
                <form:checkbox id="seizureDetailComment" path="seizureDetailComment"
                               class="input-block-level toCheck"/>
                <form:label path="seizureDetailComment"><spring:message code="label.comment"/></form:label>
            </li>
        </ul>
    </li>
    <li class="collapsed">
        <form:checkbox id="pharmacotherapy"
                       class="toCheck"
                       path="seizure"/>
        <form:label path="pharmacotherapy">
            <spring:message code="label.pharmacotherapy"/>
        </form:label>
        <ul>
            <li>
                <form:checkbox id="pharmacotherapyAED" path="pharmacotherapyAED"
                               class="input-block-level toCheck"/>
                <form:label
                        path="pharmacotherapyAED"> <spring:message code="label.aed"/>
                </form:label>
            </li>
            <li>
                <form:checkbox id="pharmacotherapyEffective" path="pharmacotherapyEffective"
                               class="input-block-level toCheck"/>
                <form:label path="pharmacotherapyEffective"> <spring:message code="label.efficiency"/></form:label>
            </li>

            <li>
                <form:checkbox id="pharmacotherapyDuringSurgery" path="pharmacotherapyDuringSurgery"
                               class="input-statusEpilepticus-level toCheck"/>
                <form:label path="pharmacotherapyDuringSurgery"> <spring:message code="label.duringSurgery"/></form:label>
            </li>

            <li>
                <form:checkbox id="pharmacotherapyComment" path="pharmacotherapyComment"
                               class="input-block-level toCheck"/>
                <form:label path="pharmacotherapyComment"> <spring:message code="label.comment"/></form:label>
            </li>
        </ul>
    </li>
    <li class="collapsed">
        <form:checkbox id="neurologicalFinding"
                       class="toCheck"
                       path="seizure"/>
        <form:label path="neurologicalFinding">
            <spring:message code="label.neurologicalFinding"/>
        </form:label>
        <ul>
            <li>
                <form:checkbox id="neurologicalFindingHemisphereDominance" path="neurologicalFindingHemisphereDominance"
                               class="input-block-level toCheck"/>
                <form:label
                        path="neurologicalFindingHemisphereDominance"> <spring:message code="label.hemisphereDominance"/>
                </form:label>
            </li>
            <li>
                <form:checkbox id="neurologicalFindingAbnormalNeurologicalFinding" path="neurologicalFindingAbnormalNeurologicalFinding"
                               class="input-block-level toCheck"/>
                <form:label path="neurologicalFindingAbnormalNeurologicalFinding"> <spring:message code="label.abnormalNeurologicalFinding"/></form:label>
            </li>

            <li>
                <form:checkbox id="neurologicalFindingHemiparesis" path="neurologicalFindingHemiparesis"
                               class="input-statusEpilepticus-level toCheck"/>
                <form:label path="neurologicalFindingHemiparesis"> <spring:message code="label.hemiparesis"/></form:label>
            </li>

            <li>
                <form:checkbox id="neurologicalFindingVisualFieldDefects" path="neurologicalFindingVisualFieldDefects"
                               class="input-block-level toCheck"/>
                <form:label path="neurologicalFindingVisualFieldDefects"> <spring:message code="label.visualFieldDefect"/></form:label>
            </li>

            <li>
                <form:checkbox id="neurologicalFindingComment" path="neurologicalFindingComment"
                               class="input-block-level toCheck"/>
                <form:label path="neurologicalFindingComment"> <spring:message code="label.comment"/></form:label>
            </li>
        </ul>
    </li>
    <li class="collapsed">
        <form:checkbox id="neuropsychology"
                       class="toCheck"
                       path="seizure"/>
        <form:label path="neuropsychology">
            <spring:message code="label.neuropsychology"/>
        </form:label>
        <ul>
            <li>
                <form:checkbox id="neuropsychologyIntellect" path="neuropsychologyIntellect"
                               class="input-block-level toCheck"/>
                <form:label
                        path="neuropsychologyIntellect"> <spring:message code="label.intellect"/>
                </form:label>
            </li>
            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExamination" path="neuropsychologyNeurodevelopmentalExamination"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExamination"> <spring:message code="label.neurodevelopmentalExamination"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationAdaptability" path="neuropsychologyNeurodevelopmentalExaminationAdaptability"
                               class="input-statusEpilepticus-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationAdaptability"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.adaptability"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively" path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.speechExpressively"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively" path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.speechReceptively"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills" path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.fineMotorSkills"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills" path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.grossMotorSkills"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSocialBehavior" path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.socialBehavior"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyIntellectualPerformance" path="neuropsychologyIntellectualPerformance"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyIntellectualPerformance"> <spring:message code="label.intellectualPerformance"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyIntellectualPerformanceVerbally" path="neuropsychologyIntellectualPerformanceVerbally"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyIntellectualPerformanceVerbally"> <spring:message code="label.intellectualPerformanceVerbally"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyIntellectualPerformanceNonverbalAbstraction" path="neuropsychologyIntellectualPerformanceNonverbalAbstraction"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyIntellectualPerformanceNonverbalAbstraction"> <spring:message code="label.intellectualPerformanceNonverbalAbstraction"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyIntellectualPerformanceNonverbalDesignCap" path="neuropsychologyIntellectualPerformanceNonverbalDesignCap"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyIntellectualPerformanceNonverbalDesignCap"> <spring:message code="label.intellectualPerformanceNonverbalDesignCapabilities"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfile" path="neuropsychologyNeuropsychologicalProfile"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfile"> <spring:message code="label.neuropsychologicalProfile"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileAttention" path="neuropsychologyNeuropsychologicalProfileAttention"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileAttention"> <spring:message code="label.attention"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileCognitiveSpeed" path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"> <spring:message code="label.cognitiveSpeed"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileExecutiveFunction" path="neuropsychologyNeuropsychologicalProfileExecutiveFunction"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileExecutiveFunction"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.executiveFunction"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileSpeechExpressively" path="neuropsychologyNeuropsychologicalProfileSpeechExpressively"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileSpeechExpressively"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.speechExpressively"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively" path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"> <spring:message code="label.neurodevelopmentalExamination"/> - <spring:message code="label.speechReceptively"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding" path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.speechUnderstanding"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryOperating" path="neuropsychologyNeuropsychologicalProfileMemoryOperating"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMemoryOperating"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.memoryOperating"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryVerbal" path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.memoryVerbal"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryNonverbal" path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.memoryNonverbal"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryLearning" path="neuropsychologyNeuropsychologicalProfileMemoryLearning"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMemoryLearning"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.memoryLearning"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionSpeech" path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.perceptionSpeech"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionVisual" path="neuropsychologyNeuropsychologicalProfilePerceptionVisual"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionVisual"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.perceptionVisual"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionSpatial" path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.perceptionSpatial"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity" path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.motorSkillsDexterity"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyNeuropsychologicalProfileMotorCoordination" path="neuropsychologyNeuropsychologicalProfileMotorCoordination"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyNeuropsychologicalProfileMotorCoordination"> <spring:message code="label.neuropsychologicalProfile"/> - <spring:message code="label.motorCoordination"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyPresenceOfChanges" path="neuropsychologyPresenceOfChanges"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyPresenceOfChanges"> <spring:message code="label.presenceOfChanges"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyPresenceOfChangesDetail" path="neuropsychologyPresenceOfChangesDetail"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyPresenceOfChangesDetail"> <spring:message code="label.presenceOfChangesDetail"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyEmotionalStatus" path="neuropsychologyEmotionalStatus"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyEmotionalStatus"> <spring:message code="label.emotionalState"/></form:label>
            </li>

            <li>
                <form:checkbox id="neuropsychologyComment" path="neuropsychologyComment"
                               class="input-block-level toCheck"/>
                <form:label path="neuropsychologyComment"> <spring:message code="label.comment"/></form:label>
            </li>

        </ul>
    </li>

</ul>
</div>
</fieldset>
</div>
</div>

</fieldset>

<fieldset>
    <legend>
        <spring:message code="label.saveParameters"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="name">
            <spring:message code="label.name"/>
        </label>

        <div class="col-xs-4">
            <form:input id="name"
                        class="input-sm form-control"
                        type="text"
                        path="name"/>
        </div>

        <div class="col-xs-2">
            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <form:checkbox id="generic"
                               path="generic"/>
                <label for="generic">
                    <spring:message code="label.generic"/>
                </label>
            </sec:authorize>
        </div>

        <div>
            <button id="saveButton"
                    class="btn btn-primary btn-sm">
                <spring:message code="label.save"/>
            </button>
        </div>
    </div>
</fieldset>

</form:form>

</div>
</div>

</jsp:body>
</t:menuLVL1>