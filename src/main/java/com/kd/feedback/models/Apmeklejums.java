package com.kd.feedback.models;

import com.kd.feedback.services.ApmeklejumsService;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;


@Entity
public class Apmeklejums {

    @Transient
    @Autowired
    private ApmeklejumsService apmeklejumsService;

    public static final int STATUS_CREATED = 0;
    public static final int STATUS_ACCEPTED = 1;
    public static final int STATUS_CONFIRMED = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String date;
    private String description;
    private Integer state;

    @ManyToOne(targetEntity = Pacients.class)
    private Pacients pacients;

    @ManyToOne(targetEntity = Medmasa.class)
    private Medmasa medmasa;


    public Apmeklejums(String date, String description, Integer state, Pacients pacients, Medmasa medmasa) {
        this.date = date;
        this.description = description;
        this.state = state;
        this.pacients = pacients;
        this.medmasa = medmasa;
    }

    public Apmeklejums() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Pacients getPacients() {
        return pacients;
    }

    public void setPacients(Pacients pacients) {
        this.pacients = pacients;
    }

    public Medmasa getMedmasa() {
        return medmasa;
    }

    public void setMedmasa(Medmasa medmasa) {
        this.medmasa = medmasa;
    }

}
