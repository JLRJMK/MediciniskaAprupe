package com.kd.feedback.models;

import com.kd.feedback.services.Gim_arstsService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gim_arsts extends Person implements Serializable {

    @Transient
    @Autowired
    private Gim_arstsService gim_arstsService;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "gim_arsts", fetch = FetchType.EAGER)
    private List<Pacients> pacienti = new ArrayList<>();

    public Gim_arsts(String fName, String lName, String number, String address) {
        super(fName, lName, number, address);
    }

    public Gim_arsts() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pacients> getPacienti() {
        return pacienti;
    }

    public void setPacienti(List<Pacients> pacienti) {
        this.pacienti = pacienti;
    }
}
