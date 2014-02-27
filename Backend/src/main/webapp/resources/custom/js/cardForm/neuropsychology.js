$(document).ready(function () {

    //variables for intellect
    var intellect = $('#intellect');
    var intellectNeurodevelopmentalExamination = $('#intellect-neurodevelopmental-examination');
    var intellectIntellectualPerformance = $("#intellect-intellectual-performance");

    //variables for neuropsychological profile
    var neuropsychologicalProfile = $("#neuropsychologicalProfile");
    var neuropsychologicalProfileConcernes = $("#neuropsychological-profile-concernes");

    //variables for presence of changes
    var presenceOfChanges = $("#presenceOfChanges");
    var presenceOfChangesDeterioration = $("#presence-of-changes-deterioration");

    //intellect section
    intellect.change(function () {
        if (intellect.val() == 0) {
            intellectNeurodevelopmentalExamination.hide();
            intellectIntellectualPerformance.hide();
        } else if (intellect.val() == 1) {
            intellectNeurodevelopmentalExamination.show();
            intellectIntellectualPerformance.hide();
        } else if (intellect.val() == 2) {
            intellectNeurodevelopmentalExamination.hide();
            intellectIntellectualPerformance.show();
        } else {
            //unexpected behavior
        }
    });

    intellect.trigger("change");

    //neuropsychological profile section
    neuropsychologicalProfile.change(function () {
        if (neuropsychologicalProfile.val() != 1) {
            neuropsychologicalProfileConcernes.hide();
        } else if (neuropsychologicalProfile.val() == 1) {
            neuropsychologicalProfileConcernes.show();
        } else {
            //unexpected behavior
        }
    });

    neuropsychologicalProfile.trigger("change");

    //presence of changes section
    presenceOfChanges.change(function () {
        if (presenceOfChanges.val() != 1) {
            presenceOfChangesDeterioration.hide();
        } else if (presenceOfChanges.val() == 1) {
            presenceOfChangesDeterioration.show();
        } else {
            //unexpected behavior
        }
    });

    presenceOfChanges.trigger("change");

});