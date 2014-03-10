<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2>
<jsp:attribute name="head">
      <link href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />" rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="title">
      <spring:message code="label.addRecord"/> upravit zaznam
    </jsp:attribute>

	<jsp:attribute name="script">
		<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script src="<c:url value="/resources/custom/js/datepicker.js" />"></script>
   </jsp:attribute>
<jsp:body>

<div class="row">
    <div class="col-xs-12">
        <h2>
            <spring:message code="label.anamnesis"/>
        </h2>
    </div>
</div>

<%@include file="../patientDetails.jsp" %>

<%-- mapping resource in action with c:url caused errors --%>
<form:form class="form-horizontal" role="form" method="POST"
           action="/GENEPI/patient/${patient.id}/anamnesis/save" commandName="anamnesis">

    <div class="form-group">
        <label for="date" class="col-xs-3 control-label">
            <spring:message code="label.dateOfContractAward"/>
        </label>

        <div class="col-xs-8">
            <form:input path="date" id="date" type="text" class="form-control datepicker-today"/>
            <form:errors path="date" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="epilepsyInFamily" class="col-xs-3 control-label">
            <spring:message code="label.epilepsyInFamily"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="epilepsyInFamily" id="epilepsyInFamily"/>
            <form:errors path="epilepsyInFamily" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="prenatalRisk" class="col-xs-3 control-label">
            <spring:message code="label.prenatalRisk"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="prenatalRisk" id="prenatalRisk"/>
            <form:errors path="prenatalRisk" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="fibrilConvulsions" class="col-xs-3 control-label">
            <spring:message code="label.fibrilConvulsions"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="fibrilConvulsions" id="fibrilConvulsions"/>
            <form:errors path="fibrilConvulsions" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="inflammationCns" class="col-xs-3 control-label">
            <spring:message code="label.inflammationCns"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="inflammationCns" id="inflammationCns"/>
            <form:errors path="inflammationCns" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="injuryCns" class="col-xs-3 control-label">
            <spring:message code="label.injuryCns"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="injuryCns" id="injuryCns"/>
            <form:errors path="injuryCns" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="operationCns" class="col-xs-3 control-label">
            <spring:message code="label.operationCns"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="operationCns" id="operationCns"/>
            <form:errors path="operationCns" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="earlyPmdRetardation" class="col-xs-3 control-label">
            <spring:message code="label.earlyPmdRetardation"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="earlyPmdRetardation" id="earlyPmdRetardation"/>
            <form:errors path="earlyPmdRetardation" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="beginningEpilepsy" class="col-xs-3 control-label">
            <spring:message code="label.beginningEpilepsy"/>
        </label>

        <div class="col-xs-8">
            <form:input path="beginningEpilepsy" id="beginningEpilepsy" type="text" class="form-control datepicker"/>
            <form:errors path="beginningEpilepsy" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="firstFever" class="col-xs-3 control-label">
            <spring:message code="label.firstFever"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="firstFever" id="firstFever"/>
            <form:errors path="firstFever" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="infantileSpasm" class="col-xs-3 control-label">
            <spring:message code="label.infantileSpasm"/>
        </label>

        <div class="col-xs-8">
            <form:checkbox path="infantileSpasm" id="infantileSpasm"/>
            <form:errors path="infantileSpasm" cssClass="error">
            </form:errors>
        </div>
    </div>

    <div class="form-group">
        <label for="specificSyndrome" class="col-xs-3 control-label">
            <spring:message code="label.epilepticSyndrome"/>
        </label>

        <div class="col-xs-8">
            <form:select path="specificSyndrome" id="specificSyndrome" type="text" class="form-control">
                <form:option value="0">
                    <spring:message code="label.specificSyndrome.0"/>
                </form:option>
                <form:option value="1">
                    <spring:message code="label.specificSyndrome.1"/>
                </form:option>
                <form:option value="2">
                    <spring:message code="label.specificSyndrome.2"/>
                </form:option>
                <form:option value="3">
                    <spring:message code="label.specificSyndrome.3"/>
                </form:option>
                <form:option value="4">
                    <spring:message code="label.specificSyndrome.4"/>
                </form:option>
                <form:option value="5">
                    <spring:message code="label.specificSyndrome.5"/>
                </form:option>
                <form:option value="6">
                    <spring:message code="label.specificSyndrome.6"/>
                </form:option>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <label for="nonCnsComorbidity" class="col-xs-3 control-label">
            <spring:message code="label.nonCnsComorbidity"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="nonCnsComorbidity" id="nonCnsComorbidity" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="comment" class="col-xs-3 control-label">
            <spring:message code="label.comment"/>
        </label>

        <div class="col-xs-8">
            <form:textarea path="comment" id="comment" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-8">
            <button class="btn btn-primary" type="submit">
                <spring:message code="label.add"/>ulozit
            </button>
        </div>
    </div>
</form:form>
</jsp:body>
</t:menuLVL2>