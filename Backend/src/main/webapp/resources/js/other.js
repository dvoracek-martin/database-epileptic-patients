var show = true;
function changePassword() {
	if ( show ) {
		document.getElementById('passwordChange').style.display="block";
		show = false;
	} else {
		document.getElementById('passwordChange').style.display="none";
		show = true;
	}
}

function editUsername() {
	document.getElementById('editUsername').style.display="block";
	document.getElementById('editPassword').style.display="none";
	document.getElementById('editOther').style.display="none";
}

function editPassword() {
	document.getElementById('editUsername').style.display="none";
	document.getElementById('editPassword').style.display="block";
	document.getElementById('editOther').style.display="none";
}

function editOther() {
	document.getElementById('editUsername').style.display="none";
	document.getElementById('editPassword').style.display="none";
	document.getElementById('editOther').style.display="block";
}