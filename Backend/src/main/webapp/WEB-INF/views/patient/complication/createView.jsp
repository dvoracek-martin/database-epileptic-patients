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
	  <style>
          #title {
              color: black;
              font-weight: bold;
          }
      </style>
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
            <h2><spring:message code="label.complication"/></h2>
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
                   action="/GENEPI/patient/${patientID}/complication/create" commandName="complication">

            <div class="control-group">
                <label class="control-label" for="date"><strong><spring:message code="label.dateExamination"/></strong></label>

                <div class="controls">
                    <form:input path="date" id="date" type="text" class="input-medium datepicker"/>
                    <form:errors path="date" cssClass="error">
                    </form:errors>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="withComplication"><strong><spring:message
                        code="label.process"/></strong></label>

                <div class="controls">
                    <form:select path="withComplication" id="withComplication" type="text" class="input-large">
                        <form:option value="false">
                            <spring:message code="label.withoutComplications"/>
                        </form:option>
                        <form:option value="true">
                            <spring:message code="label.withComplications"/>
                        </form:option>
                    </form:select>
                </div>
            </div>

            <div id="complications">
                <div class="control-group">
                    <label class="control-label" for="complicationType"><strong><spring:message
                            code="label.typeComplication"/></strong></label>

                    <div class="controls">
                        <form:select path="complicationType" id="complicationType" type="text" class="input-large">
                            <form:option value="1">
                                <spring:message code="label.unexpectedPermanent"/>
                            </form:option>
                            <form:option value="2">
                                <spring:message code="label.expectedPermanent"/>
                            </form:option>
                            <form:option value="3">
                                <spring:message code="label.transitional"/>
                            </form:option>
                        </form:select>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="complication"><strong><spring:message
                            code="label.complication"/></strong></label>

                    <div class="controls">
                        <form:select path="complication" id="complication" type="text" class="input-large">
                            <form:option value="1">
                                <spring:message code="label.aphasia"/>
                            </form:option>
                            <form:option value="2">
                                <spring:message code="label.edema"/>
                            </form:option>
                            <form:option value="3">
                                <spring:message code="label.hemiparesis"/>
                            </form:option>
                            <form:option value="4">
                                <spring:message code="label.hydrocefalus"/>
                            </form:option>
                            <form:option value="5">
                                <spring:message code="label.ischemia"/>
                            </form:option>
                            <form:option value="6">
                                <spring:message code="label.other"/>
                            </form:option>
                            <form:option value="7">
                                <spring:message code="label.hemorrhage"/>
                            </form:option>
                            <form:option value="8">
                                <spring:message code="label.paresisOfCranialNerves"/>
                            </form:option>
                            <form:option value="9">
                                <spring:message code="label.visualFieldDefects"/>
                            </form:option>
                            <form:option value="10">
                                <spring:message code="label.death"/>
                            </form:option>
                            <form:option value="11">
                                <spring:message code="label.inflammation"/>
                            </form:option>
                        </form:select>
                    </div>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="comment"><strong><spring:message
                        code="label.comment"/></strong></label>

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


