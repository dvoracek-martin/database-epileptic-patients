<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>
<div class="row">
    <div class="col-xs-12">
        <div class="table-responsive">
            <table class="table table-condensed">
                <tbody>
                <tr>
                    <th><spring:message code="label.patient"/>:</th>
                    <td>${patient.contact.firstName} ${patient.contact.lastName}</td>

                    <th><spring:message code="label.birthIdentificationNumber"/>:</th>
                    <td>${patient.nin}</td>

                    <th><spring:message code="label.address"/>:</th>
                    <td>${patient.contact.addressStreet}</td>

                    <th><spring:message code="label.telephone"/>:</th>
                    <td>${patient.contact.phoneNumber}</td>
                </tr>
                <tr>
                    <th><spring:message code="label.birthdate"/>:</th>
                    <td>${patient.birthday} (${currentAge} let)</td>

                    <th><spring:message code="label.gender"/>:</th>
                    <td><spring:message code="label.gender.${patient.gender}"/></td>

                    <td></td>
                    <td>${patient.contact.addressCity}</td>

                    <th><spring:message code="label.email"/>:</th>
                    <td>${patient.contact.email}</td>
                </tr>
                <tr>
                    <th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
                    <td>(${beginningEpilepsy} let)</td>

                    <th><spring:message code="label.assignedDoctor"/>:</th>
                    <td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>

                    <td></td>
                    <td>${patient.contact.addressCountry}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>