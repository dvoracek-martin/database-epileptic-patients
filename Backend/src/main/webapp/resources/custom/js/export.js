$(document).ready(function () {
    $("#saveButton").click(function () {
        $('#exportForm')
            .attr('action',
            '/GENEPI/export/save');
    });
});