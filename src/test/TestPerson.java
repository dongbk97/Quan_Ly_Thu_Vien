package test;

import control.BookBorrowingControl;
import control.EmplyeeControl;
import control.PersonControl;
import control.ReaderControl;
import dao.*;
import jdbcutils.JDBCUtils;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) throws ParseException {
		System.out.println("*******");
//        PersonModel personModel=new PersonModel("121","Nguyen van Dong","My son","Nam");
//        PersonControl personControl=new PersonControl();
//        PersonDAO personDAO=new PersonDAO();
//       personDAO.add(personControl.add());
//       String str="PER002";
//        PersonModel personModel=new PersonModel(str);
//        PersonControl personControl=new PersonControl();
//        personControl.show(personModel);
//        PersonDAO personDAO=new PersonDAO();
//        personDAO.edit("PER001");

//        ReaderControl readerControl=new ReaderControl();
//
//        ReaderModel readerModel=readerControl.add();
//        System.out.println(readerModel);
//        ReaderControl readerControl=new ReaderControl();
//
//        ReaderDAO readerDAO=new ReaderDAO();
//        readerDAO.findByName("am");

//        ReaderDAO readerDAO=new ReaderDAO();
//        readerDAO.findById("READER001");
//        for (int i = 0; i < 100; i++) {

        //         ReaderModel readerModel=ReaderControl.getInstance().getReaderModel();
//            ReaderModel readerModel = new ReaderModel();
//            readerModel.setType("Lau nam");
//            readerModel.setEmail("dongtr" + i + "@gmail.com");
//            readerModel.setIdR("READER00" + i);
//            readerModel.setPhoneN("0987654" + i);
//            PersonModel personModel = new PersonModel();
//            personModel.setId("READER00" + i);
//            personModel.setName("Nguyen Van Dong" + i);
//            personModel.setAdress("My Son");
//            personModel.setGender("Nam");
//            String str="1997-02-22";
//            java.sql.Date date = java.sql.Date.valueOf(str);
//            personModel.setDayOfBirth(date);
//            readerModel.setPersonModel(personModel);
//            ReaderDAO readerDAO = new ReaderDAO();
//            readerDAO.add(readerModel);
//            PersonDAO personDAO=new PersonDAO();
//            personDAO.add(personModel);
//        }
//        String idm="dsd";
//        DocumentModel documentModel1=new DocumentModel("a","b",12,2,"r","tt");
//        String sql = "UPDATE  book " +
//                "SET " + " title = " + '"' + documentModel1.getTitle() + '"' + "," + " yearPNs = " + documentModel1.getYearPNs() + "," + " quantity = " + documentModel1.getQuantity() + "," + " author = " + '"' + documentModel1.getAuthor() +'"' + "," + " type = " + '"' + documentModel1.getType() + '"' +
//                " WHERE " + "id = " + '"' + idm + '"';
//        System.out.println(sql);

//        DocumentDAO documentDAO =new DocumentDAO();
//        documentDAO.findById("BOOK001");
//        EmployeeModel t= EmplyeeControl.getInstance().add();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập id của Employee");
//        String str =sc.nextLine();
//        Scanner sc = new Scanner(System.in);
//
//        boolean u = false;
//        String str = null;
//        int a=0;
//        do {
//
//
//            if (a>0) {
//                System.out.println("Không tồn tại mã này Mời nhập lại");
//
//            }else if (a==0){
//                System.out.println("NHập ID");
//            }
//            str = sc.nextLine();
//            ArrayList<String> listStr = new ArrayList<>();
//            try {
//
//                ArrayList<EmployeeModel> listEmployee = new ArrayList<>();
//// Tạo Connection
//                Connection con = JDBCUtils.getConnection();
//// Tạo Statement
//                Statement sttm = con.createStatement();
//// Tạo câu lệnh SQL
//
//                String sql = "SELECT id FROM person WHERE " + "id LIKE " + "'%EMP%'";
//// Câu lệnh Query
//
//                ResultSet resultSet = sttm.executeQuery(sql);
//                while (resultSet.next()) {
//                    String ae = resultSet.getString("id");
//                    listStr.add(ae);
//                }
//                u = listStr.contains(str);
//
//                con.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            a++;
//        }while(!u);
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        employeeDAO.edit(str);
//
//        String idm =" ytd";
//        String sql = "SELECT * FROM person WHERE id LIKE "+ "'%EMP%'"  + " AND id =" + '"' + idm + '"';
//        System.out.println(sql);

//    EmployeeDAO employeeDAO=new EmployeeDAO();
//
//      EmployeeModel employeeModel=  employeeDAO.findById("EMP001");
//        System.out.println(employeeModel);


//        ReaderDAO readerDAO= new ReaderDAO();
//        ReaderModel readerModel=readerDAO.findById("READER001");
//        System.out.println(readerModel);
//        BookBorrowingModel bookBorrowingModel= BookBorrowingControl.getIstance().add();
//        BookBorrowingDAO bookBorrowingDAO= new BookBorrowingDAO();
//        bookBorrowingDAO.add(bookBorrowingModel);
//        bookBorrowingDAO.findById("BORR003");
//
//        for(BookBorrowingModel st :bookBorrowingModel){
//            System.out.println(st);
//        }
//        String sql = "SELECT c.id , c.reader,e.name, b.bookid, d.title, b.quantity, c.total  " +
//                "FROM  (((borrowing AS c " +
//                "INNER JOIN person AS e ON  e.id= c.reader) " +
//                "INNER JOIN borrowingsatae AS b ON b.borrowingid = c.id ) " +
//                " INNER JOIN book AS d ON  d.id= b.bookid) ";
//        System.out.println(sql);
        String idm="BORR001";
//        String sql_select = "SELECT * FROM borrowingsatae WHERE " + "id =" + "'" + idm + "'";
//
//        System.out.println(sql_select);


        try{
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();

// Tạo câu lệnh SQL
            String sql_select = "SELECT id FROM borrowingsatae WHERE borrowingid =" + "'" + idm + "'";
            ResultSet se1 = sttm.executeQuery(sql_select);
            while(se1.next()){
                int l= se1.getInt("id");
//                list_id.add(l);
                System.out.println(se1.getInt("id"));
            }
//            for (int  t2 :list_id ) {

            //  System.out.println("tet");

//                StateModel t = StateControl.getInstance().add();
//
//                String sql_update_state = "UPDATE  borrowingsatae " + "SET " + "bookid = " + '"' +  t.getDocumentModel().getId() + '"' + "," + "quantity = " + '"' + t.getQuantity() + '"' + " WHERE " + "id =" + '"' + t2 + '"';
//
//                int ketqua2=  sttm.executeUpdate(sql_update_state);
//                System.out.println("Số dòng đã thay đổi borring: " + ketqua2);
//            }

            sttm.close();
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }


    }
}
