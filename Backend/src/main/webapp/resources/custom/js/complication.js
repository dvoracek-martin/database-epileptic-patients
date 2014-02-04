/**
 * Created by Jan on 30.1.14.
 */
$(document).ready(function () {
    var withComplicationSelector = $('#process');
    var sectionWithComplicationSelector = $("#section-with-complication");


    if (withComplicationSelector.val() == 1) {
        sectionWithComplicationSelector.hide();
    }

    withComplicationSelector.change(function () {
        if (sectionWithComplicationSelector.is(":visible")) {
            sectionWithComplicationSelector.hide();
        } else {
            sectionWithComplicationSelector.show();
        }
    });
});