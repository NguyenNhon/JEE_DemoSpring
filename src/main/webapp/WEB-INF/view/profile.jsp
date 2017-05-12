<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Profile Page</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/portfolio-item.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Meo</a>
			</div>
		</div>
	</nav>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Profile</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<img class="img-responsive" src="${user.profile}" alt="">
			</div>
			<div class="col-md-4">
				<h3>Profile</h3>
				<ul>
					<li>I'm ${user.username}.</li>
					<li>I'm living in California.</li>
					<li>....</li>
				</ul>
				<h3>My friends:</h3>
				<ul>
					<c:forEach items="${user.friends}" var="item">
						<li><a href='friend?username=${item}'>${item}</a></li>
					</c:forEach>
				</ul>
				<hr>
				<form:form action="${user.username}" method="post" enctype="multipart/form-data" modelAttribute="user">
					<input name="image" type="file" value="Upload new profile picture" />
					<input type="submit" value="Submit" />
				</form:form>
				<hr>
			</div>
		</div>
		<hr>
		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>©2016 Group 4. All Rights Reserved.</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
