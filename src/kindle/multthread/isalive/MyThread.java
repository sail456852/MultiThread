package kindle.multthread.isalive;

public class MyThread extends Thread{
    private String name; // the name of this thread
    public MyThread(String name) {
        // give the thread a new name
        super(name);
        this.name = name; // append data in this morning
        // call the start function of the inheriting class
        start();
    }

    @Override
    public void run() {
        System.out.println("MyThread.run" + name);
    }
}
