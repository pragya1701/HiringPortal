<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
body {
	text-align: center;
}

#tab {
	margin-left: 15%;
	width: 70%;
}
</style>

<script>



function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

	function formToJSON() {
		var tid = getCookie("test_id");
		console.log("tid==="+tid);
		var start = getCookie("test_start");
		console.log("start="+ start);
		
		var end = getCookie("test_end");
		console.log("end="+ end);
		
		var cid = getCookie("cord_id");
		console.log("cord="+cid);
			
		var eqn = JSON.stringify({
			"cordid" : cid,
			"testid" : tid,
			"starttime" : start,
			"endtime" : end
		});
  		return eqn;
  	}
	
	$(document).ready(function(){
	    	 $.ajax({
		  			type : 'POST', // GET
		  			contentType : "application/json",
		  			url : "http://localhost:3030/getReport",
		  			dataType : "json",
		  			data : formToJSON(),
		  			success : function(data) {
		  				var i=0;
		  				data.forEach(function(row){
		  					 $('#addr'+i).html("<td>"+ row.rank +"</td><td>"+ row.email +"</td><td>"+row.totalmarks+"</td>");
		  					 $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
				  		     i++; 
		  				});
		  				
		  				console.log(data);
		  			},
		  			error : function(data) {
		  				console.log(data);
		  			}
		  		}); 		
	  });
	
	/*
	var quesData;
	$(document).ready(function(){
		quesData = $.parseJSON($.ajax({
		type : 'GET', 
		contentType : "application/json",
		url : "http://localhost:3000/generateMarks",
		dataType : "json",
		data : formToJSON(),
	    async: false
		}).responseText); 
		
		var i=0;
		quesData.forEach(function(ques) {
			var data = quesData[i];
			alert(data.marks);
		});
	});
	*/
	
	function printDiv(tab){
		var printContents = document.getElementById(tab).innerHTML;
	    var originalContents = document.body.innerHTML;
	    document.body.innerHTML = printContents;
		window.print();
		document.body.innerHTML = originalContents;
	}
	
</script>

</head>

<body>
	<h1>User Report</h1>
	<br>

	<div id="tab">
		<table class="table table-bordered" id="tab_logic">
			<thead>
				<tr>
					<th width="30%">Rank</th>
					<th width="60%">UserId</th>
					<th width="30%">Marks</th>
				</tr>
			</thead>
			<tbody>
				<tr id='addr0'>
			</tbody>

		</table>
	</div>

	<div class="container">
		<button type="submit" class="btn btn-primary" id="print"
			onclick="printDiv('tab')">Print</button>
	</div>

</body>