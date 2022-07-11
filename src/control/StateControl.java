package control;

import dao.DocumentDAO;
import jdbcutils.JDBCUtils;
import model.DocumentModel;
import model.StateModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class StateControl implements InterfaceControl<StateModel> {


    public static StateControl getInstance() {
        return new StateControl();
    }

    @Override
    public StateModel add() throws ParseException {
        StateModel stateModel = new StateModel();
        Scanner sc = new Scanner(System.in);
        boolean u = false;
        String strm = null;
        int a = 0;
        do {
            if (a > 0) {
                System.out.println("Không tồn tại mã này Mời nhập lại");

            } else if (a == 0) {
                System.out.println("NHập ID sách : ");
            }
            strm = sc.nextLine();
            ArrayList<String> listStr = new ArrayList<>();
            try {
                // Tạo Connection
                Connection con = JDBCUtils.getConnection();
                // Tạo Statement
                Statement sttm = con.createStatement();
                // Tạo câu lệnh SQL

                String sql = "SELECT id FROM book WHERE " + "id LIKE " + "'%BOOK%'";
                // Câu lệnh Query

                ResultSet resultSet = sttm.executeQuery(sql);
                while (resultSet.next()) {
                    String ae = resultSet.getString("id");
                    listStr.add(ae);
                }
                u = listStr.contains(strm);

                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            a++;
        } while (!u);
        DocumentDAO documentDAO = new DocumentDAO();
        DocumentModel documentModel = documentDAO.findById(strm);
        stateModel.setDocumentModel(documentModel);
        System.out.println("Nhập số lượng sách " + documentModel.getTitle() + " muốn mượn");
        stateModel.setQuantity(Integer.parseInt(sc.nextLine()));
//        System.out.println("Nhập Id State");
//        stateModel.setId(sc.nextLine());
        return stateModel;
    }

    @Override
    public void show(StateModel stateModel) {

    }
}
