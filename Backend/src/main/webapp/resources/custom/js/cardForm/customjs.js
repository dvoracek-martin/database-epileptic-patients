$(document).ready(function () {
    var doneSelector = $('#done');
    var sectionDoneSelector = $("#section-done");

    doneSelector.change(function () {
        if (doneSelector.val() == 1) {
            sectionDoneSelector.hide();
        } else if (doneSelector.val() == 2) {
            sectionDoneSelector.show();
        } else {
            //unexpected behavior
        }
    });

    doneSelector.trigger("change");
});