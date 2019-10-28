<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<head>
  <jsp:include page="index_include_head.jsp"></jsp:include>
</head>
<body>
<!-- navbar -->
<jsp:include page="index_include_navbar.jsp"></jsp:include>

<div class="container">
<br><br><br>
<br>
<form style="color: white">
<h3 >회원가입</h3>
  <div class="form-group" >
      <label for="ID col-sm-5">ID:</label>
      <input type="text" class="form-control" id="ID">
    </div>
    <div class="form-group">
      <label for="pwd col-sm-5">Password:</label>
      <input type="password" class="form-control" id="pwd">
    </div>
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="Name">
    </div>
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" class="form-control" id="Age">
    </div>
    <div class="form-group">
     <label for="Gender">Gender:</label><br>
      <label class="radio-inline"><input type="radio" name="woman" >여자</label>
      <label class="radio-inline"><input type="radio" name="man" >남자</label>
   </div>
     <div class="form-group">
      <label for="Emali">Email:</label>
      <input type="text" class="form-control" id="Email">
    </div>
    <div class="col-sm-offset-1 col-sm-10">
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
</form>
</div>
</body>