package kindle.multthread.isalive;
// testing isAlive function
public class App {
    public static void main(String[] args) {
        System.out.println("Main thread has started!");
        // these thread has already call its own thread in this constructor
        MyThread m1 = new MyThread("thread_name_1");
        MyThread m2 = new MyThread("thread_name_2");
        MyThread m3 = new MyThread("thread_name_3");


        do {
            System.out.println("...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (
                m1.isAlive() || m2.isAlive() || m3.isAlive()
                );

        System.out.println("Main thread has ended!");
    }
}
