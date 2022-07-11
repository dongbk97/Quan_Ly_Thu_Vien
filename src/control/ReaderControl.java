package control;

import model.PersonModel;
import model.ReaderModel;

import java.text.ParseException;
import java.util.Scanner;

public class ReaderControl implements InterfaceControl<ReaderModel> {
    private ReaderModel readerModel;

    public ReaderModel getReaderModel() {
        return readerModel;
    }

    public void setReaderModel(ReaderModel readerModel) {
        this.readerModel = readerModel;
    }

    public static ReaderControl getInstance(){
        return new ReaderControl();
    }
    @Override
    public ReaderModel add() throws ParseException {
        Scanner sc = new Scanner(System.in);
        ReaderModel t = new ReaderModel();
        PersonModel m = PersonControl.getInstance().add();
        t.setIdR(m.getId());
        t.setPersonModel(m);
        System.out.println("Nhập Loại Reader: ");
        t.setType(sc.nextLine());
        System.out.println("Nhập Email: ");
        t.setEmail(sc.nextLine());
        System.out.println("Nhập Sdt: ");
        t.setPhoneN(sc.nextLine());
        return t;
    }
    @Override
    public void show(ReaderModel readerModel) {
        System.out.println(readerModel);
    }
}
