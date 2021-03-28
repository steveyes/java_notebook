package basic;


public class CreateThread {
    public static void main(String[] args) {
        createThread01();
        createThread02();
        createThread03();
        createThread04();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createThread04() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-3");
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void createThread03() {
        new Thread(() -> {
            Thread.currentThread().setName("Thread-3");
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void createThread02() {
        Thread t = new Thread(new RunnableImpl2());
        t.start();
    }

    private static void createThread01() {
        Thread t = new Thread(new RunnableImpl1());
        t.start();
    }
}


class RunnableImpl2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableImpl1 extends Thread {
    public RunnableImpl1() {
    }

    public RunnableImpl1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
