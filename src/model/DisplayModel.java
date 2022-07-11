package model;

public class DisplayModel {
    private String  borrowingid;
    private String readerid;
    private String name;
    private String bookid;
    private String title;
    private int quantity;
    private int total;

    private String date;

    public DisplayModel(String borrowingid, String readerid, String name, String bookid, String title, int quantity, int total) {
        this.borrowingid = borrowingid;
        this.readerid = readerid;
        this.name = name;
        this.bookid = bookid;
        this.title = title;
        this.quantity = quantity;
        this.total = total;
    }

    public DisplayModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBorrowingid() {
        return borrowingid;
    }

    public void setBorrowingid(String borrowingid) {
        this.borrowingid = borrowingid;
    }

    public String getReaderid() {
        return readerid;
    }

    public void setReaderid(String readerid) {
        this.readerid = readerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Thông tin mượn sách: \n" +
                "- Id mượn sách: " + borrowingid + '\n' +
                "- Id người mượn: " + readerid + '\n' +
                "- Tên người mượn: " + name + '\n' +
                "- Id sách: " + bookid + '\n' +
                "- Sách đã mượn: \n" + " + "+    title + '\n' +
                "- Tổng: " + total +'\n' +
                "- Ngày mượn : " + date +'\n' +
                "___________________________";
    }
}
