package rest.Services.Model;

import java.io.Serializable;
import java.net.URLEncoder;
import org.apache.commons.codec.binary.Base64;
import java.util.Date;
import com.google.gson.annotations.SerializedName;
public class PDF implements Serializable {
  
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @SerializedName("id")
	 String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public Date getUploaded_time() {
		return uploaded_time;
	}
	public void setUploaded_time(Date uploaded_time) {
		this.uploaded_time = uploaded_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 @SerializedName("file")
	byte[] file;
	 @SerializedName("filetype")
    String filetype;
	 @SerializedName("uploaded_time")
    Date uploaded_time;
	 @SerializedName("description")
    String description;
	 @SerializedName("filename")
    String filename;
	 @SerializedName("size")
    long size;
   
    public String toString() {
    		StringBuilder builder = new StringBuilder();
    		builder.append("{\"description\":\""+getDescription()+"\",");
    		builder.append("\"filename\": \""+getFilename()+"\",");
    		builder.append("\"size\": \""+getSize()+"\",");
    		builder.append("\"filetype\": \""+getFiletype()+"\",");
    		builder.append("\"id\":\""+getId()+"\",");
    		try {
    		String n = new Base64().encodeToString(getFile());
    		builder.append("\"file\":\""+n+"\"");
    		}catch(Exception ex) {
    			System.out.println(ex);
    		}
    		builder.append("}");
    	return builder.toString();
    }
}