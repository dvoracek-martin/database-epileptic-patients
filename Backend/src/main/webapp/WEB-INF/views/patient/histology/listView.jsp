<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL3>

	<jsp:attribute name="title">
      <spring:message code="label.histology"/>
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.histology"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    	
	</jsp:attribute>

    <jsp:body>
        <div>
            <div class="span5">
                <h2><spring:message code="label.histology"/></h2>
            </div>
            <div>
                <h3 class="pull-right">
                    <a id="export"
                       href="<c:url value="/patient/${patientID}/histology/create" />"><spring:message
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

        <!-- histology list START -->
        <div class="accordion">
            <c:set var="count" value="0" scope="page"/>
            <c:forEach items="${patient.histologyList}" var="histology">
                <c:if test="${histology.status==0}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <div>
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
                               href="#collapse${histology.id}">
                                <strong><spring:message code="label.dateOfContractAward"/>:</strong> ${histology.date}
                            </a>
                        </div>

                        <div id="collapse${histology.id}" class="accordion-body collapse">

                            <div class="accordion-inner">
                                <div class="label-info"
                                     style="border-radius: 5px; padding-top: 5px; padding-left: 5px; padding-right: 5px">
                                    <div class="pull-right">
                                        <a class="close"
                                           href="<c:url value="/patient/${patientID}/histology/${histology.id}/hide"/>"><spring:message
                                                code="label.delete"/></a>
                                    </div>
                                    <div class="pull-left">
                                        <a class="close"
                                           href="<c:url value="/patient/${patientID}/histology/list"/>"><spring:message
                                                code="label.edit"/></a>
                                    </div>
                                    </br>
                                </div>
                                <table class="table">
                                    <tbody>
                                    <tr class="info">
                                        <td><spring:message code="label.histopathology"/></td>
                                        <c:if test="${histology.histopathology==1}">
                                            <td>FCD</td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==2}">
                                            <td><spring:message code="label.glialLesions"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==3}">
                                            <td>HS</td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==4}">
                                            <td><spring:message code="label.hamartoma"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==5}">
                                            <td>MCD <spring:message code="label.other"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==6}">
                                            <td><spring:message code="label.unavialable"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==7}">
                                            <td><spring:message code="label.normal"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==8}">
                                            <td><spring:message code="label.tumor"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==9}">
                                            <td><spring:message code="label.post-traumaticChanges"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==10}">
                                            <td>SWC</td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==11}">
                                            <td>TSC</td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==12}">
                                            <td><spring:message code="label.vascularLesions"/></td>
                                        </c:if>
                                        <c:if test="${histology.histopathology==12}">
                                            <td><spring:message code="label.inflammatoryLesions"/></td>
                                        </c:if>
                                    </tr>
                                    <tr class="info">
                                        <td><spring:message code="label.FCDClasification"/></td>
                                        <c:if test="${empty histology.fcdClasification}">
                                            <td>-</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==1}">
                                            <td>0</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==2}">
                                            <td>FCD <spring:message code="label.type"/> lla</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==3}">
                                            <td>FCD <spring:message code="label.type"/> llb</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==4}">
                                            <td>FCD <spring:message code="label.type"/> la</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==5}">
                                            <td>FCD <spring:message code="label.type"/> lb</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==6}">
                                            <td>mMCD <spring:message code="label.type"/> l</td>
                                        </c:if>
                                        <c:if test="${histology.fcdClasification==7}">
                                            <td>mMCD <spring:message code="label.type"/> ll</td>
                                        </c:if>
                                    </tr>
                                    <tr class="info">
                                        <td><spring:message code="label.comment"/></td>
                                        <c:choose>
                                            <c:when test="${empty histology.comment}">
                                                <td><spring:message code="label.noComments"/></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>${histology.comment}</td>
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


