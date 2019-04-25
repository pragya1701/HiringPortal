<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
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

.bg-image {
	/* The image used */
	background-image: url("/images/user.png");
	height: 30%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

#sidebar-wrapper {
	z-index: 1000;
	position: fixed;
	left: 250px;
	width: 0;
	height: 100%;
	margin-left: -250px;
	overflow-y: auto;
	border: 3px solid #000;
	background: #bbff9b;
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
	max-width: 600px;
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
	border: 3px solid #111;
	width: 250px;
	height: 100%;
	float: right;
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
<body onload="StartTimers(); loadcorddetails(); return loadstudents();"
	onmousemove="ResetTimers();">

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<div class="bg-image"></div>
			<ul class="list-group" id="profile">
			</ul>
			<ul class="sidebar-nav">
				<li class="sidebar-brand"></li>
			</ul>
			<div id="MainMenu">

				<a href="#demo5" class="list-group-item list-group-item strong"
					data-toggle="collapse" data-parent="#MainMenu"
					onClick="return loadOrganization();"><i class="fa fa-cubes"></i>
					Organizations <i class="fa fa-caret-down"></i></a>
				<div class="collapse list-group-submenu" id="demo5">
					<div id="catdisplay" class="list-group-item"
						onClick="seachOrganization()"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="container1">
		<h2 class="text-center" style="color: #000; font-size: 50px">
			<i>Send Notification</i>
		</h2>
		<fieldset class="form-group">
			<label for="subject" class="bmd-label-floating">Subject</label> <input
				type="text" class="form-control" id="subject">
		</fieldset>
		<fieldset class="form-group">
			<textarea rows="10" cols="74" id="body"
				placeholder="please enter body of email"></textarea>
		</fieldset>
		<ul class="list-group" id="uldisplay">
		</ul>
		<textarea rows="10" cols="74" id="emailarea"
			placeholder="please enter comma(,) separated email addresses"></textarea>
		<button id="submit_button" class="btn btn-primary btn-raised"
			onclick="addEmail()">Add Custom Email</button>
		<button id="submit_button" class="btn btn-primary btn-raised"
			value="Register" onclick="sendEmail()">Send Email</button>
	</div>
	<div class="container2">
		<div class="sidebar">
			<br> <br>
			<ul>
				<li><a href="cordinit"><i class="fa fa-fw fa-home"></i> Home</a></li>
				<li><a href="contactus"><i class="fa fa-fw fa-envelope"></i>
						Contact</a></li>
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
	function seachOrganization() {
		if (document.querySelector('input[name="org"]:checked').value != "null") {
			var organization = document
					.querySelector('input[name="org"]:checked').value;
			$('#failure_p').hide();
			$('#success_p').hide();
			var isvalidate = true;
			if (isvalidate) {
				$(document)
						.ready(
								function() {
									$
											.getJSON(
													"/api/selectorganization/"
															+ organization,
													function(json) {
														$("#uldisplay").empty();
														var tr = $("#uldisplay");
														for (var i = 0; i < json.length; i++) {
															tr
																	.append("<li class='list-group-item'><ul role='listbox' tabindex='0' aria-label='email list'>"
																			+ json[i]
																			+ "</li></ul></li>");
															console.log(tr);
														}
													});
								});

			}
		}
	}
	function loadstudents() {
		$('#failure_p').hide();
		$('#success_p').hide();
		var isvalidate = true;
		if (isvalidate) {
			$(document)
					.ready(
							function() {
								$
										.getJSON(
												"/api/allstudents",
												function(json) {
													$("#uldisplay").empty();
													var tr = $("#uldisplay");
													for (var i = 0; i < json.length; i++) {
														tr
																.append("<li class='list-group-item'><ul role='listbox' tabindex='0' aria-label='email list'>"
																		+ json[i]
																		+ "</li></ul></li>");
														console.log(tr);
													}
												});
							});

		}
	}
	function loadOrganization() {
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
												"/api/allorganizations",
												function(json) {
													console.log(json);
													$("#catdisplay").empty();
													var tr = $("#catdisplay");
													for (var i = 0; i < json.length; i++) {
														tr
																.append("<a class='list-group-item'><input type='radio' name='org' value='"+json[i]+"'>"
																		+ json[i]
																		+ "</a>");
													}
												});
							});

		}
	}

	function addEmail() {
		var emailarea = document.getElementById("emailarea").value;
		$.ajax({
			type : 'GET', // GET
			contentType : "application/json",
			url : "/api/addemail/" + emailarea,
			success : function(data) {

			},
			error : function(data) {

			}
		});
	}
	function sendEmail() {

		$.ajax({
			type : 'POST', // GET
			contentType : "application/json",
			url : "/api/sendnotification",
			dataType : "json",
			data : formToJSON(),
			statusCode : {
				200 : function() {
					console.log("success");
					alert("Email sent");
					window.location.href = "/corddashboard";
				},
				201 : function() {
					console.log("error");
					alert("Error has occured");
				}
			}
		});
	}

	function formToJSON() {
		var subject = document.getElementById("subject").value;
		var body = document.getElementById("body").value;
		var eqn = JSON.stringify({
			"subject" : subject,
			"body" : body
		});
		return eqn;
	}

	var timoutWarning = 840000; // Display warning in 14 Mins.
	var timoutNow = 900000; // Timeout in 15 mins.
	var logoutUrl = '/login'; // URL to logout page.

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
											"/api/getcorddetails/"
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