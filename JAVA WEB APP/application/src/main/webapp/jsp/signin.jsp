<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

request.getSession(true);
String key =(String)session.getAttribute("sessionKey");
System.out.println("signin.jsp");
if(key==null) {
	System.out.println("auth not confirmed");
	//response.sendRedirect("auth");
}else{
	response.sendRedirect("userdashboard");
	System.out.println("auth is confirmed");
}
%>
<body>
sign in
<form method="post" action="auth">
username :<input type="text" name="username" required><br>
password : <input type="password" name="password" required><br>
<input type="submit">
</form>

</body>
</html>