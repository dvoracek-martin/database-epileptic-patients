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
            <form:input id="date"
                        class="input-sm form-control"
                        type="text"
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
           for="histopathology">
        <spring:message code="label.histopathology"/>*
    </label>

    <div class="col-xs-8">
        <form:select id="histopathology"
                     class="form-control input-sm"
                     type="text"
                     path="histopathology">
            <form:option value="0">
                <spring:message code="label.histopathology.0"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.histopathology.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.histopathology.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.histopathology.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.histopathology.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.histopathology.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.histopathology.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.histopathology.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.histopathology.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.histopathology.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.histopathology.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.histopathology.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.histopathology.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.histopathology.13"/>
            </form:option>
        </form:select>
        <form:errors path="histopathology"
                     cssClass="text-danger"/>
    </div>
</div>

<div id="section-fcd">
    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="fcdClassification">
            <spring:message code="label.fcdClassification"/>
        </label>

        <div class="col-xs-8">
            <form:select id="fcdClassification"
                         class="form-control input-sm"
                         type="text"
                         path="fcdClassification">
                <form:option value="0">
                    <spring:message code="label.fcdClassification.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.fcdClassification.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.fcdClassification.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.fcdClassification.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.fcdClassification.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.fcdClassification.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.fcdClassification.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.fcdClassification.7"/>
                </form:option>
            </form:select>
        </div>
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