package model;

import java.util.Date;

public class PersonModel {
    protected String id;
    protected String name;
    protected String adress;
    protected String gender;
    protected Date dayOfBirth;

    public PersonModel() {
    }

    public PersonModel(String id, String name, String adress, String gender, Date dayOfBirth) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public PersonModel(String id, String name, String adress, String gender) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.gender = gender;
    }

    public PersonModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}
