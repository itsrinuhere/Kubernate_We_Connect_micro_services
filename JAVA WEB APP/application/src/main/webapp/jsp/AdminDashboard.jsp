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

<form method="post" action="pdf/upload" enctype="multipart/form-data">
  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Name">
   <input type="file" name="file" class="form-control" id="exampleInputPassword1" placeholder="PDF file">
    <input type="text" name="description" class="form-control" placeholder="description">
   <input type="submit" class="btn btn-primary"placeholder="submit">
</form>
	
</body>
</html>