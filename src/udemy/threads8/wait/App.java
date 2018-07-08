package udemy.threads8.wait;

import java.util.Scanner;

class Processor{
   public void produce(){
       synchronized (this)
       {
           System.out.println("Processor.produce started");
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Processor.produce waked after being waited");
       }
   }

    public void consume() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Thread.sleep(200);
        synchronized (this)
        {
            System.out.println("Processor.consume");
            scan.nextLine();
            System.out.println("Returned key pressed. ");
            notify();
            Thread.sleep(5000);
        }
    }


}
public class App {
    final static Processor processor = new Processor();
    public static void main(String[] args) {

        // create two thread call the produce, and consume method respectively.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // start the threads defined inside this classes as fields
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
