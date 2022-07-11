package control;

import model.PersonModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonControl implements InterfaceControl<PersonModel> {
    protected PersonModel personModel;

    public static PersonControl getInstance() {
        return new PersonControl();
    }

    public PersonControl(PersonModel personModel) {
        this.personModel = personModel;
    }

    public PersonControl() {
        this.personModel = new PersonModel();
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    @Override
    public PersonModel add() throws ParseException {
        PersonModel t = new PersonModel();
        System.out.println("Nhập thông tin: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID_Person: ");
        t.setId(sc.nextLine());
        System.out.println("Nhập Name_Person: ");
        t.setName(sc.nextLine());
        System.out.println("Nhập Adress_Person: ");
        t.setAdress(sc.nextLine());
        System.out.println("Nhập Gender_Person: ");
        t.setGender(sc.nextLine());
        System.out.println("Nhập DayOfBirth_Person(yyyy-mm-dd): ");
        String str = sc.nextLine();
        java.sql.Date date = java.sql.Date.valueOf(str);
        t.setDayOfBirth(date);
        return t;
    }

    @Override
    public void show(PersonModel personModel) {
        System.out.println(personModel);
    }
}
