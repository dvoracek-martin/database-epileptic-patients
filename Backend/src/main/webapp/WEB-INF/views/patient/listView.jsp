<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script>  
        function filter() {  
     
            
           var search = $('#search').val(); 
           var maxResults = "20";
           var pageNumber = "1";
         
           $.ajax({  
            type : "Get",   
            url : "<c:url value="/patient/listSearch" />",   
            data :  "search=" + search + "&maxResults=" + maxResults + "&pageNumber=" + pageNumber,
            success: function(response){
                alert("yes");
                var obj = JSON.parse(response);
                alert(obj.maxResults);
            },
            error: function(e) {  
                alert("Error "+e);   
            }  
           });
        }  
       </script> 
    </jsp:attribute>

	<jsp:body>
	<div class="row">
	<div class="col-xs-6">
						<h2>
							<spring:message code="label.cardIndex" />
						</h2>
						
  						</div>
  						<div class="col-xs-6">
						<h3 class="pull-right">
							<a href="<c:url value="/patient/create" />"><spring:message
							code="label.addPatient" /></a>
						</h3>
						</div>
</div>
	<div class="row">
	<div class="col-xs-12">
	<!-- <form class="form-horizontal" role="form"> -->	
	 			<div class="form-group">
    					<label for="search" class="col-xs-2 control-label">Filtruj:</label>
    				<div class="col-xs-4 input-group">
  						<span class="input-group-addon glyphicon glyphicon-search"></span>
  						<input type="text" class="form-control" id="search"
								placeholder="jmeno/prijmeni" onkeyup="filter()">
					</div>
  				</div>
		<!-- </form> -->	
			
	</div>
			</div>
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
            <c:set var="temp" value="${countOfPatients/maxResults}" scope="page" />
            ${temp}
            <fmt:formatNumber var="countOfPages" value="${temp}" maxFractionDigits="0" />

            <c:if test="${countOfPages<temp}">
            	<c:set var="countOfPages" value="${countOfPages+1}" scope="page" />	
            </c:if>
            
            <div class="text-center">
                <ul class="pagination">
                    <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=1" />">&laquo;</a></li>
                    <c:choose>
                        <c:when test="${pageNumber<=1}">
                            <li class="disabled"><a href="#">&lsaquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${pageNumber-1}" />">&lsaquo;</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${pageNumber-2>0}">
                        <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${pageNumber-2}" />" >${pageNumber-2} <span class="sr-only"></span></a></li>
                    </c:if>

                    <c:if test="${pageNumber-1>0}">
                        <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${pageNumber-1}" />" >${pageNumber-1} <span class="sr-only"></span></a></li>
                     </c:if>
                  
                    <li class="active"><a href="#">${pageNumber-i}<span class="sr-only"></span></a></li>

                    <c:forEach var="i" begin="1" end="2">
                        <c:if test="${countOfPages>=pageNumber+i}">
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${pageNumber+i}" />" >${pageNumber+i} <span class="sr-only"></span></a></li>
                        </c:if>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${countOfPages<=pageNumber}">
                            <li class="disabled"><a href="#">&rsaquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${pageNumber+1}" />">&rsaquo;</a></li>
                        </c:otherwise>
                    </c:choose>  

                    <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${countOfPages}" />">&raquo;</a></li>           
                </ul>
            </div>
            								
	</jsp:body>
</t:menuLVL1.NEW303>
