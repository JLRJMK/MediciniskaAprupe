package com.kd.feedback.models;
import java.util.ArrayList;
import java.util.List;

public class Pacients extends Person {

    private Gim_arsts gim_arsts;

    public Pacients(Integer id, String fName, String lName, String number, String address, Gim_arsts gim_arsts) {
        super(id, fName, lName, number, address);
        this.gim_arsts = gim_arsts;
    }
    public Pacients(){
        super();
    }

    public static final List<Pacients> pacientsList = new ArrayList<>();

    {
        pacientsList.add(new Pacients(1, "e", "ee", "eee", "eeee", null));
        pacientsList.add(new Pacients(2, "f", "ff", "fff", "ffff", null));
    }

    public Gim_arsts getGim_arsts() {
        return gim_arsts;
    }

    public void setGim_arsts(Gim_arsts gim_arsts) {
        this.gim_arsts = gim_arsts;
    }
}
