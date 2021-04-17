<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="compose" method="post">
		FROM : <input type="text" placeholder="${uname }" disabled="disabled"><br>
		TO : <input type="text" name="to"><br> 
		MESSAGE : <input type="text" name="msgg"><br> 
		<input type="submit" value="SEND">
	</form>
</body>
</html>