package com.kd.feedback.models;

import com.kd.feedback.data.DataLists;

public class Apmeklejums {
    public static final int STATUS_CREATED = 0;
    public static final int STATUS_ACCEPTED = 1;
    public static final int STATUS_CONFIRMED = 2;

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

    public static Apmeklejums getById(Integer id) {
        for (Apmeklejums apmeklejums : DataLists.apmeklejumsList) {
            if (apmeklejums.getId().equals(id)) {
                return apmeklejums;
            }
        }
        return null;
    }

    public void save() {
        Apmeklejums apmeklejums = Apmeklejums.getById(this.id);
        if (apmeklejums != null) {
            DataLists.apmeklejumsList.remove(apmeklejums);
        }
        DataLists.apmeklejumsList.add(this);
    }

    public void delete() {
        Apmeklejums apmeklejums = Apmeklejums.getById(this.id);
        if (apmeklejums != null) {
            DataLists.apmeklejumsList.remove(apmeklejums);
        }
    }
}
