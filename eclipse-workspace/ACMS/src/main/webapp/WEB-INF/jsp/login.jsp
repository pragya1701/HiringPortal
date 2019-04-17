<!DOCTYPE link PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<style>

body { background-image: linear-gradient(to right, #d0dbef , #9cb1d8);
  font-family: Comic Sans MS;
}

h1, h3 { font-weight: 300;
color: #ffffff;
			}

input[type=text] ,input[type=email],input[type=password],.drop{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  height: 10%;
}
input[type=submit] {
  width: 100%;
  background-color: #3067d3;
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
  background-color: #3067d3;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #000;
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
	margin-left:50px;
	border-radius: 5px;
	background-color: #ffffff	;
	padding: 20px;
	width: 35%;
}

</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	<link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css"
    rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js">
</script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


</head>
<body>
	<h1 class="text-center" style="color:#000;font-size:70px">
		<b><i>Online Hiring Portal</i></b>
	</h1>
	<h3  class="text-center" style="color:#000;font-size:30px"><b><i>Improving People's Lives Through A Better Currier</i></b></h3>
	
	<div class="container" style="margin-top: 30px; margin-left: -30px;">
		<div>
			<img src="/images/running.gif" height="400px" width="500px">
		</div>
		<div class="incontainer" style="margin-left: 100px; margin-right: -200px">
			<font color="red">${errorMessage}</font>
			<form method="post" id="myForm">
			<fieldset class="form-group"> 
			    <label for="username" class="bmd-label-floating">UserName</label>
			    <input type="text" class="form-control" id="username" required>
			    
			</fieldset>
				<fieldset class="form-group">
			    <label for="password" class="bmd-label-floating">Password</label>
			    <input type="password" class="form-control" id="password" required>   
			</fieldset>
			 <input type="button" value="Login" id="submit_button" onclick="submitForm()">
			 <input type="button" value="New User?  Register" id="register" onclick="registration()">
			 
			</form>
		</div>
	</div>
	<h3 id="success_p" style="display: none; color: #000">Student Logged in.</h3>
	<h3 id="failure_p" style="display: none; color: #000">Username or Password does not match.</h3>
	

		<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"></script>
    <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>
</body>

</html>

<script>
	function submitForm() {
		//window.location.href="/userdashboard";
		$('#failure_p').hide();
		$('#success_p').hide();
		$('#wrong_pass').hide();
		var isvalidate = $("#myForm")[0].checkValidity();

		if (isvalidate) {
			event.preventDefault();
			$.ajax({
				type : 'POST', 
				contentType : "application/json",
				url : "http://localhost:3030/api/login",
				data : formToJSON(),
				statusCode: {
				    200: function() {
				    	sessionStorage.setItem("flag",1);
				    	getUserID();
				    	
				    },
				    201: function() {
				      	$('#success_p').hide();
				    	sessionStorage.setItem("flag",0);
						$('#failure_p').show();
				    }
				  }
			});
		
			
		} 
	}
	
	function registration() {
				window.location.href="/registration";
	}
	
	function getUserID(){
		var username = document.getElementById("username").value;
		$.ajax({
			type : 'GET', 
			contentType : "application/json",
			url : "http://localhost:3030/api/email/"+username,
			success : function(data) {
				var semail = data;
				console.log(semail);
				sessionStorage.setItem("semail",semail);
				window.location.href="/userdashboard";
			},
			error : function(data) {
				return data;
			}
		});
		
	}
	
	function formToJSON() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;

		var eqn = JSON.stringify({
			"username" : username,
			"password" : password

		});
		return eqn;
	}
</script>