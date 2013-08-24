function passwordValidation() {
			var password = document.getElementById('password').value;
			if (password.length < 8 || password.length > 30)
				document.getElementById('passwordErr').style.display="block";
			 else 
			 {
				document.getElementById('passwordErr').style.display="none";
				var password = document.getElementById('password').value;
				if ( passwordAgain != password ) {
					document.getElementById('passwordAgainSuccComparison').style.display="none";
					document.getElementById('passwordAgainErrComparison').style.display="block";
					} 
				else {
					document.getElementById('passwordAgainSuccComparison').style.display="block";
					document.getElementById('passwordAgainErrComparison').style.display="none";
				}
			}	
		}
		
		function passwordAgainValidation() {
			var passwordAgain = document.getElementById('passwordAgain').value;
			if (passwordAgain.length < 8 || passwordAgain.length > 30)
				document.getElementById('passwordAgainErrLength').style.display="block";
			 else 
			 {
				document.getElementById('passwordAgainErrLength').style.display="none";
				var password = document.getElementById('password').value;
				if ( passwordAgain != password ) {
					document.getElementById('passwordAgainSuccComparison').style.display="none";
					document.getElementById('passwordAgainErrComparison').style.display="block";
					} 
				else {
					document.getElementById('passwordAgainSuccComparison').style.display="block";
					document.getElementById('passwordAgainErrComparison').style.display="none";
				}
			}		
		}
		
		function usernameValidation() {
			var username = document.getElementById('username').value;
			if ( username.length > 20)
				document.getElementById('usernameErr').style.display="block";
			else
				document.getElementById('usernameErr').style.display="none";
		}
		
		function firstnameValidation() {
			var firstname = document.getElementById('firstname').value;
			if ( firstname.length > 20)
				document.getElementById('firstnameErr').style.display="block";
			else
				document.getElementById('firstnameErr').style.display="none";
		}
		
		function lastnameValidation() {
			var lastname = document.getElementById('lastname').value;
			if ( lastname.length > 20)
				document.getElementById('lastnameErr').style.display="block";
			else
				document.getElementById('lastnameErr').style.display="none";
		}