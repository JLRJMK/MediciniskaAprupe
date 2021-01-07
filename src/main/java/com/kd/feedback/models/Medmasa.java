package com.kd.feedback.models;

import com.kd.feedback.services.MedmasaService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Medmasa extends Person implements Serializable {

    @Transient
    @Autowired
    private MedmasaService medmasaService;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "medmasa", fetch = FetchType.EAGER)
    private List<Apmeklejums> apmeklejumi = new ArrayList<>();

    public Medmasa(String fName, String lName, Integer number, String address, String pers_code) {
        super(fName, lName, number, address, pers_code);
    }

    public Medmasa() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Apmeklejums> getApmeklejumi() {
        return apmeklejumi;
    }

    public void setApmeklejumi(List<Apmeklejums> apmeklejumi) {
        this.apmeklejumi = apmeklejumi;
    }
}
