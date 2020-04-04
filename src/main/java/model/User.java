package model;

import javafx.util.Pair;

import java.util.*;

public class User implements Observer {

    public int idUser;
    public String firstName;
    public String  secondName;
    public int age;
    public String gender;
    public String dance;
    public List<Date> coursesDates;

    public User(int idUser, String firstName, String secondName, int age, String gender, String dance) {
        this.idUser=idUser;
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
        this.gender=gender;
        this.dance = dance;
        this.coursesDates = new ArrayList<>();
    }

    public User() {
    }

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }

    public String toString()
    {
        return idUser+" "+firstName+" "+secondName+" "+age+" "+gender;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addCourseDate(Date date){
        this.coursesDates.add(date);
    }

    @Override
    public void update(Observable o, Object arg) {
        Pair<Date, Date> dates = (Pair<Date, Date>)arg; //the old date and the new date
        this.coursesDates.remove(dates.getKey());
        this.coursesDates.add(dates.getValue());
    }

}