<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="toCheck"
             scope="request"
             type="java.lang.Boolean"/>

<fieldset id="seizureFieldset">
<legend>
    <spring:message code="label.seizures"/>
</legend>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="seizureFrequency">
        <spring:message code="label.seizureFrequency"/>
    </label>

    <div class="col-xs-8">
        <form:select id="seizureFrequency"
                     class="form-control input-sm"
                     type="text"
                     path="seizureSeizureFrequency">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.seizureFrequency.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.seizureFrequency.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.seizureFrequency.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.seizureFrequency.4"/>
            </form:option>
        </form:select>
    </div>
</div>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName"
               value="seizureSecondarilyGeneralizedSeizure"/>
    <jsp:param name="messageCode"
               value="secondarilyGeneralizedSeizure"/>
</jsp:include>

<jsp:include page="../decideRadiobuttons.jsp">
    <jsp:param name="propertyName"
               value="seizureStatusEpilepticus"/>
    <jsp:param name="messageCode"
               value="statusEpilepticus"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="sscClassification">
        <spring:message code="label.sscClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select id="sscClassification"
                     class="form-control input-sm"
                     type="text"
                     path="seizureSscClassification">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.sscClassification.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.sscClassification.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.sscClassification.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.sscClassification.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.sscClassification.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.sscClassification.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.sscClassification.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.sscClassification.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.sscClassification.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.sscClassification.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.sscClassification.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.sscClassification.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.sscClassification.13"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.sscClassification.14"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.sscClassification.15"/>
            </form:option>
            <form:option value="16">
                <spring:message code="label.sscClassification.16"/>
            </form:option>
            <form:option value="17">
                <spring:message code="label.sscClassification.17"/>
            </form:option>
            <form:option value="18">
                <spring:message code="label.sscClassification.18"/>
            </form:option>
            <form:option value="19">
                <spring:message code="label.sscClassification.19"/>
            </form:option>
            <form:option value="20">
                <spring:message code="label.sscClassification.20"/>
            </form:option>
            <form:option value="21">
                <spring:message code="label.sscClassification.21"/>
            </form:option>
            <form:option value="22">
                <spring:message code="label.sscClassification.22"/>
            </form:option>
            <form:option value="23">
                <spring:message code="label.sscClassification.23"/>
            </form:option>
            <form:option value="24">
                <spring:message code="label.sscClassification.24"/>
            </form:option>
            <form:option value="25">
                <spring:message code="label.sscClassification.25"/>
            </form:option>
            <form:option value="26">
                <spring:message code="label.sscClassification.26"/>
            </form:option>
            <form:option value="27">
                <spring:message code="label.sscClassification.27"/>
            </form:option>
            <form:option value="28">
                <spring:message code="label.sscClassification.28"/>
            </form:option>
            <form:option value="29">
                <spring:message code="label.sscClassification.29"/>
            </form:option>

        </form:select>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="ilaeClassification">
        <spring:message code="label.ilaeClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select id="ilaeClassification"
                     class="form-control input-sm"
                     type="text"
                     path="seizureIlaeClassification">
            <form:option value="0">
                <spring:message code="label.notDistinguish"/>
            </form:option>
            <form:option value="1">
                <spring:message code="label.ilaeClassification.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.ilaeClassification.2"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.ilaeClassification.3"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.ilaeClassification.4"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.ilaeClassification.5"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.ilaeClassification.6"/>
            </form:option>
            <form:option value="7">
                <spring:message code="label.ilaeClassification.7"/>
            </form:option>
            <form:option value="8">
                <spring:message code="label.ilaeClassification.8"/>
            </form:option>
            <form:option value="9">
                <spring:message code="label.ilaeClassification.9"/>
            </form:option>
            <form:option value="10">
                <spring:message code="label.ilaeClassification.10"/>
            </form:option>
            <form:option value="11">
                <spring:message code="label.ilaeClassification.11"/>
            </form:option>
            <form:option value="12">
                <spring:message code="label.ilaeClassification.12"/>
            </form:option>
            <form:option value="13">
                <spring:message code="label.ilaeClassification.13"/>
            </form:option>
            <form:option value="14">
                <spring:message code="label.ilaeClassification.14"/>
            </form:option>
            <form:option value="15">
                <spring:message code="label.ilaeClassification.15"/>
            </form:option>

        </form:select>
    </div>
</div>


<div class="form-group">
    <label class="col-xs-4 control-label"
           for="seizureSeizureOccurence">
        <spring:message code="label.occurrence"/>
    </label>


    <div id="seizureSeizureOccurence"
         class="col-xs-8">
        <form:radiobutton id="seizureOccurence1"
                          value="1"
                          path="seizureSeizureOccurence"/>
        <label for="seizureOccurence1">
            <spring:message code="label.seizureOccurence.1"/>
        </label>

        <form:radiobutton id="seizureOccurence2"
                          value="2"
                          path="seizureSeizureOccurence"/>
        <label for="seizureOccurence2">
            <spring:message code="label.seizureOccurence.2"/>
        </label>

        <form:radiobutton id="seizureOccurence3"
                          value="3"
                          path="seizureSeizureOccurence"/>
        <label for="seizureOccurence3">
            <spring:message code="label.seizureOccurence.3"/>
        </label>

        <c:choose>
            <c:when test="${toCheck}">
                <form:radiobutton id="seizureOccurence4"
                                  value="4"
                                  checked="true"
                                  path="seizureSeizureOccurence"/>
                <label for="seizureOccurence4">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </c:when>
            <c:otherwise>
                <form:radiobutton id="seizureOccurence4"
                                  value="4"
                                  path="seizureSeizureOccurence"/>
                <label for="seizureOccurence4">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</fieldset>