$(function() {
	$(".datepicker-today").datepicker({
		dateFormat : "yy-mm-dd",
		changeYear : true,
		yearRange : "1900:c",
	});
	$(".datepicker-today").datepicker("setDate", "+0");
});

$(function() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeYear : true,
		yearRange : "1900:c",
	});
});