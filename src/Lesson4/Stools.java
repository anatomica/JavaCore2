package Lesson4;

class Game {
  Object stool1 = new Object();
  Object stool2 = new Object();

  public static void main(String[] args) {
      Game game = new Game();
      game.startThread();
  }

  void startThread() {
      Thread Человек1 = new Thread(new Runnable() {
          @Override
          public void run() {
              System.out.println("Человек1 подошел к stool1");

              synchronized (stool1) {
                  System.out.println("Человек1 сел на stool1");

                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  System.out.println("Человек1 встал со stool1");
              }

          }
      });

      Человек1.start();

      Thread Человек2 = new Thread(new Runnable() {
          @Override
          public void run() {
              System.out.println("Человек2 подошел к stool1");

              synchronized (stool1) {
                  System.out.println("Человек2 сел на stool1");

                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  System.out.println("Человек2 встал со stool1");
              }

          }
      });
      Человек2.start();

      Thread Человек3 = new Thread(new Runnable() {
          @Override
          public void run() {
              System.out.println("Человек3 подошел к stool2");

              synchronized (stool2) {
                  System.out.println("Человек3 сел на stool2");

                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  System.out.println("Человек3 встал со stool2");
              }

          }
      });
      Человек3.start();
  }
}
