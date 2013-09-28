<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>

<t:menuLVL2>

	<jsp:attribute name="head">
     <link href="<c:url value="/resources/css/validation.css"/>"
			rel="stylesheet">
		<link
			href="<c:url value="/resources/jquery-ui-datepicker/jquery-ui.min.css" />"
			rel="stylesheet">
    </jsp:attribute>
	<jsp:attribute name="title">
      <spring:message code="label.adduser" />
    </jsp:attribute>
	<jsp:attribute name="header">
      <spring:message code="label.adduser" />
    </jsp:attribute>
	<jsp:attribute name="script">
      <script src="<c:url value="/resources/js/validation.js"/>"></script>
		<script src="<c:url value="/resources/js/datepicker.js" />"></script>
    </jsp:attribute>

	<jsp:body>
	
<div style="border-bottom: 2px solid black">
	<h2>
		<spring:message code="label.adduser" />
	</h2>
</div>
<div class="form" style="margin: 10px; width: 60%">
	<!-- form for adding new patient -->
	<form:form method="POST" action="/GENEPI/user/create" commandName="user">

		<form:label path="username">
			<spring:message code="label.username" />*
						</form:label>
		<form:input id="username" path="username" type="text"
					pattern="[a-ž\dA-Ž]{1,20}" class="input-block-level"
					onFocusOut="usernameValidation();" required="true"
					title="Nesmí být delší jak 20 znaků. Smí být tvořeno pouze písmeny a čísly." />
		<form:errors path="username" cssClass="alert alert-error">
		</form:errors>
		<div id="usernameErrEmpty" class="alert alert-error"
					style="display: none">Toto pole nesmí zůstat prázdné!</div>
		<div id="usernameErr" class="alert alert-error" style="display: none">Je
			delší jak 20 znaků!</div>
		<div id="usernameErrChar" class="alert alert-error"
					style="display: none">Lze zadat pouze písmena a číslice!</div>

		<form:label path="password">
			<spring:message code="label.password" />*
						</form:label>
		<form:input id="password" path="password" type="password"
					pattern=".{8,30}" class="input-block-level"
					onFocusOut="passwordValidation();" required="true"
					title="Délka musí být mezi 8-30 znaky." />
		<form:errors path="password" cssClass="alert alert-error">
		</form:errors>
		<div id="passwordErrEmpty" class="alert alert-error"
					style="display: none">Toto pole nesmí zůstat prázdné!</div>
		<div id="passwordErr" class="alert alert-error" style="display: none">Délka
			není mezi 8-30 znaky!</div>

		<spring:message code="label.passwordAgain" />*
						<input type="password" id="passwordAgain" pattern=".{8,30}"
					class="input-block-level" onFocusOut="passwordAgainValidation();"
					required="true" title="Délka musí být mezi 8-30 znaky." />
		<div id="passwordAgainErrEmpty" class="alert alert-error"
					style="display: none">Toto pole nesmí zůstat prázdné!</div>
		<div id="passwordAgainErrLength" class="alert alert-error"
					style="display: none">Délka není mezi 8-30 znaky!</div>
		<div id="passwordAgainErrComparison" class="alert alert-error"
					style="display: none">Hesla se neshodují.</div>
		<div id="passwordAgainSuccComparison" class="alert alert-success"
					style="display: none">Hesla se shodují.</div>


		<form:label path="contact.firstName">
			<spring:message code="label.firstname" />*
						</form:label>
		<form:input id="firstname" path="contact.firstName" type="text"
					pattern="[a-žA-Ž]{1,20}" class="input-block-level"
					onFocusOut="firstnameValidation();" required="true"
					title="Nesmí přesáhnout délku 20 znaků." />
		<form:errors path="contact.firstName" cssClass="alert alert-error">
		</form:errors>
		<div id="firstnameErrEmpty" class="alert alert-error"
					style="display: none">Toto pole nesmí zůstat prázdné!</div>
		<div id="firstnameErr" class="alert alert-error" style="display: none">Je
			delší jak 20 znaků!</div>

		<form:label path="contact.lastName">
			<spring:message code="label.lastname" />*
						</form:label>
		<form:input id="lastname" path="contact.lastName" type="text"
					pattern="[a-žA-Ž]{1,20}" class="input-block-level"
					onFocusOut="lastnameValidation();" required="true"
					title="Nesmí přesáhnout délku 20 znaků." />
		<form:errors path="contact.lastName" cssClass="alert alert-error">
		</form:errors>
		<div id="lastnameErrEmpty" class="alert alert-error"
					style="display: none">Toto pole nesmí zůstat prázdné!</div>
		<div id="lastnameErr" class="alert alert-error" style="display: none">Je
			delší jak 20 znaků!</div>

		<form:label path="contact.addressStreet">
			<spring:message code="label.street" />
		</form:label>
		<form:input id="addressStreet" path="contact.addressStreet"
					type="text" pattern=".{0,30}" class="input-block-level"
					onchanged="addressStreetValidation();"
					title="Nesmí přesáhnout délku 30 znaků." />
		<form:errors path="contact.addressStreet" cssClass="alert alert-error" />
		<div id="addressStreetErr" class="alert alert-error"
					style="display: none">Je delší jak 30 znaků!</div>

		<form:label path="contact.addressHn">
			<spring:message code="label.addressHn" />
		</form:label>
		<form:input id="addressHn" path="contact.addressHn" type="text"
					pattern=".{0,10}" class="input-block-level"
					onchange="addressHnValidation();"
					title="Nesmí přesáhnout délku 10 znaků." />
		<form:errors path="contact.addressHn" cssClass="alert alert-error" />
		<div id="addressHnErr" class="alert alert-error" style="display: none">Je
			delší jak 10 znaků!</div>

		<form:label path="contact.addressCity">
			<spring:message code="label.addressCity" />
		</form:label>
		<form:input id="addressCity" path="contact.addressCity" type="text"
					pattern=".{0,30}" class="input-block-level"
					onchange="addressCityValidation();"
					title="Nesmí přesáhnout délku 30 znaků." />
		<form:errors path="contact.addressCity" cssClass="alert alert-error" />
		<div id="addressCityErr" class="alert alert-error"
					style="display: none">Je delší jak 30 znaků!</div>

		<form:label path="contact.addressPostalcode">
			<spring:message code="label.addressPostalcode" />
		</form:label>
		<form:input id="addressPostalcode" path="contact.addressPostalcode"
					type="text" pattern="\d{0,10}" class="input-block-level"
					onchange="addressPostalcodeValidation();"
					title="Smí obsahovat pouze číslce. Nesmí přesáhnout délku 10 číslic." />
		<form:errors path="contact.addressPostalcode"
					cssClass="alert alert-error" />
		<div id="addressPostalcodeErr" class="alert alert-error"
					style="display: none">Je delší jak 10 znaků!</div>

		<form:label path="contact.addressCountry">
			<spring:message code="label.addressCountry" />
		</form:label>
<form:input path="contact.addressCountry" type="text"
					class="input-block-level" list="countries" />
						<form:errors path="contact.addressCountry" cssClass="error" />

		<form:label path="contact.phoneNumber">
			<spring:message code="label.phoneNumber" />
		</form:label>
		<form:input id="phoneNumber" path="contact.phoneNumber" type="text"
					pattern="[0-9+]\d{0,19}" onchange="phoneNumberValidation();"
					class="input-block-level"
					title="Musí být ve formátu +číslo/číslo. Nesmí přesáhnout délku 20 znaků." />
		<form:errors path="contact.phoneNumber" cssClass="alert alert-error" />
		<div id="phoneNumberErr" class="alert alert-error"
					style="display: none">Je delší jak 20 znaků!</div>

		<form:label path="contact.email">
			<spring:message code="label.email" />
		</form:label>
		<form:input id="email" path="contact.email" type="email"
					title="example@address.com" class="input-block-level" />
		<form:errors path="contact.email" cssClass="alert alert-error" />



		<c:forEach var="role" items="${listOfPossibleRoles}">
			<input type="checkbox" value="${role.id}"/> ${role.authority}
			</br>
		</c:forEach>

		<button class="btn btn-small btn-primary" type="submit"
					onclick="validation();">
			<spring:message code="label.add" />
		</button>



		<form:hidden path="id" id="id" />
	</form:form>

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
		
	</jsp:body>
</t:menuLVL2>

