package base.thread;

public class LambdaThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 0 new thread created!");
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 1 new thread created!");
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 2 new Thread created!")).start();

    }
}
