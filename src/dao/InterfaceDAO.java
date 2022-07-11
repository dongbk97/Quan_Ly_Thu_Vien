package dao;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
    void add(T t);

    ArrayList<T> findByName(String str);

    void edit(String str);

    T findById(String id);

    void remove(String id);

}
