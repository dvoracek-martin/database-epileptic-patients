<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="histologyFieldset">
    <legend>
        <spring:message code="label.histology"/>
    </legend>


    <div class="form-group">
        <label for="histopathology" class="col-xs-4 control-label">
            <spring:message code="label.histopathology"/>
        </label>

        <div class="col-xs-8">
            <form:select path="histologyHistopathology" id="histopathology" type="text" class="form-control input-sm">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
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
        </div>
    </div>

    <div id="section-fcd">
        <div class="form-group">
            <label for="fcdClassification" class="col-xs-4 control-label">
                <spring:message code="label.fcdClassification"/>
            </label>

            <div class="col-xs-8">
                <form:select path="histologyFcdClassification" id="fcdClassification" type="text"
                             class="form-control input-sm">
                    <form:option value="0">
                        <spring:message code="label.notDistinguish"/>
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

</fieldset>