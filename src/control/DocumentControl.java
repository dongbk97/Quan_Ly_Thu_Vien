package control;

import model.DocumentModel;

import java.text.ParseException;
import java.util.Scanner;

public class DocumentControl implements InterfaceControl<DocumentModel> {
    private DocumentModel documentModel;

    public static DocumentControl getInstance() {
        return new DocumentControl();
    }

    public DocumentControl(DocumentModel documentModel) {
        this.documentModel = documentModel;
    }

    public DocumentControl() {
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public void setDocumentModel(DocumentModel documentModel) {
        this.documentModel = documentModel;
    }


    @Override
    public DocumentModel add() throws ParseException {
        DocumentModel documentModel1 = new DocumentModel();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin sách: ");
        System.out.println("Nhập id: ");
        documentModel1.setId(sc.nextLine());
        System.out.println("Nhập tên sách: ");
        documentModel1.setTitle(sc.nextLine());
        System.out.println("Nhập năm xuất bản: ");
        documentModel1.setYearPNs(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập số lượng: ");
        documentModel1.setQuantity(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tên tác giả: ");
        documentModel1.setAuthor(sc.nextLine());
        System.out.println("Nhập thể loại sách: ");
        documentModel1.setType(sc.nextLine());

        return documentModel1;
    }

    @Override
    public void show(DocumentModel documentModel) {
        System.out.println(documentModel);
    }
}
