package Lesson1.common;

public class StringStorage {

    private String[] data;
    private int currentSize ;

    public StringStorage(int size) {
        this.data = new String[size];
    }

    public String get(int index) {
        return data[index];
    }

    public void add(String value) {
        add(value, currentSize);
    }

    public void add(String value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(String value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals (data[i])) {
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
                String a = data[i];
                String b = data[j];
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
        String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}