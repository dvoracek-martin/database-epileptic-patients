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

    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-xs-6">
                <h2>
                        <%--<spring:message code="label.searchResults"/>--%>ulozene parametry
                </h2>

            </div>
            <div class="col-xs-6">

            </div>
        </div>

        <c:choose>
            <c:when test="${empty advancedSearchList}">
                no result
            </c:when>
            <c:otherwise>


                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <td>
                                    <%--<b><spring:message code="label.firstname"/></b>--%>nazev
                            </td>
                            <td>
                                    <%--<b><spring:message code="label.firstname"/></b>--%>vytvoren
                            </td>
                            <td>
                                    <%--<b><spring:message code="label.firstname"/></b>--%>vytvoril
                            </td>
                        </tr>
                        </thead>
                        <tbody id="patientList">
                        <c:forEach items="${advancedSearchList}" var="advancedSearchVo">

                            <tr class="clickable-row"
                                data-href="<c:url value="/advanced-search/load/${advancedSearchVo.id}" />">
                                <td>
                                        ${advancedSearchVo.name}
                                </td>
                                <td>
                                        ${advancedSearchVo.added}
                                </td>
                                <td>
                                        ${advancedSearchVo.username}
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:menuLVL1>