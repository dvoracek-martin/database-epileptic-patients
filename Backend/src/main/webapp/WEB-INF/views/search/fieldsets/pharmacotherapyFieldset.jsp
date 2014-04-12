<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="pharmacotherapyFieldset">
    <legend>
        <spring:message code="label.pharmacotherapy"/>
    </legend>

    <div class="form-group">
        <label for="pharmacotherapyAed" class="col-xs-4 control-label">
            <spring:message code="label.aed"/>
        </label>

        <div class="col-xs-8">
            <form:select path="pharmacotherapyAed" id="pharmacotherapyAed" type="text"
                         class="form-control input-sm" multiple="multiple">
                <form:option value="1">
                    <spring:message code="label.aed.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.aed.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.aed.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.aed.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.aed.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.aed.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.aed.7"/>
                </form:option>
                <form:option value="8">
                    <spring:message code="label.aed.8"/>
                </form:option>
                <form:option value="9">
                    <spring:message code="label.aed.9"/>
                </form:option>
                <form:option value="10">
                    <spring:message code="label.aed.10"/>
                </form:option>
                <form:option value="11">
                    <spring:message code="label.aed.11"/>
                </form:option>
                <form:option value="12">
                    <spring:message code="label.aed.12"/>
                </form:option>
                <form:option value="13">
                    <spring:message code="label.aed.13"/>
                </form:option>
                <form:option value="14">
                    <spring:message code="label.aed.14"/>
                </form:option>
                <form:option value="15">
                    <spring:message code="label.aed.15"/>
                </form:option>
                <form:option value="16">
                    <spring:message code="label.aed.16"/>
                </form:option>
                <form:option value="17">
                    <spring:message code="label.aed.17"/>
                </form:option>
                <form:option value="18">
                    <spring:message code="label.aed.18"/>
                </form:option>
                <form:option value="19">
                    <spring:message code="label.aed.19"/>
                </form:option>
                <form:option value="20">
                    <spring:message code="label.aed.20"/>
                </form:option>
                <form:option value="21">
                    <spring:message code="label.aed.21"/>
                </form:option>
                <form:option value="22">
                    <spring:message code="label.aed.22"/>
                </form:option>
                <form:option value="23">
                    <spring:message code="label.aed.23"/>
                </form:option>
                <form:option value="24">
                    <spring:message code="label.aed.24"/>
                </form:option>
                <form:option value="25">
                    <spring:message code="label.aed.25"/>
                </form:option>
            </form:select>
        </div>
    </div>

</fieldset>