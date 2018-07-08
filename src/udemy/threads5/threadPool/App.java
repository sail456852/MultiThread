package udemy.threads5.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;
    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting process id: " + id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed process id: " + id);
    }
}
public class App {
    // create a main function to create a thread.
    public static void main(String[] args) {
        ExecutorService  executor = Executors.newFixedThreadPool(2);
        for(int i=0; i<5; i++)
        {
            executor.submit(new Processor(i)); // create multi thread at once
        }
        executor.shutdown(); // seems turn off the thread pool immediately
        System.out.println("All tasks submitted!.");
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed!");
    }
}
