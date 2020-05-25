package model;

public class Antrenori {

    public int idAntrenori;
    public String firstName;
    public String secondName;
    public String dance;

    public Antrenori(){}

    public Antrenori(int idAntrenori, String firstName, String secondName, String dance)
    {
        this.idAntrenori = idAntrenori;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dance = dance;
    }

    public void setIdAntrenori(int idAntrenori) {
        this.idAntrenori = idAntrenori;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public int getIdAntrenori() {
        return idAntrenori;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDance() {
        return dance;
    }

    public String toString(){
        return idAntrenori + " " + firstName + " " + secondName + " " + dance;
    }
}
