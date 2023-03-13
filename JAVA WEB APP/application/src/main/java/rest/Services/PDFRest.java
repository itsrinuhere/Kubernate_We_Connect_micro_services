package rest.Services;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rest.Services.Model.PDF;
import rest.Services.Model.Template;

import java.io.IOException;
import java.lang.reflect.Type;
public class PDFRest {
//List<Pdf> ls = null;
public List<Template> getAllPdf(){
	 String endpoint ="http://127.0.0.1:9090/pdf/getAll";
	 String output="";
	 Type listType;
	 		try{
	 			URL  url = new URL(endpoint);
	 			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 			connection.setRequestMethod("GET");
	 			connection.setRequestProperty("Accept", "application/json");
	 			Scanner scanner = new Scanner(connection.getInputStream());
	 			while(scanner.hasNext()){
        output += scanner.next();
       }
       scanner.close();
       GsonBuilder builder = new GsonBuilder();
       builder.setPrettyPrinting();
      Gson gson = builder.create();
       listType= new com.google.gson.reflect.TypeToken<List<Template>>() {
       }.getType();
    List<Template> data = gson.fromJson(output, listType);
    for(Template d : data) {
    	System.out.println(d.getId());
    }
      // System.out.println(data.get(0).getFilename());
    return data;
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
	
}
}
