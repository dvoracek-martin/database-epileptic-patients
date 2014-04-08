<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="title">
     <spring:message code="label.searchResults"/>
    </jsp:attribute>

    	<jsp:attribute name="head">
    <link href="<c:url value="/resources/custom/css/clickable-row.css" />" rel="stylesheet">
    </jsp:attribute>

    	<jsp:attribute name="script">
    <script src="<c:url value="/resources/custom/js/clickable-row.js"/>"></script>
            <script src="<c:url value="/resources/custom/js/search-results.js"/>"></script>
                <script src="<c:url value="/resources/custom/js/exportSubmit.js"/>"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.searchResults"/>
                </h2>

            </div>
            <div class="col-xs-6">

                <form id="patientIds" action="<c:url value="/export" />" method="POST">
                    <c:forEach items="${patients}" var="patientList">
                        <c:forEach items="${patientList}" var="patient">
                            <input type="hidden" name="patientId" value="${patient.id}">
                        </c:forEach>
                    </c:forEach>
                    <input name="source" type="hidden" value="search">
                </form>

                <h3 class="pull-right">
                    <a id="postExport" class="cursor-pointer">
                        <spring:message code="label.export"/>
                    </a>
                </h3>

            </div>
        </div>

        <c:choose>
            <c:when test="${empty patients}">
                no result
            </c:when>
            <c:otherwise>

                <input id="pagesCount" type="hidden" value="${pages}">

                <div class="text-center">
                    <ul class="pagination">
                        <li><a class="start" href="#">&laquo;</a></li>
                        <li><a class="prev" href="#">&lsaquo;</a></li>
                        <c:forEach var="i" begin="1" end="${pages}">
                            <li class="pager-elem-${i}">
                                <a class="page-number" href="#" data-page-number="${i}">
                                        ${i}
                                </a>
                            </li>
                        </c:forEach>
                        <li class="next-li"><a class="next" href="#">&rsaquo;</a></li>
                        <li><a class="end" href="#">&raquo;</a></li>
                    </ul>
                </div>


                <c:set value="1" var="count"/>

                <c:forEach items="${patients}" var="patientList">

                    <div id="page-${count}" class="table-responsive page">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <td>
                                    <b><spring:message code="label.firstname"/></b>
                                </td>
                                <td>
                                    <b><spring:message code="label.lastname"/></b>
                                </td>
                                <td>
                                    <b><spring:message code="label.birthIdentificationNumber"/></b>
                                </td>
                                <td>
                                    <b><spring:message code="label.address"/></b>
                                </td>
                                <td>
                                    <b><spring:message code="label.addressCity"/></b>
                                </td>
                            </tr>
                            </thead>
                            <tbody id="patientList">
                            <c:forEach items="${patientList}" var="patient">

                                <tr class="clickable-row" data-href="<c:url value="/patient/${patient.id}/overview" />">
                                    <td>
                                            ${patient.contact.firstName}
                                    </td>
                                    <td>
                                            ${patient.contact.lastName}
                                    </td>
                                    <td>
                                            ${patient.nin}
                                    </td>
                                    <c:choose>
                                        <c:when test="${empty patient.contact.addressStreet}">
                                            <td></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                    ${patient.contact.addressStreet}, ${patient.contact.addressHn}
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>
                                            ${patient.contact.addressCity}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <c:set value="${count+1}" var="count"/>

                </c:forEach>


                <div class="text-center">
                    <ul class="pagination">
                        <li><a class="start" href="#">&laquo;</a></li>
                        <li><a class="prev" href="#">&lsaquo;</a></li>
                        <c:forEach var="i" begin="1" end="${pages}">
                            <li class="pager-elem-${i}">
                                <a class="page-number" href="#" data-page-number="${i}">
                                        ${i}
                                </a>
                            </li>
                        </c:forEach>
                        <li class="next-li"><a class="next" href="#">&rsaquo;</a></li>
                        <li><a class="end" href="#">&raquo;</a></li>
                    </ul>
                </div>


            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:menuLVL1>