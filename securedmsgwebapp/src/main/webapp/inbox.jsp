<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.ArrayList,com.sma.app.entity.message" %>
user is : ${uname}<br>
the messages are : 

<c:forEach var="entry" items="${msgs}">

<form action="openmsg" method="post">
<input type="hidden" value="${entry.getMid() }" name="mid">
<input type="hidden" value="${in }" name="in">
<input type="submit" value="FROM:${entry.getFrom_user()}       ${entry.getDate()}${entry.getTime()}">
</form>
</c:forEach>
</body>
</html>