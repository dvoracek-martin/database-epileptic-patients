<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Přidat pacienta</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/img/logoIcon.ico"/>">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
	rel="stylesheet">

</head>
<body>

	<!-- box of whole page -->
	<div class="container-fluid">
		<!--  it defines box with logo -->
		<div class="navbar navbar-inverse">
			<div class="navbar-inner">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">GENEPI - PŘIDAT PACIENTA</a>
			</div>

		</div>

		<!--  it defines box with menu and logo -->
		<div class="span3">
			<div class="well sidebar-nav">
				<a href="/GENEPI/"> <img class="photo1" width=2560 height=1600
					src="<c:url value="/resources/img/logo.png"/>" alt="logo" />
				</a>
			</div>
			<div>
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Pacienti</li>
						<li><a href="<c:url value="/patient/list" />">Kartotéka
								pacientů</a></li>
						<li><a href="underConstruction">Pokročilé vyhledávání</a></li>
						<li class="nav-header">Uživatel:</li>
						<li><a href="<c:url value="/profile" />">Profil</a></li>
						<li><a href="j_spring_security_logout">Odhlásit</a></li>
						<li class="nav-header">Jazyk</li>
						<li><a href="?lang=cs">CZ</a></li>
						<li><a href="?lang=en">EN</a></li>
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

		<!-- box with content -->
		<div class="span9">
			<div class="hero-unit">
				<div style="border-bottom: 2px solid black">
					<h2>
						<spring:message code="label.addpatient" />
					</h2>
				</div>
				<div class="form" style="margin: 10px; width: 60%">
					<!-- form for adding new patient -->
					<form:form method="POST" action="/GENEPI/patient/add"
						commandName="patient">
						<form:label path="contact.firstName">
							<spring:message code="label.firstname" />
						</form:label>
						<form:input path="contact.firstName" type="text"
							class="input-block-level" />
						<form:errors path="contact.firstName" cssClass="error">
						</form:errors>
						<form:label path="contact.lastName">
							<spring:message code="label.lastname" />
						</form:label>
						<form:input path="contact.lastName" type="text"
							class="input-block-level" />

						<form:label path="birthday">
							<spring:message code="label.birthdate" />
						</form:label>
						<form:input path="birthday" type="text"
							class="input-block-level datepicker" />
						<form:errors path="birthday" cssClass="error" />

						<form:label path="nin">
							<spring:message code="label.idnumber" />
						</form:label>
						<form:input path="nin" type="text" class="input-block-level" />
						<form:errors path="nin" cssClass="error" />


						<form:label path="gender">
							<spring:message code="label.sex" />
						</form:label>
						<form:select path="gender" class="input-block-level">
							<form:option value="NONE" label="--- Select ---" />
							<form:option value="male" label="male" />
							<form:option value="female" label="female" />
						</form:select>

						<form:label path="contact.addressStreet">
							<spring:message code="label.street" />
						</form:label>
						<form:input path="contact.addressStreet" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressStreet" cssClass="error" />

						<form:label path="contact.addressHn">
							<spring:message code="label.addressHn" />
						</form:label>
						<form:input path="contact.addressHn" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressHn" cssClass="error" />

						<form:label path="contact.addressCity">
							<spring:message code="label.addressCity" />
						</form:label>
						<form:input path="contact.addressCity" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressCity" cssClass="error" />

						<form:label path="contact.addressPostalcode">
							<spring:message code="label.addressPostalcode" />
						</form:label>
						<form:input path="contact.addressPostalcode" type="text"
							class="input-block-level" />
						<form:errors path="contact.addressPostalcode" cssClass="error" />

						<form:label path="contact.addressCountry">
							<spring:message code="label.addressCountry" />
						</form:label>
						<form:input path="contact.addressCountry" type="text"
							class="input-block-level" list="countries" />
						<form:errors path="contact.addressCountry" cssClass="error" />

						<form:label path="contact.phoneNumber">
							<spring:message code="label.phoneNumber" />
						</form:label>
						<form:input path="contact.phoneNumber" type="text"
							class="input-block-level" />
						<form:errors path="contact.phoneNumber" cssClass="error" />

						<form:label path="contact.email">
							<spring:message code="label.email" />
						</form:label>
						<form:input path="contact.email" type="text"
							class="input-block-level" />
						<form:errors path="contact.email" cssClass="error" />

						<form:label path="doctorId">osetrujici lekar-FIXME multilang</form:label>
						<form:input path="doctorId" type="text" class="input-block-level"
							list="doctors" />
						<form:errors path="doctorId" cssClass="error" />

						<button class="btn btn-small btn-primary" type="submit">
							<spring:message code="label.add" />
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<datalist id="countries">
		<option value="<spring:message code="country.AD" />">
		<option value="<spring:message code="country.AE" />">
		<option value="<spring:message code="country.AF" />">
		<option value="<spring:message code="country.AG" />">
		<option value="<spring:message code="country.AI" />">
		<option value="<spring:message code="country.AL" />">
		<option value="<spring:message code="country.AM" />">
		<option value="<spring:message code="country.AO" />">
		<option value="<spring:message code="country.AQ" />">
		<option value="<spring:message code="country.AR" />">
		<option value="<spring:message code="country.AS" />">
		<option value="<spring:message code="country.AT" />">
		<option value="<spring:message code="country.AU" />">
		<option value="<spring:message code="country.AW" />">
		<option value="<spring:message code="country.AX" />">
		<option value="<spring:message code="country.AZ" />">
		<option value="<spring:message code="country.BA" />">
		<option value="<spring:message code="country.BB" />">
		<option value="<spring:message code="country.BD" />">
		<option value="<spring:message code="country.BE" />">
		<option value="<spring:message code="country.BF" />">
		<option value="<spring:message code="country.BG" />">
		<option value="<spring:message code="country.BH" />">
		<option value="<spring:message code="country.BI" />">
		<option value="<spring:message code="country.BJ" />">
		<option value="<spring:message code="country.BL" />">
		<option value="<spring:message code="country.BM" />">
		<option value="<spring:message code="country.BN" />">
		<option value="<spring:message code="country.BO" />">
		<option value="<spring:message code="country.BQ" />">
		<option value="<spring:message code="country.BR" />">
		<option value="<spring:message code="country.BS" />">
		<option value="<spring:message code="country.BT" />">
		<option value="<spring:message code="country.BV" />">
		<option value="<spring:message code="country.BW" />">
		<option value="<spring:message code="country.BY" />">
		<option value="<spring:message code="country.BZ" />">
		<option value="<spring:message code="country.CA" />">
		<option value="<spring:message code="country.CC" />">
		<option value="<spring:message code="country.CD" />">
		<option value="<spring:message code="country.CF" />">
		<option value="<spring:message code="country.CG" />">
		<option value="<spring:message code="country.CI" />">
		<option value="<spring:message code="country.CK" />">
		<option value="<spring:message code="country.CL" />">
		<option value="<spring:message code="country.CM" />">
		<option value="<spring:message code="country.CN" />">
		<option value="<spring:message code="country.CO" />">
		<option value="<spring:message code="country.CR" />">
		<option value="<spring:message code="country.CU" />">
		<option value="<spring:message code="country.CV" />">
		<option value="<spring:message code="country.CW" />">
		<option value="<spring:message code="country.CX" />">
		<option value="<spring:message code="country.CY" />">
		<option value="<spring:message code="country.CZ" />">
		<option value="<spring:message code="country.DE" />">
		<option value="<spring:message code="country.DJ" />">
		<option value="<spring:message code="country.DK" />">
		<option value="<spring:message code="country.DM" />">
		<option value="<spring:message code="country.DO" />">
		<option value="<spring:message code="country.DZ" />">
		<option value="<spring:message code="country.EC" />">
		<option value="<spring:message code="country.EE" />">
		<option value="<spring:message code="country.EG" />">
		<option value="<spring:message code="country.EH" />">
		<option value="<spring:message code="country.ER" />">
		<option value="<spring:message code="country.ES" />">
		<option value="<spring:message code="country.ET" />">
		<option value="<spring:message code="country.FI" />">
		<option value="<spring:message code="country.FJ" />">
		<option value="<spring:message code="country.FK" />">
		<option value="<spring:message code="country.FM" />">
		<option value="<spring:message code="country.FO" />">
		<option value="<spring:message code="country.FR" />">
		<option value="<spring:message code="country.GA" />">
		<option value="<spring:message code="country.GB" />">
		<option value="<spring:message code="country.GD" />">
		<option value="<spring:message code="country.GE" />">
		<option value="<spring:message code="country.GF" />">
		<option value="<spring:message code="country.GG" />">
		<option value="<spring:message code="country.GH" />">
		<option value="<spring:message code="country.GI" />">
		<option value="<spring:message code="country.GL" />">
		<option value="<spring:message code="country.GM" />">
		<option value="<spring:message code="country.GN" />">
		<option value="<spring:message code="country.GP" />">
		<option value="<spring:message code="country.GQ" />">
		<option value="<spring:message code="country.GR" />">
		<option value="<spring:message code="country.GS" />">
		<option value="<spring:message code="country.GT" />">
		<option value="<spring:message code="country.GU" />">
		<option value="<spring:message code="country.GW" />">
		<option value="<spring:message code="country.GY" />">
		<option value="<spring:message code="country.HK" />">
		<option value="<spring:message code="country.HM" />">
		<option value="<spring:message code="country.HN" />">
		<option value="<spring:message code="country.HR" />">
		<option value="<spring:message code="country.HT" />">
		<option value="<spring:message code="country.HU" />">
		<option value="<spring:message code="country.CH" />">
		<option value="<spring:message code="country.ID" />">
		<option value="<spring:message code="country.IE" />">
		<option value="<spring:message code="country.IL" />">
		<option value="<spring:message code="country.IM" />">
		<option value="<spring:message code="country.IN" />">
		<option value="<spring:message code="country.IO" />">
		<option value="<spring:message code="country.IQ" />">
		<option value="<spring:message code="country.IR" />">
		<option value="<spring:message code="country.IS" />">
		<option value="<spring:message code="country.IT" />">
		<option value="<spring:message code="country.JE" />">
		<option value="<spring:message code="country.JM" />">
		<option value="<spring:message code="country.JO" />">
		<option value="<spring:message code="country.JP" />">
		<option value="<spring:message code="country.KE" />">
		<option value="<spring:message code="country.KG" />">
		<option value="<spring:message code="country.KH" />">
		<option value="<spring:message code="country.KI" />">
		<option value="<spring:message code="country.KM" />">
		<option value="<spring:message code="country.KN" />">
		<option value="<spring:message code="country.KP" />">
		<option value="<spring:message code="country.KR" />">
		<option value="<spring:message code="country.KW" />">
		<option value="<spring:message code="country.KY" />">
		<option value="<spring:message code="country.KZ" />">
		<option value="<spring:message code="country.LA" />">
		<option value="<spring:message code="country.LB" />">
		<option value="<spring:message code="country.LC" />">
		<option value="<spring:message code="country.LI" />">
		<option value="<spring:message code="country.LK" />">
		<option value="<spring:message code="country.LR" />">
		<option value="<spring:message code="country.LS" />">
		<option value="<spring:message code="country.LT" />">
		<option value="<spring:message code="country.LU" />">
		<option value="<spring:message code="country.LV" />">
		<option value="<spring:message code="country.LY" />">
		<option value="<spring:message code="country.MA" />">
		<option value="<spring:message code="country.MC" />">
		<option value="<spring:message code="country.MD" />">
		<option value="<spring:message code="country.ME" />">
		<option value="<spring:message code="country.MF" />">
		<option value="<spring:message code="country.MG" />">
		<option value="<spring:message code="country.MH" />">
		<option value="<spring:message code="country.MK" />">
		<option value="<spring:message code="country.ML" />">
		<option value="<spring:message code="country.MM" />">
		<option value="<spring:message code="country.MN" />">
		<option value="<spring:message code="country.MO" />">
		<option value="<spring:message code="country.MP" />">
		<option value="<spring:message code="country.MQ" />">
		<option value="<spring:message code="country.MR" />">
		<option value="<spring:message code="country.MS" />">
		<option value="<spring:message code="country.MT" />">
		<option value="<spring:message code="country.MU" />">
		<option value="<spring:message code="country.MV" />">
		<option value="<spring:message code="country.MW" />">
		<option value="<spring:message code="country.MX" />">
		<option value="<spring:message code="country.MY" />">
		<option value="<spring:message code="country.MZ" />">
		<option value="<spring:message code="country.NA" />">
		<option value="<spring:message code="country.NC" />">
		<option value="<spring:message code="country.NE" />">
		<option value="<spring:message code="country.NF" />">
		<option value="<spring:message code="country.NG" />">
		<option value="<spring:message code="country.NI" />">
		<option value="<spring:message code="country.NL" />">
		<option value="<spring:message code="country.NO" />">
		<option value="<spring:message code="country.NP" />">
		<option value="<spring:message code="country.NR" />">
		<option value="<spring:message code="country.NU" />">
		<option value="<spring:message code="country.NZ" />">
		<option value="<spring:message code="country.OM" />">
		<option value="<spring:message code="country.PA" />">
		<option value="<spring:message code="country.PE" />">
		<option value="<spring:message code="country.PF" />">
		<option value="<spring:message code="country.PG" />">
		<option value="<spring:message code="country.PH" />">
		<option value="<spring:message code="country.PK" />">
		<option value="<spring:message code="country.PL" />">
		<option value="<spring:message code="country.PM" />">
		<option value="<spring:message code="country.PN" />">
		<option value="<spring:message code="country.PR" />">
		<option value="<spring:message code="country.PS" />">
		<option value="<spring:message code="country.PT" />">
		<option value="<spring:message code="country.PW" />">
		<option value="<spring:message code="country.PY" />">
		<option value="<spring:message code="country.QA" />">
		<option value="<spring:message code="country.RE" />">
		<option value="<spring:message code="country.RO" />">
		<option value="<spring:message code="country.RS" />">
		<option value="<spring:message code="country.RU" />">
		<option value="<spring:message code="country.RW" />">
		<option value="<spring:message code="country.SA" />">
		<option value="<spring:message code="country.SB" />">
		<option value="<spring:message code="country.SC" />">
		<option value="<spring:message code="country.SD" />">
		<option value="<spring:message code="country.SE" />">
		<option value="<spring:message code="country.SG" />">
		<option value="<spring:message code="country.SH" />">
		<option value="<spring:message code="country.SI" />">
		<option value="<spring:message code="country.SJ" />">
		<option value="<spring:message code="country.SK" />">
		<option value="<spring:message code="country.SL" />">
		<option value="<spring:message code="country.SM" />">
		<option value="<spring:message code="country.SN" />">
		<option value="<spring:message code="country.SO" />">
		<option value="<spring:message code="country.SR" />">
		<option value="<spring:message code="country.SS" />">
		<option value="<spring:message code="country.ST" />">
		<option value="<spring:message code="country.SV" />">
		<option value="<spring:message code="country.SX" />">
		<option value="<spring:message code="country.SY" />">
		<option value="<spring:message code="country.SZ" />">
		<option value="<spring:message code="country.TC" />">
		<option value="<spring:message code="country.TD" />">
		<option value="<spring:message code="country.TF" />">
		<option value="<spring:message code="country.TG" />">
		<option value="<spring:message code="country.TH" />">
		<option value="<spring:message code="country.TJ" />">
		<option value="<spring:message code="country.TK" />">
		<option value="<spring:message code="country.TL" />">
		<option value="<spring:message code="country.TM" />">
		<option value="<spring:message code="country.TN" />">
		<option value="<spring:message code="country.TO" />">
		<option value="<spring:message code="country.TR" />">
		<option value="<spring:message code="country.TT" />">
		<option value="<spring:message code="country.TV" />">
		<option value="<spring:message code="country.TW" />">
		<option value="<spring:message code="country.TZ" />">
		<option value="<spring:message code="country.UA" />">
		<option value="<spring:message code="country.UG" />">
		<option value="<spring:message code="country.UM" />">
		<option value="<spring:message code="country.US" />">
		<option value="<spring:message code="country.UY" />">
		<option value="<spring:message code="country.UZ" />">
		<option value="<spring:message code="country.VA" />">
		<option value="<spring:message code="country.VC" />">
		<option value="<spring:message code="country.VE" />">
		<option value="<spring:message code="country.VG" />">
		<option value="<spring:message code="country.VI" />">
		<option value="<spring:message code="country.VN" />">
		<option value="<spring:message code="country.VU" />">
		<option value="<spring:message code="country.WF" />">
		<option value="<spring:message code="country.WS" />">
		<option value="<spring:message code="country.XK" />">
		<option value="<spring:message code="country.YE" />">
		<option value="<spring:message code="country.YT" />">
		<option value="<spring:message code="country.ZA" />">
		<option value="<spring:message code="country.ZM" />">
		<option value="<spring:message code="country.ZW" />">
	</datalist>

	<datalist id="doctors">
		<option value="ddd">
	</datalist>

	<!-- Javascripts imports -->
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script>
		$(function() {
			$(".datepicker").datepicker({
				dateFormat : "dd/mm/yy",
				changeYear : true
			});

		});
	</script>

</body>
</html>