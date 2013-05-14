<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!-- import of controllers -->
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.models.*"%>
<!-- import of Entities -->
<%@ page import="cz.cvut.fit.genepi.entities.*"%>

<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="cz">
	<head>
		<meta charset="utf-8" />
		<title>Anamnéza</title>
		<link href="resources/css/bootstrap2.2.css" rel="stylesheet">
		<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
	</head>
	<body>
		<%
				User user = (User) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal();
				String username = user.getUsername();
				Collection<GrantedAuthority> authorities = user.getAuthorities();
				//finding object of patient
				PatientOverviewController patientOverviewController = new PatientOverviewController();
				PatientEntity patient = patientOverviewController.findByID(Integer.parseInt(request.getParameter("id")));
		%>
				
		<!-- box of whole page -->			
		<div class="container-fluid">
			<!--  it defines box with logo -->
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - ANAMNÉZA</a>
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
	              		<li><a href="#">Anamnéza</a></li>
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
							<p>GENEPI, &copy 2013, FIT CVUT</p>
						</div>
					</div>
				</div>
			</div>
		      	
		    <!-- box with content -->
			<div class="span9">
				<div class="hero-unit">
		        	<div>
						<div class ="span5">
							<h2>Přehled pacienta</h2>
			            </div>
			            <div>
			            	<form name="createAnamnesis" action="createAnamnesis" method="post" style="display:inline">
	    						<input type="hidden" id="id" name="id" value="<% out.print(patient.getId());%>">
	    						<a href="javascript:;" onclick="parentNode.submit();"><h3>Přidat záznam</h3></a>
	    						<input type="hidden" name="mess"/>
	    					</form>
						</div>
					</div>	
					<table style="border: 1px solid black">
						<tbody>
							<tr>
								<th>Číslo pacienta: </th>
									<td><%out.println(patient.getId()); %></td>
		
								<th>Rodné číslo: </th>
									<td><%out.println(patient.getNin()); %></td>
		
								<th>Adresa: </th>
									<td><%out.println("nevyplněno");%></td>
		
							</tr>
							<tr>
								<th>Telefon: </th>
									<td><%out.println("nevyplněno");%></td>
											
								<th>Věk:</th>
									<td><%out.println("nevyplněno");%></td>
		
								<th>Pohaví:</th>
									<td><%out.println(patient.getGender()=="male"?"muž":"žena"); %></td>
							</tr>
									
					        <tr>
					          	<th>Email:</th>
									<td><%out.println("nevyplněno");%></td>
											
								<th>Věk při začátku epilepsie:</th>
									<td><%out.println("nevyplněno");%></td>
		
								<th>Ošetřující lékař:</th>
									<td><%out.println("nevyplněno");%></td>
		
							</tr>
						</tbody>
					</table>
					
		                                            
					<div>
						<h3>Anamnéza</h3>
						<table style="border: 1px solid black" class="">
		        			<thead style="border: 1px solid black">
		        				<tr>
		            				<td>Zadáno dne:</td>
		            				<td class="pull-right"><a href="underConstruction">Zobrazit všechny záznamy</a></td>
		        				</tr>
		        			</thead>
		        			<tbody>	
		        				<tr>
		            				<td colspan="2">
		                				<div>
		                					<table>
		                    					<tbody>
		                    						<tr>
		                        						<td>Epilepsie v rodině</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Prenatální rizika</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Febrilní křeče</td>
		                    						</tr>
		                    
		                    						<tr>
		                        						<td>Zánět CNS</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Úraz CNS</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Operace CNS</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Casná PMD retardace</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Začátek epilepsie</td>
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>První záchvat s horečkou</td>				
		                    						</tr>
		                    					
		                    						<tr>
		                        						<td>Infantilní spasmy</td>
		                    						</tr>
		                    					
		                    						<tr>
		                    							<td>Epileptický syndrom</td>
		                    						</tr>
		                   						
		                   							<tr>
														<td>Non CNS komorbidita</td>
			                    					</tr>
			                    					
			                    					<tr>
			                       						<td>Komentář</td>
			                    					</tr>
		                						</tbody>
		                					</table>
		                				</div>
		           					</td>
		        				</tr>
		    				</tbody>
		    			</table>
					</div>	
				</div>
			</div>
		</div>
	</body>
</html>
