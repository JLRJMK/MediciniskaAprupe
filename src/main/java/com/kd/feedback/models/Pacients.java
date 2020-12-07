package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

public class Pacients extends Person {

    private Gim_arsts gim_arsts;

    public Pacients(Integer id, String fName, String lName, String number, String address, Gim_arsts gim_arsts) {
        super(id, fName, lName, number, address);
        this.gim_arsts = gim_arsts;
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

    public static Pacients getById(Integer id) {
        for (Pacients pacients : DataLists.pacientsList) {
            if (pacients.getId().equals(id)) {
                return pacients;
            }
        }
        return null;
    }

    public void save() {
        Pacients pacients = Pacients.getById(this.id);
        if (pacients != null) {
            DataLists.pacientsList.remove(pacients);
        }
        DataLists.pacientsList.add(this);
    }



    public void delete() {
        Pacients pacients = Pacients.getById(this.id);
        if (pacients != null) {
            DataLists.pacientsList.remove(pacients);
        }
    }
}

