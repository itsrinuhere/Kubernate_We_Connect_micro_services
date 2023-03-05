package rest.Services.Model;

import java.io.Serializable;
import java.util.Date;

public class PDF implements Serializable {
  
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	byte[] file;
   
    String filetype;
  
    Date uploaded_time;
    String description;
  
    String filename;
    long size;
}