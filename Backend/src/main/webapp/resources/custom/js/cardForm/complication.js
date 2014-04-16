$(document).ready(function () {
    var withComplicationSelector = $('#process');
    var sectionWithComplicationSelector = $("#section-with-complication");

    withComplicationSelector.change(function () {
        if (withComplicationSelector.val() == 0) {
            sectionWithComplicationSelector.hide();
        } else if (withComplicationSelector.val() == 1) {
            sectionWithComplicationSelector.hide();
        } else if (withComplicationSelector.val() == 2) {
            sectionWithComplicationSelector.show();
        } else {
            //unexpected behavior
        }
    });

    withComplicationSelector.trigger("change");
});