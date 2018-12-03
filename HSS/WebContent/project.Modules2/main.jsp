<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Moudle2 Demo Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<c:if test="${not empty controller }">
	<div class="container">
	<h1>Module2 Demo Page</h1>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
	  <li class="nav-item">
	    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Hardware</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Records</a>
	  </li>
	</ul>
	
	<div class="tab-content" id="myTabContent">
	
	  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
		<div class="container">
			<br>
			<h4 class="text-white bg-dark">Status of all devices</h4>
			<table class="table table-striped">
			    <tr>
			      <th scope="col">Camera</th>
			      <th scope="col">KeyPad</th>
			      <th scope="col">Motion Sensor</th>
			    </tr>
			    <tr>
		      		<c:forEach items="${controller.statusOfDevices}" var="entry" varStatus="status">
		      			<td>
		      				<c:if test="${entry == true }">
		      					<c:out value="Working" />
		      				</c:if>
		      				
		      				<c:if test="${entry == false }">
		      					<c:out value="Not Working" />
		      				</c:if>
		      			</td>
		      		</c:forEach>
			    </tr>
			</table>
			
			<c:if test="${controller.actived == false }">
				<a href="Index?code=101"><button type="button" class="btn btn-primary">Active All Devices</button></a>
			</c:if>
			
			<c:if test="${controller.actived == true }">
				<h4 class="text-white bg-dark">Sets of testing function</h4>
				<br>
				<c:if test="${controller.motionTested == true }">
					
					<div class="alert alert-success" role="alert">
						You have tested your motion sensor, and now the camera has been taken a picture, and waiting to enter a password to unlock the door.
					</div>
					
				</c:if>
				<a href="Index?code=102"><button type="button" class="btn btn-secondary btn-lg btn-block">Motion Test</button></a>
				<br>
				<c:if test="${controller.paswded == true }">
					
					<div class="alert alert-success" role="alert">
						You have entered password ${controller.enterTimes } times, and your password is 
						<span class="badge badge-secondary">
							<c:if test="${controller.paswValid == true }">
								Valid.
							</c:if>
							<c:if test="${controller.paswValid != true }">
								Invalid.
							</c:if>
						</span>.
					</div>
					
				</c:if>
				<a href="Index?code=103"><button type="button" class="btn btn-secondary btn-lg btn-block">Enter Password</button></a>
			</c:if>
			
		</div>
	  </div>
	  
	  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
	    <br><h4 class="text-white bg-dark">Records</h4>
	    <br><p class="alert alert-info">Total number of records: ${controller.numberOfRecords}</p>
	    <table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Date</th>
		      <th scope="col">Picture</th>
		      <th scope="col">Password(s)</th>
		    </tr>
		  </thead>
		  <tbody>
		  	
		  	<c:if test="${controller.actived == true }">
		  		<c:forEach items="${controller.records}" var="entry" varStatus="status">
		  			<tr>
		  				<th>${entry.id + 1}</th>
		  				<th>${entry.recordDate}</th>
		  				<th><img src="Image?id=${entry.id}" alt="..." class="img-thumbnail"></th>
		  				<th>
		  					<c:forEach items="${entry.password}" var="aa" varStatus="status">
		  						<c:out value="${aa}" />
		  						<br>
		  					</c:forEach>
		  				</th>
		  			</tr>
		  		
		  		</c:forEach>
	  		</c:if>
		  	
		  </tbody>
		</table>
	  </div>
	  
	</div>
	
	</div>	
</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>