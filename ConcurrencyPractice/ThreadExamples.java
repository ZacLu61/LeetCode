package ConcurrencyPractice;


public class ThreadExamples {
    public static void main(String[] args) throws InterruptedException {
        // // Extends from Thread class
        // ExampleThread thread = new ExampleThread();
        // thread.start();

        // Implements Runnable interface
        ExampleRunnable runnable = new ExampleRunnable();
        Thread thread1 = new Thread(runnable);
        System.out.println("Thread 1 started.");
        thread1.start();
        thread1.join(2_000);
        System.out.println("Thread 1 finished.");


        // // Anonymous thread
        // Thread thread1 = new Thread(() -> {
        //     System.out.println("Thread 1:" + Thread.currentThread().getName());
        // });
        // thread1.start();
    }
}
