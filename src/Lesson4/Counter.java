package Lesson4;

public class Counter {
    private int c;
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    public synchronized void dec() {
        c--;
    }
    public synchronized void inc() {
        c++;
    }
    public Counter() {
        this.c = 0;
    }
}

class CounterMain {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                   c.inc();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    c.dec();
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println(c.getC());

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(c.getC());
    }
}