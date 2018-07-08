package udemy.threads7.producer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App{
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void producer()throws InterruptedException{
        // put the value into the queue as fast as possible
        while(true)
        {
            // add 1 to 10 into the queue
            queue.put(new Random().nextInt(10));
        }
    }

    public static void consumer(){
        // get the data out of the queue every 0.1 s
        while(true)
        {
            try {
                // take it out
                Thread.sleep(100);
                int value = queue.take();
                System.out.println("Taken value " + value + "; Queue size is: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
