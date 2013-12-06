<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL1.NEW303>

	<jsp:attribute name="title">
      <spring:message code="label.cardIndex" />
    </jsp:attribute>

	<jsp:attribute name="head">
    <link
			href="<c:url value="/resources/css/clickable-row.NEW303.css" />"
			rel="stylesheet">
    </jsp:attribute>

	<jsp:attribute name="script">
 	<script src="<c:url value="/resources/js/clickable-row.NEW303.js"/>"></script>
    </jsp:attribute>

	<jsp:body>
	
						<h2>
							<spring:message code="label.cardIndex" />
						</h2>
						<!-- <form class="form-search">
  								<div class="input-append">
    								<input type="text" class="span2 search-query">
    								<button type="submit" class="btn">Search</button>
  								</div>
  						</form> -->
						<h3>
							<a href="<c:url value="/patient/create" />"
				style="text-decoration: none"><spring:message
					code="label.addPatient" /></a>
						</h3>

   <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <td><b><spring:message
									code="label.firstname" /></b></td>
                        <td><b><spring:message
									code="label.lastname" /></b></td>
                        <td><b><spring:message
									code="label.birthIdentificationNumber" /></b></td>
                        <td><b><spring:message
									code="label.address" /></b></td>
                        <td><b><spring:message
									code="label.addressCity" /></b></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${patientList}" var="patient">
                    <tr class="clickable-row"
							href="<c:url value="/patient/${patient.id}/overview" />">
                        <td>${patient.contact.firstName}
						</td>
                        <td>${patient.contact.lastName}
                        </td>
                        <td>${patient.nin}</td>
                        <td>${patient.contact.addressStreet}, ${patient.contact.addressHn}</td>
                        <td>${patient.contact.addressCity}</td>
                    </tr>
 
                    				</c:forEach>
                    </tbody>
                </table>
            </div>
            Paginator here
            								
	</jsp:body>
</t:menuLVL1.NEW303>
