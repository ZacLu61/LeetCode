package ConcurrencyPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorExamples {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i=0; i<20; ++i) {
            int index = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task " + index);
            });
        }
        executor.shutdown();
    }
}
