<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL1.NEW303>

	<jsp:attribute name="title">
      	Skryté záznamy
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
	<div class="row">
		<div class="col-xs-6">
			<h2>
				Skryté záznamy
			</h2>				
	  	</div>
	</div>

	<div class="row">
		<div class="col-xs-6">
			<h3>
				Pacient
			</h3>	
  		</div>     
	</div>
	
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive">
				<c:choose>
					<c:when test="${empty patientList}">
						<div class="text-center">
							<h4>
								Žádní skrytí pacienti.
							</h4>
						</div>
					</c:when>
					<c:otherwise>
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
								<td> </td>
								<td> </td>
		                    </tr>
		                    </thead>
		                    <tbody>
			                    <c:forEach items="${patientList}" var="patient">
					                <tr <%-- class="clickable-row" --%>
												href="<c:url value="/patient/${patient.id}/overview" />">
										<td>${patient.contact.firstName}
										</td>
					                    <td>${patient.contact.lastName}
					                    </td>
					                    <td>${patient.nin}</td>
					                    <td>${patient.contact.addressStreet}, ${patient.contact.addressHn}</td>
					                    <td>${patient.contact.addressCity}</td>
					                    <td>
                                    		<a href="#">
                                        		<span class="glyphicon glyphicon-retweet"></span> recover&nbsp;
                                    		</a>
                                    	</td>
					                    <td>
						                    <a href="#">
	                                        	<span class="glyphicon glyphicon-fire"></span> permanent delete
	                                    	</a>
	                                    </td>
					                </tr>
			                    </c:forEach>
		                    </tbody>
		                </table>
		            </c:otherwise>
	            </c:choose>
            </div>	
  		</div>     
	</div>
	
	<div class="row">
		<div class="col-xs-6">
			<h3>
				Anamnézy
			</h3>	
  		</div>     
	</div>
            								
	</jsp:body>
</t:menuLVL1.NEW303>
