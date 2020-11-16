package com.kd.feedback.models;


import java.util.ArrayList;
import java.util.List;

public class Gim_arsts extends Person {


    public Gim_arsts(Integer id, String fName, String lName, String number, String address) {
        super(id, fName, lName, number, address);
    }
    public Gim_arsts(){
        super();
    }

    private static final List<Gim_arsts> gim_arstsList = new ArrayList<>();

    static {
        gim_arstsList.add(new Gim_arsts(1, "a", "aa", "aaa", "aaaa"));
        gim_arstsList.add(new Gim_arsts(2, "b", "bb", "bbb", "aaaa"));
    }
}
