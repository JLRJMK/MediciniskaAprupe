package com.kd.feedback.models;

import com.kd.feedback.services.PacientsService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pacients extends Person implements Serializable {

    @Transient
    @Autowired
    private PacientsService pacientsService;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = Gim_arsts.class)
    private Gim_arsts gim_arsts;

    @OneToMany(mappedBy = "pacients", fetch = FetchType.EAGER)
    private List<Apmeklejums> apmeklejumi = new ArrayList<>();

    public Pacients(String fName, String lName, String number, String address, Gim_arsts gim_arsts) {
        super(fName, lName, number, address);
        this.gim_arsts = gim_arsts;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pacients() {
        super();
    }

    public Gim_arsts getGim_arsts() {
        return gim_arsts;
    }

    public void setGim_arsts(Gim_arsts gim_arsts) {
        this.gim_arsts = gim_arsts;
    }

    public List<Apmeklejums> getApmeklejumi() {
        return apmeklejumi;
    }

    public void setApmeklejumi(List<Apmeklejums> apmeklejumi) {
        this.apmeklejumi = apmeklejumi;
    }

}

