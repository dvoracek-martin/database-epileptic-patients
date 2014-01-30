/**
 * Created by Jan on 30.1.14.
 */
$(document).ready(function () {
    var $doneSelector = $('#done');
    var $sectionDoneSelector = $("#section-done");


    if ($doneSelector.val() == 2) {
        $sectionDoneSelector.hide();
    }

    $doneSelector.change(function () {
        if ($sectionDoneSelector.is(":visible")) {
            $sectionDoneSelector.hide();
        } else {
            $sectionDoneSelector.show();
        }
    });
});