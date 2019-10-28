<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<jsp:include page="./index_include_head.jsp"></jsp:include>
<style type="text/css">

.login {
	width: 360px;
	padding: 20% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
button{
width: 100%
}
</style>
</head>

<div class="login">
	<div class="form">
		<form>
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
			<button type="submit" class="btn btn-primary">LOGIN</button>
			<p class="message">Not registered? <a href="#">Create an account</a></p>
		</form>
	</div>
</div>
