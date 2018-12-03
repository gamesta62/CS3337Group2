<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<title>Set Password</title>
</head>


<body>
	<form action="LockSetting" method="post">
	
	<c:set var="entry" value='${HSS}' />
  	<c:set var="error" value='${applicationScope["errorMessage"]}' />
   	<c:set var="emptyPassword" value='${applicationScope["emptyPassword"]}' />
    <c:set var="counter" value='${applicationScope["counter"]}' />
    
  	 <c:if test = "${!empty entry}">
  	 	<input class="form-control"  type="password" name="oldPassword" placeholder="OldPassowrd">
  	 </c:if>
  	 
  	   <c:if test = "${counter >= 1}">
				<c:if test = "${!empty error}">
					<p>You entered wrong password!</p>
				</c:if>

		</c:if>

  	 <br/>
  	 <input class="form-control"  type="password" name="password" placeholder="Passowrd">
  	 	 <br/>
  	 <c:if test = "${counter >= 1}">
				 <c:if test = "${!empty emptyPassword}">
					<p>Please enter a valid new password!</p>
				</c:if>
				</c:if>
  	 <input type="submit" name="add" value="Submit" />
  	 </form>
</body>
</html>
