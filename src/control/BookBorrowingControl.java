package control;

import dao.EmployeeDAO;
import dao.ReaderDAO;
import dao.StateDAO;
import jdbcutils.JDBCUtils;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookBorrowingControl implements InterfaceControl<BookBorrowingModel> {

    public static BookBorrowingControl getIstance() {
        return new BookBorrowingControl();
    }

    @Override
    public BookBorrowingModel add() throws ParseException {
        BookBorrowingModel bookBorrowingModel = new BookBorrowingModel();
        Scanner sc = new Scanner(System.in);
// Nhap id nhan vien
        boolean u = false;
        String strm = null;
        int b = 0;
        do {
            if (b > 0) {
                System.out.println("Không tồn tại mã này Mời nhập lại");

            } else if (b == 0) {
                System.out.println("NHập ID nhan vien : ");
            }
            strm = sc.nextLine();
            ArrayList<String> listStr = new ArrayList<>();
            try {

                // Tạo Connection
                Connection con = JDBCUtils.getConnection();
                // Tạo Statement
                Statement sttm = con.createStatement();
                // Tạo câu lệnh SQL

                String sql = "SELECT id FROM person WHERE " + "id LIKE " + "'%EMP%'";
                // Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    String ae = resultSet.getString("id");
                    listStr.add(ae);
                }
                u = listStr.contains(strm);
                resultSet.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            b++;
        } while (!u);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeModel employeeModel = employeeDAO.findById(strm);
        bookBorrowingModel.setEmployeeModel(employeeModel);

// Nhap id nguoi doc
        boolean ue = false;
        String strm_reader = null;
        int a = 0;
        do {
            if (a > 0) {
                System.out.println("Không tồn tại mã này Mời nhập lại");

            } else if (a == 0) {
                System.out.println("NHập ID nguoi doc : ");
            }
            strm_reader = sc.nextLine();
            ArrayList<String> listReader = new ArrayList<>();
            try {
                // Tạo Connection
                Connection con = JDBCUtils.getConnection();
                // Tạo Statement
                Statement sttm = con.createStatement();
                // Tạo câu lệnh SQL

                String sql = "SELECT id FROM person WHERE " + "id LIKE " + "'%READ%'";
                // Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    String ae = resultSet.getString("id");
                    listReader.add(ae);
                }
                ue = listReader.contains(strm_reader);
                resultSet.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            a++;
        } while (!ue);
        ReaderDAO readerDAO = new ReaderDAO();
        ReaderModel readerModel = readerDAO.findById(strm_reader);
        bookBorrowingModel.setReaderModel(readerModel);
        System.out.println("Nhập id mượn sách: ");
        bookBorrowingModel.setId(sc.nextLine());

        // NHập ArrayList
        ArrayList<StateModel> stateModels = new ArrayList<>();
        int k = 0;
        do {
            System.out.println("Nhấn 1 để mượn thêm sách \n" +
                    "Nhấn số bất kỳ để kết thúc");
            k = Integer.parseInt(sc.nextLine());
            if (k == 1) {
                StateModel t = StateControl.getInstance().add();
                stateModels.add(t);

            } else ;
        } while (k == 1);
        int l = 0;
        for (StateModel st : stateModels) {

            l = l + st.getQuantity();
        }
        System.out.println("NHập ngày mượn sách: ");
        bookBorrowingModel.setDate(sc.nextLine());
        bookBorrowingModel.setTotal(l);
        bookBorrowingModel.setsStateModels(stateModels);

        return bookBorrowingModel;
    }
    @Override
    public void show(BookBorrowingModel bookBorrowingModel) {

    }
    public BookBorrowingModel update() throws ParseException {
        BookBorrowingModel bookBorrowingModel = new BookBorrowingModel();
        Scanner sc = new Scanner(System.in);
// Nhap id nhan vien
        boolean u = false;
        String strm = null;
        int b = 0;
        do {
            if (b > 0) {
                System.out.println("Không tồn tại mã này Mời nhập lại");

            } else if (b == 0) {
                System.out.println("NHập ID nhan vien : ");
            }
            strm = sc.nextLine();
            ArrayList<String> listStr = new ArrayList<>();
            try {

                // Tạo Connection
                Connection con = JDBCUtils.getConnection();
                // Tạo Statement
                Statement sttm = con.createStatement();
                // Tạo câu lệnh SQL

                String sql = "SELECT id FROM person WHERE " + "id LIKE " + "'%EMP%'";
                // Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    String ae = resultSet.getString("id");
                    listStr.add(ae);
                }
                u = listStr.contains(strm);
                resultSet.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            b++;
        } while (!u);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeModel employeeModel = employeeDAO.findById(strm);
        bookBorrowingModel.setEmployeeModel(employeeModel);

// Nhap id nguoi doc
        boolean ue = false;
        String strm_reader = null;
        int a = 0;
        do {
            if (a > 0) {
                System.out.println("Không tồn tại mã này Mời nhập lại");

            } else if (a == 0) {
                System.out.println("NHập ID nguoi doc : ");
            }
            strm_reader = sc.nextLine();
            ArrayList<String> listReader = new ArrayList<>();
            try {
                // Tạo Connection
                Connection con = JDBCUtils.getConnection();
                // Tạo Statement
                Statement sttm = con.createStatement();
                // Tạo câu lệnh SQL

                String sql = "SELECT id FROM person WHERE " + "id LIKE " + "'%READ%'";
                // Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    String ae = resultSet.getString("id");
                    listReader.add(ae);
                }
                ue = listReader.contains(strm_reader);
                resultSet.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            a++;
        } while (!ue);
        ReaderDAO readerDAO = new ReaderDAO();
        ReaderModel readerModel = readerDAO.findById(strm_reader);
        bookBorrowingModel.setReaderModel(readerModel);
//        System.out.println("Nhập id mượn sách: ");
//        bookBorrowingModel.setId(sc.nextLine());

        // NHập ArrayList
//        ArrayList<StateModel> stateModels = new ArrayList<>();
//        int k = 0;
//        do {
//            System.out.println("Nhấn 1 để mượn thêm sách \n" +
//                    "Nhấn số bất kỳ để kết thúc");
//            k = Integer.parseInt(sc.nextLine());
//            if (k == 1) {
//
//                StateModel t = StateControl.getInstance().add();
//
//                stateModels.add(t);
//
//            } else ;
//        } while (k == 1);
//        int l = 0;
//        for (StateModel st : stateModels) {
//
//            l = l + st.getQuantity();
//        }
        System.out.println("NHập ngày mượn sách: ");
        bookBorrowingModel.setDate(sc.nextLine());
//        bookBorrowingModel.setTotal(l);
//        bookBorrowingModel.setsStateModels(stateModels);

        return bookBorrowingModel;
    }
}
