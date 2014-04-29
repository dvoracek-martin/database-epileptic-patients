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

                    <sec:authorize ifAnyGranted="ROLE_SUPER_DOCTOR">
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

            <div id="tableOption"
                 class="form-group">
                <div class="col-sm-offset-3 col-sm-9">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="toTable"/>
                                 <spring:message code="label.toTable"/>
                        </label>
                    </div>
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

<div class="checkbox col-xs-offset-1">
    <label>
        <input id="checkAll" type="checkbox" checked>  <spring:message code="label.checkUncheckAll"/>
    </label>
</div>

<div id="tree"
     class="col-xs-offset-1 col-xs-12">
<ul>

<li class="collapsed">
    <form:checkbox id="anamnesis"
                   class="toCheck check-all"
                   path="anamnesis"/>
    <form:label path="anamnesis">
        <spring:message code="label.anamnesis"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="anamnesisBeginningEpilepsy" path="anamnesisBeginningEpilepsy"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="anamnesisBeginningEpilepsy"><spring:message code="label.beginningEpilepsy"/></form:label>
        </li>
        <li>
            <form:checkbox id="anamnesisFirstFever" path="anamnesisFirstFever"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisFirstFever"><spring:message code="label.firstFever"/></form:label>
        </li>
        <li>
            <form:checkbox id="anamnesisInfantileSpasm" path="anamnesisInfantileSpasm"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisInfantileSpasm"><spring:message code="label.infantileSpasm"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisSpecificSyndrome" path="anamnesisSpecificSyndrome"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisSpecificSyndrome"><spring:message code="label.epilepticSyndrome"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisEpilepsyInFamily" path="anamnesisEpilepsyInFamily"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisEpilepsyInFamily"><spring:message code="label.epilepsyInFamily"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisParentalRisk" path="anamnesisParentalRisk"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisParentalRisk"><spring:message code="label.prenatalRisk"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisFibrilConvulsions" path="anamnesisFibrilConvulsions"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="anamnesisFibrilConvulsions"><spring:message code="label.fibrilConvulsions"/></form:label>
        </li>
        <li>
            <form:checkbox id="anamnesisInflammationCns" path="anamnesisInflammationCns"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisInflammationCns"><spring:message code="label.inflammationCns"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisInjuryCns" path="anamnesisInjuryCns"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisInjuryCns"><spring:message code="label.injuryCns"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisOperationCns" path="anamnesisOperationCns"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisOperationCns"><spring:message code="label.operationCns"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisEarlyPmdRetardation" path="anamnesisEarlyPmdRetardation"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="anamnesisEarlyPmdRetardation"><spring:message code="label.earlyPmdRetardation"/></form:label>
        </li>

        <li>
            <form:checkbox id="anamnesisNonCnsComorbidity" path="anamnesisNonCnsComorbidity"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="anamnesisNonCnsComorbidity"><spring:message code="label.nonCnsComorbidity"/></form:label>
        </li>
        <li>
            <form:checkbox id="anamnesisComment" path="anamnesisComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="anamnesisComment"><spring:message code="label.comment"/></form:label>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="seizure"
                   class="toCheck check-all"
                   path="seizure"/>
    <form:label path="seizure">
        <spring:message code="label.seizures"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="seizureFrequency" path="seizureFrequency"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="seizureFrequency"><spring:message code="label.seizureFrequency"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="seizureSecondarilyGeneralizedSeizure" path="seizureSecondarilyGeneralizedSeizure"
                           class="input-block-level toCheck check-all"/>
            <form:label path="seizureSecondarilyGeneralizedSeizure"><spring:message
                    code="label.secondarilyGeneralizedSeizure"/></form:label>
        </li>

        <li>
            <form:checkbox id="seizureStatusEpilepticus" path="seizureStatusEpilepticus"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="seizureStatusEpilepticus"><spring:message code="label.statusEpilepticus"/></form:label>
        </li>

        <li>
            <form:checkbox id="seizureComment" path="seizureComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="seizureComment"><spring:message code="label.comment"/></form:label>
        </li>

        <li>
            <form:checkbox id="seizureSSCClassification" path="seizureSSCClassification"
                           class="input-block-level toCheck check-all"/>
            <form:label path="seizureSSCClassification"><spring:message code="label.seizureDetail"/> - <spring:message code="label.sscClassification"/></form:label>
        </li>

        <li>
            <form:checkbox id="seizureILAEClassification" path="seizureILAEClassification"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="seizureILAEClassification"><spring:message code="label.seizureDetail"/> - <spring:message code="label.ilaeClassification"/></form:label>
        </li>
        <li>
            <form:checkbox id="seizureDetailComment" path="seizureDetailComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="seizureDetailComment"><spring:message code="label.seizureDetail"/> - <spring:message code="label.comment"/></form:label>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="pharmacotherapy"
                   class="toCheck check-all"
                   path="pharmacotherapy"/>
    <form:label path="pharmacotherapy">
        <spring:message code="label.pharmacotherapy"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="pharmacotherapyAED" path="pharmacotherapyAED"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="pharmacotherapyAED"><spring:message code="label.aed"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="pharmacotherapyEffective" path="pharmacotherapyEffective"
                           class="input-block-level toCheck check-all"/>
            <form:label path="pharmacotherapyEffective"><spring:message code="label.efficiency"/></form:label>
        </li>

        <li>
            <form:checkbox id="pharmacotherapyDuringSurgery" path="pharmacotherapyDuringSurgery"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="pharmacotherapyDuringSurgery"><spring:message code="label.duringSurgery"/></form:label>
        </li>

        <li>
            <form:checkbox id="pharmacotherapyComment" path="pharmacotherapyComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="pharmacotherapyComment"><spring:message code="label.comment"/></form:label>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="neurologicalFinding"
                   class="toCheck check-all"
                   path="neurologicalFinding"/>
    <form:label path="neurologicalFinding">
        <spring:message code="label.neurologicalFinding"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="neurologicalFindingHemisphereDominance" path="neurologicalFindingHemisphereDominance"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="neurologicalFindingHemisphereDominance"><spring:message code="label.hemisphereDominance"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="neurologicalFindingAbnormalNeurologicalFinding"
                           path="neurologicalFindingAbnormalNeurologicalFinding"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neurologicalFindingAbnormalNeurologicalFinding"><spring:message
                    code="label.abnormalNeurologicalFinding"/></form:label>
        </li>

        <li>
            <form:checkbox id="neurologicalFindingHemiparesis" path="neurologicalFindingHemiparesis"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neurologicalFindingHemiparesis"><spring:message code="label.hemiparesis"/></form:label>
        </li>

        <li>
            <form:checkbox id="neurologicalFindingVisualFieldDefects" path="neurologicalFindingVisualFieldDefects"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neurologicalFindingVisualFieldDefects"><spring:message
                    code="label.visualFieldDefect"/></form:label>
        </li>

        <li>
            <form:checkbox id="neurologicalFindingComment" path="neurologicalFindingComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neurologicalFindingComment"><spring:message code="label.comment"/></form:label>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="neuropsychology"
                   class="toCheck check-all"
                   path="neuropsychology"/>
    <form:label path="neuropsychology">
        <spring:message code="label.neuropsychology"/>
    </form:label>
    <ul>
    <li class="collapsed">
            <form:checkbox id="neuropsychologyIntellect" path="neuropsychologyIntellect"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="neuropsychologyIntellect"><spring:message code="label.intellect"/>
            </form:label>
            <ul>
        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExamination"
                           path="neuropsychologyNeurodevelopmentalExamination"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExamination"><spring:message
                    code="label.neurodevelopmentalExamination"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationAdaptability"
                           path="neuropsychologyNeurodevelopmentalExaminationAdaptability"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationAdaptability"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.adaptability"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"
                           path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.speechExpressively"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"
                           path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.speechReceptively"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"
                           path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.fineMotorSkills"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"
                           path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.grossMotorSkills"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"
                           path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"><spring:message
                    code="label.neurodevelopmentalExamination"/> - <spring:message
                    code="label.socialBehavior"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyIntellectualPerformance" path="neuropsychologyIntellectualPerformance"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyIntellectualPerformance"><spring:message
                    code="label.intellectualPerformance"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyIntellectualPerformanceVerbally"
                           path="neuropsychologyIntellectualPerformanceVerbally"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyIntellectualPerformanceVerbally"><spring:message
                    code="label.intellectualPerformanceVerbally"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyIntellectualPerformanceNonverbalAbstraction"
                           path="neuropsychologyIntellectualPerformanceNonverbalAbstraction"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyIntellectualPerformanceNonverbalAbstraction"><spring:message
                    code="label.intellectualPerformanceNonverbalAbstraction"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyIntellectualPerformanceNonverbalDesignCap"
                           path="neuropsychologyIntellectualPerformanceNonverbalDesignCap"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyIntellectualPerformanceNonverbalDesignCap"><spring:message
                    code="label.intellectualPerformanceNonverbalDesignCapabilities"/></form:label>
        </li>
</ul>
    </li>
    <li class="collapsed">
            <form:checkbox id="neuropsychologyNeuropsychologicalProfile" path="neuropsychologyNeuropsychologicalProfile"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfile"><spring:message
                    code="label.neuropsychologicalProfile"/></form:label>
       <ul>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileAttention"
                           path="neuropsychologyNeuropsychologicalProfileAttention"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileAttention"><spring:message
                    code="label.neuropsychologicalProfile"/> -<spring:message code="label.attention"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"
                           path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.cognitiveSpeed"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileExecutiveFunction"
                           path="neuropsychologyNeuropsychologicalProfileExecutiveFunction"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileExecutiveFunction"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.executiveFunction"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileSpeechExpressively"
                           path="neuropsychologyNeuropsychologicalProfileSpeechExpressively"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileSpeechExpressively"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.speechExpressively"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"
                           path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.speechUnderstanding"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryOperating"
                           path="neuropsychologyNeuropsychologicalProfileMemoryOperating"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMemoryOperating"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.memoryOperating"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryVerbal"
                           path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message code="label.memoryVerbal"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"
                           path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.memoryNonverbal"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMemoryLearning"
                           path="neuropsychologyNeuropsychologicalProfileMemoryLearning"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMemoryLearning"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.memoryLearning"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"
                           path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.perceptionSpeech"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionVisual"
                           path="neuropsychologyNeuropsychologicalProfilePerceptionVisual"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionVisual"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.perceptionVisual"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"
                           path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.perceptionSpatial"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"
                           path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.motorSkillsDexterity"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyNeuropsychologicalProfileMotorCoordination"
                           path="neuropsychologyNeuropsychologicalProfileMotorCoordination"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyNeuropsychologicalProfileMotorCoordination"><spring:message
                    code="label.neuropsychologicalProfile"/> - <spring:message
                    code="label.motorCoordination"/></form:label>
        </li>
       </ul>
    </li>
        <li>
            <form:checkbox id="neuropsychologyPresenceOfChanges" path="neuropsychologyPresenceOfChanges"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyPresenceOfChanges"><spring:message
                    code="label.presenceOfChanges"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyPresenceOfChangesDetail" path="neuropsychologyPresenceOfChangesDetail"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyPresenceOfChangesDetail"><spring:message
                    code="label.presenceOfChangesDetail"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyEmotionalStatus" path="neuropsychologyEmotionalStatus"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyEmotionalStatus"><spring:message
                    code="label.emotionalState"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyComment" path="neuropsychologyComment"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyComment"><spring:message code="label.comment"/></form:label>
        </li>

    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="neuropsychologyOld"
                   class="toCheck check-all"
                   path="neuropsychologyOld"/>
    <form:label path="neuropsychologyOld">
        <spring:message code="label.neuropsychologyOld"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="neuropsychologyOldNeuropsychologicalExamination"
                           path="neuropsychologyOldNeuropsychologicalExamination"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="neuropsychologyOldNeuropsychologicalExamination"><spring:message
                    code="label.neuropsychologicalExamination"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="neuropsychologyOldIntelligenceLevel" path="neuropsychologyOldIntelligenceLevel"
                           class="input-block-level toCheck check-all"/>
            <form:label path="neuropsychologyOldIntelligenceLevel"><spring:message
                    code="label.intelligenceLevel"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyOldSpecificLearning" path="neuropsychologyOldSpecificLearning"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neuropsychologyOldSpecificLearning"><spring:message
                    code="label.specificLearning"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyOldDevelopmentalLanguageDisorders"
                           path="neuropsychologyOldDevelopmentalLanguageDisorders"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neuropsychologyOldDevelopmentalLanguageDisorders"><spring:message
                    code="label.developmentalLanguageDisorders"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyOldAdhdSyndrome" path="neuropsychologyOldAdhdSyndrome"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neuropsychologyOldAdhdSyndrome"><spring:message code="label.adhdSyndrome"/></form:label>
        </li>

        <li>
            <form:checkbox id="neuropsychologyOldComment" path="neuropsychologyOldComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="neuropsychologyOldComment"><spring:message code="label.comment"/></form:label>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="diagnosticTestEEG"
                   class="toCheck check-all"
                   path="diagnosticTestEEG"/>
    <form:label path="diagnosticTestEEG">
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </form:label>
    <ul>

        <li class="collapsed">
            <form:checkbox id="diagnosticTestEEGDone" path="diagnosticTestEEGDone"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="diagnosticTestEEGDone"><spring:message code="label.eegDone"/>
            </form:label>
        <ul>
        <li>
            <form:checkbox id="diagnosticTestEEGBasicActivity" path="diagnosticTestEEGBasicActivity"
                           class="input-block-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGBasicActivity"><spring:message
                    code="label.basicEegActivity"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGSlow" path="diagnosticTestEEGSlow"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGSlow"><spring:message code="label.eegSlow"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGInterictalEEGSpikes" path="diagnosticTestEEGInterictalEEGSpikes"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGInterictalEEGSpikes"><spring:message code="label.interictalEegSpikes"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGLocalizationInerictalEEGSpikes"
                           path="diagnosticTestEEGLocalizationInerictalEEGSpikes"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGLocalizationInerictalEEGSpikes"><spring:message
                    code="label.localizationInterictalEegSpikes"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGStatusEpilepticus" path="diagnosticTestEEGStatusEpilepticus"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGStatusEpilepticus"><spring:message
                    code="label.eegStatusEpilepticus"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGSecondarySidedSynchrony" path="diagnosticTestEEGSecondarySidedSynchrony"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGSecondarySidedSynchrony"><spring:message
                    code="label.secondarySidedSynchrony"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGIctalEEGPatterns" path="diagnosticTestEEGIctalEEGPatterns"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGIctalEEGPatterns"><spring:message
                    code="label.ictalEegPatterns"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGDescriptionVideoEEG" path="diagnosticTestEEGDescriptionVideoEEG"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGDescriptionVideoEEG"><spring:message code="label.descriptionVideoEeg"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestEEGComment" path="diagnosticTestEEGComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestEEGComment"><spring:message code="label.comment"/></form:label>
        </li>
            </ul>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="diagnosticTestMRI"
                   class="toCheck check-all"
                   path="diagnosticTestMRI"/>
    <form:label path="diagnosticTestMRI">
        <spring:message code="label.diagnosticTestMri"/>
    </form:label>
    <ul>

        <li class="collapsed">
            <form:checkbox id="diagnosticTestMRIDone" path="diagnosticTestMRIDone"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="diagnosticTestMRIDone"><spring:message code="label.mri_done"/>
            </form:label>
        <ul>
        <li>
            <form:checkbox id="diagnosticTestMRIFinding" path="diagnosticTestMRIFinding"
                           class="input-block-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIFinding"><spring:message code="label.mriFinding"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDescription" path="diagnosticTestMRIDescription"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDescription"><spring:message code="label.descriptionMri"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIFdgPet" path="diagnosticTestMRIFdgPet"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIFdgPet"><spring:message code="label.fdgPet"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDescriptionPetHypometabolism"
                           path="diagnosticTestMRIDescriptionPetHypometabolism"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDescriptionPetHypometabolism"><spring:message
                    code="label.descriptionPetHypometabolism"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIInterictalSpect" path="diagnosticTestMRIInterictalSpect"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIInterictalSpect"><spring:message
                    code="label.interictalSpect"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDescriptionSpectHypoperfuse"
                           path="diagnosticTestMRIDescriptionSpectHypoperfuse"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDescriptionSpectHypoperfuse"><spring:message
                    code="label.descriptionSpectHypoperfuse"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIIctalSpect" path="diagnosticTestMRIIctalSpect"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIIctalSpect"><spring:message code="label.ictalSpect"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDescriptionSpectHyperperfuse"
                           path="diagnosticTestMRIDescriptionSpectHyperperfuse"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDescriptionSpectHyperperfuse"><spring:message
                    code="label.descriptionSpectHyperperfuse"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRISiscom" path="diagnosticTestMRISiscom"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRISiscom"><spring:message code="label.siscom"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIMrsProtocol" path="diagnosticTestMRIMrsProtocol"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIMrsProtocol"><spring:message code="label.mrsProtocol"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDescriptionMrsAbnormality"
                           path="diagnosticTestMRIDescriptionMrsAbnormality"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDescriptionMrsAbnormality"><spring:message
                    code="label.descriptionMrsAbnormality"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIFmri" path="diagnosticTestMRIFmri"
                           class="input-statusEpilepticus-level toCiagnosticTestMRIMrsFindingheck"/>
            <form:label path="diagnosticTestMRIFmri"><spring:message code="label.fmri"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDetailsFmri" path="diagnosticTestMRIDetailsFmri"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDetailsFmri"><spring:message code="label.fmriDetails"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDti" path="diagnosticTestMRIDti"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDti"><spring:message code="label.dti"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDetailsDtiStudy" path="diagnosticTestMRIDetailsDtiStudy"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDetailsDtiStudy"><spring:message
                    code="label.dtiStudyDetails"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIWada" path="diagnosticTestMRIWada"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIWada"><spring:message code="label.wada"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIDetailsWada" path="diagnosticTestMRIDetailsWada"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIDetailsWada"><spring:message code="label.wadaDetails"/></form:label>
        </li>

        <li>
            <form:checkbox id="diagnosticTestMRIComment" path="diagnosticTestMRIComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="diagnosticTestMRIComment"><spring:message code="label.comment"/></form:label>
        </li>
            </ul>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="invasiveTestECOG"
                   class="toCheck check-all"
                   path="invasiveTestECOG"/>
    <form:label path="invasiveTestECOG">
        <spring:message code="label.invasiveTestECoG"/>
    </form:label>
    <ul>

        <li class="collapsed">
            <form:checkbox id="invasiveTestECOGDone" path="invasiveTestECOGDone"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="invasiveTestECOGDone"><spring:message code="label.ecogDone"/>
            </form:label>
        <ul>
        <li>
            <form:checkbox id="invasiveTestECOGEcogCover" path="invasiveTestECOGEcogCover"
                           class="input-block-level toCheck check-all"/>
            <form:label path="invasiveTestECOGEcogCover"><spring:message code="label.ecogCover"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestECOGEcogPatterns" path="invasiveTestECOGEcogPatterns"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestECOGEcogPatterns"><spring:message code="label.ecogPatterns"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestECOGAfterResectionEcog" path="invasiveTestECOGAfterResectionEcog"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestECOGAfterResectionEcog"><spring:message
                    code="label.ecogAfterResection"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestECOGComment" path="invasiveTestECOGComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestECOGComment"><spring:message code="label.comment"/></form:label>
        </li>
            </ul>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="invasiveTestEEG"
                   class="toCheck check-all"
                   path="invasiveTestEEG"/>
    <form:label path="invasiveTestEEG">
        <spring:message code="label.invasiveTestIeeg"/>
    </form:label>
    <ul>
        <li class="collapsed">
            <form:checkbox id="invasiveTestEEGDone" path="invasiveTestEEGDone"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="invasiveTestEEGDone"><spring:message code="label.ieegDone"/>
            </form:label>
<ul>
        <li>
            <form:checkbox id="invasiveTestEEGIntracranialElectrodes" path="invasiveTestEEGIntracranialElectrodes"
                           class="input-block-level toCheck check-all"/>
            <form:label path="invasiveTestEEGIntracranialElectrodes"><spring:message
                    code="label.intracranialElectrodes"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGLocalizationIntracranialElectrodes"
                           path="invasiveTestEEGLocalizationIntracranialElectrodes"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGLocalizationIntracranialElectrodes"><spring:message
                    code="label.localizationIntracranialElectrodes"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGInvasiveEEGSlow" path="invasiveTestEEGInvasiveEEGSlow"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGInvasiveEEGSlow"><spring:message code="label.eegSlow"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGInvasiveEEGInterictalSpikes"
                           path="invasiveTestEEGInvasiveEEGInterictalSpikes"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGInvasiveEEGInterictalSpikes"><spring:message
                    code="label.interictalEegSpikes"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes"
                           path="invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes"><spring:message
                    code="label.localizationInvasiveEegInterictalSpikes"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGStatusEpilepticus" path="invasiveTestEEGStatusEpilepticus"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGStatusEpilepticus"><spring:message
                    code="label.invasiveEegStatusEpilepticus"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGInvasiveIctalEEGPatterns" path="invasiveTestEEGInvasiveIctalEEGPatterns"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGInvasiveIctalEEGPatterns"><spring:message code="label.ictalEegPatterns"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGLocalizationIctalEEGPatterns"
                           path="invasiveTestEEGLocalizationIctalEEGPatterns"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGLocalizationIctalEEGPatterns"><spring:message
                    code="label.localizationIctalEegPattern"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestEEGComment" path="invasiveTestEEGComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestEEGComment"><spring:message code="label.comment"/></form:label>
        </li>
    </ul>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="invasiveTestCorticalMapping"
                   class="toCheck check-all"
                   path="invasiveTestCorticalMapping"/>
    <form:label path="invasiveTestCorticalMapping">
        <spring:message code="label.invasiveTestCorticalMapping"/>
    </form:label>
    <ul>

        <li class="collapsed">
            <form:checkbox id="invasiveTestCorticalMappingDone" path="invasiveTestCorticalMappingDone"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="invasiveTestCorticalMappingDone"><spring:message code="label.corticalMappingDone"/>
            </form:label>
        <ul>
        <li>
            <form:checkbox id="invasiveTestCorticalMappingCorticalMapping"
                           path="invasiveTestCorticalMappingCorticalMapping"
                           class="input-block-level toCheck check-all"/>
            <form:label path="invasiveTestCorticalMappingCorticalMapping"><spring:message
                    code="label.corticalMapping"/></form:label>
        </li>

        <li>
            <form:checkbox id="invasiveTestCorticalMappingComment" path="invasiveTestCorticalMappingComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="invasiveTestCorticalMappingComment"><spring:message code="label.comment"/></form:label>
        </li>
            </ul>
        </li>
    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="operation"
                   class="toCheck check-all"
                   path="operation"/>
    <form:label path="operation">
        <spring:message code="label.operation"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="operationDateOperation" path="operationDateOperation"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="operationDateOperation"><spring:message code="label.dateOfOperation"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="operationRangeOperation" path="operationRangeOperation"
                           class="input-block-level toCheck check-all"/>
            <form:label path="operationRangeOperation"><spring:message code="label.rangeOfOperation"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationTypeOperation" path="operationTypeOperation"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationTypeOperation"><spring:message code="label.typeOfOperation"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationLocalizationOperation" path="operationLocalizationOperation"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationLocalizationOperation"><spring:message
                    code="label.localizationOfOperation"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationMst" path="operationMst"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationMst"><spring:message code="label.mst"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationColostomy" path="operationColostomy"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationColostomy"><spring:message code="label.calosotomy"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationVNS" path="operationVNS"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationVNS"><spring:message code="label.vns"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationVNsImplantationDate" path="operationVNsImplantationDate"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationVNsImplantationDate"><spring:message
                    code="label.vnsImplantationDate"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationOperationDetails" path="operationOperationDetails"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationOperationDetails"><spring:message code="label.operationDetails"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationCompleteResection" path="operationCompleteResection"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationCompleteResection"><spring:message code="label.completeResection"/></form:label>
        </li>

        <li>
            <form:checkbox id="operationComment" path="operationComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="operationComment"><spring:message code="label.comment"/></form:label>
        </li>

    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="histology"
                   class="toCheck check-all"
                   path="histology"/>
    <form:label path="histology">
        <spring:message code="label.histology"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="histologyHistopathology" path="histologyHistopathology"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="histologyHistopathology"><spring:message code="label.histopathology"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="histologyFcdClassification" path="histologyFcdClassification"
                           class="input-block-level toCheck check-all"/>
            <form:label path="histologyFcdClassification"><spring:message code="label.fcdClassification"/></form:label>
        </li>

        <li>
            <form:checkbox id="histologyComment" path="histologyComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="histologyComment"><spring:message code="label.comment"/></form:label>
        </li>

    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="complication"
                   class="toCheck check-all"
                   path="complication"/>
    <form:label path="complication">
        <spring:message code="label.complication"/>
    </form:label>
    <ul>

        <li class="collapsed">
            <form:checkbox id="complicationWithCompication" path="complicationWithCompication"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="complicationWithCompication"><spring:message code="label.process"/>
            </form:label>
       <ul>
        <li>
            <form:checkbox id="complicationComplicationType" path="complicationComplicationType"
                           class="input-block-level toCheck check-all"/>
            <form:label path="complicationComplicationType"><spring:message
                    code="label.typeComplication"/></form:label>
        </li>

        <li>
            <form:checkbox id="complicationComplication" path="complicationComplication"
                           class="input-block-level toCheck check-all"/>
            <form:label path="complicationComplication"><spring:message code="label.complication"/></form:label>
        </li>
        <li>
            <form:checkbox id="complicationComplicationType" path="complicationComplicationType"
                           class="input-block-level toCheck check-all"/>
            <form:label path="complicationComplicationType"><spring:message
                    code="label.typeComplication"/></form:label>
        </li>

        <li>
            <form:checkbox id="complicationComment" path="complicationComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="complicationComment"><spring:message code="label.comment"/></form:label>
        </li>
           </ul>
        </li>

    </ul>
</li>
<li class="collapsed">
    <form:checkbox id="outcome"
                   class="toCheck check-all"
                   path="outcome"/>
    <form:label path="outcome">
        <spring:message code="label.outcome"/>
    </form:label>
    <ul>
        <li>
            <form:checkbox id="outcomeSeizureOutcome" path="outcomeSeizureOutcome"
                           class="input-block-level toCheck check-all"/>
            <form:label
                    path="outcomeSeizureOutcome"><spring:message code="label.seizures"/>
            </form:label>
        </li>
        <li>
            <form:checkbox id="outcomeEEG" path="outcomeEEG"
                           class="input-block-level toCheck check-all"/>
            <form:label path="outcomeEEG"><spring:message code="label.eeg"/></form:label>
        </li>

        <li>
            <form:checkbox id="outcomeAED" path="outcomeAED"
                           class="input-block-level toCheck check-all"/>
            <form:label path="outcomeAED"><spring:message code="label.aed"/></form:label>
        </li>
        <li>
            <form:checkbox id="outcomeMRI" path="outcomeMRI"
                           class="input-block-level toCheck check-all"/>
            <form:label path="outcomeMRI"><spring:message code="label.mri"/></form:label>
        </li>

        <li>
            <form:checkbox id="outcomeNeuropsychology" path="outcomeNeuropsychology"
                           class="input-block-level toCheck check-all"/>
            <form:label path="outcomeNeuropsychology"><spring:message code="label.neuropsychology"/></form:label>
        </li>

        <li>
            <form:checkbox id="outcomeComment" path="outcomeComment"
                           class="input-statusEpilepticus-level toCheck check-all"/>
            <form:label path="outcomeComment"><spring:message code="label.comment"/></form:label>
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
            <sec:authorize ifAnyGranted="ROLE_SUPERDOCTOR">
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