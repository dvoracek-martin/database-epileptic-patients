<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.corticalMapping"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.corticalMapping"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

    <jsp:body>
        <div>
            <div class="span5">
                <h2><spring:message code="label.corticalMapping"/></h2>
            </div>
            <div>
                <h3 class="pull-right">
                    <a id="export"
                       href="<c:url value="/patient/${patient.id}/invasiveTestCorticalMapping/create" />"><spring:message
                            code="label.addRecord"/></a>
                </h3>
            </div>
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
                <td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>

            </tr>
            </tbody>
        </table>


        <!-- invasiveTestCorticalMapping list START -->
        <div class="accordion">
            <c:set var="count" value="0" scope="page"/>
            <c:forEach items="${patient.invasiveTestCorticalMappingList}" var="invasiveTestCorticalMapping">
                <c:if test="${invasiveTestCorticalMapping.status==0}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <div>
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                               href="#collapse${invasiveTestCorticalMapping.id}">
                                <strong><spring:message
                                        code="label.dateOfContractAward"/>:</strong> ${invasiveTestCorticalMapping.date}
                            </a>
                        </div>

                        <div id="collapse${invasiveTestCorticalMapping.id}" class="accordion-body collapse">

                            <div class="accordion-inner">
                                <div class="label-info"
                                     style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
                                    <div class="pull-right">
                                        <a class="close"
                                           href="<c:url value="/patient/${patientID}/invasiveTestCorticalMapping/${invasiveTestCorticalMapping.id}/hide"/>"><spring:message
                                                code="label.delete"/></a>
                                    </div>
                                    <div class="pull-left">
                                        <a class="close"
                                           href="<c:url value="/patient/${patientID}/invasiveTestCorticalMapping/list"/>"><spring:message
                                                code="label.edit"/></a>
                                    </div>
                                    </br>
                                </div>
                                <table class="table">
                                    <tbody>
                                    <tr class="info">
                                        <td><spring:message code="label.invasiveCorticalMappingTest"/></td>
                                        <c:if test="${invasiveTestCorticalMapping.done==1}">
                                            <td><spring:message code="label.done"/></td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.done==2}">
                                            <td><spring:message code="label.notDone"/></td>
                                        </c:if>
                                    </tr>
                                    <tr class="info">
                                        <td><spring:message code="label.corticalMapping"/></td>
                                        <c:if test="${empty invasiveTestCorticalMapping.corticalMapping}">
                                            <td>-</td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==1}">
                                            <td>Awake craniotomy</td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==2}">
                                            <td><spring:message code="label.extraoperativeElectricalStimulation"/></td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==3}">
                                            <td><spring:message code="label.functionalMappingDone"/></td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==4}">
                                            <td><spring:message code="label.intraoperativeElectricalStimulation"/></td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==5}">
                                            <td><spring:message code="label.intraoperativeElectricalStimulation"/> +
                                                <spring:message code="label.intactnessMonitoringRailways"/></td>
                                        </c:if>
                                        <c:if test="${invasiveTestCorticalMapping.corticalMapping==6}">
                                            <td><spring:message code="label.notDone"/></td>
                                        </c:if>
                                    </tr>
                                    <tr class="info">
                                        <td><spring:message code="label.comment"/></td>
                                        <c:choose>
                                            <c:when test="${empty invasiveTestCorticalMapping.comment}">
                                                <td><spring:message code="label.noComments"/></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>${invasiveTestCorticalMapping.comment}</td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
            <c:if test="${count==0}">
                <div class="alert alert-block">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4><spring:message code="label.noRecords"/></h4>
                </div>
            </c:if>
        </div>
        </br>
    </jsp:body>
</t:menuLVL3>


