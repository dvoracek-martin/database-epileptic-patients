<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="cz.cvut.fit.genepi.controllers.*"%>
<!-- import of modelsImpl -->
<%@ page import="cz.cvut.fit.genepi.DAO.*"%>
<%@ page import="cz.cvut.fit.genepi.entity.*"%>
<%@ page import=" java.util.List" %>
<!--  import of list -->
<%@ page import=" java.util.*" %>
<%@ page import=" java.lang.*" %>
<%@ page import=" java.io.*" %>

<%@ page import=" java.text.SimpleDateFormat" %>

<%@page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Přidaný pacient</title>
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  
  
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
					</a> <a class="brand" href="#">GENEPI - PŘIDANÝ PACIENT</a>
				</div>
				
			</div>
		
		  	<!--  it defines box with menu and logo -->
			<div class="span3">
				<div class="well sidebar-nav">
	           		<a href="/GENEPI/" >  <img  class="photo1" width=2560  height=1600 src="resources/img/logo.png" alt="logo"/> </a>
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
				// creation of patientsListController
				CreatePatientController patientsListController = new CreatePatientController();
		         CreatedPatientController patientsController = new CreatedPatientController();
				// gets list of patients in the database
				//List<PatientDAO> patients = patientsListController.findAll(); 
				
				String string = request.getParameter("patientBirthdate");
				String nin = request.getParameter("patientIN");
				String sex = request.getParameter("patientSEX");
				String sex1 = "deafult";
				if(sex=="man"){sex1="muz";
				}
				if(sex=="woman"){sex1="zena";
				}
				try{
					Date date = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(string);
					patientsController.createNewContact(request.getParameter("patientFirstname"), request.getParameter("patientSurname"), request.getParameter("patientStreet"), request.getParameter("patientLRN"),request.getParameter("patientCity") , request.getParameter("patientZIP"), request.getParameter("patientCountry"), request.getParameter("patientPhone"), request.getParameter("patientMail"));
					// TADY SE MUSÍ VYHLEDAT POSLEDNÍ ID KONTKTU KTERÝ SE PŘIDALO A PŘIŘADIT SE DO METODY DOLE
					int a = 1;
					// creation of patientsListController
					PatientsListController patientsListController1 = new PatientsListController();
					// gets list of patients in the database
					List<PatientEntity> patients = patientsListController1.findAll();
					PatientOverviewController patientOverviewController = new PatientOverviewController();
					if(patients.size()!=0){
					for (PatientEntity patient : patients) {
						ContactEntity contact=patientOverviewController.findContactByID(patient.getId());
						if(contact != null)
						a=contact.getId();
					}
					// creation of patientOverviewController
					
					a++;}
					
					
					patientsListController.createNewPatient(nin,date, sex1, 1, 0, 0,a, 0); 
					
				}catch(java.text.ParseException ex){ out.println("Incorect format of date of birth ");
			%>
				<jsp:forward page="createPatientView.jsp"/>
			<%
				}			
			%>
						
			<!-- box for the content -->		
			<div class="span9">
	          <div class="hero-unit">
	            	<h2 style="margin-bottom: 1em">Pacient byl vytvořen!</h2>
		            <p>
		                Jméno : <% out.println(request.getParameter("patientFirstname")); %>
		            </p>
		            <p>
		                Příjmení : <% out.println(request.getParameter("patientSurname")); %>
		            </p>
		            <p>
		                Datum narození : <% out.println(request.getParameter("patientBirthdate")); %>
		            </p>
		            <p>
		                Rodné číslo : <% out.println(request.getParameter("patientIN")); %>
		            </p>
		            <p>
		                Pohlaví : <% out.println(request.getParameter("patientSex")); %>
		            </p>
		            <p>
		                Ošetřující lékař : <% out.println(request.getParameter("patientDoctor")); %>   
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