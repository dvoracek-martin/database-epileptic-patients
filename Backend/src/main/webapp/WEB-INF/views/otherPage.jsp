<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=utf-8"
		pageEncoding="ISO-8859-1" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Some other page</title>
</head>
<body>
	<P>Pls set page encoding and charset to utf-8 instead of ISO-8859-1
		to display czech properly.</P>
	<P>The time on the server is ${anotherServerTime}.</P>
	<P>You wrote ${name} to the formular.</P>
</body>
	</html>
</jsp:root>