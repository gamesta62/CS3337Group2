<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<title>Enter password to unlock</title>
</head>
<body>
	<form action="Lock" method="post">
	<c:set var="error" value='${applicationScope["WrongPassword"]}' />
	
	   <c:if test = "${error >= 3}">
      You have entered over three times wrong password! System will send notification to the owner
      </c:if>
 					
 	  <c:if test = "${error < 3}">
		<input type="password" name="password" /> <br />
		<input type="submit" name="add" value="Submit" /> 
	  </c:if>     
</form>
</body>
</html>