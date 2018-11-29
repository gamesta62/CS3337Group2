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
			<th class=text-center><a href="OwnerSettings">Owner's Preferences</a></th>
			<th>Emergency Contacts</th>
			<th></th>
		</tr>
	</table>
	
	<div class="card" style="width: 70rem; margin: 0 auto;">
		<c:if test="${fn:length(entries)==0 }">
			<p>No registered Emergency Contacts</p>
		</c:if>
		<c:if test="${fn:length(entries)>0 }">
			<table class="table table-sm">
				<tr> <th></th> <th>Name</th> <th>Email</th> <th>Phone Number </th> <th>Receive Emails</th> <th>Receive Texts</th>	</tr>
				<c:forEach items="${entries }" var="entry" varStatus="status">
				<tr>
					<td><a class="btn btn-primary btn-sm" href="EditContact?id=${entry.id }" role="button">Edit</a><a class="btn btn-primary btn-sm" href="DeleteContact?id=${entry.id}" role="button">Delete</a></td>
					<td>${entry.name }</td>
					<c:choose>
						<c:when test="${fn:length(entry.email)==0 }">
							<td>No Email Entered</td>
						</c:when>
						<c:otherwise>
							<td>${entry.email }</td>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${fn:length(entry.phoneNumber)==0 }">
							<td>No Phone Number Entered</td>
						</c:when>
						<c:otherwise>
							<td>${entry.phoneNumber }</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${entry.notifyByEmail==false }">
							<td>No</td>
						</c:when>
						<c:otherwise>
							<td>Yes</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${entry.notifyByText==false }">
							<td>No</td>
						</c:when>
						<c:otherwise>
							<td>Yes</td>
						</c:otherwise>
					</c:choose>
				</tr>
					
				</c:forEach>
			</table>
		</c:if>
		<a class="btn btn-primary" href="AddContact" role="button">Add Contact</a>
	</div>
</body>
</html>