<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.application.auth.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.getSession(true);
String key =(String)session.getAttribute("sessionKey");
if(key==null ){
	response.sendRedirect("/application");
}
if(key!=null )
if(key.equals(Action.key())){
	System.out.println("userdashboard.jsp");
%>
<section id="body">
user dash board
	<a href="logout">log out</a>	
		
</section>
<%}else{%>
something gone wrong
<%} %>
</body>
</html>