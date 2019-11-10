package Lesson1.common;

public class CommonStorage  implements Storage{

    private Object[] data;
    private int currentSize ;

    public CommonStorage(int size) {
        this.data = new Object[size];
    }

    public Object get(int index) {
        return data[index];
    }

    public void add(Object value) {
        add(value, currentSize);
    }

    public void add(Object value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(Object value) {
        for (int i = 0; i < currentSize; i++) {
            if (value == (data[i])) {
                return true;
            }
        }
        return false;
    }

    public void display() {
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i]);
            }
    }

    public void sort() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                Comparable a = (Comparable) data[i];
                Comparable b = (Comparable) data[j];
                if (a.compareTo(b) > 0) {
                    exchange(i, j);
                }
            }
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private void exchange(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}