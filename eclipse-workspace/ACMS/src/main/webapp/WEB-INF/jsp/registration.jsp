<html>
<head>
<title>User Registration</title>
<style>
body {
	font-family: Arial;
	background-image: linear-gradient(to right, #dae0ea , #8d9096);
}

input[type=text], input[type=email], input[type=password], .drop {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

input[type=button] {
	width: 100%;
	background-color: #4f91f9;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}

/* div.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
} */
.container {
	height: 70%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.incontainer {
	margin-left: 50px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	width: 50%;
}

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">

<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<script>
	var myInput = document.getElementById("password");
	var letter = document.getElementById("letter");
	var capital = document.getElementById("capital");
	var number = document.getElementById("number");
	var length = document.getElementById("length");

	// When the user clicks on the password field, show the message box
	myInput.onfocus = function() {
		document.getElementById("message").style.display = "block";
	}

	// When the user clicks outside of the password field, hide the message box
	myInput.onblur = function() {
		document.getElementById("message").style.display = "none";
	}

	// When the user starts to type something inside the password field
	myInput.onkeyup = function() {
		// Validate lowercase letters
		var lowerCaseLetters = /[a-z]/g;
		if (myInput.value.match(lowerCaseLetters)) {
			letter.classList.remove("invalid");
			letter.classList.add("valid");
		} else {
			letter.classList.remove("valid");
			letter.classList.add("invalid");
		}

		// Validate capital letters
		var upperCaseLetters = /[A-Z]/g;
		if (myInput.value.match(upperCaseLetters)) {
			capital.classList.remove("invalid");
			capital.classList.add("valid");
		} else {
			capital.classList.remove("valid");
			capital.classList.add("invalid");
		}

		// Validate numbers
		var numbers = /[0-9]/g;
		if (myInput.value.match(numbers)) {
			number.classList.remove("invalid");
			number.classList.add("valid");
		} else {
			number.classList.remove("valid");
			number.classList.add("invalid");
		}

		// Validate length
		if (myInput.value.length >= 8) {
			length.classList.remove("invalid");
			length.classList.add("valid");
		} else {
			length.classList.remove("valid");
			length.classList.add("invalid");
		}
	}
</script>

<style>
</style>
</head>

<body>
	<h1 class="text-center">
		<b>REGISTRATION</b>
	</h1>
	<font color="red">${errorMessage}</font>
	<div class="container" style="margin-top: 200px">
		
		<div class="incontainer">
			<form method="post" id="myForm">
				<fieldset class="form-group">
					<label for="username" class="bmd-label-floating">User Name</label> <input type="text"
						id="username" name="username">
				</fieldset>
				<fieldset class="form-group">
					<label for="firstname" class="bmd-label-floating">First Name</label> <input type="text"
						id="firstname" name="firstname" required>
				</fieldset>
				<fieldset class="form-group">
					<label for="lastname" class="bmd-label-floating" style="text-align:center">Last Name</label> <input type="text"
						id="lastname" name="lastname" required>
				</fieldset>
				<fieldset class="form-group">
					<label for="email" class="bmd-label-floating">Email</label><input type="email" id="email"
						name="email" required>
				</fieldset>
				<fieldset class="form-group">
					<label for="password" class="bmd-label-floating">Password</label> <input type="password"
						id="password" name="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						required>
				</fieldset>
				<fieldset class="form-group">
					<label for="phone" class="bmd-label-floating">Phone</label> <input type="text"
						pattern="[789][0-9]{9}" id="phone" name="phone" min="10"
						maxlength="10" required>
				</fieldset>
				<fieldset class="form-group">
					<label for="organization" class="bmd-label-floating">Organization</label> <input type="text"
						id="organization" name="organization">
				</fieldset>

				<!-- <button type="reset" class="btn btn-primary btn-raised">Reset</button>
				<button id="submit_button" class="btn btn-primary btn-raised"
					value="Register" onclick="submitForm()">Register</button>
				 -->	<input type="button" value="Register" id="registeruser" onclick="submitForm()">

			</form>
		</div>
		</div>
		<h3 id="success_p" style="display: none; color: #000">Registration
			done successfully</h3>
		<h3 id="failure_p" style="display: none; color: #000">Username or
			Email Address already taken.</h3>


		<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"></script>
		<script
			src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"></script>
		<script>
			$(document).ready(function() {
				$('body').bootstrapMaterialDesign();
			});
		</script>
</body>
</html>
<script>
	function submitForm() {
		$('#failure_p').hide();
		$('#success_p').hide();
		var isvalidate = $("#myForm")[0].checkValidity();

		if (isvalidate) {
			event.preventDefault();
			var username = document.getElementById("username").value;
			$.ajax({
				type : 'POST',
				contentType : "application/json",
				url : "http://localhost:3030/api/register",
				dataType : "json",
				data : formToJSON(),
				statusCode : {
					200 : function() {
						window.location.href = "/login";
					},
					201 : function() {
						$('#success_p').hide();
						$('#failure_p').show();
					}
				}
			});
		}

	}

	function formToJSON() {
		var username = document.getElementById("username").value;
		var firstname = document.getElementById("firstname").value;
		var lastname = document.getElementById("lastname").value;
		var email = document.getElementById("email").value;
		var phone = document.getElementById("phone").value;
		var organization = document.getElementById("organization").value;
		var password = document.getElementById("password").value;

		var eqn = JSON.stringify({
			"username" : username,
			"firstname" : firstname,
			"lastname" : lastname,
			"email" : email,
			"phone" : phone,
			"organization" : organization,
			"password" : password

		});
		return eqn;
	}
</script>


