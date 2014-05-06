<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="patient"
             scope="request"
             type="cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO"/>

<sec:authorize ifAllGranted="ROLE_USER,ROLE_RESEARCHER"
               ifNotGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
               var="researcherAccess"/>

<div class="row">
    <div class="col-xs-12">
        <div class="table-responsive">
            <table class="table table-condensed">
                <c:choose>
                    <c:when test="${not researcherAccess}">

                        <tr>
                            <th>
                                <spring:message code="label.patient"/>:
                            </th>
                            <td>
                                    ${patient.contact.firstName} ${patient.contact.lastName}
                            </td>

                            <th>
                                <spring:message code="label.birthIdentificationNumber"/>:
                            </th>
                            <td>
                                    ${patient.nin}
                            </td>

                            <th>
                                <spring:message code="label.birthdate"/>:
                            </th>
                            <td>
                                    ${patient.birthday} (${patient.age}) let
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="label.assignedDoctor"/>:
                            </th>
                            <td>
                                    ${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}
                            </td>

                            <th>
                                <spring:message code="label.gender"/>:
                            </th>
                            <td>
                                <spring:message code="label.gender.${patient.gender}"/>
                            </td>
                            <th>
                                <spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:
                            </th>
                            <td>
                                <c:if test="${!empty patient.ageAtTheBeginningOfEpilepsy}">
                                    ${patient.ageAtTheBeginningOfEpilepsy}
                                    <spring:message code="label.years"/>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="label.address"/>:
                            </th>
                            <td>
                                <c:if test="${!empty patient.contact.addressStreet}">
                                    ${patient.contact.addressStreet},
                                </c:if>
                                <c:if test="${!empty patient.contact.addressCity}">
                                    ${patient.contact.addressCity},
                                </c:if>
                                    ${patient.contact.addressCountry}
                            </td>
                            <th>
                                <spring:message code="label.telephone"/>:
                            </th>
                            <td>
                                    ${patient.contact.phoneNumber}
                            </td>
                            <th>
                                <spring:message code="label.email"/>:
                            </th>
                            <td>
                                    ${patient.contact.email}
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <th>
                                <spring:message code="label.patient"/>:
                            </th>
                            <td>
                                ****
                            </td>
                            <th>
                                <spring:message code="label.birthIdentificationNumber"/>:
                            </th>
                            <td>
                                    ${patient.nin}
                            </td>
                            <th>
                                <spring:message code="label.birthdate"/>:
                            </th>
                            <td>
                                    ${patient.birthday} (${patient.age}) let
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="label.assignedDoctor"/>:
                            </th>
                            <td>
                                    ${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}
                            </td>
                            <th>
                                <spring:message code="label.gender"/>:
                            </th>
                            <td>
                                <spring:message code="label.gender.${patient.gender}"/>
                            </td>
                            <th>
                                <spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:
                            </th>
                            <td>
                                <c:if test="${!empty patient.ageAtTheBeginningOfEpilepsy}">
                                    ${patient.ageAtTheBeginningOfEpilepsy} let
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <spring:message code="label.address"/>:
                            </th>
                            <td>
                                <c:if test="${!empty patient.contact.addressStreet}">
                                    ${patient.contact.addressStreet},
                                </c:if>
                                <c:if test="${!empty patient.contact.addressCity}">
                                    ${patient.contact.addressCity},
                                </c:if>
                                    ${patient.contact.addressCountry}
                            </td>
                            <th>
                                <spring:message code="label.telephone"/>:
                            </th>
                            <td>
                                    ${patient.contact.phoneNumber}
                            </td>
                            <th>
                                <spring:message code="label.email"/>:
                            </th>
                            <td>
                                    ${patient.contact.email}
                            </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>

    </div>
    <c:if test="${not patient.verified}">
        <div class="col-xs-12">
            <p class="pull-right text-danger">
                <spring:message code="label.recordsNotVerified"/>
            </p>
        </div>
    </c:if>
</div>