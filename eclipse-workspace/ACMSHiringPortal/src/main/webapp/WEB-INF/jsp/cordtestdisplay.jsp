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

#sidebar-wrapper {
	z-index: 1000;
	position: fixed;
	left: 250px;
	width: 0;
	height: 100%;
	margin-left: -250px;
	overflow-y: auto;
	background: #000;
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
}

div.container2 {
	max-width: 750px;
	height: 100%;
	margin: auto;
	border: 3px solid #73AD21;
}

div.container2 {
	margin-top: -640px;
	border: 3px solid #111;
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
	background-color: #f1f1f1;
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

table, th, td , tr {
  border: 1px solid black; 
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
<script>
	var testid = sessionStorage.getItem("testid");
	var marks = sessionStorage.getItem("marks");
</script>
<body onload="StartTimers(); return showUserMarks(testid,marks);" onmousemove="ResetTimers();">
	<div class="container1">
	<h3>List of all users</h3>
	<table>

	<col width="130">
  	<col width="80">
	</table>
	</div> 
	<div class="container2">
		<div class="sidebar">
			<br> <br>
			<ul>
				<li><a href="home"><i class="fa fa-fw fa-home"></i> Home</a></li>
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
	function showUserMarks(testid,marks) {

		$.ajax({
			type : 'GET', // GET
			contentType : "application/json",
			url : "http://localhost:3000/api/getAllUsersWithTest/" + testid,
			success : function(data) {
				console.log(data);
				var tableval = $('table');
				if(marks==1){
					tableval.append("<th>Users</th><th>Marks</th>");
					for (var i = 0; i < data.length; i++) {
						 tableval.append("<tr><td>" + data[i]+"</td><td style='text-align:right'>0</td></tr>");	
					 }	
				} else {
					tableval.append("<th>Users</th>");
					for (var i = 0; i < data.length; i++) {
						 tableval.append("<tr><td>" + data[i]+"</td></tr>");	
					 }	
				}
				 
			},
			error : function(data) {
				console.log("Error has occured");
			}
		});
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
</script>