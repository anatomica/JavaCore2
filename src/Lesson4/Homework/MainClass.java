package Lesson4.Homework;

import java.io.File;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Задание 4.1");
        Print print = new Print();
        print.letterA();
        print.letterB();
        print.letterC();

        print.t1.join();
        print.t2.join();
        print.t3.join();

        System.out.println("\n\n" + "Задание 4.2");
        File file = new File("FileForWrite.txt");
        System.out.println(file.canWrite());
        new WriteToFile(" строка, потока № 1", " строка, потока № 2", " строка 3 потока № 3");

        System.out.println("\n" + "Задание 4.3");
        MFU mfu = new MFU();
        mfu.printMFU();
        mfu.scanNFU();

    }
}