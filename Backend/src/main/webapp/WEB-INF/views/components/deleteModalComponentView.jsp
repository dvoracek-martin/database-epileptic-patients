<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div id="${param.modalId}"
     class="modal fade"
     role="dialog"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <spring:message code="label.${param.bodyMessage}"/>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default"
                        type="button"
                        data-dismiss="modal">
                    <spring:message code="label.cancel"/>
                </button>
                <a class="btn btn-primary"
                   href="<c:url value="${param.deleteUrl}" />"
                   type="button">
                    <spring:message code="label.yes"/>
                </a>
            </div>
        </div>
    </div>
</div>