package model;

public class Dances {
    public int idDances;
    public String dance;

    public Dances(){}

    public Dances(int idDances, String dance){
        this.idDances = idDances;
        this.dance = dance;
    }

    public int getIdDances() {
        return idDances;
    }

    public String getDance() {
        return dance;
    }

    public void setIdDances(int idDances) {
        this.idDances = idDances;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }
}
