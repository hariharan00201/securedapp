<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="60;write_the_url_of_the_page_to_be_tested_over_here.html" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate,max-age=0"); %>
<h1>Enter the security code in the same order:</h1>
<form action="${uname}" method="post">
<input type="text" name="word1"><br>
<input type="text" name="word2"><br>
<input type="text" name="word3"><br>
<input type="text" name="word4"><br>
<input type="text" name="word5"><br>
<input type="text" name="word6"><br>
<input type="text" name="word7"><br>
<input type="text" name="word8"><br>
<input type="text" name="word9"><br>
<input type="text" name="word10"><br>
<input type="submit" value="Enter">
</form>
</body>
</html>