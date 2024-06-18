package ConcurrencyPractice;

import java.lang.Thread;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name:" + Thread.currentThread().getName());
    }
}