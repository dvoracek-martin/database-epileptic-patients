<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.DAO.*"%>
<!--  import of list -->
<%@ page import=" java.util.*" %>
<%@ page import=" java.lang.*" %>
<%@ page import=" java.io.*" %>
<!-- import of Entities -->
<%@ page import="cz.cvut.fit.genepi.entity.*"%>

<%@ page import=" java.text.SimpleDateFormat" %>

<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="cz">
	<head>
		<meta charset="utf-8" />
		<title>Přidat záznam</title>
		<link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
		<link href="resources/css/bootstrap2.2.css" rel="stylesheet">
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
						</a> <a class="brand" href="#">GENEPI - PŘIDAT ZÁZNAM</a>
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
							<h2>Přehled pacienta</h2>
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
						
						<!-- form for adding new record -->
						<div class="form" style="margin: 10px; width: 60%">
							<form name="createdAnamnesis" action="createdAnamnesis" method="post">
								<input type="hidden" id="id" name="id" value="<% out.print(patient.getId());%>">
								
								<b>Datum vyšetření</b> <input type="text" id="anamnesisDate" class="input-block-level"
									name="anamnesisDate" placeholder=""> <br/>
									
								<b>Ošetřující lékař</b><br/> <select id="anamnesisDoctor" class="" name="anamnesisDoctor">
													<option value="default">Zvolte lekare</option>
													<option value="hlavni">hlavni</option>
												</select> <br/>
							
												
				                Epilepsie v rodině &nbsp;<input type="checkbox" name="anamnesisFamilyEp" id="anamnesisFamilyEp"> <br/>  
				                Prenatální rizika &nbsp;<input type="checkbox" name="anamnesisPren" id="anamnesisPren"> <br/> 
				                Fibrilní křeče &nbsp;<input type="checkbox" name="anamnesisFib" id="anamnesisFib"> <br/>   
				                Zánět CNS  &nbsp;<input type="checkbox" name="anamnesisZan" id="anamnesisZan"> <br/>   
				                Úraz CNS &nbsp;<input type="checkbox" name="anamnesisUra" id="anamnesisUra"> <br/>   
				                Operace CNS &nbsp;<input type="checkbox" name="anamnesisOper" id="anamnesisOper"> <br/>  
				                Časná PMD retardace &nbsp;<input type="checkbox" name="anamnesisPMD" id="anamnesisPMD"> <br/>   
				                Začátek epilepsie <input type="text" id="anamnesisEpStart" class="input-block-level"
									name="anamnesisEpStart" placeholder=""> <br/>
				
				                První záchvat s horečkou &nbsp;<input type="checkbox" name="anamnesisFirstZ" id="anamnesisFirstZ"> <br/>  
				
				                Infantilní spasmy &nbsp;<input type="checkbox" name="anamnesisInfSpas" id="anamnesisInfSpas"> <br/>  
				
				                Epileptický syndrom <select id="anamnesisEpiSyn" class="" name="anamnesisEpiSyn">
													<option value="default">Zvolte syndrom</option>
													<option value="Extratemporální fokální epilepsie">Extratemporální fokální epilepsie</option>
													<option value="Hemisferální symtomaptická epilepsie">Hemisferální symtomaptická epilepsie</option>
													<option value="Meziotemporální epilepsie (MTLE)">Meziotemporální epilepsie (MTLE)</option>
													<option value="Multifokální epilepsie">Multifokální epilepsie</option>
												</select> <br/>
				
				                Non CNS komorbidita <input type="text" id="anamnesisNonCNS" class="input-block-level"
									name="anamnesisNonCNS" placeholder="porod per S.C. pro gestrózu zjistenou az behem porodu"> <br/>
									
				                Komentář <textarea cols="40" rows="10" name="komentar" id="anamnesisCom"></textarea> <br/>
				                
				                <button class="btn btn-small btn-primary" type="submit">Uložit</button>
				            </form>
						</div>
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
