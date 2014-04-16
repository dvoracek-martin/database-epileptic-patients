<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

	<jsp:attribute name="title">
       <spring:message code="label.homepage"/>
    </jsp:attribute>

    <jsp:attribute name="script">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.news"/>
                </h2>
            </div>
            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <div class="col-xs-6">
                    <h3 class="pull-right">
                        <a href="<c:url value="/news/create" />">
                            <spring:message code="label.addMessage"/>
                        </a>
                    </h3>
                </div>
            </sec:authorize>
        </div>
        <c:choose>
            <c:when test="${empty newsMessages}">
                <div class="alert alert-info">
                    <spring:message code="label.noMessages"/>
                </div>
            </c:when>
            <c:otherwise>

                <c:forEach items="${newsMessages}"
                           var="newsMessage">
                    <div class="row">
                        <div class="col-xs-6">
                            <h3>
                                    ${newsMessage.date}
                            </h3>
                        </div>

                        <div class="col-xs-2"></div>
                        <div class="col-xs-2">
                            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                                <h3 class="pull-right">
                                    <a href="<c:url value="/news/${newsMessage.id}/edit" />">
                                        <spring:message code="label.edit"/>
                                    </a>
                                </h3>
                            </sec:authorize>
                        </div>
                        <div class="col-xs-2">
                            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                                <h3 class="pull-right">
                                    <a href="#delete-news-${newsMessage.id}" data-toggle="modal">
                                        <spring:message code="label.delete"/>
                                    </a>
                                </h3>
                            </sec:authorize>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <h3>
                                    ${newsMessage.heading}
                            </h3>

                            <p>
                                    ${newsMessage.message}
                            </p>
                        </div>
                    </div>
                    <hr>
                </c:forEach>


                <c:forEach items="${newsMessages}"
                           var="newsMessage">
                    <!-- Modal -->
                    <div id="delete-news-${newsMessage.id}"
                         class="modal fade"
                         role="dialog"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <spring:message code="label.reallyDeleteMessage"/>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-default"
                                            type="button"
                                            data-dismiss="modal">
                                        <spring:message code="label.cancel"/>
                                    </button>
                                    <a class="btn btn-primary"
                                       href="<c:url value="/news/${newsMessage.id}/delete" />"
                                       type="button">
                                        <spring:message code="label.yes"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:menuLVL1>