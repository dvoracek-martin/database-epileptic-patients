$(document).ready(function () {

    var pageNumberSel = $(".page-number");
    var pageSel = $(".page");
    var activePageId = 1;
    var pagesCount = $("#pagesCount").val();

    pageSel.hide();
    $("#page-1").show();
    $(".pager-elem-1").addClass("active");

    pageNumberSel.click(function () {
        $(".pager-elem-" + activePageId).removeClass("active");
        activePageId = $(this).data("page-number");
        pageSel.hide();
        $("#page-" + activePageId).show();
        $(".pager-elem-" + activePageId).addClass("active");
    });

    $(".start").click(function () {
        $(".pager-elem-" + activePageId).removeClass("active");
        activePageId = 1;
        $(".pager-elem-" + activePageId).addClass("active");
        pageSel.hide();
        $("#page-" + activePageId).show();

    });

    $(".end").click(function () {
        $(".pager-elem-" + activePageId).removeClass("active");
        activePageId = pagesCount;
        $(".pager-elem-" + activePageId).addClass("active");
        pageSel.hide();
        $("#page-" + activePageId).show();
    });


    $(".next").click(function () {
        if (pagesCount != activePageId) {
            $(".pager-elem-" + activePageId).removeClass("active");
            activePageId++;
            $(".pager-elem-" + activePageId).addClass("active");
            pageSel.hide();
            $("#page-" + activePageId).show();
        }
    });


    $(".prev").click(function () {
        if (activePageId != 1) {
            $(".pager-elem-" + activePageId).removeClass("active");
            activePageId--;
            $(".pager-elem-" + activePageId).addClass("active");
            pageSel.hide();
            $("#page-" + activePageId).show();
        }
    });

});