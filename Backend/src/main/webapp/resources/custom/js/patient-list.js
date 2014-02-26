function filter(defaultMaxResults) {

    var search = $('#search').val();
    if (search == "")
        var maxResults = defaultMaxResults;
    else
        var maxResults = "5";
    var pageNumber = "1";

    $.ajax({
        type: "Get",
        url: "http://localhost:8080/GENEPI/patient/listSearch",
        data: "search=" + search + "&maxResults=" + maxResults + "&pageNumber=" + pageNumber,
        success: function (response) {
            var obj = JSON.parse(response);
            var countOfPatients = obj.patientList.length;
            $("#patientList").html("");
            for (var i = 0; i < countOfPatients; i++) {
                var firstName = obj.patientList[i][0].patientFirstName;
                var lastName = obj.patientList[i][0].patientLastName;
                var patientID = obj.patientList[i][0].patientID;
                var nin = obj.patientList[i][0].nin;
                var address = obj.patientList[i][0].addressStreet;
                if (address != "")
                    address += ", " + obj.patientList[i][0].addressHn;
                var city = obj.patientList[i][0].addressCity;

                $("#patientList").html($("#patientList").html() + "<tr class='clickable-row' href='/GENEPI/patient/" + patientID + "/overview'><td>" + firstName + "</td><td>" + lastName + "</td><td>" + nin + "</td><td>" + address + "</td><td>" + city + "</td></tr>");
            }

            if (search === "")
                document.getElementById("defaultPaginator").style.display = "block";
            else {
                document.getElementById("defaultPaginator").style.display = "none";
                document.getElementById("paginator").style.display = "none";
            }
        },
        error: function (e) {
            alert("Error " + e);
        }
    });
}