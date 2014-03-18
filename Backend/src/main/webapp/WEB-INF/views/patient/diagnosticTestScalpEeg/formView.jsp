<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input path="date" id="date" type="text" class="input-sm form-control" autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label for="done" class="col-xs-4 control-label">
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </label>

    <div class="col-xs-8">
        <form:select path="done" id="done" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done">

    <div class="form-group">
        <label for="basicEegActivity" class="col-xs-4 control-label">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select path="basicEegActivity" id="basicEegActivity" type="text" class="form-control">
                <form:option value="0">
                    Zvolte
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
        <label for="eegSlow" class="col-xs-4 control-label">
            <spring:message code="label.eegSlow"/>
        </label>

        <div class="col-xs-8">
            <form:select path="eegSlow" id="eegSlow" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.eegSlow.0"/>
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
        <label for="interictalEegSpikes" class="col-xs-4 control-label">
            <spring:message code="label.interictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:select path="interictalEegSpikes" id="interictalEegSpikes" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.interictalEegSpikes.0"/>
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

    <div class="form-group">
        <label for="localizationInterictalEegSpikes" class="col-xs-4 control-label">
            <spring:message code="label.localizationInterictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationInterictalEegSpikes" id="localizationInterictalEegSpikes"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="eegStatusEpilepticus"/>
        <jsp:param name="messageCode" value="eegStatusEpilepticus"/>
    </jsp:include>


    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="secondarySidedSynchrony"/>
        <jsp:param name="messageCode" value="secondarySidedSynchrony"/>
    </jsp:include>

    <div class="form-group">
        <label for="ictalEegPatterns" class="col-xs-4 control-label">
            <spring:message code="label.ictalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:select path="ictalEegPatterns" id="ictalEegPatterns" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.ictalEegPatterns.0"/>
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

    <div class="form-group">
        <label for="localizationIctalEegPattern" class="col-xs-4 control-label">
            <spring:message code="label.localizationIctalEegPattern"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationIctalEegPattern" id="localizationIctalEegPattern"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <div class="form-group">
        <label for="comment" class="col-xs-4 control-label">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
        </div>
    </div>

    <div class="form-group">
        <label for="descriptionVideoEeg" class="col-xs-4 control-label">
            <spring:message code="label.descriptionVideoEeg"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="descriptionVideoEeg" id="descriptionVideoEeg" class="form-control resize-vertical"/>
        </div>
    </div>
</div>