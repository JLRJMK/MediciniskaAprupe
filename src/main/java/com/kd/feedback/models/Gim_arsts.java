package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Gim_arsts extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    public static Gim_arsts getById(Integer id) {
        for (Gim_arsts gim_arsts : DataLists.gim_arstsList) {
            if (gim_arsts.getId().equals(id)) {
                return gim_arsts;
            }
        }
        return null;
    }

    public void save() {
        Gim_arsts gim_arsts = Gim_arsts.getById(this.id);
        if (gim_arsts != null) {
            DataLists.gim_arstsList.remove(gim_arsts);
        }
        DataLists.gim_arstsList.add(this);
    }

    public void delete() {
        Gim_arsts gim_arsts = Gim_arsts.getById(this.id);
        ;
        if (gim_arsts != null) {
            DataLists.gim_arstsList.remove(gim_arsts);
        }
    }
}
