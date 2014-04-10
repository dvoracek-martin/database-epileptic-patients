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