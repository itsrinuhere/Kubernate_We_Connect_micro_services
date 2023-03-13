package com.Weconnet.REST.Library;

import jakarta.persistence.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

import java.io.Serializable;
import java.util.Date;
@Entity
public class Temp implements Serializable {
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Id
        // @GeneratedValue(strategy = GenerationType.UUID)
        String id;
        // @Column(name="file",nullable = false)
        @Column(name="file",columnDefinition ="bytea",nullable = false)
        String file;
        @Column(name="filetype")
        String filetype;
        @Column(name="uploaded_time")
        Date uploaded_time;
        @Column(name="description")
        String description;
        @Column(name="filename")
        String filename;
        @Column(name="size")
        long size;

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

