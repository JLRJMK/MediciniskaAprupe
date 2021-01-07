package com.kd.feedback.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class Person implements Serializable {

    protected String fName;
    protected String lName;
    protected Integer number;
    protected String address;
    @Column(unique = true)
    protected String pers_code;


    public Person(String fName, String lName, Integer number, String address, String pers_code) {

        this.fName = fName;
        this.lName = lName;
        this.number = number;
        this.address = address;
        this.pers_code = pers_code;
    }

    public Person() {

    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public  String getPers_code(){ return pers_code;}

    public void setPers_code(String pers_code) {
        this.pers_code = pers_code;
    }
}

