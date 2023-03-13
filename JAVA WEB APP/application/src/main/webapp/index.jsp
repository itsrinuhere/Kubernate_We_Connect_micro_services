<%@ page  import ="jakarta.servlet.http.HttpServlet" %>
<%@ page import ="java.util.*" %>
<%@ page import ="rest.Services.Model.*" %>
<%@ page import ="rest.Services.*" %>
<%@ page import ="org.apache.commons.codec.binary.Base64" %>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<section id="head">
	<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="#">Active</a>
  </li>
  <li class="nav-item">
    <a class="nav-link"  href="admin?action=upload">Administrator</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="auth">sign-in</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
</ul>
</section>
<section="library">
<% List<Template> ls = new PDFRest().getAllPdf();
if(ls!= null)
for(Template pdf : ls){
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
      <th scope="col">Uploaded time</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  		<tr>
  				<td><%out.println(pdf.getId()); %></td>
  				<td><%out.println(pdf.getFilename()); %></td>
  				<td><%out.println(pdf.getUploaded_time()); %></td>
  				<td><a href="<%
  				String data ="data:"+pdf.getFiletype()+";base64,"+pdf.getFile();
  				out.println(data);%>" download="download"target="_blank">link</a></td>
  	
  		</tr>
  </tbody>
  </table>
</div>
<%} else out.println("<br><h2>library empty<h2>");%>
</section>
<section>
	<div class="card text-center">
  <div class="card-header">
    Featured
  </div>
  <div class="card-body">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  <div class="card-footer text-muted">
    2 days ago
  </div>
</div>
</section>
</body>
</html>
