<%@ page import="org.springframework.security.core.userdetails.User"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="java.util.Collection"%>
<%@ page import="javax.swing.text.AbstractDocument"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html lang="cz">
<head>
<meta charset="utf-8" />
<title>Home Page</title>
  <link href="resources/css/bootstrap2.2.css" rel="stylesheet">
  <link rel="icon" type="image/png" href="resources/img/logoIcon.ico">
  
  
</head>
<body>
	<div class="navbar-wrapper" id="home">
		<div class="container">

			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">GENEPI - PACIENT</a>
				</div>
			</div>
		</div>
	</div>

	<%
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
	%>
	
	<div class="container-fluid">
      
        <div class="span3">
			<div class="well sidebar-nav">
				</br></br></br></br></br></br></br></br></br></br></br></br></br>
          		<h1><a href="/GENEPI/" style="text-decoration: none">FN MOTOL</a></h1>
        	</div>
		
			<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header">Cislo pacienta:</li>
             	 	<li><a href="underConstruction">Prehled</a></li>
              		<li><a href="underConstruction">Anamneza</a></li>
              		<li><a href="underConstruction">Farmakoterapie</a></li>
              		<li><a href="underConstruction">Neurologicke nalezy</a></li>
              		<li><a href="underConstruction">Neuropsychologie</a></li>
              		<li><a href="underConstruction">(Neuropsychologie - old)</a></li>
              		<li><a href="underConstruction">Diagnosticke testy</a></li>
              		<li><a href="underConstruction">Neuropsychologie</a></li>
              			<ul>
              				<li><a href="underConstruction">Skalpove EEG</a></li>
              				<li><a href="underConstruction">Neurozobraz. testy</a></li>
              			</ul>
              		<li><a href="underConstruction">Invazivni testy</a></li>
              			<ul>
              				<li><a href="underConstruction">ECoG</a></li>
              				<li><a href="underConstruction">iEEG</a></li>
              				<li><a href="underConstruction">Kortikalni mapovani</a></li>
              			</ul>
             		 <li><a href="underConstruction">Operace</a></li>
             		 <li><a href="underConstruction">Komplikace</a></li>
              		<li><a href="underConstruction">Outcome</a></li>
            	</ul>
			</div>
          
			<div class="well sidebar-nav">
            	<ul class="nav nav-list">
            	  <li class="nav-header">Pacienti</li>
             	 <li><a href="patientsList">Kartoteka pacientu</a></li>
             	 <li><a href="#">Pokrocile vyhledavani</a></li>
             	 <li class="nav-header">Uzivatel: <%=username%></li>
             	 <li><a href="myProfile">Profil</a></li>
             	 <li><a href="j_spring_security_logout">Odhlasit</a></li>
             	 <li class="nav-header">Jazyk</li>
            	</ul>
          	</div>
			
		</div>
      	
		<div class="span9">
			<div class="hero-unit">
           		<div>
            		<h2 class="pull-left">Prehled pacienta</h2>
            		<h3 class="pull-right"><a href="#">export pacienta</a></h3>
					<table style="border: 1px solid black">
						<tbody>
							<tr>
								<th>Cislo pacienta: </th>
									<td>XXXX</td>

								<th>Rodne cislo: </th>
									<td>XXXX</td>

								<th>Adresa: </th>
									<td>XXXX</td>

							</tr>
							<tr>
								<th>Telefon: </th>
									<td>XXXX</td>
									
								<th>Vek:</th>
									<td>XX let</td>

								<th>Pohlavi:</th>
									<td>XXX</td>
							</tr>
							
			                 <tr>
			                 	<th>Email:</th>
									<td>XXXX</td>
									
								<th>Vek pri zacatku epilepsie:</th>
									<td>23 let (trvani: 0 let)</td>

								<th>Osetrujici lekar:</th>
									<td>Nevyplneno</td>

							</tr>
						</tbody>
					</table>
				</div>
                                            
				<div>
					<h3>Anamneza</h3>
					<table style="border: 1px solid black" class="span7">
        				<thead style="border: 1px solid black">
        					<tr>
            					<td>Zadano dne: XX.XX.XXXX</td>
            					<td class="pull-right"><a href="#">Zobrazit vsechny zaznamy</a></td>
        					</tr>
        				</thead>
        				<tbody>	
        					<tr>
            					<td colspan="2">
                					<div>
                						<table>
                    						<tbody>
                    							<tr>
                        							<td>Epilepsie v rodine</td>
                    							</tr>
                    					
                    							<tr>
                        							<td>Prenatální rizika</td>
                    							</tr>
                    					
                    							<tr>
                        							<td>Febrilní krece</td>
                    							</tr>
                    
                    							<tr>
                        							<td>Zánet CNS</td>
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
                        							<td>Zacátek epilepsie</td>
                    							</tr>
                    					
                    							<tr>
                        							<td>První záchvat s horeckou</td>						
                    							</tr>
                    					
                    							<tr>
                        							<td>Infantilní spasmy</td>
                    							</tr>
                    					
                    							<tr>
                    							    <td>Epileptický syndrom</td>
                     							    <td></td>
                    							</tr>
                   						
                   								<tr>
													<td>Non CNS komorbidita</td>
	                        				 		<td></td>
	                    						</tr>
	                    					
	                    						<tr>
	                       							<td>Komentár</td>
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
					
				
			</div>
		</div>
	</div>
	
	<div class="span3">
    	<div id="copyright">
        			<p>GENEPI, &copy 2013, FIT CVUT</p>
		</div>
	</div>
</body>
</html>
