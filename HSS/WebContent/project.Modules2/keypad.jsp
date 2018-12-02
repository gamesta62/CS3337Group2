<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Key Pad</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style type="text/css">
body{
	background-color: black;
	color: white;
}
table.table-board tr td {
	height: 6rem;
	width: 6rem;
	font-size: 6rem;
	text-align: center;
}

table.table-board tr td a {
	text-decoration: none;
}
</style>
</head>
<body>
<div class="container">

<h1 class="display-1 text-center">Key-Pad</h1>

	<c:if test="${controller.keyPadLocked == true }">
		<div class="alert alert-danger" role="alert">
		   The keypad is locked now.
		</div>
	</c:if>

<c:if test="${controller.keyPadLocked != true }">
<h3 class="text-center">
	
</h3>

<div class="row">
	<div class="col-sm-6 offset-sm-3">
	
		<h1>Password: <span class="badge badge-secondary">
			<c:if test="${controller.password != -2 }">
				<c:out value= "${controller.password }"/>
			</c:if>
		</span></h1>
		
		<table class="table table-bordered table-board">
		
			<c:forEach items="${controller.keys}" var="entry" varStatus="status">
		
				<c:if test="${status.index % 3 == 0 }">
					<tr>
				</c:if>
				
				<td>
					<c:if test="${entry == -1 }">
						<a href="Index?code=104&location=<c:out value= "${entry}"/>"><c:out value= "D"/></a>
					</c:if>
					<c:if test="${entry == 99 }">
						<a href="Index?code=104&location=<c:out value= "${entry}"/>"><c:out value= "E"/></a>
					</c:if>
					<c:if test="${entry != -1 and entry != 99}">
						<a href="Index?code=104&location=<c:out value= "${entry}"/>"><c:out value= "${entry}"/></a>
					</c:if>
				</td>
			
				<c:if test="${status.index % 3 == 2 }">
					</tr>
				</c:if>
		
			</c:forEach>
			
		</table>
		
	</div>
		
</div>
</c:if>

</div>
</body>
</html>