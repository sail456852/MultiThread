package kindle.multthread.ticktockquiz;
/*
to implement two functions which executes in turns
 */
public class TickTock {
    String state;   //  contains the status of virtual clock;

    //implementation of the tick function
    public synchronized void tick(boolean running)//definite if run the valid function part or not functioning part
    {
        if(!running){//
            state = "ticked";// to stop tick, need to set the common clock
            notify();// to notify any other thread waiting
            return;
        }
        System.out.print("ticked ");
        state = "ticked";
        notify(); // notify the other thread

        while(!state.equals("tocked")){
            try {
                wait(); //  wait the tock to complete
            } catch (InterruptedException e) {
                System.out.println("tick interrupted:");
            }
        }
    }

    //implementation of the tock function
    public synchronized void tock(boolean running)//definite if run the valid function part or not functioning part
    {
        if(!running){//
            state = "tocked";// to stop tick, need to set the common clock
            notify();// to notify any other thread waiting
            return;
        }
        System.out.println("tocked");
        state = "tocked";
        notify(); // notify the other thread

        while(!state.equals("ticked")){
            try {
                wait(); //  wait the tick to complete
            } catch (InterruptedException e) {
                System.out.println("tock interrupted:");
            }
        }
    }
}
