package com.udemy.demo3;

/**
 *  This uses anonymous class to implements the runnable interface. here we go
 */
public class App {
    public static void main(String[] args) {


        // create a thread on the fly
        // any class implements runnable interface will be regarded as thread class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("i = " + i);
                }
            }
        });
        t1.start();
        // main thread printing out the shit
        for (int i = 0; i < 20; i++) {
            System.out.println(" Main thread: i = " + i);
        }
    }
}
