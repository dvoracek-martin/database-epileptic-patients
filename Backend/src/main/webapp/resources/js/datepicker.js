$(function () {
    $(".datepicker").datepicker({
        dateFormat: "yy-mm-dd",
        changeYear: true,
        yearRange: "1900:c",
    });
    $(".datepicker").datepicker("setDate", "+0");
});