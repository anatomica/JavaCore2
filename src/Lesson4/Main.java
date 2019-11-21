package Lesson4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//	MyThread t1 = new MyThread();
//	t1.start();
//
//	Thread t2 = new Thread(new MyRunnableClass());
//	t2.start();
//
//	new Thread (new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("start!");
//        }
//    }).start();

        MyThread t1 = new MyThread();
        t1.start();

//        t1.join();

        while (true) {
            if (!t1.isAlive());
            break;
        }

        System.out.println("END!");




    }
}

class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}