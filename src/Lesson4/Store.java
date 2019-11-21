package Lesson4;

public class Store {
    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }

    public synchronized void set() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }
}

class Producer implements Runnable {

    private Store store;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.set();
        }
    }
}

class Consumer implements Runnable {
    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}


class MainShop {
    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}