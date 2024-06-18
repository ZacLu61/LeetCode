package ConcurrencyPractice;

public class RaceConditionsExample {
    public static void main(String[] args) {
        Increment increment = new Increment();
        for (int i=0; i<1000; ++i) {
            Thread thread = new Thread(increment::increment);
            thread.start();
        }
        // The output is less than 1000 sometime due to race condition.
        System.out.println("Count:" + increment.getCount());
    }
}

class Increment {
    private int count;

    public Increment() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}