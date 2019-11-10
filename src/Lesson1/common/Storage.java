package Lesson1.common;

public interface Storage {

    void add(Object value);

    void add(Object value, int index);

    void remove(int index);

    Object get(int index);

    boolean find(Object value);

    void display();

    void sort();

    int getCurrentSize();
}