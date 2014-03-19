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
        <spring:message code="label.invasiveTestECoG"/>
    </label>

    <div class="col-xs-8">
        <form:select path="done" id="done" type="text" class="input-sm form-control">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done" class="section-hide">

    <div class="form-group">
        <label for="ecogCover" class="col-xs-4 control-label">
            <spring:message code="label.ecogCover"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="ecogCover" id="ecogCover" class="form-control resize-vertical"/>
        </div>
    </div>

    <div class="form-group">
        <label for="ecogPatterns" class="col-xs-4 control-label">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select path="ecogPatterns" id="ecogPatterns" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.ecogPatterns.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.ecogPatterns.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.ecogPatterns.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.ecogPatterns.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.ecogPatterns.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.ecogPatterns.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="afterResectionEcog" class="col-xs-4 control-label">
            <spring:message code="label.ecogAfterResection"/>
        </label>

        <div class="col-xs-8">
            <form:select path="afterResectionEcog" id="afterResectionEcog" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.afterResectionEcog.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.afterResectionEcog.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.afterResectionEcog.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.afterResectionEcog.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.afterResectionEcog.4"/>
                </form:option>

            </form:select>
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
</div>