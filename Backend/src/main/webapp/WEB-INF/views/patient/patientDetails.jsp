<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="row">
    <div class="col-xs-12">
        <div class="table-responsive">
            <table class="table table-condensed">
                <tr>
                    <th><spring:message code="label.patient"/>:</th>
                    <td>
                        <%--   <c:choose>--%>
                        <%--   <c:when test="researcheraccess">--%>
                        ${patient.contact.firstName} ${patient.contact.lastName}
                        <%--   </c:when>
                          <c:otherwise>
                              *****
                          </c:otherwise>
                      </c:choose>--%></td>

                    <th><spring:message code="label.birthIdentificationNumber"/>:</th>
                    <td>${patient.nin}</td>

                    <th><spring:message code="label.birthdate"/>:</th>
                    <td>${patient.birthday} (${patient.age}) let</td>
                </tr>
                <tr>
                    <th><spring:message code="label.assignedDoctor"/>:</th>
                    <td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>

                    <th><spring:message code="label.gender"/>:</th>
                    <td><spring:message code="label.gender.${patient.gender}"/></td>

                    <th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
                    <td>${beginningEpilepsy} let</td>
                </tr>
                <tr>
                    <th><spring:message code="label.address"/>:</th>
                    <td>${patient.contact.addressStreet}, ${patient.contact.addressCity}, ${patient.contact.addressCountry}</td>

                    <th><spring:message code="label.telephone"/>:</th>
                    <td>${patient.contact.phoneNumber}</td>

                    <th><spring:message code="label.email"/>:</th>
                    <td>${patient.contact.email}</td>
                </tr>
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