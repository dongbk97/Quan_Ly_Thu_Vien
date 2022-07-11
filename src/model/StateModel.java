package model;

public class StateModel {
    private String id;
    private BookBorrowingModel bookBorrowingModel;
    private DocumentModel documentModel;
    private int quantity;


    public StateModel(String id, BookBorrowingModel bookBorrowingModel, DocumentModel documentModel, int quantity) {
        this.id = id;
        this.bookBorrowingModel = bookBorrowingModel;
        this.documentModel = documentModel;
        this.quantity = quantity;
    }

    public StateModel() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookBorrowingModel getBookBorrowingModel() {
        return bookBorrowingModel;
    }

    public void setBookBorrowingModel(BookBorrowingModel bookBorrowingModel) {
        this.bookBorrowingModel = bookBorrowingModel;
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public void setDocumentModel(DocumentModel documentModel) {
        this.documentModel = documentModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StateModel{" +
                "id='" + id + '\'' +
                ", documentModel=" + documentModel.getTitle() +
                ", quantity=" + quantity +
                '}';
    }
}
