package ConcurrencyPractice;

import java.lang.Thread;

public class ExampleRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ExampleRunnable name:" + Thread.currentThread().getName());
    }
}
