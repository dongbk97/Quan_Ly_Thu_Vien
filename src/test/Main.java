package test;

import control.BookBorrowingControl;
import control.DocumentControl;
import control.EmplyeeControl;
import control.ReaderControl;
import dao.BookBorrowingDAO;
import dao.DocumentDAO;
import dao.EmployeeDAO;
import dao.ReaderDAO;
import jdbcutils.JDBCUtils;
import model.BookBorrowingModel;
import model.DocumentModel;
import model.EmployeeModel;
import model.ReaderModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        do {
            System.out.println("__________MENU___________");
            System.out.println("Mời bạn chọn chức năng: \n" +
                    "1. Con người \n" +
                    "2. Sách \n" +
                    "3. Quản lý thông tin mượn sách \n" +
                    "Nhập vào số bất kỳ để thoát");
            luaChon = Integer.parseInt(sc.nextLine());
            if (luaChon == 1) {
                int lc11 = 0;
                do {
                    System.out.println("__________MENU-CON-NGUOI___________");
                    System.out.println("Mời bạn chọn chức năng: \n" +
                            "1. Bạn đọc \n" +
                            "2. Nhân viên \n" +
                            "0. Nhập 0 để thoát MENU-CON-NGUOI");
                    lc11 = Integer.parseInt(sc.nextLine());
                    if (lc11 == 1) {
                        int lc1 = 0;
                        do {
                            System.out.println("__________MENU-BAN-DOC___________");
                            System.out.println("Mời bạn chọn chức năng: \n" +
                                    "1. Thêm bạn đọc \n" +
                                    "2. Tìm theo tên \n" +
                                    "3. Tìm theo ID \n" +
                                    "4. Sửa theo ID \n" +
                                    "5. Xóa theo ID \n" +
                                    "0. Nhập 0 để thoát MENU-BAN-DOC");
                            lc1 = Integer.parseInt(sc.nextLine());
                            if (lc1 == 1) {
                                ReaderModel readerModel = ReaderControl.getInstance().add();
                                ReaderDAO readerDAO = new ReaderDAO();
                                readerDAO.add(readerModel);
                            }else if (lc1 == 2) {
                                System.out.println("Nhập tên bạn muốn tìm:");
                                String str = sc.nextLine();
                                ReaderDAO readerDAO = new ReaderDAO();
                                readerDAO.findByName(str);
                            } else if (lc1 == 3) {
                                System.out.println("Nhập ID bạn muốn tìm:");
                                String str = sc.nextLine();
                                ReaderDAO readerDAO = new ReaderDAO();
                                System.out.println(readerDAO.findById(str));
                            } else if (lc1 == 4) {
                                boolean u = false;
                                String strm = null;
                                int a = 0;
                                do {
                                    if (a > 0) {
                                        System.out.println("Không tồn tại mã này Mời nhập lại");

                                    } else if (a == 0) {
                                        System.out.println("NHập ID bạn muốn sửa: ");
                                    }
                                    strm = sc.nextLine();
                                    ArrayList<String> listStr = new ArrayList<>();
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
                                            listStr.add(ae);
                                        }
                                        u = listStr.contains(strm);

                                        con.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    a++;
                                } while (!u);
                                ReaderDAO readerDAO = new ReaderDAO();
                                readerDAO.edit(strm);
                            } else if (lc1 == 5) {
                                System.out.println("Nhập ID bạn muốn xóa:");
                                String str = sc.nextLine();
                                ReaderDAO readerDAO = new ReaderDAO();
                                readerDAO.remove(str);
                            }
                        } while (lc1 != 0);
                    } else if (lc11 == 2) {
                        int lc2 = 0;
                        do {
                            System.out.println("__________MENU-NHAN-VIEN___________");
                            System.out.println("Mời bạn chọn chức năng: \n" +
                                    "1. Thêm nhân viên \n" +
                                    "2. Tìm theo tên \n" +
                                    "3. Tìm theo ID \n" +
                                    "4. Sửa theo ID \n" +
                                    "5. Xóa theo ID \n" +
                                    "0. Nhập 0 để thoát MENU-NHAN-VIEN");
                            lc2 = Integer.parseInt(sc.nextLine());
                            if (lc2 == 1) {
                                EmployeeModel employeeModel = EmplyeeControl.getInstance().add();
                                EmployeeDAO employeeDAO = new EmployeeDAO();
                                employeeDAO.add(employeeModel);
                            } else if (lc2 == 2) {
                                System.out.println("Nhập tên bạn muốn tìm:");
                                String str = sc.nextLine();
                                EmployeeDAO employeeDAO = new EmployeeDAO();
                                employeeDAO.findByName(str);
                            } else if (lc2 == 3) {
                                System.out.println("Nhập ID bạn muốn tìm:");
                                String str = sc.nextLine();
                                EmployeeDAO employeeDAO = new EmployeeDAO();
                                employeeDAO.findById(str);
                            } else if (lc2 == 4) {
                                boolean u = false;
                                String strm = null;
                                int a = 0;
                                do {
                                    if (a > 0) {
                                        System.out.println("Không tồn tại mã này Mời nhập lại");

                                    } else if (a == 0) {
                                        System.out.println("NHập ID bạn muốn sửa: ");
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

                                        con.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    a++;
                                } while (!u);
                                EmployeeDAO employeeDAO = new EmployeeDAO();
                                employeeDAO.edit(strm);
                            } else if (lc2 == 5) {
                                System.out.println("Nhập ID bạn muốn xóa:");
                                String strc = sc.nextLine();
                                EmployeeDAO employeeDAO = new EmployeeDAO();
                                employeeDAO.remove(strc);
                            }
                        } while (lc2 != 0);
                    }
                } while (lc11 != 0);
// Menu Sách
            } else if (luaChon == 2) {
                int lc2 = 0;
                do {
                    System.out.println("__________MENU-SACH___________");
                    System.out.println("Mời bạn chọn chức năng: \n" +
                            "1. Thêm sách \n" +
                            "2. Tìm theo tên \n" +
                            "3. Tìm theo ID \n" +
                            "4. Sửa theo ID \n" +
                            "5. Xóa theo ID \n" +
                            "0. Nhập 0 để thoát MENU-SACH");
                    lc2 = Integer.parseInt(sc.nextLine());
                    if (lc2 == 1) {
                        DocumentModel documentModel = DocumentControl.getInstance().add();
                        DocumentDAO documentDAO = new DocumentDAO();
                        documentDAO.add(documentModel);
                    } else if (lc2 == 2) {
                        System.out.println("Nhập tên sách bạn muốn tìm:");
                        String str = sc.nextLine();
                        DocumentDAO documentDAO = new DocumentDAO();
                        for (DocumentModel df : documentDAO.findByName(str)) {
                            System.out.println(df);
                        }
                    } else if (lc2 == 3) {
                        System.out.println("Nhập ID sách bạn muốn tìm:");
                        String str = sc.nextLine();
                        DocumentDAO documentDAO = new DocumentDAO();
                        System.out.println(documentDAO.findById(str));
                    } else if (lc2 == 4) {
                        boolean u = false;
                        String strm = null;
                        System.out.println("NHập ID bạn muốn sửa: ");
                        strm = sc.nextLine();
                        ArrayList<String> listStr = new ArrayList<>();
                        try {
                            ArrayList<EmployeeModel> listEmployee = new ArrayList<>();
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
                        if (!u) {
                            System.out.println("Mã người đọc này không tồn tại mời nhập lại");
                            strm = sc.nextLine();
                        }
                        DocumentDAO documentDAO = new DocumentDAO();
                        documentDAO.edit(strm);
                    } else if (lc2 == 5) {
                        System.out.println("Nhập ID sách bạn muốn xóa:");
                        String str = sc.nextLine();
                        DocumentDAO documentDAO = new DocumentDAO();
                        documentDAO.remove(str);
                    }
                } while (lc2 != 0);
//  Menu mượn sách
            } else if (luaChon == 3) {
                int lc3 = 0;
                do {
                    System.out.println("__________MENU-MUON-SACH___________");
                    System.out.println("Mời bạn chọn chức năng: \n" +
                            "1. Thêm ho so muon sach \n" +
                            "2. Hiển thị hồ sơ theo ID \n" +
                            "3. Hiển thị tất cả hồ sơ \n" +
                            "4. Sửa theo id \n" +
                            "0. Nhập số khác để thoát MENU-MUON-SACH");
                    lc3 = Integer.parseInt(sc.nextLine());
                    if (lc3 == 1) {
                        BookBorrowingModel bookBorrowingModel = BookBorrowingControl.getIstance().add();
                        BookBorrowingDAO bookBorrowingDAO = new BookBorrowingDAO();
                        bookBorrowingDAO.add(bookBorrowingModel);
                    } else if (lc3 == 2) {

                        boolean u = false;
                        String strm = null;
                        int b = 0;
                        do {
                            if (b > 0) {
                                System.out.println("Không tồn tại mã này Mời nhập lại");

                            } else if (b == 0) {
                                System.out.println("NHập ID mượn sách : ");
                            }
                            strm = sc.nextLine();
                            ArrayList<String> listStr = new ArrayList<>();
                            try {

                                // Tạo Connection
                                Connection con = JDBCUtils.getConnection();
                                // Tạo Statement
                                Statement sttm = con.createStatement();
                                // Tạo câu lệnh SQL

                                String sql = "SELECT id FROM borrowing ";
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

                        BookBorrowingDAO bookBorrowingDAO = new BookBorrowingDAO();
                        bookBorrowingDAO.findById(strm);
                    } else if (lc3 == 3) {
                        BookBorrowingDAO bookBorrowingDAO = new BookBorrowingDAO();
                        bookBorrowingDAO.findAllIf();
                    } else if (lc3 == 4) {
                        boolean u = false;
                        String strm = null;
                        int b = 0;
                        do {
                            if (b > 0) {
                                System.out.println("Không tồn tại mã này Mời nhập lại");

                            } else if (b == 0) {
                                System.out.println("NHập ID mượn sách cần sửa: ");
                            }
                            strm = sc.nextLine();
                            ArrayList<String> listStr = new ArrayList<>();
                            try {

                                // Tạo Connection
                                Connection con = JDBCUtils.getConnection();
                                // Tạo Statement
                                Statement sttm = con.createStatement();
                                // Tạo câu lệnh SQL

                                String sql = "SELECT id FROM borrowing ";
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
                        BookBorrowingDAO bookBorrowingDAO = new BookBorrowingDAO();
                        bookBorrowingDAO.edit(strm);
                    }
                } while (lc3 == 1 || lc3 == 2 || lc3 == 3 || lc3 == 4);
            }
        } while (luaChon == 1 || luaChon == 2 || luaChon == 3);
    }
}
