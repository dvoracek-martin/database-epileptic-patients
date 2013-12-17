$(function() {
	$(".datepicker-today").datepicker({
		dateFormat : "yy-mm-dd",
		changeYear : true,
		yearRange : "1900:c",

	});
	if ($(".datepicker-today").val() == "") {
		$(".datepicker-today").datepicker("setDate", "+0");
	}
});

$(function() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeYear : true,
		yearRange : "1900:c",
		defaultDate : new Date()
	});
});