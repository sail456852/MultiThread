package udemy.threads6.latch;

import java.util.concurrent.CountDownLatch;
class Processor implements  Runnable{
    private CountDownLatch latch;
    public Processor(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        System.out.println();

    }
}
public class App {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        // when // to do
    }
}
