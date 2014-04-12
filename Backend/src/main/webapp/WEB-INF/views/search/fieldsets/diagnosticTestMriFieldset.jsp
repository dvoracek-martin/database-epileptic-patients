<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="diagnosticTestMriFieldset">
    <legend>
        <spring:message code="label.diagnosticTestMri"/>
    </legend>

    <jsp:include page="../../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mriFinding"/>
        <jsp:param name="propertyName" value="diagnosticTestMriMriFinding"/>
    </jsp:include>

    <jsp:include page="../../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="fdgPet"/>
        <jsp:param name="propertyName" value="diagnosticTestMriFdgPet"/>
    </jsp:include>

    <jsp:include page="../../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="interictalSpect"/>
        <jsp:param name="propertyName" value="diagnosticTestMriInterictalSpect"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriSiscom"/>
        <jsp:param name="messageCode" value="siscom"/>
    </jsp:include>

    <div class="form-group">
        <label for="mrsProtocol" class="col-xs-4 control-label">
            <spring:message code="label.mrsProtocol"/>
        </label>

        <div class="col-xs-8">
            <form:select path="diagnosticTestMriMrsProtocol" id="mrsProtocol" type="text" class="input-sm form-control">
                <form:option value="0">
                    <spring:message code="label.mrsProtocol.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.mrsProtocol.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.mrsProtocol.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.mrsProtocol.3"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="../../patient/diagnosticTestMri/resultTypeOptionsView.jsp">
        <jsp:param name="labelName" value="mrsFinding"/>
        <jsp:param name="propertyName" value="diagnosticTestMriMrsFinding"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriDti"/>
        <jsp:param name="messageCode" value="dti"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriFmri"/>
        <jsp:param name="messageCode" value="fmri"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMriWada"/>
        <jsp:param name="messageCode" value="wada"/>
    </jsp:include>
</fieldset>