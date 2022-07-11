package dao;

import jdbcutils.JDBCUtils;
import model.StateModel;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class StateDAO implements InterfaceDAO<StateModel> {
    @Override
    public void add(StateModel t) {
        try {
// Tạo Connection
            Connection con = JDBCUtils.getConnection();
// Tạo Statement
            Statement sttm = con.createStatement();
// Tạo câu lệnh SQL
            String sql = "INSERT INTO borrowingsatae (id,bookid,quantity,borrowingid)" +
                    "VALUES(" + '"' + t.getId() + '"' + "," + '"' + t.getDocumentModel().getId() + '"' + "," + t.getQuantity()  +'"' + t.getId() + '"' + ")";

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
    public ArrayList<StateModel> findByName(String str) {
        return null;
    }

    @Override
    public void edit(String str) {

    }

    @Override
    public StateModel findById(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
