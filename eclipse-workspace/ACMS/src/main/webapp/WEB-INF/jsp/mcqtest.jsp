<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/usertest.css">
<script src="js/mcq.js"></script>

</head>

<body>
	<div class="sidenav"></div>

	<div class="main">

		<br />
		<h3 id="ques"></h3>
		<input type="radio" name="options" value="A" id="a"><label
			for="a"></label></input> <br> <input type="radio" name="options"
			value="B" id="b"><label for="b"></label></input> <br> <input
			type="radio" name="options" value="C" id="c"><label for="c"></label></input>
		<br> <input type="radio" name="options" value="D" id="d"><label
			for="d"></label></input> <br /> <br /> <br />
		<button type="submit" class="btn btn-primary" id="isSelect">
			Save</button>
		<p id="temp">Saved!</p>

	</div>

	<div id="header">
		<button class="btn btn-primary" id="target" style="margin-top: 5%;">Proceed</button>
		<br> <br>
		<h5 id="demo"></h5>
	</div>

</body>
</html>
