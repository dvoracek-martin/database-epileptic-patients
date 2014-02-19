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
		<script src="<c:url value="/resources/custom/js/datepicker.NEW303.js" />"></script>
        	<script src="<c:url value="/resources/custom/js/cardForm/neuropsychology.js" />"></script>
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
            <form:option value="0">
                <spring:message code="label.intellect.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.intellect.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.intellect.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<%-- if intellect == neurodevelopmentalExamination START --%>
<div id="intellect-neurodevelopmental-examination">
        <%--<fieldset>
            <legend>Dilci nerovnomernosti:</legend>--%>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="neurodevelopmentalExamination"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExamination"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="adaptability"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationAdaptability"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="speechExpressively"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationSpeechExpressively"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="speechReceptively"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationSpeechReceptively"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="fineMotorSkills"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationFineMotorSkills"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="grossMotorSkills"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationGrossMotorSkills"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="socialBehavior"/>
        <jsp:param name="propertyName" value="neurodevelopmentalExaminationSocialBehavior"/>
    </jsp:include>
        <%-- </fieldset>--%>
</div>
<%-- if intellect == neurodevelopmentalExamination END--%>

<%-- if intellect == intellectualPerformance START--%>
<div id="intellect-intellectual-performance">
    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="intellectualPerformance"/>
        <jsp:param name="propertyName" value="intellectualPerformance"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="intellectualPerformanceVerbally"/>
        <jsp:param name="propertyName" value="intellectualPerformanceVerbally"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="intellectualPerformanceNonverbalAbstraction"/>
        <jsp:param name="propertyName" value="intellectualPerformanceNonverbalAbstraction"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="intellectualPerformanceNonverbalDesignCapabilities"/>
        <jsp:param name="propertyName" value="intellectualPerformanceNonverbalDesignCapabilities"/>
    </jsp:include>
</div>
<%-- if intellect == intellectualPerformance END--%>

<div class="form-group">
    <label for="neuropsychologicalProfile" class="col-xs-3 control-label">
        <spring:message code="label.neuropsychologicalProfile"/>
    </label>

    <div class="col-xs-8">
        <form:select path="neuropsychologicalProfile" id="neuropsychologicalProfile" type="text"
                     class="form-control">
            <form:option value="0">
                <spring:message code="label.neuropsychologicalProfile.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.neuropsychologicalProfile.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.neuropsychologicalProfile.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<%-- if neuropsychologicalProfile == concernes START--%>
<div id="neuropsychological-profile-concernes">
    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="attention"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileAttention"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="executiveFunction"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileExecutiveFunction"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="cognitiveSpeed"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileCognitiveSpeed"/>
    </jsp:include>

    <div class="form-group">
        <label for="neuropsychologicalProfileSpeechExpressively" class="col-xs-3 control-label">
            <spring:message code="label.speechExpressively"/>
        </label>

        <div class="col-xs-8">
            <form:select path="neuropsychologicalProfileSpeechExpressively"
                         id="neuropsychologicalProfileSpeechExpressively"
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
                <form:option value="5">
                    <spring:message code="label.speechExpressively.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="speechUnderstanding"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileSpeechUnderstanding"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="memoryOperating"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMemoryOperating"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="memoryVerbal"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMemoryVerbal"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="memoryNonverbal"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMemoryNonverbal"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="memoryLearning"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMemoryLearning"/>
    </jsp:include>

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
                <form:option value="3">
                    <spring:message code="label.perceptionOfSpeech.3"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="perceptionVisual"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfilePerceptionVisual"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="perceptionSpatial"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfilePerceptionSpatial"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="motorSkillsDexterity"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMotorSkillsDexterity"/>
    </jsp:include>

    <jsp:include page="deficitOptionsView.jsp">
        <jsp:param name="labelName" value="motorCoordination"/>
        <jsp:param name="propertyName" value="neuropsychologicalProfileMotorCoordination"/>
    </jsp:include>
</div>
<%-- if neuropsychologicalProfile == concernes END--%>

<div class="form-group">
    <label for="presenceOfChanges" class="col-xs-3 control-label">
        <spring:message code="label.presenceOfChanges"/>
    </label>

    <div class="col-xs-8">
        <form:select path="presenceOfChanges" id="presenceOfChanges" type="text" class="form-control">
            <form:option value="0">
                <spring:message code="label.presenceOfChanges.0"/>
            </form:option>
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
<div id="presence-of-changes-deterioration">
    <div class="form-group">
        <label for="presenceOfChangesDetail" class="col-xs-3 control-label">
            <spring:message code="label.presenceOfChangesDetail"/>
        </label>

        <div class="col-xs-8">
            <form:select path="presenceOfChangesDetail" id="presenceOfChangesDetail" type="text" class="form-control">

            </form:select>
        </div>
    </div>
</div>
<%-- if presenceOfChanges == deteriorace END--%>

<div class="form-group">
    <label for="emotionalState" class="col-xs-3 control-label">
        <spring:message code="label.emotionalState"/>
    </label>

    <div class="col-xs-8">
        <form:select path="emotionalStatus" id="emotionalState" type="text" class="form-control">
            <form:option value="0">
                <spring:message code="label.emotionalState.0"/>
            </form:option>
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