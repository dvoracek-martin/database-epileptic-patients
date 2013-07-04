<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!-- import of controllers -->
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.DAO.*"%>
<!-- import of Entities -->
<%@ page import="cz.cvut.fit.genepi.entity.*"%>
<!--  import of list -->
<%@ page import=" java.util.List" %>


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
				
				ContactEntity contact=patientOverviewController.findContactByID(patient.getId());
				
				List<AnamnesisEntity> anamnesises = patientOverviewController.findAnamnesisByPatientID(patient.getId());
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
					
		                                            
					<%
					int i = 1;
				for(AnamnesisEntity anamnesis: anamnesises) {
				out.println("<div>"+
					"<h3>Anamnéza: "+(i++)+"</h3>"+
					"<table style=\"border: 1px solid black\">"+
						"<thead style=\"border: 1px solid black\">"+
							"<tr>"+
								"<td>Zadáno dne:"+anamnesis.getDate()+"</td>"+
							"</tr>"+
						"</thead>"+
						"<tbody>"+
							"<tr>"+
								"<td colspan=\"2\">"+
									"<div>"+
										"<table>"+
											"<tbody>"+
												"<tr>"+
													"<td>Epilepsie v rodině</td>"+
													"<td>");
															if(anamnesis==null)out.println("Nevyplněno");
															else
															if(anamnesis.getEpilepsyInFamily()==1)
																out.println("ano");
															else
																out.println("ne");
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Prenatální rizika</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getPrenatalRisk()==1)
																out.println("ano");
															else
																out.println("ne");
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Febrilní křeče</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getFibrilConvulsions()==1)
																out.println("ano");
															else
																out.println("ne");	
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Zánět CNS</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getInflammationCns()==1)
																out.println("ano");
															else
																out.println("ne");		
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Úraz CNS</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getInjuryCns()==1)
																out.println("ano");
															else
																out.println("ne");	
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Operace CNS</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getOperationCns()==1)
																out.println("ano");
															else
																out.println("ne");	
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Časná PMD retardace</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getEarlyPmdRetardation()==1)
																out.println("ano");
															else
																out.println("ne");
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Začátek epilepsie</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
													out.println(anamnesis.getBeginningEpilepsy().toString());
											 	out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>První záchvat s horečkou</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getFirstFever()==1)
																out.println("ano");
															else
																out.println("ne");
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Infantilní spasmy</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getInfantileSpasm()==1)
																out.println("ano");
															else
																out.println("ne");
													out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Epileptický syndrom</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getSpecificSyndromeIdcom()==1)
																out.println("ano");
															else
																out.println("ne");
												out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Non CNS komorbidita</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getNonCnsComorbidity()==null)
																out.println("nevyplněno");
															else
																out.println(anamnesis.getNonCnsComorbidity());
												out.println("</td>"+
												"</tr>"+

												"<tr>"+
													"<td>Komentář</td>"+
													"<td>");
													if(anamnesis==null)out.println("Nevyplněno");
													else
															if(anamnesis.getComment()==null)
																out.println("nevyplněno");
															else
																out.println(anamnesis.getComment());
															out.println("</td>"+
												"</tr>"+
											"</tbody>"+
										"</table>"+
									"</div>"+
								"</td>"+
							"</tr>"+
						"</tbody>"+
					"</table>"+
				"</div>");
				
				}
				%>
				</div>
			</div>
		</div>
	</body>
</html>
