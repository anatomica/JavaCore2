package Lesson4;

public class ThreadTest {

    private volatile static Integer n = new Integer(300);

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (n) {
                n++;
                System.out.println(n);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (n) {
                n++;

                System.out.println(n);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    n++;

                    System.out.println(n);

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
