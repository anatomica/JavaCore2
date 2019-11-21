package Lesson4.Homework;

public class MFU {

    private static final Object printWait = new Object();
    private volatile String document = "print";
    private Thread p1;
    private Thread p2;
    private int pagePrint = 1;
    private int pageScan = 1;

    void printMFU() {
        p1 = new Thread(() -> {
            synchronized (printWait) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (!document.equals("print")) printWait.wait();
                        System.out.print("Отпечатано " + pagePrint + "\n");
                        pagePrint++;
                        document = "scan";
                        Thread.sleep(50);
                        printWait.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        p1.start();
    }

    void scanNFU() {
        p2 = new Thread(() -> {
            synchronized (printWait) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (!document.equals("scan")) printWait.wait();
                        System.out.print("Отсканировано " + pageScan + "\n");
                        pageScan++;
                        document = "print";
                        Thread.sleep(50);
                        printWait.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        p2.start();
    }

}
