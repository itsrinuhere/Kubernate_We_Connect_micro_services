package rest.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import rest.Services.Model.PDF;
@WebServlet("/pdf/upload")
@MultipartConfig(maxFileSize = 20177215)//max 20 MB
public class FileUploadServlet extends HttpServlet {
/**
	 * 
	 */
	PDF pdf = new PDF();
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		InputStream inputStream = null; // input stream of the upload file
		Part filePart = req.getPart("file");
		System.out.println("DEBUG: /pdf/upload envoked");
		if(filePart != null) {
			inputStream = filePart.getInputStream();
		}else{
			out.print("file already received ");
		}
		byte[] file = inputStream.readAllBytes();//data received
		
		String description = req.getParameter("description");
		String name =req.getParameter("name");
		pdf.setFile(file);
		pdf.setDescription(description);
		pdf.setFilename(name);
		pdf.setSize(filePart.getSize());
		pdf.setFiletype(filePart.getContentType());
		pdf.setUploaded_time(new Date());
		out.println("Response : "+ (RestService(pdf)?"successfull":"failed"));
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		doPost(req,res);
	}//end of the doGet method
	private String getFormDataAsString(Map<String, String> formData) {
	    StringBuilder formBodyBuilder = new StringBuilder();
	    for (Map.Entry<String, String> singleEntry : formData.entrySet()) {
	        if (formBodyBuilder.length() > 0) {
	            formBodyBuilder.append(",");
	        }
	        formBodyBuilder.append("\""+singleEntry.getKey());
	        formBodyBuilder.append("\":\"");
	        formBodyBuilder.append(singleEntry.getValue());
	        formBodyBuilder.append("\"");
	    }
	    return "{"+formBodyBuilder.toString()+"}";
	}
	boolean RestService(PDF pdf) {
	String endpoint ="http://127.0.0.1:9090/pdf/jsonupload";
	try {
		URL url = new URL (endpoint);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		Map<String,String> map = new HashMap<String,String>();
		map.put("filename",pdf.getFilename());
		//map.put("file",pdf.getFile().toString());
		map.put("filetype", pdf.getFiletype());
		map.put("size", pdf.getSize()+"");
		//map.put("uploaded_time", pdf.getUploaded_time().toString());
		map.put("description", pdf.getDescription());
		OutputStream os = con.getOutputStream();
		byte[] input = getFormDataAsString(map).getBytes("utf-8");
		os.write(input, 0, input.length);	
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		StringBuilder response = new StringBuilder();
	    String responseLine = null;
	    while ((responseLine = br.readLine()) != null) {
	    		response.append(responseLine.trim());
				    }
				    System.out.println(response.toString());
				    //out.println(response.toString());
				    return true;
	}catch(Exception ex){
		System.out.println(ex.toString());
		return false;
	}
	
	}
}
