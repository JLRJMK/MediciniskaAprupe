package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

public class Gim_arsts extends Person {


    public Gim_arsts(Integer id, String fName, String lName, String number, String address) {
        super(id, fName, lName, number, address);
    }

    public Gim_arsts() {
        super();
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
