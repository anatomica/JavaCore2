package Lesson1.generics;
import java.io.Serializable;
import java.lang.reflect.Array;

public class StorageImpl<E extends Object & Comparable<E> & Serializable> implements IStorage<E> {

    private E[] data;
    private int currentSize;

    public StorageImpl(E[] data) {
        this.data = data;
    }

    public StorageImpl(int maxSize) {

        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void add(E value) {
        add(value, currentSize);
    }

    @Override
    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }

    @Override
    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public boolean find(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public Pair<Integer, IllegalArgumentException> indexOf(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return Pair.create(i);
            }
        }

        return new Pair<>(null, new IllegalArgumentException("невозможно найти элемент " + value));
    }


    @Override
    public void sort() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                E a = data[j];
                E b = data[j + 1];
                if (a.compareTo(b) > 0) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    private void exchange(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
