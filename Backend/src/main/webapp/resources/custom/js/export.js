$(document).ready(function () {

    $("#saveButton").click(function () {
        $('#exportForm')
            .attr('action',
            '/GENEPI/export/save');
    });

    $("#genericConfigurationsDeleteButton").click(function () {
        $('#genericConfigurationsForm')
            .attr('action',
            '/GENEPI/export/delete');
    });

    $("#userConfigurationsDeleteButton").click(function () {
        $('#userConfigurationsForm')
            .attr('action',
            '/GENEPI/export/delete');
    });

    $("#tree").tree({
        onCheck: { node: 'expand' },
        onUncheck: { node: 'collapse' },
        dnd: false,
        collapseUiIcon: 'ui-icon-plus',
        expandUiIcon: 'ui-icon-minus',
        leafUiIcon: 'ui-icon-bullet'
    });

    if ($("#exportParamsId").val() == "0") {
        $(".toCheck").prop("checked", true);
    }

    var tableOptionSel = $("#tableOption");
    var pdfFormatSel = $("#pdfFormat");

    $(pdfFormatSel).change(function () {
        tableOptionSel.show();
    });

    $("#docxFormat").change(function () {
        tableOptionSel.show();
    });

    $("#csvFormat, #xlsxFormat, #txtFormat").change(function () {
        tableOptionSel.hide();
    });

    pdfFormatSel.change();


    var checkAll = $('#checkAll');
    checkAll.click(function () {
        if (checkAll.prop('checked')) {
            $(".check-all").prop("checked", true);
        } else {
            $(".check-all").prop("checked", false);
        }
    })
});