package udemy.threads4.multiLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ALL")
public class Worker {
    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    // create lock object for following threads to use
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne(){
        // put the code into a lock
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process(){
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
    //  test  last edit location
    public void main(){
        System.out.println("Starting....");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        // This actually will throws a out of ArrayIndex exception if you run enough time
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }
}
