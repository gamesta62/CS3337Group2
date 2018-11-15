<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<title>Locker</title>
</head>
<body>

<c:set var="counter" value='${applicationScope["Locker"]}' />

      <c:if test = "${counter % 2 == 0}">
 					 <a href="Lock" class="badge badge-warning">       <h2>     Lock      </h2></a><br/>
      </c:if>
        
 	 <c:if test = "${counter % 2 != 0}">
 					 <a href="Lock" class="badge badge-warning">       <h2>     Unlock      </h2></a><br/>
      </c:if>

   

<a href="Fingerprint" class="badge badge-warning"><h2>  Fingerprint  </h2></a><br/>
<a href="LockSetting" class="badge badge-warning"><h2>  Lock Setting </h2></a>

</body>
</html>