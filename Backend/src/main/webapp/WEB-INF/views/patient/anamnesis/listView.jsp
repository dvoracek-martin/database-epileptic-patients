<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec" %>
<%@ page pageEncoding="UTF-8" %>


<t:menuLVL2.NEW303>

<jsp:attribute name="title">
      <spring:message code="label.anamnesis"/>
    </jsp:attribute>

<jsp:attribute name="head">
     <link href="<c:url value="/resources/css/hidden.NEW303.css" />"
           rel="stylesheet">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-xs-6">
                <h2>
                    <spring:message code="label.anamnesis"/>
                </h2>

            </div>
            <div class="col-xs-6">
                <h3 class="pull-right">
                    <a href="<c:url value="/patient/${patient.id}/anamnesis/create" />">
                        <spring:message code="label.addRecord"/></a>
                </h3>
            </div>
        </div>

         <%@include file="../patientDetails.jsp" %>

        <!-- anamnesis list START -->
        <div class="panel-group" id="accordion">
            <c:set var="count" value="0" scope="page"/>
            <c:forEach items="${patient.anamnesisList}" var="anamnesis">
                <c:if test="${anamnesis.status == 0}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a class="accordion-toggle" data-toggle="collapse" href="#collapse${anamnesis.id}">
                                    Zadano dne: ${anamnesis.date}
                                </a>

                                <a class="pull-right"
                                   href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/hide"/>">
                                    <span class="glyphicon glyphicon-remove-circle"></span> delete
                                </a>
                                <a class="pull-right"
                                   href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/edit"/>">
                                    <span class="glyphicon glyphicon-edit"></span> edit&nbsp;
                                </a>
                            </h4>
                        </div>
                        <%@include file="anamnesisTable.jsp" %>
                    </div>
                </c:if>
                <c:if test="${anamnesis.status == 1}">
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="accordion-toggle" data-toggle="collapse" href="#collapse${anamnesis.id}">
                                        Zadano dne: ${anamnesis.date} -Hidden
                                    </a>

                                    <a class="pull-right"
                                       href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/delete"/>">
                                        <span class="glyphicon glyphicon-trash"></span> perma delete
                                    </a>
                                    <a class="pull-right"
                                       href="<c:url value="/patient/${patient.id}/anamnesis/${anamnesis.id}/unhide"/>">
                                        <span class="glyphicon glyphicon-refresh"></span> recover&nbsp;
                                    </a>
                                </h4>
                            </div>
                            <%@include file="anamnesisTable.jsp" %>
                        </div>
                    </sec:authorize>
                </c:if>
            </c:forEach>
        </div>
        <c:if test="${count == 0}">
            <div class="alert alert-info">
                <spring:message code="label.noRecords"/>
            </div>
        </c:if>
        <!-- anamnesis list END -->
    </jsp:body>
</t:menuLVL2.NEW303>