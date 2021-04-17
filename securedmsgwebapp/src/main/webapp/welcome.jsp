<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="refresh"
	content="60;write_the_url_of_the_page_to_be_tested_over_here.html" />
<style type="text/css">
.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
	opacity: 1;
	transition: opacity 0.6s;
	margin-bottom: 15px;
}

.alert.success {
	background-color: #4CAF50;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate,max-age=0");

	if (session.getAttribute("uname") == null)
		response.sendRedirect("login.jsp");
	%>
	user is : ${uname}
	<br>

	<form action="inbox" method="post">
		<input type="hidden" value=1 name="in"> <input type="submit"
			value="inbox">
	</form>
	<br>

	<form action="outbox" method="post">
		<input type="hidden" value=0 name="in"> <input type="submit"
			value="seen">
	</form>
	<br>

	<form action="compose.jsp" method="post">
		<input type="submit" value="compose">
	</form>
	<br>

	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>
	<br>
<input type="hidden" id="wrong" value="${success}">
	<div class="alert success" id="success">
		<span class="closebtn">&times;</span> <strong>Success!</strong>
		Indicates a successful or positive action.
	</div>
	
	
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js'></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	
	
	<script type="text/javascript">
	if ($('#wrong').val() != "1"){
	$('#success').prop('disabled', true);
	$('#success').css('display','none');
	var alert = document.getElementsByClassName("alert");
	alert.style.opacity = "0";
    setTimeout(function(){ alert.style.display = "none"; }, 600);
	}
	else
	{
	$('#success').prop('disabled', false);
	}
	
	</script>
	
	
	<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
  close[i].onclick = function(){
    var div = this.parentElement;
    div.style.opacity = "0";
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
</script>
</body>
</html>