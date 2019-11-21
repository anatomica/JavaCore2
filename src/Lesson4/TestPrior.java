package Lesson4;

public class TestPrior extends Thread
{
    public void run() {
        System.out.println(getName());
    }

    public static void main(String[] args) {
        TestPrior t1 = new TestPrior();
        TestPrior t2 = new TestPrior();

        t1.setPriority(2);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
