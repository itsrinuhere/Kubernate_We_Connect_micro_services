<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
sign up
<form method="post" action="signup"  enctype="multipart/form-data">
<label>user-name : <input type="text" name="username" required></label><br>
<label>profile photo : <input type="file" name="profile-picture" accept="image/png, image/gif, image/jpeg"></label><br>
<label>Email Id :<input type="text" name="email" required></label><br>
<label>password :<input type="text" name="password" required></label><br>
<label><input type="submit"></label>
</form>
</body>
</html>