package com.kd.feedback.models;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Medmasa extends Person {


    public Medmasa(Integer id, String fName, String lName, String number, String address) {
        super(id, fName, lName, number, address);
    }

    public Medmasa() {
        super();
    }

    public static final List<Medmasa> medmasas = new ArrayList<>();

    static {
        medmasas.add(new Medmasa(1, "C", "CC    ", "ccc", "cccc"));
        medmasas.add(new Medmasa(2, "d", "dd", "ddd", "dddd"));
    }

    static public void deleteById(Integer id){
        Iterator<Medmasa> itr = medmasas.iterator();
        while (itr.hasNext()){
            if(itr.next().getId().equals(id)){
                itr.remove();
                break;
            }
        }
    }

    public void delete() {
        Iterator<Medmasa> itr = medmasas.iterator();
        while (itr.hasNext()){
            if(itr.next().getId().equals(this.id)){
                itr.remove();
                break;
            }
        }
    }
}
