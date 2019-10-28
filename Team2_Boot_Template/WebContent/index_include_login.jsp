<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<jsp:include page="./index_include_head.jsp"></jsp:include>
</head>
	

<form action="/action_page.php">
	<div class="form-group">
		<label for="email">Email address:</label> <input type="email"
			class="form-control" id="email">
	</div>
	<div class="form-group">
		<label for="pwd">Password:</label> <input type="password"
			class="form-control" id="pwd">
	</div>
	<div class="checkbox">
		<label><input type="checkbox"> Remember me</label>
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
</form>