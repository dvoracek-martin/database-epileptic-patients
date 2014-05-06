<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

    <jsp:attribute name="head">
    </jsp:attribute>

	<jsp:attribute name="title">
        <spring:message code="label.addMessage"/>
    </jsp:attribute>

	<jsp:attribute name="script">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-12">
                <h2>
                    <spring:message code="label.addMessage"/>
                </h2>
            </div>
        </div>

        <form:form class="form-horizontal"
                   action="/GENEPI/news/create"
                   method="POST"
                   commandName="newsMessageFormBO">

            <jsp:include page="formView.jsp"/>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-8">
                    <button class="btn btn-small btn-primary"
                            type="submit">
                        <spring:message code="label.add"/>
                    </button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</t:menuLVL1>