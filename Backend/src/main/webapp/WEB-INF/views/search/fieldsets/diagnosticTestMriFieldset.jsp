<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="diagnosticTestMriFieldset">
<legend>
    <spring:message code="label.diagnosticTestMri"/>
</legend>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="diagnosticTestMriMriFinding">
        <spring:message code="label.mriFinding"/>
    </label>

    <div class="col-xs-8">
        <form:select id="diagnosticTestMriMriFinding"
                     class="input-sm form-control"
                     type="text"
                     path="diagnosticTestMriMriFinding">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.resultType.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.resultType.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.resultType.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.resultType.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.resultType.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.resultType.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.resultType.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.resultType.8"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="diagnosticTestMriFdgPet">
        <spring:message code="label.fdgPet"/>
    </label>

    <div class="col-xs-8">
        <form:select id="diagnosticTestMriFdgPet"
                     class="input-sm form-control"
                     type="text"
                     path="diagnosticTestMriFdgPet">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.resultType.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.resultType.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.resultType.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.resultType.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.resultType.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.resultType.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.resultType.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.resultType.8"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="diagnosticTestMriInterictalSpect">
        <spring:message code="label.interictalSpect"/>
    </label>

    <div class="col-xs-8">
        <form:select id="diagnosticTestMriInterictalSpect"
                     class="input-sm form-control"
                     type="text"
                     path="diagnosticTestMriInterictalSpect">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.resultType.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.resultType.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.resultType.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.resultType.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.resultType.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.resultType.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.resultType.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.resultType.8"/>
            </form:option>
        </form:select>
    </div>
</div>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="diagnosticTestMriSiscom"/>
    <jsp:param name="messageCode" value="siscom"/>
</jsp:include>

<div class="form-group">
    <label for="mrsProtocol" class="col-xs-4 control-label">
        <spring:message code="label.mrsProtocol"/>
    </label>

    <div class="col-xs-8">
        <form:select path="diagnosticTestMriMrsProtocol" id="mrsProtocol" type="text" class="input-sm form-control">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.mrsProtocol.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.mrsProtocol.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.mrsProtocol.3"/>
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="diagnosticTestMriMrsFinding">
        <spring:message code="label.mrsFinding"/>
    </label>

    <div class="col-xs-8">
        <form:select id="diagnosticTestMriMrsFinding"
                     class="input-sm form-control"
                     type="text"
                     path="diagnosticTestMriMrsFinding">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.resultType.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.resultType.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.resultType.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.resultType.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.resultType.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.resultType.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.resultType.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.resultType.8"/>
            </form:option>
        </form:select>
    </div>
</div>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="diagnosticTestMriDti"/>
    <jsp:param name="messageCode" value="dti"/>
</jsp:include>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="diagnosticTestMriFmri"/>
    <jsp:param name="messageCode" value="fmri"/>
</jsp:include>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="diagnosticTestMriWada"/>
    <jsp:param name="messageCode" value="wada"/>
</jsp:include>
</fieldset>