<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<th>Emergency Contacts</th>
			<th></th>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>Name</td>
			<th>${owner.name}</th>
		</tr>
	</table>
</body>
</html>