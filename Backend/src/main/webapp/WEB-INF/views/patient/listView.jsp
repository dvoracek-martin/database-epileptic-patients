<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.cardIndex"/>
    </jsp:attribute>

	<jsp:attribute name="head">
    <link href="<c:url value="/resources/custom/css/clickable-row.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="script">
    <script src="<c:url value="/resources/custom/js/patient-list.js"/>"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.cardIndex"/>
                </h2>
            </div>
            <div class="col-xs-6">
                <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DOCTOR,ROLE_SUPER_DOCTOR">
                    <h3 class="pull-right">
                        <a href="<c:url value="/patient/create" />">
                            <spring:message code="label.addPatient"/>
                        </a>
                    </h3>
                </sec:authorize>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="form-group">
                    <label for="search" class="col-xs-2 control-label"><spring:message code="label.filter"/>:</label>

                    <div class="col-xs-4 input-group">
                        <span class="input-group-addon glyphicon glyphicon-search"></span>
                        <sec:authorize ifAllGranted="ROLE_USER,ROLE_RESEARCHER"
                                       ifNotGranted="ROLE_DOCTOR,ROLE_SUPER_DOCTOR,ROLE_ADMIN"
                                       var="researcherOnly"/>
                        <c:choose>
                            <c:when test="${researcherOnly}">
                                <input type="text" class="form-control" id="search"
                                       placeholder="<spring:message code="label.id"/>"
                                       data-max-results="${maxResult}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control" id="search"
                                       placeholder="<spring:message code="label.lastname"/>/<spring:message code="label.firstname"/>/<spring:message code="label.nin"/>"
                                       data-max-results="${maxResult}">
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            <ul class="pagination">
                <li>
                    <a class="start" href="#">
                        &laquo;
                    </a>
                </li>
                <li>
                    <a class="prev" href="#">
                        &lsaquo;
                    </a>
                </li>
                <li class="next-li">
                    <a class="next" href="#">
                        &rsaquo;
                    </a>
                </li>
                <li>
                    <a class="end" href="#">
                        &raquo;
                    </a>
                </li>
            </ul>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <td>
                        <b>
                            <spring:message code="label.id"/>
                        </b>
                    </td>
                    <td>
                        <b>
                            <spring:message code="label.lastname"/>
                        </b>
                    </td>
                    <td>
                        <b>
                            <spring:message code="label.firstname"/>
                        </b>
                    </td>
                    <td>
                        <b>
                            <spring:message code="label.birthIdentificationNumber"/>
                        </b>
                    </td>
                    <td>
                        <b>
                            <spring:message code="label.address"/>
                        </b>
                    </td>
                    <td>
                        <b>
                            <spring:message code="label.addressCity"/>
                        </b>
                    </td>
                </tr>
                </thead>
                <tbody id="patientList">

                </tbody>
            </table>
        </div>

        <div class="text-center">
            <ul class="pagination">
                <li>
                    <a class="start" href="#">
                        &laquo;
                    </a>
                </li>
                <li>
                    <a class="prev" href="#">
                        &lsaquo;
                    </a>
                </li>
                <li class="next-li">
                    <a class="next" href="#">
                        &rsaquo;
                    </a>
                </li>
                <li>
                    <a class="end" href="#">
                        &raquo;
                    </a>
                </li>
            </ul>
        </div>

    </jsp:body>
</t:menuLVL1>