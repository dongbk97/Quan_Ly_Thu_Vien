package dao;

import control.BookBorrowingControl;
import control.StateControl;
import jdbcutils.JDBCUtils;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookBorrowingDAO implements InterfaceDAO<BookBorrowingModel> {
    @Override
    public void add(BookBorrowingModel t) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL

            String sql = "INSERT INTO borrowing (id,reader,employee,total,date)" + "VALUES(" + '"' + t.getId() + '"' + "," + '"' + t.getReaderModel().getIdR() + '"' + "," + '"' + t.getEmployeeModel().getIdE() + '"' + "," + '"' + t.getTotal() + '"' + "," + '"' + t.getDate() + '"' + ")";
            int ketqua = sttm.executeUpdate(sql);


            for (StateModel t2 : t.getStateModels()) {

                String sql2 = "INSERT INTO borrowingsatae (bookid,quantity,borrowingid)" +
                        "VALUES(" + '"' + t2.getDocumentModel().getId() + '"' + "," + t2.getQuantity() + "," + '"' + t.getId() + '"' + ")";
                sttm.executeUpdate(sql2);
            }

            System.out.println("Câu lệnh SQL: " + sql);

            System.out.println("Số dòng đã thay đổi Employee: " + ketqua);

            sttm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BookBorrowingModel> findAll(String str) {
        BookBorrowingModel brm = new BookBorrowingModel();
        ArrayList<String> listRD = new ArrayList<>();
        ArrayList<BookBorrowingModel> listST = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM borrowing ";
// Câu lệnh Query

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                String k = resultSet.getString("reader");
                brm.setTotal(resultSet.getInt("total"));
                listRD.add(k);
            }
            for (String p : listRD) {
                System.out.println(p);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String j : listRD) {
            try {
// Tạo Connection
                Connection con = JDBCUtils.getConnection();
// Tạo Statement
                Statement sttm = con.createStatement();
// Tạo câu lệnh SQL

                String sql = "SELECT * FROM person WHERE " + "id= " + '"' + j + '"';
// Câu lệnh Query
                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    ReaderModel readerModel = new ReaderModel();
                    readerModel.getPersonModel().setId(resultSet.getString("id"));
                    readerModel.getPersonModel().setName(resultSet.getString("name"));
                    brm.setReaderModel(readerModel);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        listST.add(brm);
        return listST;
    }

    @Override
    public ArrayList<BookBorrowingModel> findByName(String str) {
        return null;
    }

    @Override
    public void edit(String idm) {
        ArrayList list_id = new ArrayList<>();
        int ketqua2=0;
        int ketqua =0;
        try {
            BookBorrowingModel bookBorrowingModel = BookBorrowingControl.getIstance().update();

// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();

// Tạo câu lệnh SQL
            String sql_update = "UPDATE  borrowing " + "SET " + "reader = " + '"' + bookBorrowingModel.getReaderModel().getIdR() + '"' + "," + "employee = " + '"' + bookBorrowingModel.getEmployeeModel().getIdE() + '"' + "," + "total = " + '"' + bookBorrowingModel.getTotal() + '"' + "," + "date = " + '"' + bookBorrowingModel.getDate() + '"' + " WHERE " + "id =" + '"' + idm + '"';

             ketqua = sttm.executeUpdate(sql_update);
            sttm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();

// Tạo câu lệnh SQL
            String sql_select = "SELECT id FROM borrowingsatae WHERE " + " borrowingid = " + "'" + idm + "'";
            ResultSet se1 = sttm.executeQuery(sql_select);
            while (se1.next()) {
                int l = se1.getInt("id");
                list_id.add(l);

            }
            for (int i = 0; i < list_id.size(); i++) {

                StateModel t = StateControl.getInstance().add();

                String sql_update_state = "UPDATE  borrowingsatae " + "SET " + "bookid = " + '"' + t.getDocumentModel().getId() + '"' + "," + "quantity = " + '"' + t.getQuantity() + '"' + " WHERE " + "id =" + '"' + list_id.get(i) + '"';

                 ketqua2 = sttm.executeUpdate(sql_update_state);
            }
            sttm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ketqua!=0 &&ketqua2!=0){
            System.out.println("Bạn đã thay đổi thành công");
        }

    }

    public BookBorrowingModel findAllIf() {
        ArrayList<DisplayModel> displayModels = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL

            String sql = "SELECT c.id , c.reader,e.name, b.bookid, d.title, b.quantity, c.total, c.date  " +
                    "FROM  ((( borrowing AS c " +
                    "INNER JOIN person AS e ON  e.id= c.reader ) " +
                    "INNER JOIN borrowingsatae AS b ON b.borrowingid = c.id ) " +
                    " INNER JOIN book AS d ON  d.id= b.bookid )" +
                    " ORDER BY c.id ";

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                DisplayModel displayModel = new DisplayModel();
                displayModel.setBorrowingid(resultSet.getString("id"));
                displayModel.setReaderid(resultSet.getString("reader"));
                displayModel.setName(resultSet.getString("name"));
                displayModel.setBookid(resultSet.getString("bookid"));
                displayModel.setTitle(resultSet.getString("title"));
                displayModel.setQuantity(resultSet.getInt("quantity"));
                displayModel.setTotal(resultSet.getInt("total"));
                displayModel.setDate(resultSet.getString("date"));
                displayModels.add(displayModel);
            }
            sttm.close();
            con.close();
            ArrayList<DisplayModel> listD = new ArrayList<>();
            for (int i = 0; i < displayModels.size(); i++) {
                //  DisplayModel displayModelT = new DisplayModel();
                for (int j = i + 1; j < displayModels.size(); j++) {

                    if (displayModels.get(i).getBorrowingid().equals(displayModels.get(j).getBorrowingid())) {
                        String v = displayModels.get(i).getTitle() + "\n";
                        displayModels.get(i).setTitle(v + " + " + displayModels.get(j).getTitle());
                        // displayModels.get(i).setTotal( displayModels.get(i).getQuantity()+displayModels.get(j).getQuantity());
                        displayModels.get(j).setTitle("null");
                        displayModels.get(j).setName("null");
                        //  displayModels.get(j).setQuantity(0);
                    }
                }
            }
            for (int i = 0; i < displayModels.size(); i++) {
                if (!displayModels.get(i).getName().equals("null"))
                    listD.add(displayModels.get(i));

            }
            for (DisplayModel fg : listD) {
                System.out.println(fg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BookBorrowingModel findById(String idm) {
        ArrayList<DisplayModel> displayModels = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL

            String sql = "SELECT c.id , c.reader,e.name, b.bookid, d.title, b.quantity, c.total, c.date  " +
                    "FROM  ((( borrowing AS c " +
                    "INNER JOIN person AS e ON  e.id= c.reader ) " +
                    "INNER JOIN borrowingsatae AS b ON b.borrowingid = c.id ) " +
                    " INNER JOIN book AS d ON  d.id= b.bookid )" +
                    " ORDER BY c.id ";

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                DisplayModel displayModel = new DisplayModel();
                displayModel.setBorrowingid(resultSet.getString("id"));
                displayModel.setReaderid(resultSet.getString("reader"));
                displayModel.setName(resultSet.getString("name"));
                displayModel.setBookid(resultSet.getString("bookid"));
                displayModel.setTitle(resultSet.getString("title"));
                displayModel.setQuantity(resultSet.getInt("quantity"));
                displayModel.setTotal(resultSet.getInt("total"));
                displayModel.setDate(resultSet.getString("date"));
                displayModels.add(displayModel);
            }
            sttm.close();
            con.close();
            ArrayList<DisplayModel> listD = new ArrayList<>();
            for (int i = 0; i < displayModels.size(); i++) {

                for (int j = i + 1; j < displayModels.size(); j++) {

                    if (displayModels.get(i).getBorrowingid().equals(displayModels.get(j).getBorrowingid())) {
                        String v = displayModels.get(i).getTitle() + "\n";
                        displayModels.get(i).setTitle(v + " + " + displayModels.get(j).getTitle());
                        displayModels.get(j).setTitle("null");
                        displayModels.get(j).setName("null");
                    }
                }
            }
            for (int i = 0; i < displayModels.size(); i++) {
                if (!displayModels.get(i).getName().equals("null"))
                    listD.add(displayModels.get(i));

            }
            for (DisplayModel fg : listD) {
                if (fg.getBorrowingid().equals(idm)) {
                    System.out.println(fg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
