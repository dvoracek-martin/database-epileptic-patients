<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL2>

    <jsp:attribute name="title">
      <spring:message code="label.seizures"/>
    </jsp:attribute>

    <jsp:attribute name="head">
     <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.export"/>
                </h2>
            </div>
            <div class="col-xs-6">

            </div>
        </div>

        <c:forEach items="${patientIds}" var="patientId">
            <input form="exportForm" name="patientId" type="hidden" value="${patientId}">
        </c:forEach>

        <%-- export aprams --%>
        <form:form id="exportForm" method="POST" action="/GENEPI/perform-export" commandName="exportParams">
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
        </form:form>


    </jsp:body>
</t:menuLVL2>
