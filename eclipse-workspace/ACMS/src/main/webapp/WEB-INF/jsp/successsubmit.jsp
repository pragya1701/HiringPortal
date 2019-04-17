<html>
<head>
<title>Hiring Portal:Login</title>
<style>
* { box-sizing:border-box; }

body {
	font-family: Helvetica;
	background: #eee;
  -webkit-font-smoothing: antialiased;
  background-image: url("/images/Green-Tick.jpg");
}

hgroup { 
	text-align:center;
	margin-top: 4em;
}

h1, h3 { font-weight: 300; }

h1 { color: #ffffff; }

h3 { color: #4a89dc; }

form {
	width: 380px;
	margin: 4em auto;
	padding: 3em 2em 2em 2em;
	background: #fafafa;
	border: 1px solid #ebebeb;
	box-shadow: rgba(0,0,0,0.14902) 0px 1px 1px 0px,rgba(0,0,0,0.09804) 0px 1px 2px 0px;
}

.group { 
	position: relative; 
	margin-bottom: 45px; 
}

input {
	font-size: 18px;
	padding: 10px 10px 10px 5px;
	-webkit-appearance: none;
	display: block;
	background: #fafafa;
	color: #636363;
	width: 100%;
	border: none;
	border-radius: 0;
	border-bottom: 1px solid #757575;
}

input:focus { outline: none; }


/* Label */

label {
	color: #999; 
	font-size: 18px;
	font-weight: normal;
	position: absolute;
	pointer-events: none;
	left: 5px;
	top: 10px;
	transition: all 0.2s ease;
}


/* active */

input:focus ~ label, input.used ~ label {
	top: -20px;
  transform: scale(.75); left: -2px;
	/* font-size: 14px; */
	color: #4a89dc;
}


/* Underline */

.bar {
	position: relative;
	display: block;
	width: 100%;
}

.bar:before, .bar:after {
	content: '';
	height: 2px; 
	width: 0;
	bottom: 1px; 
	position: absolute;
	background: #4a89dc; 
	transition: all 0.2s ease;
}

.bar:before { left: 50%; }

.bar:after { right: 50%; }


/* active */

input:focus ~ .bar:before, input:focus ~ .bar:after { width: 50%; }


/* Highlight */

.highlight {
	position: absolute;
	height: 60%; 
	width: 100px; 
	top: 25%; 
	left: 0;
	pointer-events: none;
	opacity: 0.5;
}


/* active */

input:focus ~ .highlight {
	animation: inputHighlighter 0.3s ease;
}


/* Animations */

@keyframes inputHighlighter {
	from { background: #4a89dc; }
	to 	{ width: 0; background: transparent; }
}


/* Button */

.button {
  position: relative;
  display: inline-block;
  padding: 12px 24px;
  margin: .3em 0 1em 0;
  width: 100%;
  vertical-align: middle;
  color: #fff;
  font-size: 16px;
  line-height: 20px;
  -webkit-font-smoothing: antialiased;
  text-align: center;
  letter-spacing: 1px;
  background: transparent;
  border: 0;
  border-bottom: 2px solid #3160B6;
  cursor: pointer;
  transition: all 0.15s ease;
}
.button:focus { outline: 0; }


/* Button modifiers */

.buttonBlue {
  background: #4a89dc;
  text-shadow: 1px 1px 0 rgba(39, 110, 204, .5);
}

.buttonBlue:hover { background: #357bd8; }


/* Ripples container */

.ripples {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background: transparent;
}


/* Ripples circle */

.ripplesCircle {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  opacity: 0;
  width: 0;
  height: 0;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.25);
}

.ripples.is-active .ripplesCircle {
  animation: ripples .4s ease-in;
}

.bg-image {
	/* The image used */
	background-image: url("/Green-Tick.jpg");
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: 400px;
	margin-top:-100px;
}

/* Ripples animation */

@keyframes ripples {
  0% { opacity: 0; }

  25% { opacity: 1; }

  100% {
    width: 200%;
    padding-bottom: 200%;
    opacity: 0;
  }
}

footer { text-align: center; }

footer p {
	color: #888;
	font-size: 13px;
	letter-spacing: .4px;
}

footer a {
	color: #4a89dc;
	text-decoration: none;
	transition: all .2s ease;
}

.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}


footer a:hover {
	color: #666;
	text-decoration: underline;
}

footer img {
	width: 80px;
	transition: all .2s ease;
}

footer img:hover { opacity: .83; }

footer img:focus , footer a:focus { outline: none; }
  	
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
	
	<style>
  	body {
  		background-image: url("images/home_bg.jpg");
  		height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	
  	}
  	
  </style>
  <script type="text/javascript">
  	sessionStorage.setItem("stage_id",3);
  </script>
  
  <script>
  
  	var testid = sessionStorage.getItem("test_id");
	var userid = sessionStorage.getItem("userid");
	var starttime = sessionStorage.getItem("test_start");
	var endtime = sessionStorage.getItem("test_end");
	var cordid = sessionStorage.getItem("cord_id");
	
  	function formToResponse() {
		var eqn = JSON.stringify({
			"userid" : userid,
			"testid" : testid,
			"cordid" : cordid,
			"starttime" : starttime,
			"endtime" : endtime
		});
		return eqn;
	}
  
  	$(document).ready(function() {
	      $.ajax({
	  			type : 'POST', // GET
	  			contentType : "application/json",
	  			url : "http://localhost:3030/generateMarks",
	  			dataType : "json",
	  			data : formToResponse()
	  		}); 
	  });				
  </script>
  
  
</head>

<body>

	<br>
	<h1 class="text-center"><b>Succesfully Submitted</b></h1>
	<h3 class="text-center">Your response is submitted for evaluation.</h3>
	<div class="bg-image"></div>
	
	
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"></script>
    <script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>

</body>

</html>

