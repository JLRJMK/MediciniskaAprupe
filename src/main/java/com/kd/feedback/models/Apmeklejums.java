package com.kd.feedback.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apmeklejums {
    private Integer id;
    private String date;
    private String description;
    private Integer state;
    private Pacients pacients;
    private Medmasa medmasa;


    public Apmeklejums(Integer id, String date, String description, Integer state, Pacients pacients, Medmasa medmasa) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.state = state;
        this.pacients = pacients;
        this.medmasa = medmasa;
    }
    public static final List<Apmeklejums> apmeklejumsList = new ArrayList<>();

    {
        apmeklejumsList.add(new Apmeklejums(1, "20.12.2020", "g", 1, null, null));
        apmeklejumsList.add(new Apmeklejums(2, "03.01.2021", "h", 0, null, null));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
