package rest.Services.Model;


import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;


public class Template implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("id")
    // @GeneratedValue(strategy = GenerationType.UUID)
    String id;
	@SerializedName("file")
    String file;
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


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
