package kindle.multthread.ticktockquiz;


// the entrance
public class ThreadCom { public static void main(String[] args) {
        TickTock ttOb = new TickTock();
        MyThread mt1 = new MyThread("thread1", ttOb);
        MyThread mt2 = new MyThread("thread2", ttOb);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("ThreadCom.main, interrupted!");
        }
        System.out.println("ThreadCom.main finished normally!");
    }
}
