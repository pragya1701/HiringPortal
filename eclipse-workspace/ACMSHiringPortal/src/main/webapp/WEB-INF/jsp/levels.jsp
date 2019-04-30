<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Hiring Portal : Levels</title>
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
	margin-top:  -672px	;
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

/* Position text in the middle of the page/image */
.bg-text {
	background-color: rgb(4, 30, 92); /* Fallback color */
	background-color: #65c13a;
	color: black;
	font-weight: bold;
	border: 3px solid #f1f1f1;
	top: 20%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 2;
	width: 80%;
	padding: 20px;
	text-align: center;
}
</style>
<meta charset="UTF-8">
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
<body onload="StartTimers(); return loadcorddetails();"
	onmousemove="ResetTimers();">
	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<div class="bg-image"></div>
			<ul class="list-group" id="profile">
			</ul>
		</div>
	</div>
	<div class="container1">
		<h2 class="text-center" style="margin-top: 20px">
			<i>Choose Level</i>
		</h2>
		<div class="bg-text"
			style="margin-top: 120px; margin-left: 400px; height: 200px; width: 250px">
			<h3>Easy</h3>
			<img style="height: 80px; width: 80px" src="/images/easy.png"
				onClick="goPage(1)" />

		</div>
		<div class="bg-text"
			style="margin-top: 40px; margin-left: 200px; height: 200px; width: 250px">

			<h3>Medium</h3>
			<img style="height: 80px; width: 80px" src="/images/medium.png"
				onClick="goPage(2)" id="level" value="medium" />
		</div>

		<div class="bg-text"
			style="margin-top: -200px; margin-left: 590px; height: 200px; width: 250px">

			<h3>Difficult</h3>
			<img style="height: 80px; width: 80px" src="/images/difficult.png"
				onclick="goPage(3)" />
		</div>
		<br>

	</div>

	<div class="container2">
		<div class="sidebar">
			<br> <br>
			<ul>
				<li><a href="cordinit"><i class="fa fa-fw fa-home"></i>
						Home</a></li>
				<li><a href="contactus"><i class="fa fa-fw fa-envelope"></i>
						Contact</a></li>
				<li><a onclick="return logout();" href="login"><i class="fa fa-fw fa-user"></i> Logout
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
	function logout() {

		$.ajax({
			type : 'GET',
			contentType : "application/json",
			url : "/api/clearAll"
		});

	}
	function goPage(i) {
		sessionStorage.setItem("level", i);
		window.location.href = "corddashboard";
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
											"/api/getcorddetails/" + cordid,
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
