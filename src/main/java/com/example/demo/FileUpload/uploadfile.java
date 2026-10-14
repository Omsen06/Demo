package com.example.demo.FileUpload;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class uploadfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String origianalfilename;
    private  String storedfilename;
    private String contenttype;

    private Long size;

    public uploadfile() {
    }

    public uploadfile(Long id, String origianalfilename, String storedfilename, String contenttype, Long size) {
        this.id = id;
        this.origianalfilename = origianalfilename;
        this.storedfilename = storedfilename;
        this.contenttype = contenttype;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigianalfilename() {
        return origianalfilename;
    }

    public void setOrigianalfilename(String origianalfilename) {
        this.origianalfilename = origianalfilename;
    }

    public String getStoredfilename() {
        return storedfilename;
    }

    public void setStoredfilename(String storedfilename) {
        this.storedfilename = storedfilename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
