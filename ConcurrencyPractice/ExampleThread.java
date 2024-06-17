import java.lang.Thread;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread name:" + Thread.currentThread().getName());
        }
    }
}