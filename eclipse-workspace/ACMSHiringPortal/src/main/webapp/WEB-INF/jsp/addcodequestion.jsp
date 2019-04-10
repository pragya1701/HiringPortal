<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Hiring Portal : Add Code Question</title>
<style>
body {
	font-family: Arial;
}

h1, h3 {
	font-weight: 300;
	color: #ffffff;
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
	background-color: #228b22;
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

body, html {
	height: 100%;
}

body {
	overflow-x: hidden;
}

/* Toggle Styles */
#wrapper {
	padding-left: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

#wrapper.toggled {
	padding-left: 250px;
}

#sidebar-wrapper {
	z-index: 1000;
	position: fixed;
	left: 250px;
	width: 0;
	height: 100%;
	margin-left: -250px;
	overflow-y: auto;
	background: #bbff9b;
	border: 3px solid #000;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
	width: 250px;
}

#page-content-wrapper {
	width: 100%;
	position: absolute;
	padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
	position: absolute;
	margin-right: -250px;
}

/* Sidebar Styles */
.sidebar-nav {
	position: absolute;
	top: 0;
	width: 250px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.sidebar-nav li {
	text-indent: 20px;
	line-height: 40px;
}

.sidebar-nav li a {
	display: block;
	text-decoration: none;
	color: #999999;
}

.sidebar-nav li a:hover {
	text-decoration: none;
	color: #fff;
	background: rgba(255, 255, 255, 0.2);
}

.sidebar-nav li a:active, .sidebar-nav li a:focus {
	text-decoration: none;
}

div.container1 {
	max-width: 750px;
	height: 100%;
	margin: auto;
	border: 3px solid #ffffff;
}

div.container2 {
	max-width: 750px;
	height: 100%;
	margin: auto;
	border: 3px solid #ffffff;
}

div.container2 {
	margin-top: -672px;
	border: 3px solid #ffffff;
	width: 250px;
	height: 100%;
	float: right;
}

.sidebar-nav>.sidebar-brand {
	height: 65px;
	font-size: 18px;
	line-height: 60px;
}

.sidebar-nav>.sidebar-brand a {
	color: #999999;
}

.sidebar-nav>.sidebar-brand a:hover {
	color: #fff;
	background: none;
}

@media ( min-width :768px) {
	#wrapper {
		padding-left: 250px;
	}
	#wrapper.toggled {
		padding-left: 0;
	}
	#sidebar-wrapper {
		width: 250px;
	}
	#wrapper.toggled #sidebar-wrapper {
		width: 0;
	}
	#page-content-wrapper {
		padding: 20px;
		position: relative;
	}
	#wrapper.toggled #page-content-wrapper {
		position: relative;
		margin-right: 0;
	}
}

.sidebar {
	position: fixed;
	background-color: #bbff9b;
	border: 3px solid #000;
	width: 250px;
	height: 100%;
	float: right;
}

.tablink:hover {
	background-color: #777;
}

.tablink {
	background-color: #555;
	color: white;
	float: left;
	border:;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 17px;
	width: 50%;
}

.bg-image {
	/* The image used */
	background-image: url("/images/user.png");
	height: 30%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.sidebar a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 20px;
	color: #111;
	display: block;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.incontainer {
	margin-left: 120px;
	border-radius: 5px;
	background-color: #f2f1ed;
	padding: 20px;
	width: 72%;
	margin-top: 40px;
}
</style>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</head>
<body onload="StartTimers(); loadcorddetails(); return dropDownCategory();"
	onmousemove="ResetTimers();">
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<div class="bg-image"></div>
			<ul class="list-group" id="profile" onClick="checkBox()">
			</ul>
		</div>
	</div>
	<div class="container1">
		<h2 class="text-center" style="margin-top: 20px">
			<i>Add Coding Question</i>
		</h2>
		<div class="incontainer">
			<form method="post" id="myForm">
				<fieldset class="form-group">
					<label for="question" class="bmd-label-floating">Question</label> <input
						type="text" class="form-control" id="question" required>
				</fieldset>

				<fieldset class="form-group">
					<label for="prototype" class="bmd-label-floating">Prototype</label>
					<textarea cols="61" rows="5" id="prototype"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="main" class="bmd-label-floating">Main</label>
					<textarea cols="61" rows="5" id="main"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="sampleinput" class="bmd-label-floating">Sample
						Input</label>
					<textarea cols="61" rows="5" id="sampleinput"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="sampleoutput" class="bmd-label-floating">Sample
						Output</label>
					<textarea cols="61" rows="5" id="sampleoutput"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="testinput" class="bmd-label-floating">Test
						Input</label>
					<textarea cols="61" rows="5" id="testinput"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="testoutput" class="bmd-label-floating">Test
						Output</label>
					<textarea cols="61" rows="5" id="testoutput"></textarea>
				</fieldset>

				<fieldset class="form-group">
					<label for="level">Level</label> <select id="level">
						<option value="easy">Easy</option>
						<option value="medium" selected="selected">Medium</option>
						<option value="hard">Hard</option>
					</select>
				</fieldset>
				<fieldset class="form-group">
					<label for="categorydrop">Category</label> <select
						id="categorydrop">
					</select>
				</fieldset>
			
				<input type="button" value="Add Question" id="submit_button"
					onclick="getCatID()">
			</form>
		</div>
	</div>

	<div class="container2">
		<div class="sidebar">
			<br> <br>
			<ul>
				<li><a href="cordinit"><i class="fa fa-fw fa-home"></i> Home</a></li>
				<li><a href="addmcqquestion"><i class="fa fa-fw fa-wrench"></i>
						Add MCQ Question </a></li>
				<li><a href="addcodequestion"><i class="fa fa-fw fa-wrench"></i>
						Add Coding Question </a></li>
				<li><a href="addcategory"><i class="fa fa-fw fa-dashboard"></i>
						Add Category </a></li>
				<li><a href="contactus"><i class="fa fa-fw fa-envelope"></i>
						Contact</a></li>
				<li><a href="sendemail"><i class="fa fa-fw fa-envelope"></i>
						Send Invite</a></li>
				<li><a href="sendnotification"><i
						class="fa fa-fw fa-envelope"></i> Send Notification</a></li>
				<li><a href="login"><i class="fa fa-fw fa-user"></i> Logout
				</a></li>
			</ul>
		</div>
	</div>

	<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"></script>
	<script
		src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"></script>
	<script>
		$(document).ready(function() {
			$('body').bootstrapMaterialDesign();
		});
	</script>

	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});

		$("[role=listbox]").on(
				"keydown",
				function(e) {
					var currentItem = $(this).find("[aria-selected=true]");
					switch (e.keyCode) {
					case 38: // Up arrow
						if (currentItem.prev().length) {
							currentItem.attr("aria-selected", "false");
							currentItem.prev().attr("aria-selected", "true")
									.focus();
						}
						e.preventDefault();
						break;
					case 40: // Down arrow
						if (currentItem.next().length) {
							currentItem.attr("aria-selected", "false");
							currentItem.next().attr("aria-selected", "true")
									.focus();
						}
						e.preventDefault();
						break;
					case 32: // Space                                                                                              
						if (currentItem.attr("aria-checked") === "true") {
							currentItem.attr("aria-checked", "false");
							currentItem.find("input[type=checkbox]").prop(
									"checked", false);
						} else {
							currentItem.attr("aria-checked", "true");
							currentItem.find("input[type=checkbox]").prop(
									"checked", true);
						}
						e.preventDefault();
						break;

					}
				});
	</script>
</body>
</html>
<script>
	var catIDVal;
	function submitForm() {
		$('#failure_p').hide();
		$('#success_p').hide();
		var isvalidate = $("#myForm")[0].checkValidity();

		if (isvalidate) {
			event.preventDefault();
			var username = document.getElementById("question").value;
			$.ajax({
				type : 'POST', // GET
				contentType : "application/json",
				url : "http://localhost:3000/api/addmcqquestion",
				dataType : "json",
				data : formToJSON(),
				statusCode : {
					200 : function() {
						console.log("success");
						window.location.href = "corddashboard";
					},
					201 : function() {
						console.log("error");
					}
				}
			});
		}
	}
	function getCatID() {
		var isvalidate = $("#myForm")[0].checkValidity();
		//var isvalidate = true;
		var indexCat = document.getElementById("categorydrop");
		var cat = indexCat.options[indexCat.selectedIndex].text;
		console.log(cat);
		if (isvalidate) {
			event.preventDefault();
			$.ajax({
				type : 'GET', // GET
				contentType : "application/json",
				url : "http://localhost:3000/api/categoryid/" + cat,
				success : function(data) {
					catIDVal = data;
					console.log(catIDVal);
					//return data;
					submitForm();

				},
				error : function(data) {
					return data;
				}
			});
		}
	}
	function formToJSON() {
		var question = document.getElementById("question").value;
		var mainclass = document.getElementById("main").value;
		var prototype = document.getElementById("prototype").value;
		var input = document.getElementById("sampleinput").value;
		var output = document.getElementById("sampleoutput").value;
		var testinput = document.getElementById("testinput").value;
		var testoutput = document.getElementById("testoutput").value;
		var indexLevel = document.getElementById("level");
		var level = indexLevel.options[indexLevel.selectedIndex].text;

		var cordid = sessionStorage.getItem("cordid");

		var eqn = JSON.stringify({
			"question" : question,
			"body" : mainclass,
			"prototype" : prototype,
			"sampleinput" : input,
			"sampleoutput" : output,
			"testinput" : testinput,
			"testoutput" : testoutput,
			"cid" : catIDVal,
			"level" : level,
			"type" : "code",
			"coordid" : cordid

		});
		return eqn;
	}

	function dropDownCategory() {
		$('#failure_p').hide();
		$('#success_p').hide();
		//var isvalidate = $("#myForm")[0].checkValidity();
		console.log("inside the method");
		var isvalidate = true;
		if (isvalidate) {
			$(document)
					.ready(
							function() {
								$
										.getJSON(
												"http://localhost:3000/api/allcodecategories",
												function(json) {
													$("#categorydrop").empty();
													var tr = $("#categorydrop");
													for (var i = 0; i < json.length; i++) {
														tr
																.append("<option value='"+json[i].categoryname+"''>"
																		+ json[i].categoryname
																		+ "</option>");
													}
												});
							});

		}
	}

	var timoutWarning = 840000; // Display warning in 14 Mins.
	var timoutNow = 900000; // Timeout in 15 mins.
	var logoutUrl = 'http://localhost:3000/login'; // URL to logout page.

	var warningTimer;
	var timeoutTimer;

	// Start timers.
	function StartTimers() {
		warningTimer = setTimeout(timoutWarning);
		timeoutTimer = setTimeout("IdleTimeout()", timoutNow);
	}

	// Reset timers.
	function ResetTimers() {
		clearTimeout(warningTimer);
		clearTimeout(timeoutTimer);
		StartTimers();
	}
	// Logout the user.
	function IdleTimeout() {
		alert("Session Timeout.... Please login again");
		window.location = logoutUrl;
	}

	function loadcorddetails() {
		console.log("inside coordinator details");
		$(document)
				.ready(
						function() {
							var cordid = sessionStorage.getItem("cordid");
							$
									.getJSON(
											"http://localhost:3000/api/getcorddetails/"
													+ cordid,
											function(json) {
												console.log(json);
												$("#profile").empty();
												var tr = $("#profile");
												for (var i = 0; i < json.length; i++) {
													tr
															.append("<li class='list-group-item'>  <b>Username:</b> "
																	+ json[i].username
																	+ "</li><li class='list-group-item'>  <b>Phone:</b> "
																	+ json[i].phone
																	+ "</li>");
													console.log(tr);
												}
											});
						});
	}
</script>