package ConcurrencyPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedCache {
    private Map<Integer, String> cache;
    private ReentrantReadWriteLock lock;

    public SharedCache() {
        this.cache = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public String readData(Integer key) {
        lock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(Integer key, String value) {
        lock.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedCache sharedCache = new SharedCache();
        for (int i=0; i<10; ++i) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                sharedCache.writeData(finalI, finalI + "");    
            });
            thread.start();
        }

        for (int i=0; i<10; ++i) {
            System.out.println("key:" + i + " value:" + sharedCache.readData(i));
        }
    }
}
