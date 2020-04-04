package model;

import javafx.util.Pair;


import java.util.Date;
import java.util.Observable;

public class DanceCourse extends Observable {
    private int idDanceCourse;
    private Antrenori antrenor;
    private String name;
    private String dance;
    private Date date;

    public DanceCourse(int idDanceCourse, Antrenori antrenor, String name, Date date){
        this.idDanceCourse = idDanceCourse;
        this.antrenor = antrenor;
        this.name = name;
        this.dance = this.antrenor.getDance();
        this.date = date;
    }

    public int getIdDanceCourse() {
        return idDanceCourse;
    }

    public void setIdDanceCourse(int idDanceCourse) {
        this.idDanceCourse = idDanceCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Pair<Date, Date> dates = new Pair<>(this.date, date);
        setChanged();
        notifyObservers(dates);
        this.date = date;
    }

    public Antrenori getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenori antrenor) {
        this.antrenor = antrenor;
    }

}
