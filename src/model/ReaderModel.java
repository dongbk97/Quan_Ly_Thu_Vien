package model;

public class ReaderModel {
    private String idR;
    private String type;
    private String email;
    private String phoneN;
    private PersonModel personModel;

    public ReaderModel() {
    }

    public ReaderModel(String idR, String type, String email, String phoneN, PersonModel personModel) {
        this.idR = idR;
        this.type = type;
        this.email = email;
        this.phoneN = phoneN;
        this.personModel = personModel;
    }

    public String getIdR() {
        return idR;
    }

    public void setIdR(String idR) {
        this.idR = idR;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    @Override
    public String toString() {
        return "ReaderModel{" +
                "idR='" + idR + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", phoneN='" + phoneN + '\'' +", "+
                personModel +
                '}';
    }
}
