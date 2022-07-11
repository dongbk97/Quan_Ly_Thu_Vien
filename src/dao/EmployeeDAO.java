package dao;

import control.EmplyeeControl;
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

public class EmployeeDAO implements InterfaceDAO<EmployeeModel> {


    @Override
    public void add(EmployeeModel t) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();

// Tạo câu lệnh SQL


            String sql = "INSERT INTO employee (id,shift,role)" + "VALUES(" + '"' + t.getIdE() + '"' + "," + '"' + t.getShift() + '"' + "," + '"' + t.getRole() + '"' + ")";

            String sql_person = "INSERT INTO person(id,name,adress,gender,dayOfBirth)" + "VALUES(" + '"' + t.getPersonModel().getId() + '"' + "," + '"' + t.getPersonModel().getName() + '"' + "," + '"' + t.getPersonModel().getAdress() + '"' + "," + '"' + t.getPersonModel().getGender() + '"' + "," + '"' + t.getPersonModel().getDayOfBirth() + '"' + ")";
            System.out.println("Câu lệnh SQL: " + sql);


            // Câu lệnh Update
            int ketqua2 = sttm.executeUpdate(sql_person);
            int ketqua = sttm.executeUpdate(sql);

            System.out.println("Câu lệnh SQL: " + sql);

            System.out.println("Số dòng đã thay đổi Employee: " + ketqua);
            System.out.println("Số dòng đã thay đổi Person: " + ketqua2);
            sttm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<EmployeeModel> findByName(String str) {
        ArrayList<EmployeeModel> listEmployee = new ArrayList<>();
        String strt = null;

        ArrayList<PersonModel> listPerson = new ArrayList<>();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE id LIKE " + "'%EMP%'" + " AND  name LIKE " + "'" + '%' + str + '%' + "'";
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
            resultSet.close();
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

                String sql = "SELECT * FROM employee WHERE " + "id = " + '"' + strt + '"';
// Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.setIdE(resultSet.getString("id"));
                    employeeModel.setShift(resultSet.getString("shift"));
                    employeeModel.setRole(resultSet.getString("role"));
                    employeeModel.setPersonModel(per);
                    listEmployee.add(employeeModel);
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (EmployeeModel per : listEmployee) {
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

            EmployeeModel employeeModel = new EmployeeModel();
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
            employeeModel.setIdE(t_per.getId());
            employeeModel.setPersonModel(t_per);
            System.out.println("Nhập ca làm việc: ");
            employeeModel.setShift(sc.nextLine());
            System.out.println("Nhập vị trí làm việc: ");
            employeeModel.setRole(sc.nextLine());

// Tạo câu lệnh SQL
            String sql = "UPDATE  person " + "SET " + "name = " + '"' + employeeModel.getPersonModel().getName() + '"' + "," + "adress = " + '"' + employeeModel.getPersonModel().getAdress() + '"' + "," + "gender = " + '"' + employeeModel.getPersonModel().getGender() + '"' + "," + "dayOfBirth = " + '"' + employeeModel.getPersonModel().getDayOfBirth() + '"' + " WHERE " + "id =" + '"' + idm + '"';
            String sql_reader = "UPDATE  employee " + "SET " + " shift = " + '"' + employeeModel.getShift() + '"' + "," + " role = " + '"' + employeeModel.getRole() + '"' + " WHERE " + "id =" + '"' + idm + '"';
// Câu lệnh Update
            int y = sttm.executeUpdate(sql);
            int b = sttm.executeUpdate(sql_reader);
            System.out.println("Số dòng đã update " + y);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public EmployeeModel findById(String idm) {
        //  EmployeeModel g=new EmployeeModel();
        EmployeeModel employeeModel = new EmployeeModel();
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "SELECT * FROM person WHERE id LIKE " + "'%EMP%'" + " AND id =" + '"' + idm + '"';
            String sql_employee = "SELECT * FROM employee WHERE " + " id =" + '"' + idm + '"';

// Câu lệnh Query

            ResultSet resultSet_employee = sttm.executeQuery(sql_employee);
            while (resultSet_employee.next()) {

                employeeModel.setIdE(resultSet_employee.getString("id"));
                employeeModel.setShift(resultSet_employee.getString("shift"));
                employeeModel.setRole(resultSet_employee.getString("role"));

                //   EmplyeeControl.getInstance().show(employeeModel);

            }
            resultSet_employee.close();
            ResultSet resultSet = sttm.executeQuery(sql);
            while (resultSet.next()) {
                PersonModel personModel = new PersonModel();
                personModel.setId(resultSet.getString("id"));
                personModel.setName(resultSet.getString("name"));
                personModel.setAdress(resultSet.getString("adress"));
                personModel.setGender(resultSet.getString("gender"));
                personModel.setDayOfBirth(resultSet.getDate("dayOfBirth"));
                //  PersonControl.getInstance().show(personModel);
                employeeModel.setPersonModel(personModel);
            }
            resultSet.close();


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeModel;
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
            String sql_employee = "DELETE FROM employee WHERE " + "id =" + '"' + id + '"';

// Câu lệnh Update
            int a = sttm.executeUpdate(sql_employee);
            int b = sttm.executeUpdate(sql);
            if (a > 0 && b > 0) {
                System.out.println("Bạn đã xóa thành công");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
