<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="invasiveTestEegFieldset">
    <legend>
        <spring:message code="label.invasiveTestIeeg"/>
    </legend>

    <div class="form-group">
        <label for="intracranialElectrodes" class="col-xs-4 control-label">
            <spring:message code="label.intracranialElectrodes"/>
        </label>

        <div class="col-xs-8">
            <form:select path="invasiveTestEegIntracranialElectrodes" id="intracranialElectrodes" type="text"
                         class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.intracranialElectrodes.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.intracranialElectrodes.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.intracranialElectrodes.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.intracranialElectrodes.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.intracranialElectrodes.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.intracranialElectrodes.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.intracranialElectrodes.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.intracranialElectrodes.7"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="invasiveEegSlow" class="col-xs-4 control-label">
            <spring:message code="label.invasiveEegSlowing"/>
        </label>

        <div class="col-xs-8">
            <form:select path="invasiveTestEegInvasiveEegSlow" id="invasiveEegSlow" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.invasiveEegSlowing.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.invasiveEegSlowing.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.invasiveEegSlowing.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.invasiveEegSlowing.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.invasiveEegSlowing.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.invasiveEegSlowing.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="../../patient/invasiveTestEeg/invasiveEegOptionsView.jsp">
        <jsp:param name="labelName" value="invasiveEegInterictalSpikes"/>
        <jsp:param name="propertyName" value="invasiveTestEegInvasiveEegInterictalSpikes"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="invasiveTestEegInvasiveEegStatusEpilepticus"/>
        <jsp:param name="messageCode" value="statusEpilepticus"/>
    </jsp:include>

    <jsp:include page="../../patient/invasiveTestEeg/invasiveEegOptionsView.jsp">
        <jsp:param name="labelName" value="invasiveIctalEegPatterns"/>
        <jsp:param name="propertyName" value="invasiveTestEegInvasiveIctalEegPatterns"/>
    </jsp:include>

</fieldset>