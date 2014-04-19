<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2>

<jsp:attribute name="title">
      <spring:message code="label.patient"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.patient"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script>
            $(document).ready(function () {
                $('p.tree-toggler').click(function () {
                    $(this).parent().children('ul.tree').toggle(300);
                });
            });
        </script>

					<!--jQuery for changing action method of foorm when clicking on SAVE set-->
					<script>
                        $('#saveButton')
                                .click(
                                function () {
                                    $('#exportForm')
                                            .attr('action',
                                            '<c:url value="/patient/export/save" />');
                                    $('#exportName').attr(
                                            'value',
                                            $('#exportNameToCopy')
                                                    .val());

                                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                                    $('#isGeneric').attr(
                                            'value',
                                            $('#isGenericBox').is(
                                                    ':checked'));
                                    </sec:authorize>

                                    $('#exportForm').submit();
                                });
                    </script>
						<!--change action URL when deleting users SET-->
						<script>
                            $('#genericSetDeleteButton')
                                    .click(
                                    function () {
                                        $('#genericSets')
                                                .attr('action',
                                                '<c:url value="/patient/export/delete" />');
                                        $('#genericSets').submit();
                                    });
                        </script>
						<script>
                            $('#userSetDeleteButton')
                                    .click(
                                    function () {
                                        $('#userSets')
                                                .attr('action',
                                                '<c:url value="/patient/export/delete" />');
                                        $('#userSets').submit();
                                    });
                        </script>

	</jsp:attribute>

<jsp:body>

<div>
    <h2>
        <spring:message code="label.exportPatient"/> <a
            href="<c:url value="/patient/${patient.id}/overview" />"
            style="text-decoration: none">${patient.contact.firstName} ${patient.contact.lastName}</a>
    </h2>
</div>
<!-- Lists -->
<!-- user Lists -->
<div class="span6">
    <form id="genericSets" method="POST" action="<c:url value="/patient/export/load" />">
        <label>Generic Sets</label>

        <select name="exportId" class="input-large">
            <c:forEach items="${listOfSavedConfigurations}" var="exportParam">
                <option value="${exportParam.id}">
                        ${exportParam.name}
                </option>
            </c:forEach>
        </select>
        <c:forEach items="${patientList}" var="patient">
            <input type="hidden" name="patient" value="${patient.id}">
        </c:forEach>
        <button class="btn btn-primary" type="submit">LOAD</button>

        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <button id="genericSetDeleteButton" class="btn btn-primary" type="submit">DELETE
            </button>
        </sec:authorize>
    </form>
</div>

<!-- generic Lists -->
<div class="span6">
    <form id="userSets" method="POST" action="<c:url value="/patient/export/load" />">
        <label>My Sets</label>

        <select name="exportId" class="input-large">
            <c:forEach items="${listOfUsersSavedConfigurations}" var="exportParam">
                <option value="${exportParam.id}">
                        ${exportParam.name}
                </option>
            </c:forEach>
        </select>
        <c:forEach items="${patientList}" var="patient">
            <input type="hidden" name="patient" value="${patient.id}">
        </c:forEach>
        <button class="btn btn-primary" type="submit">LOAD</button>
        <button id="userSetDeleteButton" class="btn btn-primary" type="submit">DELETE
        </button>
    </form>
</div>
<!-- Lists END -->


<!-- Tree list -->

<div class="span3">
<form:form id="exportForm" method="POST" action="/GENEPI/patient/export" commandName="exportParams">

<!-- Hidden fields -->
<!-- Export name -->
<input id="exportName" type="hidden" name="exportName" value="">
<!-- patient ids -->
<c:forEach items="${patientList}" var="patient">
    <input type="hidden" name="patient" value="${patient.id}">
</c:forEach>
<!-- Is Generic checkbox -->
<input id="isGeneric" type="hidden" name="isGeneric" value="0">

<ul class="nav nav-list">
<li><p class="tree-toggler nav-header">Anamneza<form:checkbox
        path="anamnesis" class="input-block-level"/>
</p>
<ul class="nav nav-list tree">

<li><form:label path="anamnesisBeginningEpilepsy">anamnesisBeginningEpilepsy</form:label>
    <form:checkbox path="anamnesisBeginningEpilepsy" class="input-block-level"/></li>

<li><form:label path="anamnesisFirstFever">anamnesisFirstFever</form:label>
    <form:checkbox path="anamnesisFirstFever" class="input-block-level"/></li>

<li><form:label path="anamnesisInfantileSpasm">anamnesisInfantileSpasm</form:label>
    <form:checkbox path="anamnesisInfantileSpasm" class="input-block-level"/></li>

<li><form:label path="anamnesisSpecificSyndrome">anamnesisSpecificSyndrome</form:label>
    <form:checkbox path="anamnesisSpecificSyndrome" class="input-block-level"/></li>

<li><form:label path="anamnesisEpilepsyInFamily">anamnesisEpilepsyInFamily</form:label>
    <form:checkbox path="anamnesisEpilepsyInFamily" class="input-block-level"/></li>

<li><form:label path="anamnesisParentalRisk">anamnesisParentalRisk</form:label>
    <form:checkbox path="anamnesisParentalRisk" class="input-block-level"/></li>

<li><form:label path="anamnesisFibrilConvulsions">anamnesisFibrilConvulsions</form:label>
    <form:checkbox path="anamnesisFibrilConvulsions" class="input-block-level"/></li>
<li><form:label path="anamnesisInflammationCns">anamnesisInflammationCns</form:label>
    <form:checkbox path="anamnesisInflammationCns" class="input-block-level"/></li>

<li><form:label path="anamnesisInjuryCns">anamnesisInjuryCns</form:label>
    <form:checkbox path="anamnesisInjuryCns" class="input-block-level"/></li>

<li><form:label path="anamnesisOperationCns">anamnesisOperationCns</form:label>
    <form:checkbox path="anamnesisOperationCns" class="input-block-level"/></li>

<li><form:label path="anamnesisEarlyPmdRetardation">anamnesisEarlyPmdRetardation</form:label>
    <form:checkbox path="anamnesisEarlyPmdRetardation" class="input-block-level"/></li>

<li><form:label path="anamnesisNonCnsComorbidity"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="anamnesisNonCnsComorbidity" class="input-block-level"/></li>

<li><form:label path="anamnesisComment">anamnesisComment</form:label>
    <form:checkbox path="anamnesisComment" class="input-block-level"/></li>

<li><form:label path="complicationComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="complicationComment" class="input-block-level"/></li>
<li><form:label path="ComplicationWithCompication"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="ComplicationWithCompication" class="input-block-level"/></li>
<li><form:label path="ComplicationComplicationType"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="ComplicationComplicationType" class="input-block-level"/></li>
<li><form:label path="ComplicationComplication"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="ComplicationComplication" class="input-block-level"/></li>

<li><form:label path="diagnosticTestEEGDone"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestEEGDone" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGBasicActivity"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestEEGBasicActivity" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGSlow"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestEEGSlow" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGInterictalEEGSpikes"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGInterictalEEGSpikes" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGLocalizationInerictalEEGSpikes"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="diagnosticTestEEGLocalizationInerictalEEGSpikes"
                                                          class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGStatusEpilepticus"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGStatusEpilepticus" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGSecondarySidedSynchrony"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGSecondarySidedSynchrony" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGIctalEEGPatterns"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGIctalEEGPatterns" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGLocalizationIctalEEGPattern"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGLocalizationIctalEEGPattern" class="input-block-level"/></li>
<li><form:label path="diagnosticTestEEGComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="diagnosticTestEEGComment" class="input-block-level"/></li>

<li><form:label path="diagnosticTestEEGDescriptionVideoEEG"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestEEGDescriptionVideoEEG" class="input-block-level"/></li>

<li><form:label path="diagnosticTestMRIDone"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDone" class="input-block-level"/></li>

<li><form:label path="diagnosticTestMRIProtocol"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIProtocol" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIFdgPet"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIFdgPet" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIInterictalSpect"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIInterictalSpect" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRISiscom"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRISiscom" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIMrsProtocol"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIMrsProtocol" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIMrsFinding"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIMrsFinding" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMriFinding"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMriFinding" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescription"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDescription" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescriptionPetHypometabolism"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDescriptionPetHypometabolism" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescriptionSpectHyperperfuse"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDescriptionSpectHypoperfuse" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescriptionSpectHypoperfuse"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDescriptionMrsAbnormality" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescriptionMrsAbnormality"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDescriptionSpectHyperperfuse" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIIctalSpect"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIIctalSpect" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDti"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDti" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDtiDetailStudy"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDtiDetailStudy" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIFmri"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIFmri" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDetailsFmri"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDetailsFmri" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDetailsDtiStudy"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRIDetailsDtiStudy" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIWada"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIWada" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDetailsWada"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDetailsWada" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIDescribe"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIDescribe" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRILocalizationSpecHypoperfuse"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRILocalizationSpecHypoperfuse" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRILocalizationMrsAbnormality"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRILocalizationMrsAbnormality" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRILocalizationPetHypometabolism"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="diagnosticTestMRILocalizationPetHypometabolism"
                                                          class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRILocalizationSpecHyperperfuse"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="diagnosticTestMRILocalizationSpecHyperperfuse" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIFmriProtocols"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="diagnosticTestMRIFmriProtocols" class="input-block-level"/></li>
<li><form:label path="diagnosticTestMRIComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="diagnosticTestMRIComment" class="input-block-level"/></li>

<li><form:label path="histologyHistopathology"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="histologyHistopathology" class="input-block-level"/></li>
<li><form:label path="histologyFcdClassification"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="histologyFcdClassification" class="input-block-level"/></li>
<li><form:label path="histologyComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="histologyComment" class="input-block-level"/></li>


<li><form:label path="invasiveTestECOGDone"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="invasiveTestECOGDone" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGIntracranialElectrodes"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestECOGIntracranialElectrodes" class="input-block-level"/></li>

<li><form:label path="invasiveTestECOGIntraOperativeEcog"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestECOGIntraOperativeEcog" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGEcogPatterns"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="invasiveTestECOGEcogPatterns" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGEcogCover"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="invasiveTestECOGEcogCover" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGAfterResectionEcog"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestECOGAfterResectionEcog" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGAwakeCraniotomy"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestECOGAwakeCraniotomy" class="input-block-level"/></li>
<li><form:label path="invasiveTestECOGComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="invasiveTestECOGComment" class="input-block-level"/></li>

<li><form:label path="invasiveTestEEGDone"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="invasiveTestEEGDone" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGInvasiveMonitoring"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGInvasiveMonitoring" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGLocalizationIntracranialElectrodes"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="invasiveTestEEGLocalizationIntracranialElectrodes"
                                                          class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGIntracranialElectrodes"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGIntracranialElectrodes" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGInvasiveEEGSlow"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="invasiveTestEEGInvasiveEEGSlow" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGInvasiveEEGInterictalSpikes"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGInvasiveEEGInterictalSpikes" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes"
                                                          class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGStatusEpilepticus"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGStatusEpilepticus" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGInvasiveIctalEEGPatterns"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGInvasiveIctalEEGPatterns" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGLocalizationIctalEEGPatterns"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="invasiveTestEEGLocalizationIctalEEGPatterns" class="input-block-level"/></li>
<li><form:label path="invasiveTestEEGComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="invasiveTestEEGComment" class="input-block-level"/></li>

<li><form:label path="neurologicalFindingHemisphereDominance"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neurologicalFindingHemisphereDominance" class="input-block-level"/></li>
<li><form:label path="neurologicalFindingAbnormalNeurologicalFinding"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neurologicalFindingAbnormalNeurologicalFinding"
                                                          class="input-block-level"/></li>
<li><form:label path="neurologicalFindingHemiparesis"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="neurologicalFindingHemiparesis" class="input-block-level"/></li>
<li><form:label path="neurologicalFindingVisualFieldDefects"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neurologicalFindingVisualFieldDefects" class="input-block-level"/></li>
<li><form:label path="neurologicalFindingComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="neurologicalFindingComment" class="input-block-level"/></li>

<li><form:label path="neuropsychologyIntellect"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyIntellect" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExamination"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyNeurodevelopmentalExamination" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationAdaptability"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeurodevelopmentalExaminationAdaptability" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeurodevelopmentalExaminationSpeechExpressively" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeurodevelopmentalExaminationSpeechReceptively" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeurodevelopmentalExaminationFineMotorSkills" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyNeurodevelopmentalExaminationSocialBehavior" class="input-block-level"/></li>
<li><form:label path="neuropsychologyIntellectualPerformance"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyIntellectualPerformance" class="input-block-level"/></li>
<li><form:label path="neuropsychologyIntellectualPerformanceVerbally"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyIntellectualPerformanceVerbally"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyIntellectualPerformanceNonverbalAbstraction"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyIntellectualPerformanceNonverbalAbstraction" class="input-block-level"/></li>
<li><form:label path="neuropsychologyIntellectualPerformanceNonverbalDesignCap"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyIntellectualPerformanceNonverbalDesignCap" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfile"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyNeuropsychologicalProfile" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileAttention"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileAttention"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileExecutiveFunction"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyNeuropsychologicalProfileExecutiveFunction" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileCognitiveSpeed"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileSpeechExpressively"> <spring:message code="label.export"/></form:label>
    <form:checkbox path="neuropsychologyNeuropsychologicalProfileSpeechExpressively" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding"> <spring:message
        code="label.export"/></form:label> <form:checkbox
        path="neuropsychologyNeuropsychologicalProfileSpeechUnderstanding" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMemoryOperating"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileMemoryOperating"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileMemoryVerbal"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileMemoryNonverbal"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMemoryLearning"> <spring:message
        code="label.export"/></form:label> <form:checkbox path="neuropsychologyNeuropsychologicalProfileMemoryLearning"
                                                          class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech"> <spring:message
        code="label.perceptionSpeech"/></form:label> <form:checkbox
        path="neuropsychologyNeuropsychologicalProfilePerceptionSpeech" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfilePerceptionVisual"> <spring:message
        code="label.perceptionVisual"/></form:label> <form:checkbox
        path="neuropsychologyNeuropsychologicalProfilePerceptionVisual" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial"> <spring:message
        code="label.perceptionSpatial"/></form:label>
    <form:checkbox path="neuropsychologyNeuropsychologicalProfilePerceptionSpatial" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity"> <spring:message
        code="label.motorSkillsDexterity"/></form:label> <form:checkbox
        path="neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity" class="input-block-level"/></li>
<li><form:label path="neuropsychologyNeuropsychologicalProfileMotorCoordination"> <spring:message
        code="label.motorCoordination"/></form:label>
    <form:checkbox path="neuropsychologyNeuropsychologicalProfileMotorCoordination" class="input-block-level"/></li>
<li><form:label path="neuropsychologyPresenceOfChanges"> <spring:message code="label.presenceOfChanges"/></form:label>
    <form:checkbox path="neuropsychologyPresenceOfChanges" class="input-block-level"/></li>
<li><form:label path="neuropsychologyPresenceOfChangesDetail"> <spring:message
        code="label.presenceOfChanges"/>+" - detail"</form:label>
    <form:checkbox path="neuropsychologyPresenceOfChangesDetail" class="input-block-level"/></li>
<li><form:label path="neuropsychologyEmotionalStatus"> <spring:message code="label.emotionalState"/></form:label>
    <form:checkbox
            path="neuropsychologyEmotionalStatus" class="input-block-level"/></li>
<li><form:label path="neuropsychologyComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="neuropsychologyComment" class="input-block-level"/></li>

<li><form:label path="neuropsychologyFindingDetail"> <spring:message code="label.neurologicalFinding"/></form:label>+" -
    detail" <form:checkbox
            path="neuropsychologyFindingDetail" class="input-block-level"/></li>

<li><form:label path="operationTypeOperation"> <spring:message code="label.typeOfOperation"/></form:label>
    <form:checkbox
            path="operationTypeOperation" class="input-block-level"/></li>
<li><form:label path="operationRangeOperation"> <spring:message code="label.rangeOfOperation"/></form:label>
    <form:checkbox
            path="operationRangeOperation" class="input-block-level"/></li>
<li><form:label path="operationLocalizationOperation"> <spring:message
        code="label.localizationOfOperation"/></form:label> <form:checkbox
        path="operationLocalizationOperation" class="input-block-level"/></li>
<li><form:label path="operationMst"> <spring:message code="label.mst"/></form:label> <form:checkbox
        path="operationMst" class="input-block-level"/></li>
<li><form:label path="operationColostomy"> <spring:message code="label.calosotomy"/></form:label> <form:checkbox
        path="operationColostomy" class="input-block-level"/></li>
<li><form:label path="operationVNS"> <spring:message code="label.vns"/></form:label> <form:checkbox
        path="operationVNS" class="input-block-level"/></li>
<li><form:label path="operationVNsImplantationDate"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="operationVNsImplantationDate" class="input-block-level"/></li>
<li><form:label path="operationOperationDetails"> <spring:message code="label.operationDetails"/></form:label>
    <form:checkbox
            path="operationOperationDetails" class="input-block-level"/></li>
<li><form:label path="operationCompleteResection"> <spring:message code="label.completeResection"/></form:label>
    <form:checkbox
            path="operationCompleteResection" class="input-block-level"/></li>
<li><form:label path="operationComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="operationComment" class="input-block-level"/></li>
<li><form:label path="outcomeDate"> <spring:message code="label.dateOfOperation"/></form:label> <form:checkbox
        path="outcomeDate"
        class="input-block-level"/></li>
<li><form:label path="outcomeAdded"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="outcomeAdded" class="input-block-level"/></li>
<li><form:label path="outcomeFinallySeizures"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="outcomeFinallySeizures" class="input-block-level"/></li>

<li><form:label path="outcomeEEG"> <spring:message code="label.export"/></form:label> <form:checkbox path="outcomeEEG"
                                                                                                     class="input-block-level"/></li>
<li><form:label path="outcomeAED"> <spring:message code="label.export"/></form:label> <form:checkbox path="outcomeAED"
                                                                                                     class="input-block-level"/></li>
<li><form:label path="outcomeMRI"> <spring:message code="label.export"/></form:label> <form:checkbox path="outcomeMRI"
                                                                                                     class="input-block-level"/></li>
<li><form:label path="outcomeNeuropsychology"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="outcomeNeuropsychology" class="input-block-level"/></li>
<li><form:label path="outcomeComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="outcomeComment" class="input-block-level"/></li>

<li><form:label path="outcomeSeizureOutcome"> <spring:message code="label.seizureOutcome"/></form:label> <form:checkbox
        path="outcomeSeizureOutcome" class="input-block-level"/></li>
<li><form:label path="outcomeDistance"> <spring:message code="label.export"/></form:label> <form:checkbox
        path="outcomeDistance" class="input-block-level"/></li>


<li><form:label path="pharmacotherapyAED"> <spring:message code="label.aed"/></form:label> <form:checkbox
        path="pharmacotherapyAED" class="input-block-level"/></li>
<li><form:label path="pharmacotherapyEffective"> <spring:message code="label.efficiency"/></form:label> <form:checkbox
        path="pharmacotherapyEffective" class="input-block-level"/></li>
<li><form:label path="pharmacotherapyDuringSurgery"> <spring:message code="label.duringSurgery"/></form:label>
    <form:checkbox
            path="pharmacotherapyDuringSurgery" class="input-block-level"/></li>
<li><form:label path="pharmacotherapyComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="pharmacotherapyComment" class="input-block-level"/></li>

<li><form:label path="neuropsychologyOldComment"> <spring:message code="label.comment"/></form:label> <form:checkbox
        path="neuropsychologyOldComment" class="input-block-level"/></li>

<li><form:label path="neuropsychologyOldNeuropsychologicalExamination"> <spring:message
        code="label.neuropsychologicalExamination"/></form:label> <form:checkbox
        path="neuropsychologyOldNeuropsychologicalExamination"
        class="input-block-level"/></li>
<li><form:label path="neuropsychologyOldIntelligenceLevel"> <spring:message
        code="label.intelligenceLevel"/></form:label>
    <form:checkbox path="neuropsychologyOldIntelligenceLevel" class="input-block-level"/></li>
<li><form:label path="neuropsychologyOldSpecificLearning"> <spring:message code="label.specificLearning"/></form:label>
    <form:checkbox path="neuropsychologyOldSpecificLearning" class="input-block-level"/></li>
<li><form:label path="neuropsychologyOldDevelopmentalLanguageDisorders"> <spring:message
        code="label.developmentalLanguageDisorders"/></form:label> <form:checkbox
        path="neuropsychologyOldDevelopmentalLanguageDisorders"
        class="input-block-level"/></li>
<li><form:label path="neuropsychologyOldAdhdSyndrome"> <spring:message code="label.adhdSyndrome"/></form:label>
    <form:checkbox
            path="neuropsychologyOldAdhdSyndrome" class="input-block-level"/></li>

<li><form:label path="invasiveTestCorticalMappingComment"> <spring:message code="label.comment"/></form:label>
    <form:checkbox path="invasiveTestCorticalMappingComment" class="input-block-level"/></li>

<li><form:label path="invasiveTestCorticalMappingDone"> <spring:message code="label.corticalMappingDone"/></form:label>
    <form:checkbox path="invasiveTestCorticalMappingDone" class="input-block-level"/></li>
<li><form:label path="invasiveTestCorticalMappingCorticalMapping"> <spring:message
        code="label.invasiveTestCorticalMapping"/></form:label>
    <form:checkbox path="invasiveTestCorticalMappingCorticalMapping" class="input-block-level"/></li>


</ul>
</li>

<li><p class="tree-toggler nav-header">Zachvaty<form:checkbox
        path="seizure" class="input-block-level"/>
</p>
    <ul class="nav nav-list tree">
        <li><form:label path="seizureComment">seizureComment</form:label>
            <form:checkbox path="seizureComment" class="input-block-level"/></li>

        <li><form:label path="seizureDetailComment">seizureDetailComment</form:label>
            <form:checkbox path="seizureDetailComment" class="input-block-level"/></li>

        <li><form:label path="seizureFrequency">seizureFrequency</form:label>
            <form:checkbox path="seizureFrequency" class="input-block-level"/></li>


        <li><form:label
                path="SeizureSecondarilyGeneralizedSeizure">SeizureSecondarilyGeneralizedSeizure</form:label>
            <form:checkbox path="SeizureSecondarilyGeneralizedSeizure" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileAwakeEpi">SeizureSeizuresWhileAwakeEpi</form:label>
            <form:checkbox path="SeizureSeizuresWhileAwakeEpi" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileAwakeNonEpi">SeizureSeizuresWhileAwakeNonEpi</form:label>
            <form:checkbox path="SeizureSeizuresWhileAwakeNonEpi" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileAwakeLatent">SeizureSeizuresWhileAwakeLatent</form:label>
            <form:checkbox path="SeizureSeizuresWhileAwakeLatent" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileSleepEpi">SeizureSeizuresWhileSleepEpi</form:label>
            <form:checkbox path="SeizureSeizuresWhileSleepEpi" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileSleepLatent">SeizureSeizuresWhileSleepLatent</form:label>
            <form:checkbox path="SeizureSeizuresWhileSleepLatent" class="input-block-level"/></li>
        <li><form:label path="SeizureSeizuresWhileSleepNonEpi">SeizureSeizuresWhileSleepNonEpi</form:label>
            <form:checkbox path="SeizureSeizuresWhileSleepNonEpi" class="input-block-level"/></li>

        <li><form:label path="seizureSSCClassification"><spring:message code="label.sscClassification"/></form:label>
            <form:checkbox path="seizureSSCClassification" class="input-block-level"/>
        </li>
        <li><form:label path="seizureILAEClassification"><spring:message
                code="label.ilaeClassification"/></form:label><form:checkbox path="seizureILAEClassification"
                                                                             class="input-block-level"/></li>

        <li><form:label path="anonymize"><spring:message
                code="label.anonymize"/></form:label><form:checkbox path="anonymize"
                                                                    class="input-block-level"/></li>

    </ul>
</li>

<li><p class="tree-toggler nav-header">Dalsi <input
        type="checkbox">
</p>
    <ul class="nav nav-list tree">
        <li>Link <input type="checkbox"></li>
        <li>Link <input type="checkbox"></li>
    </ul>
</li>
</ul>


<!-- Tree list END -->

<div class="control-group span6">
    <label class="control-label" for="pdfFormat">Formát</label>

    <div class="controls">
        <input type="radio" id="pdfFormat" name="exportType" value="pdf" checked> pdf
        <input type="radio" id="xlsxFormat" name="exportType" value="xlsx"> xlsx
        <input type="radio" id="docxFormat" name="exportType" value="docx"> docx
        <input type="radio" id="txtFormat" name="exportType" value="txt"> txt
        <input type="radio" id="csvFormat" name="exportType" value="csv"> csv
    </div>
</div>

<div class="control-group span6">
    <div class="controls">
        <button id="exportButton" type="submit" class="btn btn-primary">
            <spring:message code="label.export"/>
        </button>
    </div>
</div>
</form:form>

<div class="span6">
    <p>Uložit sestavu</p>
    <input id="exportNameToCopy" type="text">

    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <input id="isGenericBox" type="checkbox" name="isGeneric">Is Generic???
    </sec:authorize>
    <button id="saveButton" class="btn btn-primary" type="submit">SAVE</button>
</div>

</div>
</jsp:body>
</t:menuLVL2>
