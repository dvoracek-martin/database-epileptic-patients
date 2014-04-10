<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.advancedSearch"/>
    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/advanced-search.js" />"></script>
    </jsp:attribute>

<jsp:body>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <spring:message code="label.advancedSearch"/>
        </h2>
    </div>
    <div class="col-xs-6">
        <h3 class="pull-right">
            <a href="<c:url value="/advanced-search/load" />">
                <spring:message code="label.load"/>
            </a>
        </h3>
    </div>
</div>

<form:form id="advancedSearchForm"
           class="form-horizontal"
           method="POST"
           action="/GENEPI/advanced-search"
           role="form"
           commandName="advancedSearch">

<fieldset>
    <legend>
        <spring:message code="label.generalParametersSpecificPerson"/>
    </legend>

    <div class="form-group">
        <label for="patientFirstname" class="col-xs-4 control-label">
            <spring:message code="label.firstname"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientFirstname"
                        class="form-control input-sm"
                        type="text"
                        path="patientFirstname"/>

            <form:errors path="patientFirstname"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientLastname" class="col-xs-4 control-label">
            <spring:message code="label.lastname"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientLastname"
                        class="form-control input-sm"
                        type="text"
                        path="patientLastname"/>

            <form:errors path="patientLastname"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientLastname" class="col-xs-4 control-label">
            <spring:message code="label.nin"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientNin"
                        class="form-control input-sm"
                        type="text"
                        path="patientNin"/>

            <form:errors path="patientNin"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientCity" class="col-xs-4 control-label">
            <spring:message code="label.addressCity"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientCity"
                        class="form-control input-sm"
                        type="text"
                        path="patientCity"/>

            <form:errors path="patientCity"
                         cssClass="text-danger"/>
        </div>
    </div>

    <div class="form-group">
        <label for="patientCountry" class="col-xs-4 control-label">
            <spring:message code="label.addressCountry"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientCountry"
                        class="form-control input-sm"
                        type="text"
                        path="patientCountry"/>

            <form:errors path="patientCountry"
                         cssClass="text-danger"/>
        </div>
    </div>

</fieldset>


<fieldset>
    <legend>
        <spring:message code="label.generalParameters"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientGender">
            <spring:message code="label.gender"/>
        </label>

        <div id="patientGender" class="col-xs-8">
            <form:radiobutton path="patientGender" value="1"/>
            <spring:message code="label.male"/>

            <form:radiobutton path="patientGender" value="2"/>
            <spring:message code="label.female"/>

            <form:radiobutton path="patientGender" value="3" checked="true"/>
            <spring:message code="label.notDistinguish"/>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeFilter">
            <spring:message code="label.age"/>
        </label>

        <div class="col-xs-8">
            <form:select id="patientAgeFilter"
                         class="form-control input-sm"
                         type="text"
                         path="patientAgeFilter">

                <form:option value="=">
                    =
                </form:option>
                <form:option value=">">
                    >
                </form:option>
                <form:option value="<">
                    <
                </form:option>
                <form:option value=">=">
                    >=
                </form:option>
                <form:option value="<=">
                    <=
                </form:option>
            </form:select>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAge">
            <spring:message code="label.age"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientAge"
                        class="form-control input-sm"
                        type="text"
                        path="patientAge"/>

            <form:errors path="patientAge"
                         cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeEpilepsyFilter"><strong><spring:message
                code="label.age"/>patientAgeEpilepsyFilter</strong></label>

        <div class="col-xs-8">
            <form:select id="patientAgeEpilepsyFilter"
                         class="form-control input-sm"
                         type="text"
                         path="patientAgeEpilepsyFilter">

                <form:option value="=">=</form:option>
                <form:option value=">">
                    >
                </form:option>
                <form:option value="<">
                    <
                </form:option>
                <form:option value=">=">
                    >=
                </form:option>
                <form:option value="<=">
                    <=
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientAgeEpilepsy">
            <spring:message code="label.ageAtTheBeginningOfEpilepsy"/>
        </label>

        <div class="col-xs-8">
            <form:input id="patientAgeEpilepsy"
                        class="form-control input-sm"
                        type="text"
                        path="patientAgeEpilepsy"/>

            <form:errors path="patientAgeEpilepsy"
                         cssClass="error">
            </form:errors>
        </div>
    </div>


    <div class="form-group">
        <label class="col-xs-4 control-label" for="patientDoctor">
            <spring:message code="label.doctor"/>
        </label>

        <div class="col-xs-8">
            <form:select id="patientDoctor"
                         class="form-control input-sm"
                         type="text"
                         path="patientDoctor">

                <form:option value="0">
                    Nezvoleno
                </form:option>
                <c:forEach items="${doctors}" var="doctor">
                    <form:option value="${doctor.id}">
                        ${doctor.contact.firstName} ${doctor.contact.lastName}
                    </form:option>
                </c:forEach>
            </form:select>
        </div>
    </div>

</fieldset>

<fieldset>
    <legend>
        <spring:message code="label.includeParametersFrom"/>
    </legend>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="anamnesis"/>
        <jsp:param name="messageCode" value="anamnesis"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="seizure"/>
        <jsp:param name="messageCode" value="seizures"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="pharmacotherapy"/>
        <jsp:param name="messageCode" value="pharmacotherapy"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="neurologicalFinding"/>
        <jsp:param name="messageCode" value="neurologicalFinding"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="neuropsychology"/>
        <jsp:param name="messageCode" value="neuropsychology"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="diagnosticTestScalpEeg"/>
        <jsp:param name="messageCode" value="diagnosticTestScalpEeg"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="diagnosticTestMri"/>
        <jsp:param name="messageCode" value="diagnosticTestMri"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="invasiveTestEeg"/>
        <jsp:param name="messageCode" value="invasiveTestIeeg"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="invasiveTestEcog"/>
        <jsp:param name="messageCode" value="invasiveTestECoG"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="operation"/>
        <jsp:param name="messageCode" value="operation"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="histology"/>
        <jsp:param name="messageCode" value="histology"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="complication"/>
        <jsp:param name="messageCode" value="complication"/>
    </jsp:include>

    <jsp:include page="../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="outcome"/>
        <jsp:param name="messageCode" value="outcome"/>
    </jsp:include>

</fieldset>

<fieldset id="anamnesisFieldset">
    <legend>
        <spring:message code="label.anamnesis"/>
    </legend>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisEpilepsyInFamily"/>
        <jsp:param name="messageCode" value="epilepsyInFamily"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisPrenatalRisk"/>
        <jsp:param name="messageCode" value="prenatalRisk"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisFibrilConvulsions"/>
        <jsp:param name="messageCode" value="fibrilConvulsions"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisInflammationCns"/>
        <jsp:param name="messageCode" value="inflammationCns"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisInjuryCns"/>
        <jsp:param name="messageCode" value="injuryCns"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisOperationCns"/>
        <jsp:param name="messageCode" value="operationCns"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisEarlyPmdRetardation"/>
        <jsp:param name="messageCode" value="earlyPmdRetardation"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisFirstFever"/>
        <jsp:param name="messageCode" value="firstFever"/>
    </jsp:include>

    <jsp:include page="decideRadiobuttons.jsp">
        <jsp:param name="propertyName" value="anamnesisInfantileSpasm"/>
        <jsp:param name="messageCode" value="infantileSpasm"/>
    </jsp:include>

    <div class="form-group">
        <label for="anamnesisSpecificSyndrome" class="col-xs-4 control-label">
            <spring:message code="label.epilepticSyndrome"/>
        </label>

        <div class="col-xs-8">
            <form:select path="anamnesisSpecificSyndrome" id="anamnesisSpecificSyndrome" type="text"
                         class="form-control input-sm">
                <form:option value="0">
                    <spring:message code="label.specificSyndrome.0"/>
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

<fieldset id="seizureFieldset">
<legend>
    <spring:message code="label.seizures"/>
</legend>

<div class="form-group">
    <label for="seizureFrequency" class="col-xs-4 control-label">
        <spring:message code="label.seizureFrequency"/>
    </label>

    <div class="col-xs-8">
        <form:select path="seizureSeizureFrequency" id="seizureFrequency" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.seizureFrequency.0"/>
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

<jsp:include page="decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="seizureSecondarilyGeneralizedSeizure"/>
    <jsp:param name="messageCode" value="secondarilyGeneralizedSeizure"/>
</jsp:include>

<jsp:include page="decideRadiobuttons.jsp">
    <jsp:param name="propertyName" value="seizureStatusEpilepticus"/>
    <jsp:param name="messageCode" value="statusEpilepticus"/>
</jsp:include>

<div class="form-group">
    <label class="col-xs-4 control-label" for="sscClassification">
        <spring:message code="label.sscClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select path="seizureSscClassification" id="sscClassification" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.sscClassification.0"/>
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
    <label class="col-xs-4 control-label" for="ilaeClassification">
        <spring:message code="label.ilaeClassification"/>
    </label>

    <div class="col-xs-8">
        <form:select path="seizureIlaeClassification" id="ilaeClassification" type="text" class="form-control input-sm">
            <form:option value="0">
                <spring:message code="label.ilaeClassification.0"/>
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
    <label class="col-xs-4 control-label" for="seizureSeizureOccurence">
        <spring:message code="label.occurrence"/>
    </label>

    <c:choose>
        <c:when test="${toCheck}">
            <div id="seizureSeizureOccurence" class="col-xs-8">
                <form:radiobutton id="seizureOccurence1" path="seizureSeizureOccurence" value="1"/>
                <label for="seizureOccurence1">
                    <spring:message code="label.seizureOccurence.1"/>
                </label>

                <form:radiobutton id="seizureOccurence2" path="seizureSeizureOccurence" value="2"/>
                <label for="seizureOccurence2">
                    <spring:message code="label.seizureOccurence.2"/>
                </label>

                <form:radiobutton id="seizureOccurence3" path="seizureSeizureOccurence" value="3"/>
                <label for="seizureOccurence3">
                    <spring:message code="label.seizureOccurence.3"/>
                </label>

                <form:radiobutton id="seizureOccurence4" path="seizureSeizureOccurence" value="4" checked="true"/>
                <label for="seizureOccurence4">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </div>
        </c:when>
        <c:otherwise>
            <div id="seizureSeizureOccurence" class="col-xs-8">
                <form:radiobutton id="seizureOccurence1" path="seizureSeizureOccurence" value="1"/>
                <label for="seizureOccurence1">
                    <spring:message code="label.seizureOccurence.1"/>
                </label>

                <form:radiobutton id="seizureOccurence2" path="seizureSeizureOccurence" value="2"/>
                <label for="seizureOccurence2">
                    <spring:message code="label.seizureOccurence.2"/>
                </label>

                <form:radiobutton id="seizureOccurence3" path="seizureSeizureOccurence" value="3"/>
                <label for="seizureOccurence3">
                    <spring:message code="label.seizureOccurence.3"/>
                </label>

                <form:radiobutton id="seizureOccurence4" path="seizureSeizureOccurence" value="4"/>
                <label for="seizureOccurence4">
                    <spring:message code="label.notDistinguish"/>
                </label>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</fieldset>

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

<div class="form-group">
    <div class="col-xs-offset-4 col-xs-8">
        <button id="searchButton" class="btn btn-primary" type="submit">
            <spring:message code="label.search"/>
        </button>
    </div>
</div>


<fieldset>
    <legend>
        <spring:message code="label.saveParameters"/>
    </legend>

    <div class="form-group">
        <label class="col-xs-4 control-label" for="saveName">
            <spring:message code="label.name"/>
        </label>

        <div class="col-xs-6">
            <form:input id="saveName"
                        class="form-control input-sm"
                        type="text"
                        path="name"/>

            <form:errors path="name"
                         cssClass="error">
            </form:errors>
        </div>

        <div class="col-xs-2">
            <button id="saveButton" class="btn btn-primary">
                <spring:message code="label.save"/>
            </button>
        </div>
    </div>
</fieldset>

</form:form>

</jsp:body>
</t:menuLVL1>