package Lesson1.generics;

public interface IStorage<E extends Comparable<? super E>> {

    void add(E value);

    void add(E value, int index);

    void remove(int index);

    E get(int index);

    boolean find(E value);

    void display();

    void sort();

    int getCurrentSize();

    Pair<Integer, IllegalArgumentException> indexOf(E value);


}