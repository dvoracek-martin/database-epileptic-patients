$(document).ready(function () {

    /* datepicker with prefilled today date */
    var datepickerToday = $(".datepicker-today");

    datepickerToday.datetimepicker({
        pickDate: true,
        pickTime: false,
        startDate: moment("1900-01-01"),
        endDate: moment().add(50, "y"),
        language: 'cs',
        defaultDate: moment(),
        format: "YYYY-MM-DD"
    });


    /* simple datepicker */
    var datepicker = $(".datepicker");

    datepicker.datetimepicker({
        pickDate: true,
        pickTime: false,
        startDate: moment("1900-01-01"),
        endDate: moment().add(50, "y"),
        language: 'cs',
        format: "YYYY-MM-DD"
    });
});