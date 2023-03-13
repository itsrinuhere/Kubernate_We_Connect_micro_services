package rest.Services;
//import  org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import rest.Services.Model.PDF;
@WebServlet("/upload")
@MultipartConfig(maxFileSize = 100177215)//max 20 MB
public class FileUploadServlet extends HttpServlet {
/**
	 * 
	 */
	PDF pdf = new PDF();
	String random() {
		return  UUID.randomUUID().toString();
	}
	String ip="http://127.0.0.1:9090";
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
		PDF pdf = new PDF();
		String id = random();
		pdf.setId(id);
		pdf.setFile(file);
		//System.out.println(req.getParameter("name"));
		pdf.setFilename(req.getParameter("name"));
		pdf.setDescription(req.getParameter("description"));
		pdf.setFiletype(filePart.getContentType());
		pdf.setSize(filePart.getSize());
		if (req.getPart("file").getSize()>0)
			if(test(pdf)) {
				res.sendRedirect("admin?action=success");
			}
			//out.println("succes");}
		else
			res.sendRedirect("admin?action=failed");
			//out.println("failed");
		/*if (req.getPart("file").getSize()>0){
			String id = random();
			PDF pdf = new PDF();
			pdf.setId(id);
			pdf.setFile(file);
			if(test(pdf)) {
				res.sendRedirect("admin?action=uploaded&&id="+id);
			}res.sendRedirect("admin?action=erroroccured");
		}else {
			res.sendRedirect("admin?action=retry");   
		}
		*/
		//out.println("Response : "+ (test(pdf)?"successfull":"failed"));
	}
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		doPost(req,res);
	}//end of the doGet method
	boolean fileUpload(byte[] part,String id) throws IOException {
		String uri = ip+"/pdf/upload";
		StringBuilder builder = new StringBuilder();
		URL url = new URL (uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();   
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		builder.append("file=");
		builder.append(new String(part));
		builder.append("&&id=");
		builder.append(id);
		connection.setRequestProperty("Content-Type", "multipart/form-data"); 
		connection.setRequestProperty("charset","UTF-8");
		connection.setRequestProperty("Content-Length",Integer.toString(builder.toString().getBytes().length));
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
		wr.writeBytes(builder.toString());
		wr.flush();
		wr.close();
		if(connection.getResponseCode()==200) {
			connection.disconnect();
			return true;
		}
		connection.disconnect();
		return false;
	}
	boolean test(PDF pdf){
		  String uri = ip+"/pdf/json-upload";
		  try{
			  URL url = new URL (uri);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				//byte[] input = getFormDataAsString(map).getBytes("utf-8");
				//System.out.println(pdf.getUploaded_time());
		       byte[] input = pdf.toString().getBytes();
				os.write(input, 0, input.length);	
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				StringBuilder response = new StringBuilder();
			    String responseLine = null;
			    while ((responseLine = br.readLine()) != null) {
			    		response.append(responseLine.trim());
						    }
						    System.out.println(response.toString());
		                    System.out.println("202 accepted \t 404 error\nstatus is"+con.getResponseCode());
			return true;
		  }catch(Exception ex){
				System.out.println(ex.toString());
				return false;
			}
	}
	
	
}
