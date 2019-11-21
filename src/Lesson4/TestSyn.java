package Lesson4;

public class TestSyn {

    public synchronized static void m1() {
        System.out.println("m1");
        for (int i = 0; i< 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized static void m2() {
        System.out.println("m1");
        for (int i = 0; i< 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class StartThread {
    public static void main(String[] args) {
        TestSyn e1 = new TestSyn();
        TestSyn e2 = new TestSyn();

        new Thread(new Runnable() {
            @Override
            public void run() {
                e1.m2();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                TestSyn.m2();
            }
        }).start();

    }
}
