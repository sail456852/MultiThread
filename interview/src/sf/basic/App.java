package sf.basic;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                pong();
            }
        });
        try {
            thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.run();

        System.out.println("Ping!");
    }

    private static void pong() {
        System.out.println("Pong!");
    }
}
