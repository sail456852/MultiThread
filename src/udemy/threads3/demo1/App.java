package udemy.threads3.demo1;

public class App {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }
    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public void doWork(){
       Thread t1 = new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 10000 ; i++) {
                   increment();
               }
           }
       });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000 ; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        // call the join() to let main thread wait for the Child thread to finish
        // now the two thread are not modifying the same thread yet
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
}
