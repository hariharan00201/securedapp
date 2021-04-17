<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Name: ${inbox_msg.getFrom_user()} <br/>
Date: ${inbox_msg.getDate()} <br/>
Time: ${inbox_msg.getTime()} <br/>
Message: ${inbox_msg.getMsg()} <br/>
</body>
</html>