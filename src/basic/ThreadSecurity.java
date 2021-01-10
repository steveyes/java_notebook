package basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSecurity {
    public static void main(String[] args) {
        new Ticket01().run();
        new Ticket02().run();
        new Ticket03().run();
    }
}

class Ticket03 implements Runnable {
    private int n_ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (n_ticket-- >= 0) {
            lock.lock();
            if (n_ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String name = Thread.currentThread().getName();
                System.out.println(name + " is selling:" + n_ticket);
            }
            lock.unlock();
        }
    }
}

class Ticket02 implements Runnable {
    /*synchronize method*/
    private int n_ticket = 100;

    @Override
    public void run() {
        while (n_ticket-- >= 0) {
            sellTicket();
        }

    }

    private synchronized void sellTicket() {
        if (n_ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " is selling: " + n_ticket);
        }
    }
}

class Ticket01 implements Runnable {
    /*synchronize code block*/
    private int n_ticket = 100;
    final Object lock = new Object();


    @Override
    public void run() {
        while (n_ticket-- >= 0) {
            synchronized (lock) {
                if (n_ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " is selling: " + n_ticket);
                }
            }
        }

    }

}