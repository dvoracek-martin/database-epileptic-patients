<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.anamnesis"/>
    </jsp:attribute>

<jsp:attribute name="head">
     <link href="<c:url value="/resources/css/hidden.NEW303.css" />"
           rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.anamnesis"/>
                </h2>

            </div>
            <div class="col-xs-6">
                <h3 class="pull-right">
                    <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />">
                        <spring:message code="label.addRecord"/></a>
                </h3>
            </div>
        </div>

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
                    <td>${patient.birthday}</td>

                    <th><spring:message code="label.gender"/>:</th>
                    <td>${patient.gender}</td>

                    <td></td>
                    <td>${patient.contact.addressCity}</td>

                    <th><spring:message code="label.email"/>:</th>
                    <td>${patient.contact.email}</td>
                </tr>
                <tr>
                    <th><spring:message code="label.ageAtTheBeginningOfEpilepsy"/>:</th>
                    <td></td>

                    <th><spring:message code="label.assignedDoctor"/>:</th>
                    <td>${patient.doctor.contact.firstName} ${patient.doctor.contact.lastName}</td>

                    <td></td>
                    <td>${patient.contact.addressCountry}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- anamnesis list START -->
        <div class="panel-group" id="accordion">
            <c:set var="count" value="0" scope="page"/>
            <c:forEach items="${patient.anamnesisList}" var="anamnesis">
                <c:if test="${anamnesis.status == 0}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" href="#collapse${anamnesis.id}">
                                    Zadano dne: ${anamnesis.date}
                                </a>

                                <a class="pull-right"
                                   href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/hide"/>">
                                    delete
                                </a>
                                <a class="pull-right"
                                   href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/edit"/>">
                                    edit&nbsp;
                                </a>
                            </h4>
                        </div>
                        <%@include file="anamnesisTable.jsp" %>
                    </div>
                </c:if>
                <c:if test="${anamnesis.status == 1}">
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" href="#collapse${anamnesis.id}">
                                        Zadano dne: ${anamnesis.date} -Hidden
                                    </a>

                                    <a class="pull-right"
                                       href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/delete"/>">
                                        perma delete
                                    </a>
                                    <a class="pull-right"
                                       href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/unhide"/>">
                                        recover&nbsp;
                                    </a>
                                </h4>
                            </div>
                            <%@include file="anamnesisTable.jsp" %>
                        </div>
                    </sec:authorize>
                </c:if>
            </c:forEach>
        </div>
        <c:if test="${count == 0}">
            <div class="alert alert-info">
                <spring:message code="label.noRecords"/>
            </div>
        </c:if>
        <!-- anamnesis list END -->
    </jsp:body>
</t:menuLVL2.NEW303>