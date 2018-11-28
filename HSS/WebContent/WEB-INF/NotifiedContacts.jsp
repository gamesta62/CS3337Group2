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
<title>Notifications Sent</title>
</head>
<body>
<p>Notifications have been sent to the following: </p>
		<c:if test="${fn:length(notified)==0 }">
			<p>No notifications were sent</p>
		</c:if>
		<c:if test="${fn:length(notified)>0 }">
			<c:forEach items="${notified }" var="contact" varStatus="status">
				<li>${contact.name } </li>
			</c:forEach>
		</c:if>
</body>
</html>