<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Settings</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/HSS/">HSS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/HSS/">Home</a></li>
				<li><a href="/HSS/Module2/Index">Module 2</a></li>
				<li><a href="/HSS/project.Modules3/MainPage">Module 3</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="/HSS/Settings"><span class="glyphicon glyphicon-wrench"></span> Settings</a></li>
			</ul>
		</div>
	</nav>

	<p class=text-right> <a href="Admin">To Admin Page </a> </p>
	<h1 class=text-center>Home Security System</h1>
	<table class=table>
		<tr>
			<th class=text-right>Main</th>
			<th class=text-center>Hardware Status</th>
			<th class=text-left>Logged Events</th>
			<th class=text-left>Settings</th>
		</tr>
		<tr>
			<th class=text-right></th>
			<th class=text-center><a href="OwnerSettings">Owner's Preferences</a></th>
			<th><a href="EmergencyContacts">Emergency Contacts</a></th>
			<th></th>
		</tr>
	</table>
</body>
</html>
