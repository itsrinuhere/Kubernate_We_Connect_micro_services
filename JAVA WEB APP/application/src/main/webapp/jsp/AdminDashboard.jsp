<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
String action=request.getParameter("action");
if(action!=null){
%>
<form method="post" action="upload" enctype="multipart/form-data">
   <input type="file" name="file" class="form-control" placeholder="PDF file" required>
    <input type="text" name="name" class="form-control"  placeholder="name of the  file" required>
    <input type="text" name="description" class="form-control"  placeholder="description" required>
    <input type="submit" class="btn btn-primary"placeholder="upload">
</form>
<%if(action.equals("success")){ %>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Well done!</h4>
  <p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p>
  <hr>
  <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
</div>
<%} %>
	
	
	<%}%>

</body>
<script type="text/javascript">
var a = "<%out.println(action);%>";
alert(a);</script>
</html>