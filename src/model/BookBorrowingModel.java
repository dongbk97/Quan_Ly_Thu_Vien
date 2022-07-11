package model;

import java.util.ArrayList;
import java.util.Set;

public class BookBorrowingModel {
    private ReaderModel readerModel;
    private EmployeeModel employeeModel;
    private ArrayList<StateModel> stateModels;
    private String id;
    private int total;
    private String date;
    public BookBorrowingModel(ReaderModel readerModel, EmployeeModel employeeModel, String id, int total) {
        this.readerModel = readerModel;
        this.employeeModel = employeeModel;
        this.id = id;
        this.total = total;
    }

    public BookBorrowingModel() {
    }

    public BookBorrowingModel(ReaderModel readerModel, EmployeeModel employeeModel, ArrayList<StateModel> stateModels, String id, int total) {
        this.readerModel = readerModel;
        this.employeeModel = employeeModel;
        this.stateModels = stateModels;
        this.id = id;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReaderModel getReaderModel() {
        return readerModel;
    }

    public ArrayList<StateModel> getStateModels() {
        return stateModels;
    }

    public void setsStateModels(ArrayList<StateModel> stateModels) {
        this.stateModels = stateModels;
    }

    public void setReaderModel(ReaderModel readerModel) {
        this.readerModel = readerModel;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BookBorrowingModel{" +
                "readerModel=" + readerModel +
                ", id='" + id + '\'' +
                ", total=" + total +
                '}';
    }
}
