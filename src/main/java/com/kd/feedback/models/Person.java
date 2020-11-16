package com.kd.feedback.models;

public class Person {
    protected Integer id;
    protected String fName;
    protected String lName;
    protected String number;
    protected String address;

    public Person(Integer id, String fName, String lName, String number, String address) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.number = number;
        this.address = address;
    }

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void add(Medmasa medmasa) {

    }
}
