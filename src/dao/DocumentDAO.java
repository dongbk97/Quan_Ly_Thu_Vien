package dao;

import control.DocumentControl;
import control.PersonControl;
import jdbcutils.JDBCUtils;
import model.DocumentModel;
import model.PersonModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentDAO implements InterfaceDAO<DocumentModel> {

    @Override
    public void add(DocumentModel t) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "INSERT INTO book(id,title,yearPNs,quantity,author,type)" +
                    "VALUES(" + '"' + t.getId() + '"' + "," + '"' + t.getTitle() + '"' + "," + t.getYearPNs() + "," + t.getQuantity() + "," +
                    '"' + t.getAuthor() + '"' + "," + '"' + t.getType() + '"' + ")";

            // Câu lệnh Update
            int ketqua = sttm.executeUpdate(sql);
            System.out.println("Câu lệnh SQL: " + sql);
            System.out.println("Số dòng đã thay đổi là: " + ketqua);
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DocumentModel> findByName(String str) {


        ArrayList<DocumentModel> listDocument = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM book WHERE title LIKE " + "'" + '%' + str + '%' + "'";
// Câu lệnh Query

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                DocumentModel bookModel = new DocumentModel();
                bookModel.setId(resultSet.getString("id"));
                bookModel.setTitle(resultSet.getString("title"));
                bookModel.setYearPNs(resultSet.getInt("yearPNs"));
                bookModel.setQuantity(resultSet.getInt("quantity"));
                bookModel.setAuthor(resultSet.getString("author"));
                bookModel.setType(resultSet.getString("type"));
                listDocument.add(bookModel);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDocument;
    }

    @Override
    public void edit(String idm) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// NHập thông tin Update
            DocumentModel documentModel1 = new DocumentModel();
            Scanner sc = new Scanner(System.in);
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
// Tạo câu lệnh SQL
            String sql = "UPDATE  book " +
                    "SET " + " title = " + '"' + documentModel1.getTitle() + '"' + "," + " yearPNs = " + documentModel1.getYearPNs() + "," + " quantity = " + documentModel1.getQuantity() + "," + " author = " + '"' + documentModel1.getAuthor() + '"' + "," + " type = " + '"' + documentModel1.getType() + '"' +
                    " WHERE " + "id = " + '"' + idm + '"';
// Câu lệnh Update
            int a = sttm.executeUpdate(sql);
            System.out.println("Số dòng đã update " + a);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DocumentModel findById(String idm) {
        DocumentModel bookModel = new DocumentModel();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM book WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Query

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {

                bookModel.setId(resultSet.getString("id"));
                bookModel.setTitle(resultSet.getString("title"));
                bookModel.setYearPNs(resultSet.getInt("yearPNs"));
                bookModel.setQuantity(resultSet.getInt("quantity"));
                bookModel.setAuthor(resultSet.getString("author"));
                bookModel.setType(resultSet.getString("type"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookModel;
    }

    @Override
    public void remove(String idm) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "DELETE FROM book WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Update
            sttm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
