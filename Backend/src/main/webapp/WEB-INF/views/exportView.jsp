<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<t:menuLVL1>

<jsp:attribute name="title">
      <spring:message code="label.export"/>
    </jsp:attribute>

    <jsp:attribute name="head">
        <link href="<c:url value="/resources/custom/css/custom.css" />" rel="stylesheet">
           <link href="<c:url value="/resources/jquery-tree/jquery.tree.min.css" />" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="script">
        <script src="<c:url value="/resources/custom/js/export.js" />"></script>
        <script src="<c:url value="/resources/jquery-ui/jquery-ui.min.js" />"></script>
           <script src="<c:url value="/resources/jquery-tree/jquery.tree.min.js" />"></script>
    </jsp:attribute>

<jsp:body>

<div class="row">
    <div class="col-xs-6">
        <h2>
            <c:choose>
                <c:when test="${exportInfoWrapperVo.source == 'search'}">
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
    <div class="col-xs-12">

        <fieldset>
            <legend>
                <spring:message code="label.load"/>
            </legend>

            <form id="genericConfigurationsForm"
                  action="<c:url value="/export/load"/>"
                  method="POST"
                  class="form-horizontal"
                  role="form">

                <div class="form-group">

                    <label class="col-xs-3 control-label"
                           for="genericConfigurations">
                        <spring:message code="label.genericConfigurations"/>
                    </label>

                    <div class="col-xs-3">
                        <select id="genericConfigurations"
                                class="input-sm form-control"
                                name="exportId">

                            <c:forEach items="${genericConfigurations}"
                                       var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>

                        </select>
                    </div>

                    <button class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.load"/>
                    </button>

                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <button id="genericConfigurationsDeleteButton"
                                class="btn btn-primary btn-sm"
                                type="submit">
                            <spring:message code="label.delete"/>
                        </button>
                    </sec:authorize>
                </div>
            </form>

            <form id="userConfigurationsForm"
                  class="form-horizontal"
                  action="<c:url value="/export/load"/>"
                  method="POST"
                  role="form">

                <div class="form-group">

                    <label class="col-xs-3 control-label"
                           for="userConfigurations">
                        <spring:message code="label.userConfigurations"/>
                    </label>

                    <div class="col-xs-3">
                        <select id="userConfigurations"
                                class="input-sm form-control"
                                name="exportId">

                            <c:forEach items="${userConfigurations}"
                                       var="exportParam">
                                <option value="${exportParam.id}">
                                        ${exportParam.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.load"/>
                    </button>

                    <button id="userConfigurationsDeleteButton"
                            class="btn btn-primary btn-sm"
                            type="submit">
                        <spring:message code="label.delete"/>
                    </button>
                </div>
            </form>

        </fieldset>
    </div>
</div>

<div class="row">
<div class="col-xs-12">

<form:form id="exportForm"
           method="POST"
           action="/GENEPI/perform-export"
           commandName="exportParams">

<fieldset>
<legend>
    <spring:message code="label.parameters"/>
</legend>

<div id="tree">
    <ul>
        <li class="collapsed">
            <form:checkbox id="anamnesis"
                           path="anamnesis"/>
            <form:label path="anamnesis">
                anamnesis
            </form:label>
            <ul>
                <li>
                    <form:checkbox id="anamnesisBeginningEpilepsy"
                                   path="anamnesisBeginningEpilepsy"
                                   class="input-block-level"/>
                    <form:label
                            path="anamnesisBeginningEpilepsy">anamnesisBeginningEpilepsy</form:label>
                </li>
                <li>
                    <form:checkbox id="anamnesisFirstFever"
                                   path="anamnesisFirstFever"
                                   class="input-block-level"/>
                    <form:label path="anamnesisFirstFever">anamnesisFirstFever</form:label>
                </li>
                <li>
                    <form:checkbox id="anamnesisInfantileSpasm"  path="anamnesisInfantileSpasm" class="input-block-level"/>
                    <form:label path="anamnesisInfantileSpasm">anamnesisInfantileSpasm</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisSpecificSyndrome"  path="anamnesisSpecificSyndrome" class="input-block-level"/>
                    <form:label path="anamnesisSpecificSyndrome">anamnesisSpecificSyndrome</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisEpilepsyInFamily"  path="anamnesisEpilepsyInFamily" class="input-block-level"/>
                    <form:label path="anamnesisEpilepsyInFamily">anamnesisEpilepsyInFamily</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisParentalRisk"  path="anamnesisParentalRisk" class="input-block-level"/>
                    <form:label path="anamnesisParentalRisk">anamnesisParentalRisk</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisFibrilConvulsions"  path="anamnesisFibrilConvulsions" class="input-block-level"/>
                    <form:label path="anamnesisFibrilConvulsions">anamnesisFibrilConvulsions</form:label>
                </li>
                <li>
                    <form:checkbox id="anamnesisInflammationCns"  path="anamnesisInflammationCns" class="input-block-level"/>
                    <form:label path="anamnesisInflammationCns">anamnesisInflammationCns</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisInjuryCns"  path="anamnesisInjuryCns" class="input-block-level"/>
                    <form:label path="anamnesisInjuryCns">anamnesisInjuryCns</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisOperationCns"  path="anamnesisOperationCns" class="input-block-level"/>
                    <form:label path="anamnesisOperationCns">anamnesisOperationCns</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisEarlyPmdRetardation"  path="anamnesisEarlyPmdRetardation" class="input-block-level"/>
                    <form:label path="anamnesisEarlyPmdRetardation">anamnesisEarlyPmdRetardation</form:label>
                </li>

                <li>
                    <form:checkbox id="anamnesisNonCnsComorbidity"  path="anamnesisNonCnsComorbidity" class="input-block-level"/>
                    <form:label path="anamnesisNonCnsComorbidity">anamnesisNonCnsComorbidity</form:label>
                </li>
                <li>
                    <form:checkbox id="anamnesisComment"  path="anamnesisComment" class="input-block-level"/>
                    <form:label path="anamnesisComment">anamnesisComment</form:label>
                </li>
            </ul>
        </li>
    </ul>
</div>

    <%--
                    <div id="tree">
                        <ul>
                            <li class="collapsed"><input type="checkbox"><span>Node 1</span>
                                <ul>
                                    <li><input type="checkbox"><span>Node 1.1</span>
                                        <ul>
                                            <li><input type="checkbox"><span>Node 1.1.1</span>
                                        </ul>
                                </ul>
                                <ul>
                                    <li><input type="checkbox"><span>Node 1.2</span>
                                        <ul>
                                            <li><input type="checkbox"><span>Node 1.2.1</span>
                                            <li><input type="checkbox"><span>Node 1.2.2</span>
                                            <li><input type="checkbox"><span>Node 1.2.3</span>
                                                <ul>
                                                    <li><input type="checkbox"><span>Node 1.2.3.1</span>
                                                    <li><input type="checkbox"><span>Node 1.2.3.2</span>
                                                </ul>
                                            <li><input type="checkbox"><span>Node 1.2.4</span>
                                            <li><input type="checkbox"><span>Node 1.2.5</span>
                                            <li><input type="checkbox"><span>Node 1.2.6</span>
                                        </ul>
                                </ul>
                            <li><input type="checkbox"><span>Node 2</span>
                                <ul>
                                    <li><input type="checkbox"><span>Node 2.1</span>
                                        <ul>
                                            <li><input type="checkbox"><span>Node 2.1.1</span>
                                        </ul>
                                    <li><input type="checkbox"><span>Node 2.2</span>
                                        <ul>
                                            <li><input type="checkbox"><span>Node 2.2.1</span>
                                            <li><input type="checkbox"><span>Node 2.2.2</span>
                                            <li><input type="checkbox"><span>Node 2.2.3</span>
                                                <ul>
                                                    <li><input type="checkbox"><span>Node 2.2.3.1</span>
                                                    <li><input type="checkbox"><span>Node 2.2.3.2</span>
                                                </ul>
                                            <li><input type="checkbox"><span>Node 2.2.4</span>
                                            <li><input type="checkbox"><span>Node 2.2.5</span>
                                            <li><input type="checkbox"><span>Node 2.2.6</span>
                                        </ul>
                                </ul>
                        </ul>
                    </div>--%>

    <%--  <ul>

          <li>
              <div class="checkbox">
                  <label>
                      <form:checkbox path="anamnesis"
                                     class="input-block-level"/>Anamneza
                  </label>
              </div>


              <ul>
                  <li>
                      <div class="checkbox">
                          <label>
                              <form:checkbox path="anamnesisBeginningEpilepsy" class="input-block-level"/>
                              <form:label
                                      path="anamnesisBeginningEpilepsy">anamnesisBeginningEpilepsy</form:label>
                          </label>
                      </div>
                  </li>

              </ul>

      </ul>--%>


<div class="control-group span6">
    <label class="control-label" for="pdfFormat">
        <spring:message code="label.chooseFormat"/>
    </label>

    <div class="controls">
        <input type="radio"
               id="pdfFormat"
               name="exportType"
               value="pdf"
               checked>
        <label for="pdfFormat">pdf</label>

        <input type="radio"
               id="xlsxFormat"
               name="exportType"
               value="xlsx">
        <label for="xlsxFormat">xlsx</label>

        <input type="radio"
               id="docxFormat"
               name="exportType"
               value="docx">
        <label for="docxFormat">docx</label>

        <input type="radio"
               id="txtFormat"
               name="exportType"
               value="txt">
        <label for="txtFormat">txt</label>

        <input type="radio"
               id="csvFormat"
               name="exportType"
               value="csv">
        <label for="csvFormat">csv</label>
    </div>
</div>

<button class="btn btn-primary btn-sm" type="submit">
    <spring:message code="label.export"/>
</button>

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

        <div class="col-xs-2">
            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <form:checkbox id="generic" path="generic"/> <label for="generic"> <spring:message
                    code="label.generic"/></label>
            </sec:authorize>
        </div>

        <div>
            <button id="saveButton" class="btn btn-primary btn-sm">
                <spring:message code="label.save"/>
            </button>
        </div>
    </div>
</fieldset>

</form:form>

</div>
</div>

</jsp:body>
</t:menuLVL1>