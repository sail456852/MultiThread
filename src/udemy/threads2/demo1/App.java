package udemy.threads2.demo1;
/**
 * In most scenario, one thread doesn't expect other thread to modify its data.
 * but it's possible to do so, by add a keyword volatile before the var you wanna change by another thread.
 */

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running = true;

    @Override
    public void run() {
        while(running)
        {
            System.out.println("Hello ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running = false;
    }
}
public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();
        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }

}
