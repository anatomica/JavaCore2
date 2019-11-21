package Lesson4.Homework;

public class Print {

    private static final Object printWait = new Object();
    private volatile char letter = 'A';
    Thread t1;
    Thread t2;
    Thread t3;

    void letterA() {
        t1 = new Thread(() -> {
            synchronized (printWait) {
                try {
                    for (int i = 0; i < 5; i++) {
                    while (letter != 'A') printWait.wait();
                    System.out.print("A");
                    letter = 'B';
                    printWait.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        t1.start();
    }

    void letterB() {
        t2 = new Thread(() -> {
            synchronized (printWait) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'B') printWait.wait();
                        System.out.print("B");
                        letter = 'C';
                        printWait.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    void letterC() {
        t3 = new Thread(() -> {
            synchronized (printWait) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'C') printWait.wait();
                        System.out.print("C" + " ");
                        letter = 'A';
                        printWait.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
    }

}