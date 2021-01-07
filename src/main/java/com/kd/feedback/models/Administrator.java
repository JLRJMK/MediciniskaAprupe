package com.kd.feedback.models;

import com.kd.feedback.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Administrator extends Person implements Serializable {

    @Transient
    @Autowired
    private AdministratorService administratorService;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Administrator(String fName, String lName, Integer number, String address,String pers_code) {
        super(fName, lName, number, address, pers_code);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Administrator() {
        super();
    }
}
