/**
 * Created by Jan on 30.1.14.
 */
$(document).ready(function () {
    var histopathologySelector = $('#histopathology');
    var sectionFcdSelector = $("#section-fcd");

    if (histopathologySelector.val() != 1) {
        sectionFcdSelector.hide();
    }

    histopathologySelector.change(function () {
        if (histopathologySelector.val() == 1) {
            sectionFcdSelector.show();
        } else {
            sectionFcdSelector.hide();
        }
    });
});