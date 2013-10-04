<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page pageEncoding="UTF-8"%>


<t:menuLVL3>

	<jsp:attribute name="title">
      Pacient
    </jsp:attribute>
	<jsp:attribute name="header">
      Pacient
    </jsp:attribute>

	<jsp:body>
			<h1>Puso</h1>
	</jsp:body>
</t:menuLVL3>


<script>
	var link = document.getElementById('export').href;
	function chooseFormat() {
		var format = prompt(
				"Zvolte souborový formát, do kterého chcete exportovat:",
				"pdf/csv");

		while (format != "pdf" && format != "csv" && format != null) {
			format = prompt(
					"Takovýto formát není podporován. Prosím, zvolte podporovaný formát (pdf či csv).",
					"pdf/csv");
		}
		if (format == null)
			document.getElementById('export').href = "#";
		else
			document.getElementById('export').href;
	}
</script>

