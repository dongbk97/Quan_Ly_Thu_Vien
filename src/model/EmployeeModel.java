package model;

public class EmployeeModel {
    private String idE;
    private String shift;
    private String role;
    private PersonModel personModel;

    public EmployeeModel(String shift, String role) {
        this.shift = shift;
        this.role = role;
    }

    public EmployeeModel() {
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    public String getIdE() {
        return idE;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                 personModel +
                " , idE='" + idE + '\'' +
                ", shift='" + shift + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
