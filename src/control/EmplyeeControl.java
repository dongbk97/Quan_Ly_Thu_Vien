package control;

import model.BookBorrowingModel;
import model.EmployeeModel;
import model.PersonModel;

import java.text.ParseException;
import java.util.Scanner;

public class EmplyeeControl implements InterfaceControl<EmployeeModel>{

    public static EmplyeeControl getInstance(){
        return new EmplyeeControl();
    }

    @Override
    public EmployeeModel add() throws ParseException {
        EmployeeModel t = new EmployeeModel();
        System.out.println("Nhập thông tin nhân viên: ");
        Scanner sc = new Scanner(System.in);
        PersonModel m = PersonControl.getInstance().add();
        t.setIdE(m.getId());
        t.setPersonModel(m);
        System.out.println("Nhập ca làm việc: ");
        t.setShift(sc.nextLine());
        System.out.println("Nhập vị trí làm việc: ");
        t.setRole(sc.nextLine());
        return t;
    }

    @Override
    public void show(EmployeeModel employeeModel) {
        System.out.println(employeeModel);
    }
}
