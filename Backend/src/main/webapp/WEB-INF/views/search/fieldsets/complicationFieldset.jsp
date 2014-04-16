<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="complicationFieldset">
    <legend>
        <spring:message code="label.complication"/>
    </legend>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="complicationType">
            <spring:message code="label.typeComplication"/>
        </label>

        <div class="col-xs-8">
            <form:select path="complicationComplicationType" id="complicationType" type="text"
                         class="form-control input-sm">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
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
        <label class="col-xs-4 control-label" for="complication">
            <spring:message code="label.complication"/>
        </label>

        <div class="col-xs-8">
            <form:select path="complicationComplication" id="complication" type="text" class="form-control input-sm">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
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
        </div>
    </div>

</fieldset>