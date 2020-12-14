package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Medmasa extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Medmasa(String fName, String lName, String number, String address) {
        super(fName, lName, number, address);
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

    public static Medmasa getById(Integer id) {
        for (Medmasa medmasa : DataLists.medmasas) {
            if (medmasa.getId().equals(id)) {
                return medmasa;
            }
        }
        return null;
    }

    public void save() {
        Medmasa medmasa = Medmasa.getById(this.id);
        if (medmasa != null) {
            DataLists.medmasas.remove(medmasa);
        }
        DataLists.medmasas.add(this);
    }

    public void delete() {
        Medmasa medmasa = Medmasa.getById(this.id);
        if (medmasa != null) {
            DataLists.medmasas.remove(medmasa);
        }
    }

}
