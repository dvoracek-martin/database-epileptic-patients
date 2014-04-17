<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="neurologicalFindingFieldset">
    <legend>
        <spring:message code="label.neurologicalFinding"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="hemisphereDominance">
            <spring:message code="label.hemisphereDominance"/>
        </label>

        <div class="col-xs-8">
            <form:select id="hemisphereDominance"
                         class="input-sm form-control"
                         type="text"
                         path="neurologicalFindingHemisphereDominance">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.hemisphereDominance.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.hemisphereDominance.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.hemisphereDominance.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.hemisphereDominance.4"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="neurologicalFindingAbnormalNeurologicalFinding"/>
        <jsp:param name="messageCode"
                   value="abnormalNeurologicalFinding"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="neurologicalFindingHemiparesis"/>
        <jsp:param name="messageCode"
                   value="hemiparesis"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="neurologicalFindingVisualFieldDefects"/>
        <jsp:param name="messageCode"
                   value="visualFieldDefect"/>
    </jsp:include>
</fieldset>