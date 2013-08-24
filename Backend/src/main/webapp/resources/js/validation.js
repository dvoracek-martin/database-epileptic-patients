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
		
		function addressStreetValidation() {
			var addressStreet = document.getElementById('addressStreet').value;
			if ( addressStreet.length > 30)
				document.getElementById('addressStreetErr').style.display="block";
			else
				document.getElementById('addressStreetErr').style.display="none";
		}
		
		function addressHnValidation() {
			var addressHn = document.getElementById('addressHn').value;
			if ( addressHn.length > 10)
				document.getElementById('addressHnErr').style.display="block";
			else
				document.getElementById('addressHnErr').style.display="none";
		}
		
		function addressCityValidation() {
			var addressCity = document.getElementById('addressCity').value;
			if ( addressCity.length > 10)
				document.getElementById('addressCityErr').style.display="block";
			else
				document.getElementById('addressCityErr').style.display="none";
		}
		
		function addressPostalcodeValidation() {
			var addressPostalcode = document.getElementById('addressPostalcode').value;
			if ( addressPostalcode.length > 10)
				document.getElementById('addressPostalcodeErr').style.display="block";
			else
				document.getElementById('addressPostalcodeErr').style.display="none";
		}
		
		function addressCountryValidation() {
			var addressCountry = document.getElementById('addressCountry').value;
			if ( addressCountry.length > 10)
				document.getElementById('addressCountryErr').style.display="block";
			else
				document.getElementById('addressCountryErr').style.display="none";
		}
		
		function phoneNumberValidation() {
			var phoneNumber = document.getElementById('phoneNumber').value;
			if ( phoneNumber.length > 20)
				document.getElementById('phoneNumberErr').style.display="block";
			else
				document.getElementById('phoneNumberErr').style.display="none";
		}