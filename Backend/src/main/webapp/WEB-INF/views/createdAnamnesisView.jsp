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
<title>Přidaný záznam</title>
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
					
					// creation of patientsListController
					CreateAnamnesisController createAnamnesisController = new CreateAnamnesisController();
					// gets list of patients in the database
					//List<PatientDAO> patients = patientsListController.findAll(); 
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
		
				<% 
				
					String string = request.getParameter("anamnesisDate");
					String string1 = request.getParameter("anamnesisEpStart");
					int anaFZ = 1;
					int anaIS = 1;
					int anaES = 1;
					int anaFE = 1;
					int anaPR = 1;
					int anaFI = 1;
					int anaZA = 1;
					int anaUR = 1;
					int anaOP = 1;
					int anaPM = 1;
					if(request.getParameter("anamnesisFirstZ")==null){
						anaFZ=0;
					}
					if(request.getParameter("anamnesisInfSpas")==null){
						anaIS=0;
					}
					if(request.getParameter("anamnesisEpiSyn")==null){
						anaES=0;
					}
					if(request.getParameter("anamnesisFamilyEp")==null){
						anaFE=0;
					}
					if(request.getParameter("anamnesisPren")==null){
						anaPR=0;
					}
					if(request.getParameter("anamnesisFib")==null){
						anaFI=0;
					}
					if(request.getParameter("anamnesisZan")==null){
						anaZA=0;
					}
					if(request.getParameter("anamnesisUra")==null){
						anaUR=0;
					}
					if(request.getParameter("anamnesisOper")==null){
						anaOP=0;
					}
					if(request.getParameter("anamnesisPMD")==null){
						anaPM=0;
					}
					try{
						Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(string);
						Date date1 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(string1);
						createAnamnesisController.createNewAnamnesis(date, 1,date, date1, anaFZ, anaIS, anaES, anaFE, anaPR, anaFI, anaZA, anaUR, anaOP, anaPM, request.getParameter("anamnesisNonCNS").toString(), request.getParameter("anamnesisCom"), 0, patient.getId(), 1);
					}catch(java.text.ParseException ex){ out.println("Incorect format of date of birth ");
				%>
					  <jsp:forward page="createAnamnesisView.jsp"/>
				<%
					}
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
		            
		            <h2 style="margin-bottom: 1em">Záznam byl přidán!</h2>
		            <p>
		                Epilepsie v rodině :
		            	<%
		                    if(request.getParameter("anamnesisFamilyEp")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		            <p>
		                Prenatální rizika :
		            	<%
		                    if(request.getParameter("anamnesisPren")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		            <p>
		                Fibrilní křeče : 
		            	<%
		                    if(request.getParameter("anamnesisFib")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		            <p>
		                Zánět CNS : 
		            	<%
		                    if(request.getParameter("anamnesisZan")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		            <p>
		                Úraz CNS :
		            	<%
		                    if(request.getParameter("anamnesisUra")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		            <p>
		                Operace CNS :   
		            	<%
		                    if(request.getParameter("anamnesisOper")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		             <p>
		                Cašná PMD retardace :   
		            	<%
		                    if(request.getParameter("anamnesisPMD")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		             <p>
		                Začátek epilepsie : <% out.println(request.getParameter("anamnesisEpStart")); %>   
		            </p>
		             <p>
		                První záchvat s horečkou :   
		            	 <%
		                    if(request.getParameter("anamnesisFirstZ")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		             <p>
		                Infantilní spasmy : 
		                <%
		                    if(request.getParameter("anamnesisInfSpas")==null){
		                    	out.println("NE");
		                    }else{
		                	out.println("ANO");
		                    }
		                 %> 
		            </p>
		             <p>
		                Epileptický syndrom : 
		                <% 
		                	out.println(request.getParameter("anamnesisEpiSyn")); 
		                %>   
		            </p>
		            <p>
		                Non CNS komorbidita : <% out.println(request.getParameter("anamnesisNonCNS")); %>   
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