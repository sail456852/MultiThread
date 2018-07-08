package kindle.multthread.priority;

// This class tests the multi-threading priority mechanism
class Priority implements Runnable{
    static boolean stop = false; // default false turned off to stop
    static String currentThrdName;
    int count;
    Thread thrd; // seems implements Runnable you have to have a thread interface

    // Constructor
    Priority(String threadName) {
        thrd = new Thread(this, threadName); // can't add this here
        count = 0;  // set to 0 when start the thread
        currentThrdName = threadName;
    }


    @Override
    public void run() {
        System.out.println(thrd.getName() + "starting!");
        // count to 10000 and print out while running!
        do{
            count++;
            // judging the current loop method
            if(currentThrdName.compareTo(thrd.getName()) != 0){
                // if the thread is the same as the current executing thread change it
                currentThrdName = thrd.getName();
                System.out.println("In the : " + thrd.getName());
            }

        }while(count < 10000000 && stop == false);
        stop = true;  // any thread which finish the count will set the stop to true;
        System.out.println("The thread:  " + thrd.getName() + " completed!");
    }
}


class PriorityDemo{

    public static void main(String[] args) {
        // set the thread priority here then
        Priority thrd1 = new Priority("High priority");
        Priority thrd2 = new Priority("Low priority");
        // set the priority of the threads
        thrd1.thrd.setPriority(Thread.NORM_PRIORITY + 2); // priority 7
        thrd2.thrd.setPriority(Thread.NORM_PRIORITY - 2); // priority 3

        // start the threads of the same class
        thrd1.thrd.start();
        thrd2.thrd.start();

        // let the two threads waiting for the main thread to finish last
        try {
            thrd1.thrd.join();
            thrd2.thrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // show the count of each Thread
        System.out.println("The high priority thread counted to : " + thrd1.count);
        System.out.println("The low priority thread counted to : " + thrd2.count);
    }
}
