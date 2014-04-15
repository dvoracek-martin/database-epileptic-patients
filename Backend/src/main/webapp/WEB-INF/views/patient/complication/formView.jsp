<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth" scope="request" type="java.lang.Boolean"/>
<jsp:useBean id="chooseBoth" scope="request" type="java.lang.Boolean"/>

<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="date"
                        class="input-sm form-control"
                        type="text"
                        autocomplete="off"
                        path="date"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="text-danger"/>
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
           for="process">
        <spring:message code="label.process"/>
    </label>

    <div class="col-xs-8">
        <form:select id="process"
                     class="form-control input-sm"
                     type="text"
                     path="withComplication">
            <form:option value="0">
                <spring:message code="label.process.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.process.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.process.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-with-complication">

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="complicationType">
            <spring:message code="label.typeComplication"/>
        </label>

        <div class="col-xs-8">
            <form:select id="complicationType"
                         class="form-control input-sm"
                         type="text"
                         path="complicationType">
                <form:option value="0">
                    <spring:message code="label.complicationType.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.complicationType.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.complicationType.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.complicationType.3"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="complication">
            <spring:message code="label.complication"/>
        </label>

        <div class="col-xs-8">
            <form:select id="complication"
                         class="form-control input-sm"
                         type="text"
                         path="complication">
                <form:option value="0">
                    <spring:message code="label.complication.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.complication.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.complication.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.complication.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.complication.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.complication.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.complication.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.complication.7"/>
                </form:option>
                <form:option value="8">
                    <spring:message code="label.complication.8"/>
                </form:option>
                <form:option value="9">
                    <spring:message code="label.complication.9"/>
                </form:option>
                <form:option value="10">
                    <spring:message code="label.complication.10"/>
                </form:option>
                <form:option value="11">
                    <spring:message code="label.complication.11"/>
                </form:option>
            </form:select>
            <c:if test="${chooseBoth}">
                <span class="text-danger">
                     <spring:message code="label.chooseBoth"/>
                </span>
            </c:if>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="comment">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="comment"
                           class="form-control resize-vertical"
                           path="comment"/>
        </div>
    </div>
</div>