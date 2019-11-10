package Lesson1.Homework;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericClass <E extends Object & Comparable<E>> {

    private E[] obj;
    private int currentSize;

    GenericClass(E[] obj) {
        this.obj = obj;
    }

    public void add(E value) {
        add(value, currentSize);
    }

    public void add(E value, int index) {
        obj[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        obj[index] = null;
        currentSize--;
    }

    public void sort() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                E a = obj[j];
                E b = obj[j + 1];
                if (a.compareTo(b) > 0) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    void exchange(int i, int j) {
        E temp = obj[i];
        obj[i] = obj[j];
        obj[j] = temp;
    }

    ArrayList<E> createArrayList() {
        ArrayList<E> arrayList = new ArrayList<E>(Arrays.asList(obj));
        System.out.println(arrayList);
        return arrayList;
    }

    public void display() {
        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i] + " ");
        }
        System.out.println();
    }

}
