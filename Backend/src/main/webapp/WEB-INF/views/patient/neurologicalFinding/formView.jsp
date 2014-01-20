<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-3 control-label"><spring:message code="label.dateExamination"/></label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="hemisphereDominance" class="col-xs-3 control-label">
        <spring:message code="label.hemisphereDominance"/>
    </label>

    <div class="col-xs-8">
        <form:select path="hemisphereDominance" id="hemisphereDominance" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.hemisphereDominance.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.hemisphereDominance.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.hemisphereDominance.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.hemisphereDominance.4"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="abnormalNeurologicalFinding" class="col-xs-3 control-label">
        <spring:message code="label.abnormalNeurologicalFinding"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="abnormalNeurologicalFinding" id="abnormalNeurologicalFinding"/>
        <form:errors path="abnormalNeurologicalFinding" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="hemiparesis" class="col-xs-3 control-label"><spring:message code="label.hemiparesis"/></label>

    <div class="col-xs-8">
        <form:checkbox path="hemiparesis" id="hemiparesis"/>
        <form:errors path="hemiparesis" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="visualFieldDefects" class="col-xs-3 control-label">
        <spring:message code="label.visualFieldDefect"/>
    </label>

    <div class="col-xs-8">
        <form:checkbox path="visualFieldDefects" id="visualFieldDefects"/>
        <form:errors path="visualFieldDefects" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="comment" class="col-xs-3 control-label"><spring:message
            code="label.comment"/></label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control"/>
    </div>
</div>