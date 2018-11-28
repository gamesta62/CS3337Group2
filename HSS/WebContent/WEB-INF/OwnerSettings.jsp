<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <jsp:useBean id="gb" class="project.UserBean" scope="application" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Settings</title>
</head>
<body>
		<p class=text-right> Welcome back, User! </p>
	<h1 class=text-center>Home Security System</h1>
	<table class=table>
		<tr>
			<th class=text-right><a href="Index">Main</a></th>
			<th class=text-center><a href="HardwareStatus">Hardware Status</a></th>
			<th class=text-left><a href="LoggedEvents">Logged Events</a></th>
			<th class=text-left>Settings</th>
		</tr>
		<tr>
			<th class=text-right></th>
			<th class=text-center>Owner's Preferences</th>
			<th><a href="EmergencyContacts">Emergency Contacts</a></th>
			<th></th>
		</tr>
	</table>
	
	<div class="card" style="width: 70rem; margin: 0 auto;">
	<table class="table table-sm">
		<tr>
			<th>Name</th>
			<td> ${owner.name }</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${owner.email }</td>
		</tr>
		<tr>
			<th>Phone Number</th>
			<td>${owner.phoneNumber }</td>
		</tr>
		<tr>
			<th>Receive Alerts & Notifications by Email</th>
			<c:choose>
				<c:when test="${owner.notifyByEmail == true }">
					<td>Yes</td>
				</c:when>
				<c:otherwise>
					<td>No</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>Receive Alerts & Notifications by Text</th>
			<c:choose>
				<c:when test="${owner.notifyByText == true }">
					<td>Yes</td>
				</c:when>
				<c:otherwise>
					<td>No</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>Delay Time Before Notifying Authorities in Seconds</th>
			<td> ${delay.time}</td>
		</tr>
	</table>
	<a class="btn btn-primary" href="EditOwner" role="button">Edit Preferences</a>
	</div>
</body>
</html>