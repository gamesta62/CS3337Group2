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
    <p class=text-right> <a href="/HSS/Admin">To Admin Page </a></p>
    <h1 class=text-center>Home Security System</h1>
    <table class=table>
	<tr>
	    <th class=text-right><a href="/HSS/">Main</th>
	    <th class=text-center><a href="/HSS/Module2/Index">Hardware Status</th>
	    <th class=text-left><a href="/HSS/project.Modules3/MainPage">Keypad Control</th>
	    <th class=text-left><a href="/HSS/Settings">Settings </a></th>
	</tr>
	<tr>
	    <th class=text-right></th>
	    <th class=text-center><a href="/HSS/OwnerSettings">Owner's Preferences</a></th>
	    <th><a href="/HSS/EmergencyContacts">Emergency Contacts</th>
	    <th></th>
	</tr>
    </table>
	
	<form method=post>
		<div class="card" style="width: 70rem; margin: 0 auto;">
			<table class="table table-sm">
				<tr>
					<th>Name</th><td> ${owner.name }</td>
				</tr>
				<tr>
					<th>Email</th> <td><input type="text" name="email" value="${owner.email}" /></td>
				</tr>
				<tr>
					<th>Phone Number</th> <td><input type="text" name="phoneNumber" value="${owner.phoneNumber}" /></td>
				</tr>
				
				<tr> <th>Receive Emails</th> 
				<c:choose>
					<c:when test="${owner.notifyByEmail==false }">
						<td><input type="radio" name="getEmail" value="1">Yes <input type="radio" name="getEmail" value="2" checked>No
					</c:when>
					<c:otherwise>
						<td><input type="radio" name="getEmail" value="1"checked>Yes <input type="radio" name="getEmail" value="2" >No
					</c:otherwise>
				</c:choose>
				</tr>
				
				<tr> <th>Receive Texts</th>
				<c:choose>
					<c:when test="${owner.notifyByText==false }">
						<td><input type="radio" name="getText" value="1">Yes <input type="radio" name="getText" value="2" checked>No
					</c:when>
					<c:otherwise>
						<td><input type="radio" name="getText" value="1"checked>Yes <input type="radio" name="getText" value="2" >No
					</c:otherwise>
				</c:choose>
				</tr>
				
				<tr> <th>Time Before Notifying Authorities in Seconds</th> <td> <input type="text" name="time" value="${delay.time}" />
			</table>
			<input class="btn btn-primary" type="submit" value="Submit">
		</div>
	</form>

</body>
</html>
