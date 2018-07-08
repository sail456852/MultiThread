package udemy.threads9.reentrance;

public class App {
    // fields
    final Runner runner = new Runner();
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


}
