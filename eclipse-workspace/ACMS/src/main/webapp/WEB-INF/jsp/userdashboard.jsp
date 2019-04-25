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
	background: #d0dbef;
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
	background-color: #d0dbef;
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
<body onload="loaduserdetails();return showUserHistory();">
	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<div class="bg-image"></div>
			<ul class="list-group" id="uldisplay">
				<li class="sidebar-brand"><a href="#"> Start Bootstrap </a></li>
			</ul>
			<div id="MainMenu"></div>
		</div>
	</div>
	<div class="container1">
		<h5>
			<b><i>Completed Tests</i></b>
		</h5>
		<ul id="testcomp"></ul>
		<div id="comp"></div>
		<h5>
			<b><i>Running Tests</i></b>
		</h5>
		<ul id="testcurr"></ul>
		<div id="curr"></div>
		<h5>
			<b><i>Pending Tests</i></b>
		</h5>
		<ul id="testpend"></ul>
		<ul id="pend"></ul>
	</div>
	<div class="container2">
		<div class="sidebar">
			<br> <br>
			<ul>
				<li><a href="login"><i class="fa fa-fw fa-user"></i> Logout
				</a></li>
				<li><a href="#contact"><i class="fa fa-fw fa-envelope"></i>
						Contact</a></li>
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
	setTimeout(function() {
		location.reload();
	}, 60000);

	var globalData = null;
	var userid;
	function loaduserdetails() {
		$(document)
				.ready(
						function() {
							var semail = sessionStorage.getItem("semail");
							$
									.getJSON(
											"/api/getuserdetails/"+semail,
											function(json) {
												console.log("data::"+json);
												$("#uldisplay").empty();
												sessionStorage.setItem(
														"userid", json[0].sid);
												var tr = $("#uldisplay");
												for (var i = 0; i < json.length; i++) {
													tr
															.append("<li class='list-group-item'>  <b>Username:</b> "
																	+ json[i].username
																	+ "</li><li class='list-group-item'>  <b>firstname:</b> "
																	+ json[i].firstname
																	+ "</li><li class='list-group-item'>  <b>Lastname:</b> "
																	+ json[i].lastname
																	+ "</li><li class='list-group-item'>  <b>email:</b> "
																	+ json[i].email
																	+ "</li><li class='list-group-item'>  <b>organization:</b> "
																	+ json[i].organization
																	+ "</li></ul></li>");
													console.log(tr);
												}
											});
						});
	}

	function loadtests() {
		$(document)
				.ready(
						function() {
							var semail = sessionStorage.getItem("semail");
							$
									.getJSON(
											"/api/getTests/"+semail,
											function(json) {
												$("#uldisplay").empty();
												var tr = $("#uldisplay");
												for (var i = 0; i < json.length; i++) {
													tr
															.append("<li class='list-group-item'><ul role='listbox' tabindex='0' aria-label='email list'><li tabindex='-1' role='option' aria-checked='false'><input tabindex='-1' type='checkbox' id='temp'>"
																	+ json[i].tid
																	+ "</li></ul></li>");
													console.log(tr);
												}
											});
						});
	}

	function showUserHistory() {
		console.log("inside Show Test");
		var isvalidate = true;
		var email = sessionStorage.getItem("semail");

		if (isvalidate) {
			globalData = $
					.parseJSON($
							.ajax({
								type : 'GET',
								contentType : "application/json",
								url : "/api/gettesthistory/"+email,
								async : false
							}).responseText);

			$("#testcomp").empty();
			$("#testcurr").empty();

			var testcomp = $("#testcomp");
			var testcurr = $("#testcurr");
			var testpend = $("#testpend");
			var comp = $("#comp");
			var curr = $("#curr");
			var pend = $("#pend");
			var countcurr = 0;
			var countpend = 0;
			var countcomp = 0;

			var json = globalData;

			var current = new Date();
			for (var i = 0; i < json.length; i++) {

				if (json[i].testtimeflag == 1) {
					countcurr = 1;
					testcurr
							.append("<li class='list-group-item'"+ json[i].tname +"><ul role='listbox' tabindex='0' aria-label='email list'>"
									+ json[i].tname
									+ "<input type='button' class='btn btn-primary' style='margin-left:300px' id='"
									+ json[i].tid
									+ "' value='"
									+ json[i].tname
									+ "' onClick='checkTestTaken("
									+ i
									+ ")'></li></ul></li>");

					console.log("test:::" + json[i].tname);
				} else if (json[i].testtimeflag == 2) {
					countpend = 1;
					testpend
							.append("<li class='list-group-item'"+ json[i].tname +"><ul role='listbox' tabindex='0' aria-label='email list'>"
									+ json[i].tname + "</li></ul></li>");

				} else {
					countcomp = 1;
					testcomp
							.append("<li class='list-group-item'"+ json[i].tname +"><ul role='listbox' tabindex='0' aria-label='email list'>"
									+ json[i].tname
									+ "<input type='button' style='margin-left:300px' class='btn btn-primary' id='"
									+ json[i].tid
									+ "' value='"
									+ "View Results"
									+ "' onClick='myMark("
									+ i
									+ ")'>"
									+ "</li></ul></li>");

				}
			}
			if (countcurr == 0)
				curr.append("<p>no current tests</p>");
			if (countpend == 0)
				pend.append("<p>no pending tests</p>");
			if (countcomp == 0)
				comp.append("<p>no history</p>")

			console.log("Test currr::" + testcurr);
		}
	}

	function checkTestTaken(i) {

		alert(globalData[i].tid);

		sessionStorage.setItem("test_id", globalData[i].tid);
		sessionStorage.setItem("test_start", globalData[i].startdate);
		sessionStorage.setItem("test_end", globalData[i].enddate);
		sessionStorage.setItem("cord_id", globalData[i].cordid);
		sessionStorage.setItem("stage_id", 0);

		var testing = sessionStorage.getItem("test_id");
		console.log("Id----" + testing);
		window.location.href = "mcqtest";
		
		$.ajax({
			type : 'POST', 
			contentType : "application/json",
			url : "/api/checktesttaken",
			data : formToJSON(),
			statusCode: {
			    200: function() {
			    	window.location.href = "mcqtest";
			    },
			    201: function() {
			    	alert("Test Already Taken");
			    }
			  }
		}); 
	}

	function formToJSON() {
		var eqn = JSON.stringify({
			"tid" : sessionStorage.getItem("test_id"),
			"startdate" : sessionStorage.getItem("test_start"),
			"enddate" : sessionStorage.getItem("test_end"),
			"cordid" : sessionStorage.getItem("cord_id"),
			"email" : "pragya.gupta26@gmail.com"
		//sessionStorage.getItem("semail")
		});
		return eqn;
	}

	function toJSON() {
		//var tid = sessionStorage.getItem("test_id");
		//var uid = sessionStorage.getItem("userid");
		var testid = sessionStorage.getItem("test_id");
		var userid = sessionStorage.getItem("userid");
		var starttime = sessionStorage.getItem("test_start");
		var endtime = sessionStorage.getItem("test_end");
		var cordid = sessionStorage.getItem("cord_id");

		var eqn = JSON.stringify({
			"userid" : userid,
			"cordid" : cordid,
			"testid" : testid,
			"starttime" : starttime,
			"endtime" : endtime
		});
		return eqn;
	}

	function myMark(i) {
		sessionStorage.setItem("test_id", globalData[i].tid);
		sessionStorage.setItem("test_start", globalData[i].startdate);
		sessionStorage.setItem("test_end", globalData[i].enddate);
		sessionStorage.setItem("cord_id", globalData[i].cordid);
		//alert("in res");
		$.ajax({
			type : 'POST', // GET
			contentType : "application/json",
			url : "/getMyMarks",
			dataType : "json",
			data : toJSON(),
			success : function(data) {
				console.log("Got: " + data.totalmarks);
				alert("Marks ::"+ data.totalmarks);
			},
			error : function(data) {
				console.log(data);
			}
		});
	}
</script>
