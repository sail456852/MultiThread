package kindle.multthread.thread;

/**
 *  here we demonstrate the extending multi-thread way
 */
@SuppressWarnings("ALL")
public class UseMultiThread {
    public static void main(String[] args) {
        // create a new sub thread using the class defined below.
        // This thread will start once it being created, because the constructor says that
        MyThread mt = new MyThread("Child #1");

        // Now the let's created another main thread which also print out some shits
        for (int i = 0; i < 50; i++) {
            // also print out some shit
            System.out.println("."); // print out .. indicate main thread is executing
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("main thread interrupted!");
            }
        }
        System.out.println("Main thread terminating!");
    }

}


@SuppressWarnings("ALL")
class MyThread extends Thread {

    // constructor to create a new thrd
    public MyThread(String name) {
        // create a thread using the name passed in
        super(name); // Thread constructor
        // start the thread
        start();
    }


    @Override
    public void run() {
        // to call getName() directly, because we are in the subclass of the Thread class
        for (int i = 0; i < 100; i++) {
            System.out.println("current number is  i = " + i + " printed by " + getName());
            // sleep the child thread for 400 milliseconds
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Child Thread interrupted!");
            }
        }
        System.out.println("Child Thread terminating!");
    }
}
