<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.advancedSearch"/>
    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/advanced-search.js" />"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.advancedSearch"/>
                </h2>
            </div>
            <div class="col-xs-6">
                <h3 class="pull-right">
                    <a href="<c:url value="/advanced-search/load" />">
                        <spring:message code="label.load"/>
                    </a>
                </h3>
            </div>
        </div>

        <form:form id="advancedSearchForm"
                   class="form-horizontal"
                   method="POST"
                   action="/GENEPI/advanced-search"
                   role="form"
                   commandName="advancedSearch">

            <jsp:include page="fieldsets/generalParametersSpecificPersonFieldset.jsp"/>

            <jsp:include page="fieldsets/generalParametersFieldset.jsp" />

            <jsp:include page="fieldsets/includeParametersFromFieldset.jsp" />

            <jsp:include page="fieldsets/anamnesisFieldset.jsp" />

            <jsp:include page="fieldsets/seizureFieldset.jsp" />

            <jsp:include page="fieldsets/pharmacotherapyFieldset.jsp" />

            <jsp:include page="fieldsets/neurologicalFindingFieldset.jsp" />

            <jsp:include page="fieldsets/neuropsychologyFieldset.jsp" />

            <jsp:include page="fieldsets/diagnosticTestScalpEegFieldset.jsp" />

            <jsp:include page="fieldsets/diagnosticTestMriFieldset.jsp" />

            <jsp:include page="fieldsets/invasiveTestEegFieldset.jsp" />

            <jsp:include page="fieldsets/invasiveTestEcogFieldset.jsp" />

            <jsp:include page="fieldsets/invasiveTestCorticalMappingFieldset.jsp" />

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-8">
                    <button id="searchButton" class="btn btn-primary" type="submit">
                        <spring:message code="label.search"/>
                    </button>
                </div>
            </div>


            <fieldset>
                <legend>
                    <spring:message code="label.saveParameters"/>
                </legend>

                <div class="form-group">
                    <label class="col-xs-4 control-label" for="saveName">
                        <spring:message code="label.name"/>
                    </label>

                    <div class="col-xs-6">
                        <form:input id="saveName"
                                    class="form-control input-sm"
                                    type="text"
                                    path="name"/>

                        <form:errors path="name"
                                     cssClass="error">
                        </form:errors>
                    </div>

                    <div class="col-xs-2">
                        <button id="saveButton" class="btn btn-primary">
                            <spring:message code="label.save"/>
                        </button>
                    </div>
                </div>
            </fieldset>

        </form:form>

    </jsp:body>
</t:menuLVL1>