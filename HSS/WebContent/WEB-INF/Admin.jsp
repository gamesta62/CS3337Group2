<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<h1 class=text-center>Admin Page</h1>
	<table class="table">
		<tr> <td> <a class="btn btn-primary btn-large" href="#" role="button" onclick='javascript:window.open("NotifyContacts?alertType=1", "_blank", "scrollbars=1,resizable=1,height=600,width=400");' title='Notifications Sent'>Send Notifications about forced entry to Emergency Contacts </a> </td> </tr>
		<tr> <td> <a class="btn btn-prmiary btn-large" href="#" role="button" onclick='javascript:window.open("NotifyContacts?alertType=2", "_blank", "scrollbars=1,resizable=1,height=600,width=400");' title='Notifications Sent'>Send Notifications about failed keypad attempts to Emergency Contacts</a> </td> </tr>
		<tr> <td> <a class="btn btn-primary" href="#" role="button" onclick='javascript:window.open("/HSS/project.Modules3/GuestPage", "_blank", "scrollbars=1,resizable=1,height=600,width=400");' title='Notifications Sent'>Ask Emergency Contact to Unlock Door</a> </td> </tr>
		<tr> <td> <a class="btn btn-primary" href="#" role="button" role="button" onclick='javascript:window.open("DisableAlarm", "_blank", "scrollbars=1,resizable=1,height=600,width=400");' title='Notifications Sent'>Show off Silent Alarm delay</a> </td> </tr>
		
	</table>
</body>
</html>