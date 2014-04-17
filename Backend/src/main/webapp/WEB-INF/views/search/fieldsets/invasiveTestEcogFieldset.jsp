<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="invasiveTestEcogFieldset">
    <legend>
        <spring:message code="label.invasiveTestECoG"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="ecogPatterns">
            <spring:message code="label.basicEegActivity"/>
        </label>

        <div class="col-xs-8">
            <form:select id="ecogPatterns"
                         class="input-sm form-control"
                         type="text"
                         path="invasiveTestEcogEcogPatterns">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
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
        <label class="col-xs-4 control-label"
               for="afterResectionEcog">
            <spring:message code="label.ecogAfterResection"/>
        </label>

        <div class="col-xs-8">
            <form:select id="afterResectionEcog"
                         class="input-sm form-control"
                         type="text"
                         path="invasiveTestEcogAfterResectionEcog">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
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