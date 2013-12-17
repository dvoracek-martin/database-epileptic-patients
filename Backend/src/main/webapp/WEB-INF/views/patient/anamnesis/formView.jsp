<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>

<div class="form-group">
    <label for="date" class="col-xs-3 control-label"><spring:message
            code="label.dateOfContractAward"/></label>

    <div class="col-xs-8">
        <form:input path="date" id="date" type="text" class="form-control datepicker-today"/>
        <form:errors path="date" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="epilepsyInFamily" class="col-xs-3 control-label"><spring:message
            code="label.epilepsyInFamily"/></label>

    <div class="col-xs-8">
        <form:checkbox path="epilepsyInFamily" id="epilepsyInFamily"/>
        <form:errors path="epilepsyInFamily" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="prenatalRisk" class="col-xs-3 control-label"><spring:message
            code="label.prenatalRisk"/></label>

    <div class="col-xs-8">
        <form:checkbox path="prenatalRisk" id="prenatalRisk"/>
        <form:errors path="prenatalRisk" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="fibrilConvulsions" class="col-xs-3 control-label"><spring:message
            code="label.fibrilConvulsions"/></label>

    <div class="col-xs-8">
        <form:checkbox path="fibrilConvulsions" id="fibrilConvulsions"/>
        <form:errors path="fibrilConvulsions" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="inflammationCns" class="col-xs-3 control-label"><spring:message
            code="label.inflammationCNS"/></label>

    <div class="col-xs-8">
        <form:checkbox path="inflammationCns" id="inflammationCns"/>
        <form:errors path="inflammationCns" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="injuryCns" class="col-xs-3 control-label"><spring:message
            code="label.injuryCNS"/></label>

    <div class="col-xs-8">
        <form:checkbox path="injuryCns" id="injuryCns"/>
        <form:errors path="injuryCns" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="operationCns" class="col-xs-3 control-label"><spring:message
            code="label.operationCNS"/></label>

    <div class="col-xs-8">
        <form:checkbox path="operationCns" id="operationCns"/>
        <form:errors path="operationCns" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="earlyPmdRetardation" class="col-xs-3 control-label"><spring:message
            code="label.earlyPMDRetardation"/></label>

    <div class="col-xs-8">
        <form:checkbox path="earlyPmdRetardation" id="earlyPmdRetardation"/>
        <form:errors path="earlyPmdRetardation" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="beginningEpilepsy" class="col-xs-3 control-label"><spring:message
            code="label.beginningEpilepsy"/></label>

    <div class="col-xs-8">
        <form:input path="beginningEpilepsy" id="beginningEpilepsy" type="text"
                    class="form-control datepicker"/>
        <form:errors path="beginningEpilepsy" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="firstFever" class="col-xs-3 control-label"><spring:message code="label.firstFever"/></label>

    <div class="col-xs-8">
        <form:checkbox path="firstFever" id="firstFever"/>
        <form:errors path="firstFever" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="infantileSpasm" class="col-xs-3 control-label"><spring:message
            code="label.infantileSpasm"/></label>

    <div class="col-xs-8">
        <form:checkbox path="infantileSpasm" id="infantileSpasm"/>
        <form:errors path="infantileSpasm" cssClass="error">
        </form:errors>
    </div>
</div>

<div class="form-group">
    <label for="specificSyndrome" class="col-xs-3 control-label"><spring:message
            code="label.epilepticSyndrome"/></label>

    <div class="col-xs-8">
        <form:select path="specificSyndrome" id="specificSyndrome" type="text" class="form-control">
            <form:option value="0">
                <spring:message code="label.extratemporalFocalEpilepsy"/>notFilled
            </form:option>
            <form:option value="1">
                <spring:message code="label.mesiotemporalEpilepsy"/>
            </form:option>
            <form:option value="2">
                <spring:message code="label.extratemporalFocalEpilepsy"/>
            </form:option>
            <form:option value="3">
                <spring:message code="label.temporalEpilepsy"/>
            </form:option>
            <form:option value="4">
                <spring:message code="label.hemisphericSymptomaticEpilepsy"/>
            </form:option>
            <form:option value="5">
                <spring:message code="label.multifocalEpilepsy"/>
            </form:option>
            <form:option value="6">
                <spring:message code="label.temporalEpilepsy"/>other
            </form:option>
        </form:select>
    </div>
</div>

<div class="form-group">
    <label for="nonCnsComorbidity" class="col-xs-3 control-label"><spring:message
            code="label.nonCNSComorbidity"/></label>

    <div class="col-xs-8">
        <form:textarea path="nonCnsComorbidity" id="nonCnsComorbidity" class="form-control"/>
    </div>
</div>

<div class="form-group">
    <label for="comment" class="col-xs-3 control-label"><spring:message
            code="label.comment"/></label>

    <div class="col-xs-8">
        <form:textarea path="comment" id="comment" class="form-control"/>
    </div>
</div>