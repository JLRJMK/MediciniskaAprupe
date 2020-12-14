package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pacients extends Person implements Serializable {

    @Transient
    @Autowired
    private DataLists dataLists;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = Gim_arsts.class)
    private Gim_arsts gim_arsts;

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

  /*  public static Pacients getById(Integer id) {
        return (dataLists.pacientsRepository.existsById(id)) ?
                dataLists.pacientsRepository.findById(id).get() :
                null;
    }
*/
   // public void save() {
     //   dataLists.pacientsRepository.save(this);
  //  }



  /*  public void delete() {
        Pacients pacients = Pacients.getById(this.id);
        if (pacients != null) {
            DataLists.pacientsList.remove(pacients);
        }
    }*/
}

