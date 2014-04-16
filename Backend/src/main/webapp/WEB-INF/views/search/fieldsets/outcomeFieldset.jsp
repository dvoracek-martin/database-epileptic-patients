<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="outcomeFieldset">
<legend>
    <spring:message code="label.outcome"/>
</legend>

<div class="form-group">
    <label for="seizureOutcome" class="col-xs-4 control-label">
        <spring:message code="label.seizureOutcome"/>
    </label>

    <div class="col-xs-8">
        <form:select path="outcomeSeizureOutcome" id="seizureOutcome" type="text" class="form-control input-sm">

            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.seizureOutcome.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.seizureOutcome.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.seizureOutcome.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.seizureOutcome.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.seizureOutcome.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.seizureOutcome.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.seizureOutcome.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.seizureOutcome.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.seizureOutcome.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.seizureOutcome.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.seizureOutcome.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.seizureOutcome.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.seizureOutcome.13"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.seizureOutcome.14"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="outcomeAed" class="col-xs-4 control-label">
        <spring:message code="label.aed"/>
    </label>

    <div class="col-xs-8">
        <form:select path="outcomeAed" id="outcomeAed" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.outcomeAed.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.outcomeAed.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.outcomeAed.3"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="outcomeEeg" class="col-xs-4 control-label">
        <spring:message code="label.eeg"/>
    </label>

    <div class="col-xs-8">
        <form:select path="outcomeEeg" id="outcomeEeg" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.outcomeEeg.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.outcomeEeg.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.outcomeEeg.3"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="outcomeMri" class="col-xs-4 control-label">
        <spring:message code="label.mri"/>
    </label>

    <div class="col-xs-8">
        <form:select path="outcomeMri" id="outcomeMri" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="outcomeNeuropsychology" class="col-xs-4 control-label">
        <spring:message code="label.neuropsychology"/>
    </label>

    <div class="col-xs-8">
        <form:select path="outcomeNeuropsychology" id="outcomeNeuropsychology" type="text"
                     class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="outcomeDistanceFilter">
        <spring:message code="label.distanceFilter"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeDistanceFilter"
                     class="form-control input-sm"
                     type="text"
                     path="outcomeDistanceFilter">

            <form:option value="=">
                =
            </form:option>
            <form:option value=">">
                >
            </form:option>
            <form:option value="<">
                <
            </form:option>
            <form:option value=">=">
                >=
            </form:option>
            <form:option value="<=">
                <=
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label" for="outcomeDistanceFilter">
        <spring:message code="label.outcomeDistance"/>
    </label>

    <div class="col-xs-8">
        <form:select id="outcomeDistanceFilter"
                     class="form-control input-sm"
                     type="text"
                     path="outcomeDistance">

            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.distance.6"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.distance.12"/>
            </form:option>
            <form:option value="24">
                <spring:message code="label.distance.24"/>
            </form:option>
            <form:option value="60">
                <spring:message code="label.distance.60"/>
            </form:option>
            <form:option value="120">
                <spring:message code="label.distance.120"/>
            </form:option>
        </form:select>
    </div>
</div>

</fieldset>
