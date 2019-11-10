package Lesson1.common;

public class IntStorage {

    private int[] data;
    private int currentSize ;

    public IntStorage(int size) {
        this.data = new int[size];
    }

    public int get(int index) {
        return data[index];
    }

    public void add(int value) {
        add(value, currentSize);
    }

    public void add(int value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = 0;
        currentSize--;
    }

    public boolean find(int value) {
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
                int a = data[i];
                int b = data[j];
                if (a > b) {
                    exchange(i, j);
                }
            }
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private void exchange(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}