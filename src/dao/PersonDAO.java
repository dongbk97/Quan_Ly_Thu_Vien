package dao;

import control.PersonControl;
import jdbcutils.JDBCUtils;
import model.PersonModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO implements InterfaceDAO<PersonModel> {
    public static PersonModel getInstance() {
        return new PersonModel();
    }

    @Override
    public void add(PersonModel t) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "INSERT INTO person(id,name,adress,gender,dayOfBirth)" +
                    "VALUES(" + '"' + t.getId() + '"' + "," + '"' + t.getName() + '"' + "," + '"' + t.getAdress() +
                    '"' + "," + '"' + t.getGender() + '"' + "," + '"' + t.getDayOfBirth() + '"' + ")";

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
    public ArrayList<PersonModel> findByName(String str) {
        ArrayList<PersonModel> listPerson=new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE name LIKE " + "'" + '%' + str + '%' + "'";
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
        return listPerson;
    }

    @Override
    public void edit(String idm) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// NHập thông tin Update
            PersonModel personModel = PersonControl.getInstance().add();
// Tạo câu lệnh SQL
            String sql = "UPDATE  person " +
                    "SET " + "name = " + '"' + personModel.getName() + '"' + "," + "adress = " + '"' + personModel.getAdress() + '"' + "," + "gender = " + '"' + personModel.getGender() + '"' + "," + "dayOfBirth = " + '"' + personModel.getDayOfBirth() + '"' +
                    " WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Update
            int a = sttm.executeUpdate(sql);
            System.out.println("Số dòng đã update " + a);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PersonModel findById(String idm) {

        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Query

            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                PersonModel personModel = new PersonModel();
                personModel.setId(resultSet.getString("id"));
                personModel.setName(resultSet.getString("name"));
                personModel.setAdress(resultSet.getString("adress"));
                personModel.setGender(resultSet.getString("gender"));
                personModel.setDayOfBirth(resultSet.getDate("dayOfBirth"));
                PersonControl.getInstance().show(personModel);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
// Câu lệnh Update
            sttm.executeUpdate(sql);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
