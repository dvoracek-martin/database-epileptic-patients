<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth"
             scope="request"
             type="java.lang.Boolean"/>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="date">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="date" type="text"
                        class="input-sm form-control"
                        autocomplete="off"
                        path="date"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date"
                     cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors"
                  class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="done">
        <spring:message code="label.diagnosticTestScalpEeg"/>
    </label>

    <div class="col-xs-8">
        <form:select id="done"
                     class="input-sm form-control"
                     type="text"
                     path="done">
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
        <label class="col-xs-4 control-label"
               for="basicEegActivity">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select id="basicEegActivity"
                         class="input-sm form-control"
                         type="text"
                         path="basicEegActivity">
                <form:option value="0">
                    <spring:message code="label.basicEegActivity.0"/>
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
                         path="eegSlow">
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
        <label class="col-xs-4 control-label"
               for="interictalEegSpikes">
            <spring:message code="label.interictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:select id="interictalEegSpikes"
                         class="input-sm form-control"
                         type="text"
                         path="interictalEegSpikes">
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
        <label class="col-xs-4 control-label"
               for="localizationInterictalEegSpikes">
            <spring:message code="label.localizationInterictalEegSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationInterictalEegSpikes"
                           class="form-control resize-vertical"
                           path="localizationInterictalEegSpikes"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="eegStatusEpilepticus"/>
        <jsp:param name="messageCode"
                   value="eegStatusEpilepticus"/>
    </jsp:include>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="secondarySidedSynchrony"/>
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
                         path="ictalEegPatterns">
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
        <label class="col-xs-4 control-label"
               for="localizationIctalEegPattern">
            <spring:message code="label.localizationIctalEegPattern"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationIctalEegPattern"
                           class="form-control resize-vertical"
                           path="localizationIctalEegPattern"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="descriptionVideoEeg">
            <spring:message code="label.descriptionVideoEeg"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="descriptionVideoEeg"
                           class="form-control resize-vertical"
                           path="descriptionVideoEeg"/>
        </div>
    </div>

    <div class="form-group">
        <label for="comment" class="col-xs-4 control-label">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="comment"
                           class="form-control resize-vertical"
                           path="comment"/>
        </div>
    </div>

</div>