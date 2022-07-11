package model;

public class DocumentModel {
    private String id;
    private String title;
    private int yearPNs;
    private int quantity;
    private String author;
    private String type;

    public DocumentModel(String id, String title, int yearPNs, int quantity, String author, String type) {
        this.id = id;
        this.title = title;
        this.yearPNs = yearPNs;
        this.quantity = quantity;
        this.author = author;
        this.type = type;
    }

    public DocumentModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPNs() {
        return yearPNs;
    }

    public void setYearPNs(int yearPNs) {
        this.yearPNs = yearPNs;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DocumentModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", yearPNs=" + yearPNs +
                ", quantity=" + quantity +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
