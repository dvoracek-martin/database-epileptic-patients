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

<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="cz">
	<head>
		<meta charset="utf-8" />
		<title>Pacient</title>
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
				PatientDAO patient = patientOverviewController.findByID(Integer.parseInt(request.getParameter("id")));
		%>
				
		<!-- box of whole page -->			
		<div class="container-fluid">
			<!--  it defines box with logo -->
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - PACIENT</a>
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
	    							  <input type="hidden" id="id" name="id" value="<% out.print(patient.getId());%>">
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
		            		<h3 class="pull-right"><a href="underConstruction">Export pacienta</a></h3>
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
						<table style="border: 1px solid black" class="span7">
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
					<div>
						<h3>Záchvaty</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Četnost záchvatu</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Sekundárně generalizované</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Status epilepticus</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Neepileptické záchvaty</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Výskyt</td>
	                    							</tr>
		                    					
		                    						<tr>
		                       							<td>Komentář</td>
		                    						</tr>
		                    						
		                    						<tr>
		                       							<td colspan="2">1. typ záchvatu:</td>
		                    						</tr>
		                    						
		                    						<tr>
	                        							<td>Zadáno dne</td>
	                    							</tr>
		                    						
		                    						<tr>
	                        							<td>SSC klasifikace</td>
	                    							</tr>
		                    					
		                    						<tr>
	                        							<td>ILAE klasifikace</td>
	                    							</tr>
		                    					
		                    						<tr>
	                        							<td>Komentář</td>
	                    							</tr>
		                    						
		                    						<tr>
		                       							<td colspan="2">2. typ záchvatu:</td>
		                    						</tr>
		                    						
		                    						<tr>
		                       							<td colspan="2">3. typ záchvatu:</td>
		                    						</tr>
	                							</tbody>
	                						</table>
	                					</div>
	           						 </td>
	        					</tr>
	    				</tbody>
	    			</table>
					</div>
						
					<div>
						<h3>Farmakoterapie</h3>
						<table style="border: 1px solid black" class="span7">
							<thead style="border: 1px solid black">
								<tr>
	            					<td>Datum</td>
	            					<td>Léčivo</td>
	            					<td>Efektivita</td>
	            					<td>Při operaci</td>
	        					</tr>
							</thead>
	        				<tbody>
	        					<tr>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Neurologický nález</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Dominance hemisféry</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Abnormální neurologický nález</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Hemiparéza</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Defekt zorného pole</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Detaily neurologického nálezu</td>
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
						
					<div>
						<h3>Neuropsychologie</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Neuropsychologické vyšetření</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Věk při neuropsychologickém vyšetření</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Inteligencní úroveň</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Specifická porucha učení</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Vývojová porucha řeči</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>ADHD syndrom</td>
	                    							</tr>
	                    							
		                    						<tr>
		                       							<td>Komentář</td>
		                        						<td></td>
		                    						</tr>
	                							</tbody>
	                						</table>
	                					</div>
	           						 </td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Diagnostické testy - Skalpové EEG</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Diagnostický test - Skalpové EEG</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Základní EEG aktivita</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>EEG zpomalení</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Interiktální EEG hroty</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Lokalizace interiktálních EEG hrotu</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>EEG status epilepticus</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Sekundární bilaterální synchronie</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Iktální EEG vzorce</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace iktálních EEG vzoru</td>
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
						
					<div>
						<h3>Diagnostické testy - Neurozobrazovací testy</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Diagnostický test - Neurozobrazovací test</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>MRI protokol</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>MRI nález</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>MRI popis</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>FDG PET</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace PET hypometabolismu</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Interiktální SPECT</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace SPECT hypoperfuse</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Iktální SPECT</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace SPECT hyperperfuse</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>SISCOM</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>MRS protokol</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>MRS nález</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace MRS abnormality</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>fMRI</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Detaily fMRI</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>DTI</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Detaily DTI studie</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>WADA</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Detaily WADA</td>
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
						
					<div>
						<h3>Invazivní testy - ECoG</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Invazivní test ECoG</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>ECoG pokrytí</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>ECoG vzorce</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>ECoG po resekci</td>
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
						
					<div>
						<h3>Invazivní testy - iEEG</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Invazivní test iEEG</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Intrakraniální elektrody</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Lokalizace intrakraniálních elektrod</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Invazivní EEG zpomalení</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Invazivní EEG interiktální hroty</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace invazivních EEG interiktálních hrotu</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Invazivní EEG status epilepticus</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Invazivní EEG iktální vzorce</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizce invazivních EEG iktálních vzorcu</td>
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
						
					<div>
						<h3>Invazivní testy - Kortikalní mapovaní</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Invazivní test Kortikální mapování</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Kortikální mapování</td>
	                    							</tr>
	                    					
		                    						<tr>
		                       							<td>Komentář</td>
		                        						<td></td>
		                    						</tr>
	                							</tbody>
	                						</table>
	                					</div>
	           						 </td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Operace</h3>
						<table style="border: 1px solid black" class="span7">
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
	                        							<td>Datum operace</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Věk Při operaci</td>
	                    							</tr>
	                    					
	                    							<tr>
	                        							<td>Trvání epilepsie v době operace</td>
	                    							</tr>
	                    
	                    							<tr>
	                        							<td>Typ operace</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Rozsah operace</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Lokalizace operace</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>MST</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Kalostomie</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>VNS</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Datum imlantace VNS</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Detaily operace</td>
	                    							</tr>
	                    							
	                    							<tr>
	                        							<td>Resekce kompletní</td>
	                    							</tr>
	                    					
		                    						<tr>
		                       							<td>Komentář</td>
		                        						<td></td>
		                    						</tr>
	                							</tbody>
	                						</table>
	                					</div>
	           						 </td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Histologie</h3>
						<table style="border: 1px solid black" class="span7">
							<thead style="border: 1px solid black">
								<tr>
	            					<td>Datum</td>
	            					<td>Histopatologie</td>
	            					<td>Klasifikace FCD</td>
	            					<td></td>
	        					</tr>
							</thead>
	        				<tbody>
	        					<tr>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Komplikace</h3>
						<table style="border: 1px solid black" class="span7">
							<thead style="border: 1px solid black">
								<tr>
	            					<td>Datum</td>
	            					<td>Průběh</td>
	            					<td>Typ komplikace</td>
	            					<td>Komplikace</td>
	        					</tr>
							</thead>
	        				<tbody>
	        					<tr>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	            					<td></td>
	        					</tr>
	    					</tbody>
	    				</table>
					</div>
						
					<div>
						<h3>Outcome</h3>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

    
      