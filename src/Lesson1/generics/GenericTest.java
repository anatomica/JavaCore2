package Lesson1.generics;

import java.time.LocalDate;

public class GenericTest {

    public static void main(String[] args) {

        IStorage<String> strStorage = new StorageImpl<>(5);

//        strStorage.add("A");
//        strStorage.add("B");
//        strStorage.add("C");
//        strStorage.add(4);
//        System.out.println("Find 2: " + strStorage.find("A"));
//        strStorage.display();
//        String valueLast = strStorage.get(strStorage.getCurrentSize()-1);
//        System.out.println("Last value: " + valueLast);

        IStorage<Integer> intStorage = new StorageImpl<>(5);

        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(4);

        System.out.println("Find 2: " + intStorage.find(2));
        intStorage.display();

//        intStorage = strStorage;

        int valueLast1 = intStorage.get(intStorage.getCurrentSize()-1);
        System.out.println("Last value: " + valueLast1);

        Pair <Integer, IllegalArgumentException> pair = intStorage.indexOf(4);
        if (pair.hasError()) {
            throw pair.getError();
        }
        else {
            System.out.println("Index for 4 is " + pair.getValue());
        }

        IStorage <LocalDate> dateStorage = new StorageImpl(3);
        dateStorage.add(LocalDate.now());
        dateStorage.add(LocalDate.ofYearDay(2019, 20));
        dateStorage.display();
        dateStorage.sort();
        dateStorage.display();
    }
}
