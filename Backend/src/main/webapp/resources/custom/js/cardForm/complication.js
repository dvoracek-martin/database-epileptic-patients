/**
 * Created by Jan on 30.1.14.
 */
$(document).ready(function () {
    var withComplicationSelector = $('#process');
    var sectionWithComplicationSelector = $("#section-with-complication");

    withComplicationSelector.change(function () {
        if (sectionWithComplicationSelector.val() == 1) {
            sectionWithComplicationSelector.hide();
        } else if (sectionWithComplicationSelector.val() == 2) {
            sectionWithComplicationSelector.show();
        } else {
            //unexpected behavior
        }
    });

    withComplicationSelector.trigger("change");
});