<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2.NEW303>

<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.NEW303.js" />"></script>
    </jsp:attribute>

<jsp:body>
<div class="row">
    <div class="col-xs-12">
        <h2>
            <spring:message code="label.neuropsychology"/>
        </h2>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<%-- mapping resource in action with c:url caused errors --%>
<form:form class="form-horizontal" role="form" method="POST"
           action="/GENEPI/patient/${patient.id}/neuropsychology/save" commandName="neuropsychology">

<div class="form-group">
    <label for="date" class="col-xs-3 control-label">
        <spring:message code="label.dateExamination"/>
    </label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"
                    autocomplete="off"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="intellect" class="col-xs-3 control-label">
        <spring:message code="label.intellect"/>
    </label>

    <div class="col-xs-8">
        <form:select path="intellect" id="intellect" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.intellect.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.intellect.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.intellect.3"/>
            </form:option>
        </form:select>
    </div>
</div>

<%-- if intellect == neurodevelopmentalExamination START--%>
<div class="form-group">
    <label for="neurodevelopmentalExamination" class="col-xs-3 control-label">
        <spring:message code="label.neurodevelopmentalExamination"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExamination" id="neurodevelopmentalExamination" type="text"
                     class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationAdaptability" class="col-xs-3 control-label">
        <spring:message code="label.adaptability"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationAdaptability" id="neurodevelopmentalExaminationAdaptability"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationSpeechExpressively" class="col-xs-3 control-label">
        <spring:message code="label.speechExpressively"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationSpeechExpressively"
                     id="neurodevelopmentalExaminationSpeechExpressively" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationSpeechReceptively" class="col-xs-3 control-label">
        <spring:message code="label.speechReceptively"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationSpeechReceptively"
                     id="neurodevelopmentalExaminationSpeechReceptively" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationFineMotorSkills" class="col-xs-3 control-label">
        <spring:message code="label.fineMotorSkills"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationFineMotorSkills"
                     id="neurodevelopmentalExaminationFineMotorSkills" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationGrossMotorSkills" class="col-xs-3 control-label">
        <spring:message code="label.grossMotorSkills"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationGrossMotorSkills"
                     id="neurodevelopmentalExaminationGrossMotorSkills" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neurodevelopmentalExaminationSocialBehavior" class="col-xs-3 control-label">
        <spring:message code="label.socialBehavior"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neurodevelopmentalExaminationSocialBehavior" id="neurodevelopmentalExaminationSocialBehavior"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>
<%-- if intellect == neurodevelopmentalExamination END--%>

<%-- if intellect == intellectualPerformance START--%>
<div class="form-group">
    <label for="intellectualPerformance" class="col-xs-3 control-label">
        <spring:message code="label.intellectualPerformance"/>
    </label>

    <div class="col-xs-8">
        <form:select path="intellectualPerformance" id="intellectualPerformance" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="intellectualPerformanceVerbally" class="col-xs-3 control-label">
        <spring:message code="label.intellectualPerformanceVerbally"/>
    </label>

    <div class="col-xs-8">
        <form:select path="intellectualPerformanceVerbally" id="intellectualPerformanceVerbally" type="text"
                     class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="intellectualPerformanceNonverbalAbstraction" class="col-xs-3 control-label">
        <spring:message code="label.intellectualPerformanceNonverbalAbstraction"/>
    </label>

    <div class="col-xs-8">
        <form:select path="intellectualPerformanceNonverbalAbstraction" id="intellectualPerformanceNonverbalAbstraction"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="intellectualPerformanceNonverbalDesignCapabilities" class="col-xs-3 control-label">
        <spring:message code="label.intellectualPerformanceNonverbalDesignCapabilities"/>
    </label>

    <div class="col-xs-8">
        <form:select path="intellectualPerformanceNonverbalDesignCapabilities"
                     id="intellectualPerformanceNonverbalDesignCapabilities" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>
<%-- if intellect == intellectualPerformance END--%>

<div class="form-group">
    <label for="neuropsychologicalProfile" class="col-xs-3 control-label">
        <spring:message code="label.neuropsychologicalProfile"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfile" id="neuropsychologicalProfile" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<%-- if neuropsychologicalProfile == concernes START--%>
<div class="form-group">
    <label for="neuropsychologicalProfileAttention" class="col-xs-3 control-label">
        <spring:message code="label.attention"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileAttention" id="neuropsychologicalProfileAttention" type="text"
                     class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileExecutiveFunction" class="col-xs-3 control-label">
        <spring:message code="label.executiveFunction"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileExecutiveFunction" id="neuropsychologicalProfileExecutiveFunction"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileCognitiveSpeed" class="col-xs-3 control-label">
        <spring:message code="label.cognitiveSpeed"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileCognitiveSpeed" id="neuropsychologicalProfileCognitiveSpeed"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileSpeechExpressively" class="col-xs-3 control-label">
        <spring:message code="label.speechExpressively"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileSpeechExpressively" id="neuropsychologicalProfileSpeechExpressively"
                     type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.speechExpressively.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.speechExpressively.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.speechExpressively.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.speechExpressively.4"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileSpeechUnderstanding" class="col-xs-3 control-label">
        <spring:message code="label.speechUnderstanding"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileSpeechUnderstanding"
                     id="neuropsychologicalProfileSpeechUnderstanding" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMemoryOperating" class="col-xs-3 control-label">
        <spring:message code="label.memoryOperating"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMemoryOperating" id="neuropsychologicalProfileMemoryOperating"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMemoryVerbal" class="col-xs-3 control-label">
        <spring:message code="label.memoryVerbal"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMemoryVerbal" id="neuropsychologicalProfileMemoryVerbal" type="text"
                     class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMemoryNonverbal" class="col-xs-3 control-label">
        <spring:message code="label.memoryNonverbal"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMemoryNonverbal" id="neuropsychologicalProfileMemoryNonverbal"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMemoryLearning" class="col-xs-3 control-label">
        <spring:message code="label.memoryLearning"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMemoryLearning" id="neuropsychologicalProfileMemoryLearning"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfilePerceptionSpeech" class="col-xs-3 control-label">
        <spring:message code="label.perceptionSpeech"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfilePerceptionSpeech" id="neuropsychologicalProfilePerceptionSpeech"
                     type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.perceptionOfSpeech.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.perceptionOfSpeech.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfilePerceptionVisual" class="col-xs-3 control-label">
        <spring:message code="label.perceptionVisual"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfilePerceptionVisual" id="neuropsychologicalProfilePerceptionVisual"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfilePerceptionSpatial" class="col-xs-3 control-label">
        <spring:message code="label.perceptionSpatial"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfilePerceptionSpatial" id="neuropsychologicalProfilePerceptionSpatial"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMotorSkillsDexterity" class="col-xs-3 control-label">
        <spring:message code="label.motorSkillsDexterity"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMotorSkillsDexterity"
                     id="neuropsychologicalProfileMotorSkillsDexterity" type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="neuropsychologicalProfileMotorCoordination" class="col-xs-3 control-label">
        <spring:message code="label.motorCoordination"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfileMotorCoordination" id="neuropsychologicalProfileMotorCoordination"
                     type="text" class="form-control">
            <%@ include file="deficitOptionsView.jsp" %>
        </form:select>
    </div>
</div>
<%-- if neuropsychologicalProfile == concernes END--%>

<div class="form-group">
    <label for="presenceOfChanges" class="col-xs-3 control-label">
        <spring:message code="label.presenceOfChanges"/>
    </label>

    <div class="col-xs-8">
        <form:select path="presenceOfChanges" id="presenceOfChanges" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.presenceOfChanges.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.presenceOfChanges.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.presenceOfChanges.3"/>
            </form:option>
        </form:select>
    </div>
</div>

<%-- if presenceOfChanges == deteriorace START--%>
<div class="form-group">
    <label for="presenceOfChangesDetail" class="col-xs-3 control-label">
        <spring:message code="label.presenceOfChangesDetail"/>
    </label>

    <div class="col-xs-8">
        omg multiselect
    </div>
</div>
<%-- if presenceOfChanges == deteriorace END--%>

<div class="form-group">
    <label for="emotionalState" class="col-xs-3 control-label">
        <spring:message code="label.emotionalState"/>
    </label>

    <div class="col-xs-8">
        <form:select path="emotionalState" id="emotionalState" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.emotionalState.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.emotionalState.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.emotionalState.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.emotionalState.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.emotionalState.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.emotionalState.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.emotionalState.7"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="comment" class="col-xs-3 control-label">
        <spring:message code="label.comment"/>
    </label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control"/>
    </div>
</div>

<div class="form-group">
    <div class="col-xs-offset-3 col-xs-8">
        <button class="btn btn-primary" type="submit">
            <spring:message code="label.add"/>
        </button>
    </div>
</div>
</form:form>

</jsp:body>
</t:menuLVL2.NEW303>