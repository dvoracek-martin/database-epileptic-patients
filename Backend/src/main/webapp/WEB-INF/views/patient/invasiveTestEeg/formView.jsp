<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-4 control-label">
        <spring:message code="label.dateExamination"/>*
    </label>

    <div class="col-xs-8">
        <div class='input-group date datepicker-simple'>
            <form:input path="date" id="date" type="text" class="input-sm form-control" autocomplete="off"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
        <form:errors path="date" cssClass="text-danger"/>
    </div>
</div>

<div class="form-group">
    <label for="done" class="col-xs-4 control-label">
        <spring:message code="label.invasiveTestIeeg"/>
    </label>

    <div class="col-xs-8">
        <form:select path="done" id="done" type="text" class="form-control">
            <form:option value="1">
                <spring:message code="label.done.1"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.done.2"/>
            </form:option>
        </form:select>
    </div>
</div>

<div id="section-done" class="section-hide">
    <div class="form-group">
        <label for="intracranialElectrodes" class="col-xs-4 control-label">
            <spring:message code="label.intracranialElectrodes"/>
        </label>

        <div class="col-xs-8">
            <form:select path="intracranialElectrodes" id="intracranialElectrodes" type="text"
                         class="input-sm form-control">
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
        <label for="localizationIntracranialElectrodes" class="col-xs-4 control-label">
            <spring:message code="label.localizationIntracranialElectrodes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationIntracranialElectrodes"
                           id="localizationIntracranialElectrodes"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <div class="form-group">
        <label for="intracranialElectrodes" class="col-xs-4 control-label">
            <spring:message code="label.invasiveEegSlowing"/>
        </label>

        <div class="col-xs-8">
            <form:select path="invasiveEegSlow" id="invasiveEegSlow" type="text" class="input-sm form-control">
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
        <jsp:param name="labelName" value="invasiveEegInterictalSpikes"/>
        <jsp:param name="propertyName" value="invasiveEegInterictalSpikes"/>
    </jsp:include>

    <div class="form-group">
        <label for="localizationInvasiveEegInterictalSpikes" class="col-xs-4 control-label">
            <spring:message code="label.localizationInvasiveEegInterictalSpikes"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationInvasiveEegInterictalSpikes"
                           id="localizationInvasiveEegInterictalSpikes"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <jsp:include page="../../components/checkboxComponentView.jsp">
        <jsp:param name="propertyName" value="invasiveEegStatusEpilepticus"/>
        <jsp:param name="messageCode" value="invasiveEegStatusEpilepticus"/>
    </jsp:include>

    <jsp:include page="invasiveEegOptionsView.jsp">
        <jsp:param name="labelName" value="invasiveIctalEegPatterns"/>
        <jsp:param name="propertyName" value="invasiveIctalEegPatterns"/>
    </jsp:include>

    <div class="form-group">
        <label for="localizationInvasiveIctalEegPatterns" class="col-xs-4 control-label">
            <spring:message code="label.localizationInvasiveIctalEegPatterns"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="localizationInvasiveIctalEegPatterns"
                           id="localizationInvasiveIctalEegPatterns"
                           class="form-control resize-vertical"/>
        </div>
    </div>

    <div class="form-group">
        <label for="comment" class="col-xs-4 control-label">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="comment" id="comment" class="form-control resize-vertical"/>
        </div>
    </div>
</div>