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
	<h1>SIGN IN</h1>
	<form action="signin" method="post">
		Enter User_Name :<input type="text" name="uname" id="uname"><br>
		Enter Password :<input type="password" name="pass" id="pass"><br>
		Confirm Password :<input type="password" name="cpass" id="cpass"><br>
		<input type="submit" id="confirm" value="Create Account">
	</form>
	<input type="hidden" id="already" value='${msg}'>
	<a href="/"><button>LOG IN</button></a>
	<p id="res"></p>
	<p id="alr"></p>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js'></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<!-- <script type="text/javascript"
		src="passverify.js"></script> -->
	<script>
	if ($('#already').val() == "1")
		$('#alr').html('The User Name Is Already Taken').css('color', 'red');
if ($('#already').val() == "2")
		$('#alr').html('You Dont Have a Account, SIGNIN To Continue').css('color', 'red');

$('form').validate();


$('#pass, #cpass, #uname').on('keyup', function() {
	$('#alr').html('');
	if ($('#pass').val() == $('#cpass').val()) {
		$('#res').html('Matching').css('color', 'green');
		$('#confirm').prop('disabled', false);
	} else {
		$('#res').html('Not Matching').css('color', 'red');
		$('#confirm').prop('disabled', true);
	}
});
	
	</script>
</body>
</html>