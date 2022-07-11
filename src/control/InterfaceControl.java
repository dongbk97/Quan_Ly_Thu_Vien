package control;

import model.PersonModel;

import java.text.ParseException;

public interface InterfaceControl<T> {
    T add() throws ParseException;

    void show(T t);
}
