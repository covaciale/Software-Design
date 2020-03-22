package model;

public class User {


    public int idUser;
    public String firstName;
    public String  secondName;
    public int age;
    public String gender;



    public User(int idUser, String firstName, String secondName, int age, String gender) {
        this.idUser=idUser;
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
        this.gender=gender;

    }

    public User() {
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
}