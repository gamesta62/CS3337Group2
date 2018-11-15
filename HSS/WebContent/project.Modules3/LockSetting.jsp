<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set Password</title>
</head>


<body>
	<form action="LockSetting" method="post">
<c:set var="entry" value='${HSS}' />
  	 <c:if test = "${!empty entry}">
  	 	<input class="form-control"  type="password" name="oldPassword" placeholder="OldPassowrd">
  	 </c:if>
  	 <br/>
  	 <input class="form-control"  type="password" name="password" placeholder="Passowrd">
  	 	 <br/>
  	 <input type="submit" name="add" value="Submit" />
  	 </form>
</body>
</html>