package com.Weconnet.REST.Test.Testing;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="textbook")
public class Text  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_id;
    @Column(name="text_book_name",length=100,nullable=false)
    private String text_book_name;
    @Column(name="AlertTitle",length=100,nullable=false)
    private String uploaded_by;
    @Column(name="uploaded_time",nullable=false)
    private Date uploaded_time;
    @Column(name="file_type", nullable=false)
    private String Filetype;
    //type binary
    //@Column(name="book",nullable=false,columnDefinition = "BLOB")
    //@Type(columnDefinition ="org.hibernate.type.PrimitiveByteArrayBlobType", value = null)
    @Column(name="book",columnDefinition ="bytea")
    // @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] book;
    public String getFiletype() {
        return Filetype;
    }
    public void setFiletype(String filetype) {
        Filetype = filetype;
    }
    public String getUploaded_by() {
        return uploaded_by;
    }
    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }
    public Date getUploaded_time() {
        return uploaded_time;
    }
    public void setUploaded_time(Date uploaded_time) {
        this.uploaded_time = uploaded_time;
    }
    public Integer getBook_id() {
        return book_id;
    }
    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
    public String getText_book_name() {
        return text_book_name;
    }
    public void setText_book_name(String text_book_name) {
        this.text_book_name = text_book_name;
    }
    public byte[] getBook() {
        return book;
    }
    public void setBook(byte[] book) {
        this.book = book;
    }

}
