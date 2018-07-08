package kindle.multthread.join;

class MyThread implements Runnable{
    // field  has to not be a private function, or else you can't access
    Thread thrd; // add the thrd variable
    // constructor
    public MyThread(String name) {
        thrd = new Thread(this, name);
        thrd.start(); // why can't call start here
        //        start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + "start running! ");
        // count to 10 and started running and take some interval
        for (int i = 0; i < 10 ; i++) {
            System.out.println("In the" + thrd.getName() + ", the count is: " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(thrd.getName() + " interrupted");
            }
        }
        System.out.println(thrd.getName() + "terminating!");
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("main thread running!");
        // new and start a few thread instances

        MyThread m1 = new MyThread("#m1");
        MyThread m2 = new MyThread("#m2");
        MyThread m3 = new MyThread("#m3");

        try {
            m1.thrd.join();
            System.out.println("Child #1 threading running");
            m2.thrd.join();
            System.out.println("Child #2 threading running");
            m3.thrd.join();
            System.out.println("Child #3 threading running");
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted!");
        }
        System.out.println("Main thread terminating!");
    }
}
