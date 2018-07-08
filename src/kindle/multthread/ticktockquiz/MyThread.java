package kindle.multthread.ticktockquiz;

public class MyThread implements Runnable {
    Thread thrd;
    TickTock  ttOb; // Composition of the wrapper class

    public MyThread(String name, TickTock tt) {
        this.thrd = new Thread(this, name);
        ttOb = tt;  // make each instance of the wrapper compostition points to same instance of the object
        thrd.start();// when the wrapper class is instantiate
    }

    @Override
    public void run() {
        if(thrd.getName().compareTo("thread1") == 0){// string equals
            for (int i = 0; i < 5 ; i++) {
                ttOb.tick(true);// call the tick 5 times
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ttOb.tick(false);
        }else{
            for (int i = 0; i < 5 ; i++) {
                ttOb.tock(true);// call the tock 5 times
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ttOb.tock(false);
        };
    }
}
