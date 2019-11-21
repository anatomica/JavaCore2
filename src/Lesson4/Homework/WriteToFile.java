package Lesson4.Homework;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public WriteToFile(String letter1, String letter2, String letter3) throws InterruptedException {

        Thread one = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    FileForWrite(letter1, i);
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        one.start();
        one.join();

        Thread two = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    FileForWrite(letter2, i);
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        two.start();
        two.join();

        Thread three = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    FileForWrite(letter3, i);
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        three.start();
        three.join();

    }

    private void FileForWrite(String words, int nums) {
        File file = new File("FileForWrite.txt");
        try (FileWriter writer = new FileWriter(file, true);) {
            writer.write(nums + words + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
