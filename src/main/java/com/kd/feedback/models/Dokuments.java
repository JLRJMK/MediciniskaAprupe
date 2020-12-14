package com.kd.feedback.models;
import com.kd.feedback.data.DataLists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Dokuments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String date;
    private String address;
    private String doctor;
    private String content;
    @ManyToOne(targetEntity = Pacients.class)
    private Pacients pacients;
    @ManyToOne(targetEntity = Gim_arsts.class)
    private Gim_arsts gim_arsts;

    public Dokuments(String name, String date, String address, String doctor, String content, Pacients pacients, Gim_arsts gim_arsts){

        this.name = name;
        this.date = date;
        this.address = address;
        this.doctor = doctor;
        this.content = content;
        this.pacients = pacients;
        this.gim_arsts = gim_arsts;
    }

    public Dokuments() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pacients getPacients() {
        return pacients;
    }

    public void setPacients(Pacients pacients) {
        this.pacients = pacients;
    }

    public Gim_arsts getGim_arsts() {
        return gim_arsts;
    }

    public void setGim_arsts(Gim_arsts gim_arsts) {
        this.gim_arsts = gim_arsts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public static Dokuments getById(Integer id) {
        for (Dokuments dokuments : DataLists.dokumentsList) {
            if (dokuments.getId().equals(id)) {
                return dokuments;
            }
        }
        return null;
    }

    public void save() {
        Dokuments dokuments = Dokuments.getById(this.id);
        if (dokuments != null) {
            DataLists.dokumentsList.remove(dokuments);
        }
        DataLists.dokumentsList.add(this);
    }

    public void delete() {
        Dokuments dokuments = Dokuments.getById(this.id);
        if (dokuments != null) {
            DataLists.dokumentsList.remove(dokuments);
        }
    }
}
