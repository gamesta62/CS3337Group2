<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="error" value='${applicationScope["WrongPassword"]}' />
<h1>You have entered wrong password ${applicationScope["WrongPassword"]} times </h1>
 <c:if test = "${error <= 3}">
 					<a href="SmartLocker" class="badge badge-warning">Back To Main Page</a><br/>
  </c:if>


</body>
</html>