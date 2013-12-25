<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-3 control-label"><spring:message
            code="label.dateOfContractAward"/></label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="seizureFrequency" class="col-xs-3 control-label"><spring:message
            code="label.seizureFrequency"/></label>

    <div class="col-xs-8">
        <form:select path="seizureFrequency" id="seizureFrequency" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.daily"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.weekly"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.monthly"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.lessThanMonthly"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="secondarilyGeneralizedSeizure" class="col-xs-3 control-label"><spring:message
            code="label.lessThanMonthly"/> Sekundárně generalizované
        záchvaty</label>

    <div class="col-xs-8">
        <form:checkbox path="secondarilyGeneralizedSeizure" id="secondarilyGeneralizedSeizure"/>
        <form:errors path="secondarilyGeneralizedSeizure" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="statusEpilepticus" class="col-xs-3 control-label"><spring:message
            code="label.lessThanMonthly"/> Status epilepticus</label>

    <div class="col-xs-8">
        <form:checkbox path="statusEpilepticus" id="statusEpilepticus"/>
        <form:errors path="statusEpilepticus" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="statusEpilepticus" class="col-xs-3 control-label"><spring:message
            code="label.lessThanMonthly"/> Status epilepticus</label>

    <div class="col-xs-8">
        <form:checkbox path="statusEpilepticus" id="statusEpilepticus"/>
        <form:errors path="statusEpilepticus" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="nonepilepticSeizures" class="col-xs-3 control-label"><spring:message
            code="label.lessThanMonthly"/> Neepileptické záchvaty</label>

    <div class="col-xs-8">
        <form:checkbox path="nonepilepticSeizures" id="nonepilepticSeizures"/>
        <form:errors path="nonepilepticSeizures" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="seizureOccurrence" class="col-xs-3 control-label">
        <spring:message code="label.gender"/> seizureOccurrence
    </label>

    <div class="col-xs-8">


        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="0" checked="true"/> while awake
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="1"/> while sleep
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="seizureOccurrence" value="1"/> while both
            </label>
        </div>
    </div>
</div>

<div class="form-group">
    <label for="comment" class="col-xs-3 control-label"><spring:message
            code="label.comment"/></label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control"/>
    </div>
</div>
