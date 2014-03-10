var show = true;
function changePassword() {
    if (show) {
        document.getElementById('passwordChange').style.display = "block";
        show = false;
    } else {
        document.getElementById('passwordChange').style.display = "none";
        show = true;
    }
}

function editName() {
    document.getElementById('editName').style.display = "block";
    document.getElementById('editAddress').style.display = "none";
    document.getElementById('editContact').style.display = "none";
}

function editAddress() {
    document.getElementById('editName').style.display = "none";
    document.getElementById('editAddress').style.display = "block";
    document.getElementById('editContact').style.display = "none";
}

function editContact() {
    document.getElementById('editName').style.display = "none";
    document.getElementById('editAddress').style.display = "none";
    document.getElementById('editContact').style.display = "block";
}