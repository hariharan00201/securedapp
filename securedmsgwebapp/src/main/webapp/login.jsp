<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="refresh" content="60;write_the_url_of_the_page_to_be_tested_over_here.html" />
</head>
<body>

<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate,max-age=0"); %>
<h1>LOG IN</h1>
	<form action="login" method="post">
		Enter User_Name :<input type="text" id="uname" name="uname"><br>
		Enter Password :<input type="password" id="pass" name="pass"><br>
		<input type="submit" value="login">
	</form>
	<input type="hidden" id="wrong" value="${msg}">
	<a href="callsignin"><button>SIGN IN</button></a>
	<p id="res"></p>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js'></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<!-- <script type="text/javascript"
		src="wrongpass.js" ></script> -->
	<script>
	if ($('#wrong').val() == "1")
	$('#res').html('Wrong Password').css('color', 'red');

    $('#uname, #pass').on('keyup', function() {
	$('#res').html('');
});</script>
</body>
</html>