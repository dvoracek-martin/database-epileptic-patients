$(document).ready(function () {
    var histopathologySelector = $('#histopathology');
    var sectionFcdSelector = $("#section-fcd");

    histopathologySelector.change(function () {
        if (histopathologySelector.val() == 1) {
            sectionFcdSelector.show();
        } else if (histopathologySelector.val() != 1) {
            sectionFcdSelector.hide();
        } else {
            //unexpected bahavior
        }
    });

    histopathologySelector.trigger("change");
});