package ConcurrencyPractice;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int count;

    public LockExample() {
        count = 0;
    }

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        for (int i=0; i<1000; ++i) {
            Thread thread = new Thread(lockExample::increment);
            thread.start();
        }
        // The output is 1000.
        System.out.println("Count:" + lockExample.getCount());
    }
}
