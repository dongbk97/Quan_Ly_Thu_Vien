package dao;

import control.PersonControl;
import control.ReaderControl;
import jdbcutils.JDBCUtils;
import model.EmployeeModel;
import model.PersonModel;
import model.ReaderModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderDAO implements InterfaceDAO<ReaderModel> {
    public static ReaderModel getInstance() {
        return new ReaderModel();
    }

    @Override
    public void add(ReaderModel t) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();

// Tạo câu lệnh SQL
            String sql_person = "INSERT INTO person(id,name,adress,gender,dayOfBirth)" + "VALUES(" + '"' + t.getPersonModel().getId() + '"' + "," + '"' + t.getPersonModel().getName() + '"' + "," + '"' + t.getPersonModel().getAdress() + '"' + "," + '"' + t.getPersonModel().getGender() + '"' + "," + '"' + t.getPersonModel().getDayOfBirth() + '"' + ")";

            String sql = "INSERT INTO reader(id,type,email,phoneN)" + "VALUES(" + '"' + t.getIdR() + '"' + "," + '"' + t.getType() + '"' + "," + '"' + t.getEmail() + '"' + "," + '"' + t.getPhoneN() + '"' + ")";

            System.out.println("Câu lệnh SQL: " + sql);
            System.out.println("Câu lệnh SQL: " + sql_person);

            // Câu lệnh Update
            int ketqua2 = sttm.executeUpdate(sql_person);
            int ketqua = sttm.executeUpdate(sql);

            System.out.println("Câu lệnh SQL: " + sql);
            System.out.println("Câu lệnh SQL: " + sql_person);
            System.out.println("Số dòng đã thay đổi là: " + ketqua);
            sttm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ReaderModel> findByName(String str) {
        PersonDAO personDAO = new PersonDAO();
        ArrayList<ReaderModel> listReaderM = new ArrayList<>();
        String strt = null;
        ArrayList<PersonModel> listPerson = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE id LIKE " + "'%REA%'" + " AND  name LIKE " + "'" + '%' + str + '%' + "'";
// Câu lệnh Query

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                PersonModel personModel = new PersonModel();
                personModel.setId(resultSet.getString("id"));
                personModel.setName(resultSet.getString("name"));
                personModel.setAdress(resultSet.getString("adress"));
                personModel.setGender(resultSet.getString("gender"));
                personModel.setDayOfBirth(resultSet.getDate("dayOfBirth"));
                listPerson.add(personModel);
                //   PersonControl.getInstance().show(personModel);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        for (PersonModel per : listPerson) {
            strt = per.getId();
            try {
// Tạo Connection
                Connection con = JDBCUtils.getConnection();
// Tạo Statement
                Statement sttm = con.createStatement();
// Tạo câu lệnh SQL

                String sql = "SELECT * FROM reader WHERE " + "id= " + '"' + strt + '"';
// Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    ReaderModel readerModel = new ReaderModel();
                    readerModel.setIdR(resultSet.getString("id"));
                    readerModel.setType(resultSet.getString("type"));
                    readerModel.setEmail(resultSet.getString("email"));
                    readerModel.setPhoneN(resultSet.getString("phoneN"));
                    readerModel.setPersonModel(per);
                    listReaderM.add(readerModel);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (ReaderModel per : listReaderM) {

            System.out.println(per);
        }
        return null;
    }

    @Override
    public void edit(String idm) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// NHập thông tin Update

            ReaderModel readerModel = new ReaderModel();
            PersonModel t_per = new PersonModel();
            System.out.println("Nhập thông tin: ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập Name: ");
            t_per.setName(sc.nextLine());
            System.out.println("Nhập Adress: ");
            t_per.setAdress(sc.nextLine());
            System.out.println("Nhập Gender: ");
            t_per.setGender(sc.nextLine());
            System.out.println("Nhập DayOfBirth(yyyy-mm-dd): ");
            String str = sc.nextLine();
            java.sql.Date date = java.sql.Date.valueOf(str);
            t_per.setDayOfBirth(date);
            readerModel.setIdR(t_per.getId());
            readerModel.setPersonModel(t_per);
            System.out.println("Nhập Loại Reader: ");
            readerModel.setType(sc.nextLine());
            System.out.println("Nhập Email: ");
            readerModel.setEmail(sc.nextLine());
            System.out.println("Nhập Sdt: ");
            readerModel.setPhoneN(sc.nextLine());


// Tạo câu lệnh SQL
            String sql = "UPDATE  person " + "SET " + "name = " + '"' + readerModel.getPersonModel().getName() + '"' + "," + "adress = " + '"' + readerModel.getPersonModel().getAdress() + '"' + "," + "gender = " + '"' + readerModel.getPersonModel().getGender() + '"' + "," + "dayOfBirth = " + '"' + readerModel.getPersonModel().getDayOfBirth() + '"' + " WHERE " + "id =" + '"' + idm + '"';
            String sql_reader = "UPDATE  reader " + "SET " + "type = " + '"' + readerModel.getType() + '"' + "," + "email = " + '"' + readerModel.getEmail() + '"' + "," + "phoneN = " + '"' + readerModel.getPhoneN() + '"' + " WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Update
            int a = sttm.executeUpdate(sql);
            int b = sttm.executeUpdate(sql_reader);
            System.out.println("Số dòng đã update " + a);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ReaderModel findById(String idm) {
        ReaderModel readerModel = new ReaderModel();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE " + "id =" + '"' + idm + '"';
            String sql_reader = "SELECT * FROM reader WHERE " + "id =" + '"' + idm + '"';

// Câu lệnh Query
            ResultSet resultSet_reader = sttm.executeQuery(sql_reader);
            while (resultSet_reader.next()) {

                readerModel.setIdR(resultSet_reader.getString("id"));
                readerModel.setType(resultSet_reader.getString("type"));
                readerModel.setEmail(resultSet_reader.getString("email"));
                readerModel.setPhoneN(resultSet_reader.getString("phoneN"));

                //  ReaderControl.getInstance().show(readerModel);
            }
            resultSet_reader.close();
            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                PersonModel personModel = new PersonModel();
                personModel.setId(resultSet.getString("id"));
                personModel.setName(resultSet.getString("name"));
                personModel.setAdress(resultSet.getString("adress"));
                personModel.setGender(resultSet.getString("gender"));
                personModel.setDayOfBirth(resultSet.getDate("dayOfBirth"));
                readerModel.setPersonModel(personModel);
            }
            resultSet.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerModel;
    }

    @Override
    public void remove(String id) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "DELETE FROM person WHERE " + "id =" + '"' + id + '"';
            String sql_reader = "DELETE FROM reader WHERE " + "id =" + '"' + id + '"';

// Câu lệnh Update
            int a = sttm.executeUpdate(sql_reader);
            int b = sttm.executeUpdate(sql);
            if (a != 0 && b != 0) {
                System.out.println("Bạn đã xóa thành công");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
