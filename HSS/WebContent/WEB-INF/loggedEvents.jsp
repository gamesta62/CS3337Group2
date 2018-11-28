<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged Events</title>
</head>
<body>
	<p class=text-right> Welcome back, User! </p>
	<h1 class=text-center>Home Security System</h1>
	<table class=table>
		<tr>
			<th class=text-right><a href="Index">Main</a></th>
			<th class=text-center><a href="HardwareStatus">Hardware Status</a></th>
			<th class=text-left>Logged Events</a></th>
			<th class=text-left><a href="Settings">Settings</a></th>
		</tr>
	</table>
	
	<div class="card" style="width: 70rem; margin: 0 auto;">
		<table>
			<c:if test="${fn:length(logs)==0 }">
				<p>No logged events found</p>
			</c:if>
			
			<c:if test="${fn:length(logs)>0 }">
				<table class="table table-sm">
					
				</table>
			</c:if>
		</table>
	</div>
</body>
</html>