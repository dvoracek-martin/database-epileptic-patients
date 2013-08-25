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