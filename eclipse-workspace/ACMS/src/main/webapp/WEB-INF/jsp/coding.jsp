<!DOCTYPE html>
<html lang="en">
<head>


<title>Code Here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="/resources/ace-builds/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/usertest.css">
<script src="js/code.js"></script>

</head>

<body>

	<div class="sidenav"></div>

	<div class="main">

		<br />
		<div class="container">
			<h4>Question:</h4>
		</div>

		<div style="border: 1px solid black; background-color:rgb(245, 245, 245);">
			<span><p id="ques"></p>
			</span>
		</div>
		<br>

		<div id="editor"></div>

		<script>
			var editor = ace.edit("editor");
			editor.setTheme("ace/theme/monokai");
			editor.session.setMode("ace/mode/java");
		</script>

		<div class="container">
			<br />
			<button type="submit" class="btn btn-primary" id="testrun">
				Compile & Test</button>
			<button type="submit" class="btn btn-primary" id="run">
				Submit</button>
		</div>

		<br>

		<div class="container" id="logs">
			<h5 style="color: red;">Error:</h5>
			<p id="log" style="white-space: pre-line"></p>
			<br />
		</div>

		<div class="container" id="status">
			<h5 style="color: green;">Accepted.</h5>
			<p id="message" style="white-space: pre-line"></p>
		</div>

		<div class="container" id="console" style="border: 1px solid black">
			<br>
			<h6>Input:</h6>
			<p id="inp" style="white-space: pre-line"></p>
			<h6>Expected Output:</h6>
			<p id="out"></p>
			<h6>Your Output:</h6>
			<p id="userOut"></p>

		</div>

	</div>

	<div id="header">
		<button class="btn btn-primary" id="target" style="margin-top: 5%;">submit</button>
		<br>
		<h5 id="demo"></h5>
	</div>

</body>
</html>
