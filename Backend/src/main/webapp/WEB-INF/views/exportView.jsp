<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

    <jsp:attribute name="title">
      <spring:message code="label.seizures"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="script">
    <script src="<c:url value="/resources/custom/js/export.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <c:choose>
                        <c:when test="${source == 'search'}">
                            <spring:message code="label.exportSearchResults"/>
                        </c:when>
                        <c:otherwise>
                            <spring:message code="label.exportPatient"/>
                        </c:otherwise>
                    </c:choose>

                </h2>
            </div>
            <div class="col-xs-6">

            </div>
        </div>

        <div class="row">
            <fieldset>
                <legend>Load</legend>
                <div class="col-xs-12">
                    <form id="genericConfigurationsForm" action="<c:url value="/export/load"/>" method="POST">
                        <label>Generic Sets</label>
                        <select name="exportId" class="input-sm">
                            <c:forEach items="${genericConfigurations}" var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>
                        </select>

                        <button class="btn btn-primary" type="submit">
                            LOAD
                        </button>

                        <sec:authorize ifAnyGranted="ROLE_ADMIN">
                            <button id="genericConfigurationsDeleteButton" class="btn btn-primary" type="submit">
                                DELETE
                            </button>
                        </sec:authorize>
                    </form>
                </div>
                <div class="col-xs-12">
                    <form id="userConfigurationsForm" action="<c:url value="/export/load"/>" method="POST">
                        <label>User Sets</label>
                        <select name="exportId" class="input-sm">
                            <c:forEach items="${userConfigurations}" var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>
                        </select>

                        <button class="btn btn-primary" type="submit">
                            LOAD
                        </button>

                        <button id="userConfigurationsDeleteButton" class="btn btn-primary" type="submit">
                            DELETE
                        </button>
                    </form>
                </div>
            </fieldset>
        </div>

        <%-- export aprams --%>
        <form:form id="exportForm" method="POST" action="/GENEPI/perform-export" commandName="exportParams">
            <fieldset>
                <legend>Params</legend>
                <li><form:label path="anamnesisBeginningEpilepsy">anamnesisBeginningEpilepsy</form:label>
                    <form:checkbox path="anamnesisBeginningEpilepsy" class="input-block-level"/></li>

                <div class="control-group span6">
                    <label class="control-label" for="pdfFormat">Formát</label>

                    <div class="controls">
                        <input type="radio" id="pdfFormat" name="exportType" value="pdf" checked> pdf
                        <input type="radio" id="xlsxFormat" name="exportType" value="xlsx"> xlsx
                        <input type="radio" id="docxFormat" name="exportType" value="docx"> docx
                        <input type="radio" id="txtFormat" name="exportType" value="txt"> txt
                        <input type="radio" id="csvFormat" name="exportType" value="csv"> csv
                    </div>
                </div>

                <button class="btn" type="submit">export</button>

            </fieldset>

            <fieldset>
                <legend>
                    <spring:message code="label.saveParameters"/>
                </legend>

                <div class="form-group">
                    <label class="col-xs-2 control-label" for="name">
                        <spring:message code="label.name"/>
                    </label>


                    <div class="col-xs-4">
                        <form:input path="name" id="name" type="text" class="input-sm form-control"/>
                    </div>

                    <div class="col-xs-4">
                        <sec:authorize ifAnyGranted="ROLE_ADMIN">
                            <form:checkbox path="generic"/>spolecne?
                        </sec:authorize>
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