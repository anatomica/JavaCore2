package Lesson1.common;

public class CommonTest {
    public static void main(String[] args) {
//        IntTest();
//        stringTest();
        commonTest();
    }

    private static void IntTest() {
        IntStorage storage = new IntStorage(5);

        storage.add(1);
        storage.add(2);
        storage.add(3);

        System.out.println("Find 2: " + storage.find(2));

        storage.display();

        int valueLast = storage.get(storage.getCurrentSize()-1);
        System.out.println("Last value: " + valueLast);
    }

    private static void stringTest() {
        StringStorage storage = new StringStorage(5);

        storage.add("A");
        storage.add("B");
        storage.add("C");

        System.out.println("Find 2: " + storage.find("A"));

        storage.display();

        String valueLast = storage.get(storage.getCurrentSize()-1);
        System.out.println("Last value: " + valueLast);
    }

    private static void commonTest() {
        Storage strStorage = new CommonStorage(5);

        strStorage.add("A");
        strStorage.add("B");
        strStorage.add("C");
//        strStorage.add(4);

        System.out.println("Find 2: " + strStorage.find("A"));

        strStorage.display();

        String valueLast = (String) strStorage.get(strStorage.getCurrentSize()-1);
        System.out.println("Last value: " + valueLast);


        Storage intStorage = new CommonStorage(5);

        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        System.out.println("Find 2: " + intStorage.find(2));

        intStorage.display();

        intStorage = strStorage;

        int valueLast1 = (int)intStorage.get(intStorage.getCurrentSize()-1);
        System.out.println("Last value: " + valueLast);
    }


}
