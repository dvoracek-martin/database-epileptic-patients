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
        function filter(defaultMaxResults) {  
     
            
           var search = $('#search').val(); 
           if(search=="")
                var maxResults = defaultMaxResults;
            else
                var maxResults = "5";
           var pageNumber = "1";
         
           $.ajax({  
            type : "Get",   
            url : "<c:url value="/patient/listSearch" />",   
            data :  "search=" + search + "&maxResults=" + maxResults + "&pageNumber=" + pageNumber,
            success: function(response){
                var obj = JSON.parse(response);
                var countOfPatients = obj.patientList.length;
                $("#patientList").html("");
                for (var i=0; i<countOfPatients; i++)
                {   
                    var firstName=obj.patientList[i][0].patientFirstName;
                    var lastName=obj.patientList[i][0].patientLastName;
                    var patientID=obj.patientList[i][0].patientID;
                    var nin=obj.patientList[i][0].nin;
                    var address=obj.patientList[i][0].addressStreet;
                    if(address!="")
                        address+=", "+obj.patientList[i][0].addressHn;
                    var city=obj.patientList[i][0].addressCity;

                    $("#patientList").html($("#patientList").html()+"<tr class='clickable-row' href='/GENEPI/patient/"+patientID+"/overview'><td>"+firstName+"</td><td>"+lastName+"</td><td>"+nin+"</td><td>"+address+"</td><td>"+city+"</td></tr>");
                }

                if(search==="")
                    document.getElementById("defaultPaginator").style.display="block";
                else {
                    document.getElementById("defaultPaginator").style.display="none";
                    document.getElementById("paginator").style.display="none";
                }
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
								placeholder="jmeno/prijmeni" onkeyup="filter(${maxResults})">
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
                <tbody id="patientList"> 
                    <c:forEach items="${patientList}" var="patient">
                        <tr class="clickable-row"
            							href="<c:url value="/patient/${patient.id}/overview" />">
                            <td>${patient.contact.firstName}
            				</td>
                            <td>${patient.contact.lastName}
                            </td>
                            <td>${patient.nin}</td>
                            <c:choose>
                                <c:when test="${empty patient.contact.addressStreet}">
                                    <td></td>
                                </c:when>
                                <c:otherwise>
                                    <td>${patient.contact.addressStreet}, ${patient.contact.addressHn}</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${patient.contact.addressCity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

            <c:set var="temp" value="${countOfPatients/maxResults}" scope="page" />

            <fmt:formatNumber var="countOfPages" value="${temp}" maxFractionDigits="0" />

            <c:if test="${countOfPages<temp}">
            	<c:set var="countOfPages" value="${countOfPages+1}" scope="page" />	
            </c:if>
            
            <div id="paginator" class="text-center">
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

            <div id="defaultPaginator" class="text-center" style="display: none">
                <c:set var="defaultPageNmuber" value="1" scope="page" />    
                <ul class="pagination">
                    <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=1" />">&laquo;</a></li>
                    <c:choose>
                        <c:when test="${defaultPageNmuber<=1}">
                            <li class="disabled"><a href="#">&lsaquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${defaultPageNmuber-1}" />">&lsaquo;</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:if test="${defaultPageNmuber-2>0}">
                        <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${defaultPageNmuber-2}" />" >${defaultPageNmuber-2} <span class="sr-only"></span></a></li>
                    </c:if>

                    <c:if test="${defaultPageNmuber-1>0}">
                        <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${defaultPageNmuber-1}" />" >${defaultPageNmuber-1} <span class="sr-only"></span></a></li>
                    </c:if>

                    <li class="active"><a href="#">${defaultPageNmuber-i}<span class="sr-only"></span></a></li>

                    <c:forEach var="i" begin="1" end="2">
                        <c:if test="${countOfPages>=defaultPageNmuber+i}">
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${defaultPageNmuber+i}" />" >${defaultPageNmuber+i} <span class="sr-only"></span></a></li>
                        </c:if>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${countOfPages<=defaultPageNmuber}">
                            <li class="disabled"><a href="#">&rsaquo;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${defaultPageNmuber+1}" />">&rsaquo;</a></li>
                        </c:otherwise>
                    </c:choose>  

                    <li><a href="<c:url value="/patient/list?maxResults=${maxResults}&pageNumber=${countOfPages}" />">&raquo;</a></li>           
                </ul>
            </div>
            								
	</jsp:body>
</t:menuLVL1.NEW303>
