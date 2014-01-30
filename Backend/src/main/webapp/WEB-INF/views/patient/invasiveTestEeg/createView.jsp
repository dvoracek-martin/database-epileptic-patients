<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL3>
<jsp:attribute name="head">
      <link
              href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
              rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.addRecord"/>
    </jsp:attribute>
	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
   </jsp:attribute>
<jsp:body>

<div class="span5">
    <h2><spring:message code="label.invasiveTestEEG"/></h2>
</div>

<table class="table">
    <tbody>
    <tr>
        <th><spring:message code="label.patient"/>:</th>
        <td>${patient.contact.firstName}</td>

        <th><spring:message code="label.birthIdentificationNumber"/>:</th>
        <td>${patient.nin}</td>

        <th><spring:message code="label.birthdate"/>:</th>
        <td>${patient.birthday}</td>

    </tr>
    <tr>
        <th><spring:message code="label.address"/>:</th>
        <td>${patient.contact.addressStreet}</td>

        <th><spring:message code="label.telephone"/>:</th>
        <td>${patient.contact.phoneNumber}</td>

        <th><spring:message code="label.email"/>:</th>
        <td>${patient.contact.email}</td>


    </tr>
    <tr>
        <th><spring:message code="label.gender"/>:</th>
        <td>${patient.gender}</td>

        <th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
        <td></td>

        <th><spring:message code="label.assignedDoctor"/>:</th>
        <td></td>

    </tr>
    </tbody>
</table>

<!-- form for adding new record -->
<!-- mapping resource in action with c:url caused errors -->
<form:form class="form-horizontal" method="POST"
           action="/GENEPI/patient/${patientID}/invasiveTestEEG/create" commandName="invasiveTestEEG">

    <div class="control-group">
        <label class="control-label" for="date"><strong><spring:message
                code="label.dateOfContractAward"/></strong></label>

        <div class="controls">
            <form:input path="date" id="date" type="text" class="input-medium datepicker"/>
            <form:errors path="date" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="done"><strong><spring:message code="label.invasiveTestEEG"/></strong></label>

        <div class="controls">
            <form:select path="done" id="done" type="text" class="input-large">
                <form:option value="false">
                    <spring:message code="label.notDone"/>
                </form:option>
                <form:option value="true">
                    <spring:message code="label.done"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="intracranialElectrodes"><strong><spring:message
                code="label.intracranialElectrodes"/></strong></label>

        <div class="controls">
            <form:select path="intracranialElectrodes" id="intracranialElectrodes" type="text" class="input-large">
                <form:option value="1">
                    <spring:message code="label.IC"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.IcSd"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.IcSdStripsGrids"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.Sd"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.SdGrids"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.Grids"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.IcSdGrids"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="localizationIntracranialElectrodes"><strong><spring:message
                code="label.localizationIntracranialElectrodes"/></strong></label>

        <div class="controls">
            <form:textarea path="localizationIntracranialElectrodes" id="localizationIntracranialElectrodes"
                           input="localizationIntracranialElectrodes"/>
            <form:errors path="localizationIntracranialElectrodes" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="invasiveEegSlow"><strong><spring:message
                code="label.invasiveEEGSlowing"/></strong></label>

        <div class="controls">
            <form:select path="invasiveEegSlow" id="invasiveEegSlow" type="text" class="input-large">
                <form:option value="1">
                    <spring:message code="label.generalizedIntermittent"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.generalizedContinuous"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.localizedIntermittent"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.localizedContinuous"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.absent"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="invasiveEegInterictalSpikes"><strong><spring:message
                code="label.invasiveEEGInterictalSpikes"/></strong></label>

        <div class="controls">
            <form:select path="invasiveEegInterictalSpikes" id="invasiveEegInterictalSpikes" type="text"
                         class="input-large">
                <form:option value="1">
                    <spring:message code="label.missing"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.focal"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.multiregional"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.notlocalizable"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.regional"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="localizationInvasiveEegInterictalSpikes"><strong><spring:message
                code="label.localizationInvasiveEEGInterictalSpikes"/></strong></label>

        <div class="controls">
            <form:textarea path="localizationInvasiveEegInterictalSpikes" id="localizationInvasiveEegInterictalSpikes"
                           input="localizationInvasiveEegInterictalSpikes"/>
            <form:errors path="localizationInvasiveEegInterictalSpikes" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="invasiveEegStatusEpilepticus"><strong><spring:message
                code="label.invasiveEEGStatusEpilepticus"/></strong></label>

        <div class="controls">
            <form:checkbox path="invasiveEegStatusEpilepticus" input="invasiveEegStatusEpilepticus"
                           class="input-block-level"/>
            <form:errors path="invasiveEegStatusEpilepticus" cssClass="error">
            </form:errors>
        </div>
    </div>


    <div class="control-group">
        <label class="control-label" for="invasiveIctalEegPatterns"><strong><spring:message
                code="label.invasiveIctalEEGPatterns"/></strong></label>

        <div class="controls">
            <form:select path="invasiveIctalEegPatterns" id="invasiveIctalEegPatterns" type="text" class="input-large">
                <form:option value="1">
                    <spring:message code="label.missing"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.focal"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.multiregional"/>
                </form:option>
                <form:option value="4">
                </form:option>
                <form:option value="5">
                    <spring:message code="label.regional"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="comment"><strong><spring:message code="label.comment"/></strong></label>

        <div class="controls">
            <form:textarea path="comment" id="comment"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button class="btn btn-primary" type="submit"><spring:message code="label.add"/></button>
        </div>
    </div>
</form:form>
</jsp:body>
</t:menuLVL3>


