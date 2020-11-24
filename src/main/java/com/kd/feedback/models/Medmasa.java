package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

public class Medmasa extends Person {


    public Medmasa(Integer id, String fName, String lName, String number, String address) {
        super(id, fName, lName, number, address);
    }

    public Medmasa() {
        super();
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
