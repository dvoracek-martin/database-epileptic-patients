<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<jsp:useBean id="dateBeforeBirth"
             scope="request"
             type="java.lang.Boolean"/>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="date">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input id="date"
                        class="input-sm form-control"
                        type="text"
                        autocomplete="off"
                        path="date"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date"
                     cssClass="text-danger"/>
        <c:if test="${dateBeforeBirth}">
            <span id="date.errors"
                  class="text-danger">
                <spring:message code="label.cannotBeBeforeBirth"/>
            </span>
        </c:if>
    </div>
</div>

<div class="form-group">
    <label class="col-xs-4 control-label"
           for="done">
        <spring:message code="label.invasiveTestIeeg"/>
    </label>

    <div class="col-xs-8">
        <form:select id="done"
                     class="form-control"
                     type="text"
                     path="done">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done"
     class="section-hide">
    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="intracranialElectrodes">
            <spring:message code="label.intracranialElectrodes"/>
        </label>

        <div class="col-xs-8">
            <form:select id="intracranialElectrodes"
                         class="input-sm form-control"
                         type="text"
                         path="intracranialElectrodes">
                <form:option value="0">
                    <spring:message code="label.intracranialElectrodes.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.intracranialElectrodes.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.intracranialElectrodes.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.intracranialElectrodes.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.intracranialElectrodes.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.intracranialElectrodes.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.intracranialElectrodes.6"/>
                </form:option>
                <form:option value="7">
                    <spring:message code="label.intracranialElectrodes.7"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="localizationIntracranialElectrodes">
            <spring:message code="label.localizationIntracranialElectrodes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationIntracranialElectrodes"
                           class="form-control resize-vertical"
                           path="localizationIntracranialElectrodes"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="intracranialElectrodes">
            <spring:message code="label.invasiveEegSlowing"/>
        </label>

        <div class="col-xs-8">
            <form:select id="invasiveEegSlow"
                         class="input-sm form-control"
                         type="text"
                         path="invasiveEegSlow">
                <form:option value="0">
                    <spring:message code="label.invasiveEegSlowing.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.invasiveEegSlowing.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.invasiveEegSlowing.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.invasiveEegSlowing.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.invasiveEegSlowing.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.invasiveEegSlowing.5"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <jsp:include page="invasiveEegOptionsView.jsp">
        <jsp:param name="labelName"
                   value="invasiveEegInterictalSpikes"/>
        <jsp:param name="propertyName"
                   value="invasiveEegInterictalSpikes"/>
    </jsp:include>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="localizationInvasiveEegInterictalSpikes">
            <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationInvasiveEegInterictalSpikes"
                           class="form-control resize-vertical"
                           path="localizationInvasiveEegInterictalSpikes"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName"
                   value="invasiveEegStatusEpilepticus"/>
        <jsp:param name="messageCode"
                   value="invasiveEegStatusEpilepticus"/>
    </jsp:include>

    <jsp:include page="invasiveEegOptionsView.jsp">
        <jsp:param name="labelName"
                   value="invasiveIctalEegPatterns"/>
        <jsp:param name="propertyName"
                   value="invasiveIctalEegPatterns"/>
    </jsp:include>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="localizationInvasiveIctalEegPatterns">
            <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="localizationInvasiveIctalEegPatterns"
                           class="form-control resize-vertical"
                           path="localizationInvasiveIctalEegPatterns"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-4 control-label"
               for="comment">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea id="comment"
                           class="form-control resize-vertical"
                           path="comment"/>
        </div>
    </div>
</div>