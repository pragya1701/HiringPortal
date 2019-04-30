
	var stage_id = sessionStorage.getItem("stage_id");
	if(stage_id == 1)
		window.location.href = "coding";
	else if(stage_id == 2)
		window.location.href = "sucesssubmit";
	else if(stage_id == 3)
		window.location.href = "userdashboard";
	var quesData;
	var testid = sessionStorage.getItem("test_id");
	var userid = sessionStorage.getItem("userid");
	var starttime = sessionStorage.getItem("test_start");
	var endtime = sessionStorage.getItem("test_end");
	var cordid = sessionStorage.getItem("cord_id");	
	var selected = [];
	
	$(document).ready(function(){
		quesData = [];
		quesData = $.parseJSON($.ajax({
			type : 'GET', 
			contentType : "application/json",
			url : "/mcqQuestion/"+testid, 
		    async: false
		}).responseText); 
		
		var i=0;
		
		if(quesData.length == 0){
			sessionStorage.setItem("stage_id",1);
	        window.location.href = "coding";
		}
		
		quesData.forEach(function(ques) {
		$('.sidenav').append("<a href='#q" + i + "' id='q" + i + "' onclick='fetch(" + i + ")'>Question "+(i+1)+"</a>"); 
		i=i+1;
		});
		
		fetch(0);
		
	});
	
	function setColor(id){
		var sideEle = $(".sidenav > a")
		for(var i = 0; i < sideEle.length; i++)
			sideEle[i].style.color = "#818181";
		var ids = "q" + id;
		document.getElementById(ids).style.color = "#f1f1f1";
	}

	function fetch(id){
		setColor(id);
		$("#temp").hide();
		if (typeof(Storage) !== "undefined") {
		  localStorage.quesid = quesData[id].questionid;
		  localStorage.selectid = id;
		 // alert(localStorage.getItem("quesid"));
		} else {
		  alert("Enable your browser to support Web Storage...");
		}
  		var data = quesData[id];
		$("#ques").text(data.question);
  		$('label[for=a]').html(data.option1);
  		$('label[for=b]').html(data.option2);
  		$('label[for=c]').html(data.option3);
  		$('label[for=d]').html(data.option4);
  		
  		$('#a').prop('checked', false);
  		$('#b').prop('checked', false);
  		$('#c').prop('checked', false);
  		$('#d').prop('checked', false);
  		
  		var opt = JSON.parse(localStorage.getItem('selected'));
  		var i = localStorage.getItem('selectid');
  		if(opt !== null){
	            $('#'+opt[i]).prop('checked', true);
	        }
		}
	
	function formToJSON() {
		var chosen = $('input:radio[name=options]:checked').val();	
		var sid = localStorage.getItem('selectid');
		selected[sid] = $('input:radio[name=options]:checked').attr('id');
		localStorage.setItem('selected', JSON.stringify(selected));
		var eqn = JSON.stringify({
  			"response" : chosen,
  			"userid" : userid,
  			"testid" : testid,
  			"cordid" : cordid,
  			"starttime" : starttime,
  			"endtime" : endtime
  		});
  		return eqn;
  	}
	
	$(document).ready(function(){
	$( "#target" ).click(function() {
		var ask = window.confirm( "Are you sure you want to proceed to coding area?" );
		if (ask) {
			sessionStorage.setItem("stage_id",1);
	        window.location.href = "coding";
	    }
		});
	});
	
  $(document).ready(function(){
    $("#isSelect").click(function () {
    	 $("#temp").show();
    	 var id = localStorage.getItem("quesid");
    	 $.ajax({
	  			type : 'POST', // GET
	  			contentType : "application/json",
	  			url : "/saveMcq/" + id,
	  			dataType : "json",
	  			data : formToJSON(),
	  			success : function(data) {
	  				console.log(data);
	  			},
	  			error : function(data) {
	  				console.log(data);
	  			}
	  		}); 	
    });
		
  });

  	var endDate = sessionStorage.getItem("test_end");
	var countDownDate = new Date(endDate).getTime();
	var x = setInterval(function() {
	var now = new Date().getTime();
	var distance = countDownDate - now;
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);
	document.getElementById("demo").innerHTML = hours + ":" + minutes + ":" + seconds;
	if (distance < 0) {
	  clearInterval(x);
	  document.getElementById("demo").innerHTML = "EXPIRED";
	  alert("Time is up!");
	  window.location.href = "successsubmit";
	}
	}, 1000);
