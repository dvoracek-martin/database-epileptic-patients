<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-3 col-xs-3 control-label"><spring:message
            code="label.dateOfContractAward"/></label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-3 control-label" for="sscClassification"><spring:message
            code="label.SSCClassification"/></label>

    <div class="col-xs-8">
        <form:select path="sscClassification" id="sscClassification" type="text" class="form-control">

            <form:option value="1">
                <spring:message code="label.epilepticSeizure"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.aura"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.somatosenzoryAura"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.visualAura"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.auditoryAura"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.olfactoryAura"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.gustatoryAura"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.autonomicAura"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.epigastricAura"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.psychicAura"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.absence"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.autonomicSeizure"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.psychomotorSeizure"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.motorSeizure"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.clonicSeizure"/>
            </form:option>
            <form:option value="16">
                <spring:message code="label.tonicSeizure"/>
            </form:option>
            <form:option value="17">
                <spring:message code="label.tonicClonicSeizure"/>
            </form:option>
            <form:option value="18">
                <spring:message code="label.atonicSeizure"/>
            </form:option>
            <form:option value="19">
                <spring:message code="label.akineticSeizure"/>
            </form:option>
            <form:option value="20">
                <spring:message code="label.versiveSeizure"/>
            </form:option>
            <form:option value="21">
                <spring:message code="label.myoclonicSeizure"/>
            </form:option>
            <form:option value="22">
                <spring:message code="label.hypermotorSeizure"/>
            </form:option>
            <form:option value="23">
                <spring:message code="label.hypomotorSeizure"/>
            </form:option>
            <form:option value="24">
                <spring:message code="label.negativeMyoclonicSeizure"/>
            </form:option>
            <form:option value="25">
                <spring:message code="label.askatikSeizure"/>
            </form:option>
            <form:option value="26">
                <spring:message code="label.akineticSeizure"/>
            </form:option>
            <form:option value="27">
                <spring:message code="label.aphasicSeizure"/>
            </form:option>
            <form:option value="28">
                <spring:message code="label.gelasticSeizure"/>
            </form:option>
            <form:option value="29">
                <spring:message code="label.paroxymalEvent"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-3 control-label" for="ilaeClassification"><spring:message
            code="label.ILAEClassification"/></label>

    <div class="col-xs-8">
        <form:select path="ilaeClassification" id="ilaeClassification" type="text" class="form-control">

            <form:option value="1">
                <spring:message code="label.simplePartialMotor"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.simplePartialPsychic"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.simplePartialAutonomic"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.simplePartialSomatosensory"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.simplePartialSimple"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.simplePartialImpairment"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.simplePartialEvolving"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.generalizedTypical"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.generalizedAtypical"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.generalizedMyoclonic"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.generalizedClonic"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.generalizedTonic"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.generalizedTonicClonic"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.generalizedAtonic"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.unclassified"/>
            </form:option>

        </form:select>
    </div>
</div>


<div class="form-group">
    <label class="col-xs-3 control-label" for="comment"><spring:message code="label.comment"/></label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control"/>
    </div>
</div>