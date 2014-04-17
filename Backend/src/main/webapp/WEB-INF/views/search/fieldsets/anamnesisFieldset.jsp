<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<fieldset id="anamnesisFieldset">
    <legend>
        <spring:message code="label.anamnesis"/>
    </legend>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisEpilepsyInFamily"/>
        <jsp:param name="messageCode"
                   value="epilepsyInFamily"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisPrenatalRisk"/>
        <jsp:param name="messageCode"
                   value="prenatalRisk"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisFibrilConvulsions"/>
        <jsp:param name="messageCode"
                   value="fibrilConvulsions"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisInflammationCns"/>
        <jsp:param name="messageCode"
                   value="inflammationCns"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisInjuryCns"/>
        <jsp:param name="messageCode"
                   value="injuryCns"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisOperationCns"/>
        <jsp:param name="messageCode"
                   value="operationCns"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisEarlyPmdRetardation"/>
        <jsp:param name="messageCode"
                   value="earlyPmdRetardation"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisFirstFever"/>
        <jsp:param name="messageCode"
                   value="firstFever"/>
    </jsp:include>

    <jsp:include page="../decideRadiobuttons.jsp">
        <jsp:param name="propertyName"
                   value="anamnesisInfantileSpasm"/>
        <jsp:param name="messageCode"
                   value="infantileSpasm"/>
    </jsp:include>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="anamnesisSpecificSyndrome">
            <spring:message code="label.epilepticSyndrome"/>
        </label>

        <div class="col-xs-8">
            <form:select id="anamnesisSpecificSyndrome"
                         class="form-control input-sm"
                         type="text"
                         path="anamnesisSpecificSyndrome">
                <form:option value="0">
                    <spring:message code="label.notDistinguish"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.specificSyndrome.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.specificSyndrome.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.specificSyndrome.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.specificSyndrome.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.specificSyndrome.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.specificSyndrome.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

</fieldset>