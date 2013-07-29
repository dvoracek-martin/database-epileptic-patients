<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import=" java.text.SimpleDateFormat" %>

<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Přidaný záznam</title>
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap.min.css" rel="stylesheet">
  
  
</head>
	<body>
			<%
					User user = (User) SecurityContextHolder.getContext()
							.getAuthentication().getPrincipal();
					String username = user.getUsername();
					Collection<GrantedAuthority> authorities = user.getAuthorities();					
			%>
					
			<!-- box of whole page -->			
			<div class="container-fluid">
				<!--  it defines box with logo -->
				<div class="navbar navbar-inverse">
					<div class="navbar-inner">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand" href="#">GENEPI - PŘIDANÝ ZÁZNAM</a>
					</div>		
				</div>
					
				<!--  it defines box with menu and logo -->
				<div class="span3">
					<div class="well sidebar-nav">
						<a href="/GENEPI/" >  <img  class="photo1" width=2560  height=1600 src="resources/img/logo.png" alt="logo"/> </a>
				    </div>
				    <div class="well sidebar-nav">
						<ul class="nav nav-list">
							<li class="nav-header">Číslo pacienta:</li>
		             	 	<li><a href="underConstruction">Přehled</a></li>
		              		<li>
		              		<form name="anamnesis" action="anamnesis" method="post" style="display:inline">
		    							  <input type="hidden" id="id" name="id" value="<% /*out.print(patient.getId());*/%>">
		    							  <a href="javascript:;" onclick="parentNode.submit();">Anamnéza</a>
		    								<input type="hidden" name="mess"/>
		    				</form>
		              		</li>
		              		<li><a href="underConstruction">Farmakoterapie</a></li>
		              		<li><a href="underConstruction">Neurologické nálezy</a></li>
		              		<li><a href="underConstruction">Neuropsychologie</a></li>
		              		<li><a href="underConstruction">(Neuropsychologie - old)</a></li>
		              		<li><a href="underConstruction">Diagnostické testy</a></li>
		              		<li><a href="underConstruction">Neuropsychologie</a></li>
		              		<li>
		              			<ul>
		              				<li><a href="underConstruction">Skalpové EEG</a></li>
		              				<li><a href="underConstruction">Neurozobraz. testy</a></li>
		              			</ul>
		              		</li>
		              		<li><a href="underConstruction">Invazivní testy</a></li>
		              		<li>
		              			<ul>
		              				<li><a href="underConstruction">ECoG</a></li>
		              				<li><a href="underConstruction">iEEG</a></li>
		              				<li><a href="underConstruction">Kortikalní mapovaní</a></li>
		              			</ul>
		              		 </li>
		             		 <li><a href="underConstruction">Operace</a></li>
		             		 <li><a href="underConstruction">Komplikace</a></li>
		              		 <li><a href="underConstruction">Outcome</a></li>
						</ul>
					</div>
					<div>
				       	<div class="well sidebar-nav">
				            <ul class="nav nav-list">
					             <li class="nav-header">Pacienti</li>
					             <li><a href="patientsList">Kartotéka pacientů</a></li>
					              <li><a href="underConstruction">Pokročilé vyhledávání</a></li>
					              <li class="nav-header">Uživatel: <%=username%></li>
					              <li><a href="myProfile">Profil</a></li>
					              <li><a href="j_spring_security_logout">Odhlásit</a></li>
					              <li class="nav-header">Jazyk</li>
					        </ul>
						</div>
				        <!--  It block with copyright -->
						<div class="span3">
							<div id="copyright">
								<p>GENEPI, &copy; 2013, FIT CVUT</p>
							</div>
						</div>
					</div>
				</div>
					
					  <jsp:forward page="createAnamnesisView.jsp"/>
				<%
					/*}*/
				%>
					
				<!-- box with content -->	
				<div class="span9">
		          <div class="hero-unit">
		            <div>
						<h2>Přehled pacienta</h2>
					</div>
	            		
						<table style="border: 1px solid black; margin-bottom: 2em">
							<tbody>
								<tr>
									<th>Číslo pacienta: </th>
										<td></td>
	
									<th>Rodné číslo: </th>
										<td></td>
	
									<th>Adresa: </th>
										<td></td>
	
								</tr>
								<tr>
									<th>Telefon: </th>
										<td></td>
										
									<th>Věk:</th>
										<td></td>
	
									<th>Pohaví:</th>
										<td></td>
								</tr>
								
				                 <tr>
				                 	<th>Email:</th>
										<td></td>
										
									<th>Věk při začátku epilepsie:</th>
										<td></td>
	
									<th>Ošetřující lékař:</th>
										<td></td>
	
								</tr>
							</tbody>
						</table>
		            
		            <h2 style="margin-bottom: 1em">Záznam byl přidán!</h2>
		            <p>
		                Epilepsie v rodině :

		            </p>
		            <p>
		                Prenatální rizika :

		            </p>
		            <p>
		                Fibrilní křeče : 

		            </p>
		            <p>
		                Zánět CNS : 

		            </p>
		            <p>
		                Úraz CNS :

		            </p>
		            <p>
		                Operace CNS :   

		            </p>
		             <p>
		                Cašná PMD retardace :   

		            </p>
		             <p>
		                Začátek epilepsie : <% out.println(request.getParameter("anamnesisEpStart")); %>   
		            </p>
		             <p>
		                První záchvat s horečkou :   

		            </p>
		             <p>
		                Infantilní spasmy : 

		            </p>
		             <p>
		                Epileptický syndrom : 
  
		            </p>
		            <p>
		                Non CNS komorbidita :    
		            </p>
		            
		          </div>
			</div>
		</div>
    	
    	<!-- Javascripts imports -->
		<script
			src="resources/js/jquery.js"></script>
		<script
			src="resources/js/bootstrap-dropdown.js"></script>
		<script
			src="resources/js/application.js"></script>


	</body>
</html>