<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ page import ="rest.Services.Model.*" %>
	<%@ page import ="rest.Services.*" %>
	<%@ page import ="org.apache.commons.codec.binary.Base64" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>library editing</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
	<section id="library">
		<%
		List<Template> ls = new PDFRest().getAllPdf();
		if(ls!= null){
		%>
<div class="temp">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name of the file</th>
      <th scope="col">Uploaded time</th>
      <th scope="col">link</th>
      <th scope="col">file type</th>
      <th scope="col">uploaded By</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <%int i=0;
  String id,size,name;
  out.println(ls.size());
  while(i<ls.size()){ 
	  
 	id= ls.get(i).getId();
 
	  %>
  <tbody>
  		<tr>
  				<td><%out.println(i); %></td>
  				<td><%out.println(ls.get(i).getFilename()); %></td>
  				<td><%out.println(ls.get(i).getUploaded_time()); %></td>
  				<td><a href="<%
  				String data ="data:"+ls.get(i).getFiletype()+";base64,"+ls.get(i).getFile();
  				out.println(data);%>" download="download"target="_blank">link</a></td>
  				<td><%out.println(ls.get(i).getFiletype());%></td>
  				<td>admin</td>
  				<td><a href="update?id=#{id}">update</a></td>
  				<td><a href="delete?id=#{id}">delete</a></td>
  	
  		</tr>
  </tbody>
  
<%i++;
}//end of the for loop
}else out.println("<br><h2>library empty<h2>");%>
</table>
</div>
	</section>
</body>
</html>