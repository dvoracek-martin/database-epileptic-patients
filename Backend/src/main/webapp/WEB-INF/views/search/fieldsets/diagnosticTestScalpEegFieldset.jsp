<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="diagnosticTestScalpEegFieldset">
    <legend>
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="basicEegActivity">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select id="basicEegActivity"
                         class="input-sm form-control"
                         type="text"
                         path="diagnosticTestScalpEegBasicEegActivity">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.basicEegActivity.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.basicEegActivity.2"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="eegSlow">
            <spring:message code="label.eegSlow"/>
        </label>

        <div class="col-xs-8">
            <form:select id="eegSlow"
                         class="input-sm form-control"
                         type="text"
                         path="diagnosticTestScalpEegEegSlow">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.eegSlow.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.eegSlow.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.eegSlow.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.eegSlow.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.eegSlow.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="interictalEegSpikes">
            <spring:message code="label.interictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:select id="interictalEegSpikes"
                         class="input-sm form-control"
                         type="text"
                         path="diagnosticTestScalpEegInterictalEegSpikes">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.interictalEegSpikes.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.interictalEegSpikes.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.interictalEegSpikes.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.interictalEegSpikes.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.interictalEegSpikes.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.interictalEegSpikes.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="diagnosticTestScalpEegEegStatusEpilepticus"/>
        <jsp:param name="messageCode"
                   value="statusEpilepticus"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="diagnosticTestScalpEegSecondarySidedSynchrony"/>
        <jsp:param name="messageCode"
                   value="secondarySidedSynchrony"/>
    </jsp:include>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="ictalEegPatterns">
            <spring:message code="label.ictalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:select id="ictalEegPatterns"
                         class="input-sm form-control"
                         type="text"
                         path="diagnosticTestScalpEegIctalEegPatterns">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.ictalEegPatterns.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.ictalEegPatterns.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.ictalEegPatterns.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.ictalEegPatterns.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.ictalEegPatterns.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.ictalEegPatterns.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

</fieldset>