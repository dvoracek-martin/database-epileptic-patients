<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="invasiveTestEcogFieldset">
    <legend>
        <spring:message code="label.invasiveTestECoG"/>
    </legend>

    <div class="form-group">
        <label for="ecogPatterns" class="col-xs-4 control-label">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select path="invasiveTestEcogEcogPatterns" id="ecogPatterns" type="text" class="input-sm form-control">
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
            <form:select path="invasiveTestEcogAfterResectionEcog" id="afterResectionEcog" type="text" class="input-sm form-control">
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

</fieldset>