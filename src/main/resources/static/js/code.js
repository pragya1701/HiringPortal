	
	var stage_id = sessionStorage.getItem("stage_id");
	if (stage_id == 0)
		window.location.href = "mcqtest";
	else if (stage_id == 2)
		window.location.href = "sucesssubmit";
	else if (stage_id == 3)
		window.location.href = "userdashboard";

	var quesData;
	var testid = sessionStorage.getItem("test_id");
	var userid = sessionStorage.getItem("userid");
	var starttime = sessionStorage.getItem("test_start");
	var endtime = sessionStorage.getItem("test_end");
	var cordid = sessionStorage.getItem("cord_id");

	$(document).ready(
			function() {
				quesData = $.parseJSON($.ajax({
					type : 'GET',
					contentType : "application/json",
					url : "http://localhost:3000/codeQuestion/" + testid,
					async : false
				}).responseText);

				var i = 0;
				quesData.forEach(function(ques) {
					$('.sidenav').append(
							"<a href='#q" + i + "' id='q" + i
									+ "' onclick='fetch(" + i + ")'>Question "
									+ (i + 1) + "</a>");
					i = i + 1;
				});

				fetch(0);
			});

	function setColor(id) {
		var sideEle = $(".sidenav > a")
		for (var i = 0; i < sideEle.length; i++)
			sideEle[i].style.color = "#818181";
		var ids = "q" + id;
		document.getElementById(ids).style.color = "#f1f1f1";
	}

	function fetch(id) {
		setColor(id);
		$("#logs").hide();
		$("#console").hide();
		$("#status").hide();
		$('#run').attr('disabled', 'disabled');
		//document.getElementbyId("run").disabled = true;
		var data = quesData[id];
		$("#ques").text(data.question);
		var editor1 = ace.edit("editor");
		editor1.getSession().setValue(data.prototype);

		if (typeof (Storage) !== "undefined") {
			localStorage.qid = quesData[id].questionid;
			//alert(localStorage.getItem("quesid"));
		} else {
			alert("Enable your browser to support Web Storage...");
		}

	}

	function formToJSON() {
		var editor = ace.edit("editor");
		var textarea = editor.getValue();
		var eqn = JSON.stringify({
			"content" : textarea,
			"output" : "",
			"error" : ""
		});
		return eqn;
	}

	function formToResponse() {
		var editor = ace.edit("editor");
		var textarea = editor.getValue();
		var eqn = JSON.stringify({
			"response" : textarea,
			"userid" : userid,
			"testid" : testid,
			"cordid" : cordid,
			"starttime" : starttime,
			"endtime" : endtime
		});
		return eqn;
	}

	$(document).ready(function() {
		$("#run").click(function(event) {
			//alert(editor.getValue());
			var id = localStorage.getItem("qid");
			$.ajax({
				type : 'POST', // GET
				contentType : "application/json",
				url : "http://localhost:3000/codeSubmit/" + id,
				dataType : "json",
				data : formToResponse()
			});
			$("#console").hide();
			$("#status").show();
			$("#message").text("Submitted for evaluation!");
			$('#run').attr('disabled', 'disabled');
		});
	});

	$(document).ready(function() {
		$("#testrun").click(function(event) {
			//alert(editor.getValue());
			var id = localStorage.getItem("qid");
			$.ajax({
				type : 'POST', // GET
				contentType : "application/json",
				url : "http://localhost:3000/sampleCase/" + id,
				dataType : "json",
				data : formToJSON(),
				success : function(data) {
					console.log(data);

					$("#console").show();
					$("#inp").text(data.input);
					$("#out").text(data.output);
					$("#userOut").text(data.userOutput);

					$("#logs").hide();
					$('#status').hide();
					if (data.error != "1") {
						$("#logs").show();
						$("#log").text(data.error);
						$('#run').attr('disabled', 'disabled');
					} else {
						$('#run').removeAttr('disabled');
					}

				},
				error : function(data) {
					console.log(data);
				}
			});
		});
	});

	var endDate = sessionStorage.getItem("test_end");
	var countDownDate = new Date(endDate).getTime();
	//var countDownDate = new Date("April 3, 2019 20:00:00").getTime();
	var now = new Date().getTime();
	//alert("time: " + now);
	var x = setInterval(function() {
	var now = new Date().getTime();
	var distance = countDownDate - now;
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
			/ (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);
	document.getElementById("demo").innerHTML = hours + ":" + minutes + ":"
			+ seconds;
	if (distance < 0) {
		clearInterval(x);
		document.getElementById("demo").innerHTML = "EXPIRED";
		alert("Time is up!");
		window.location.href = "successsubmit";
	}
	}, 1000);

	$(document).ready(function() {
		$("#target").click(function() {
			var ask = window.confirm("Are you sure you want to submit?");
			if (ask) {
				sessionStorage.setItem("stage_id", 2);
				localStorage.clear();
				window.location.href = "successsubmit";
			}
		});
	});
