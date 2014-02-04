/**
 * Created by Jan on 30.1.14.
 */
$(document).ready(function () {
    var doneSelector = $('#done');
    var sectionDoneSelector = $("#section-done");

    doneSelector.change(function () {
        if (sectionDoneSelector.val() == 1) {
            sectionDoneSelector.hide();
        } else if (sectionDoneSelector.val() == 2) {
            sectionDoneSelector.show();
        } else {
            //unexpected behavior
        }
    });

    doneSelector.trigger("change");
});