package basic;

/*
 * NEW - Thread has not yet started.
 * RUNNABLE - Thread is currently running without blocking/waiting in its run method.
 * BLOCKED - Thread is blocked from entering a synchronized block/method, waiting for the monitor lock to be released by the other thread.
 * WAITING - Thread is waiting due to one of these calls: Object.wait(), Thread.join() or LockSupport.park()
 * TIMED_WAITING - Thread is waiting due to one of these timeout based method calls: Thread.sleep(long millis), Object.wait(long millis),
 *      Thread.join(long millis), LockSupport.partNanos(Object blocker, long nanos) or LockSupport.partUntil(Object blocker, long nanos)
 * TERMINATED - A thread has exited from its run() method.
 *
 * Note that, using Thread.getState() is not very reliable to make decisions in controlling the threads.
 * It should only be used for testing, monitoring or debugging purpose.
 *
 */

public class ThreadStates {
    public static void main(String[] args) {
        // task01
        MyTask01 t1 = new MyTask01();
        t1.setName("Thread1");
        printLifeCycle(t1);

        // task02
        MyTask02 t2 = new MyTask02();
        t2.setName("Thread2");
        printLifeCycle(t2);

        // task03
        MyTask03 t3 = new MyTask03();
        t3.setName("Thread3");
        printLifeCycle(t3);
        synchronized (ThreadStates.class) {
            ThreadStates.class.notifyAll();
        }

        // task04
        new Thread(() -> {
            //acquiring lock on ThreadStates.class object
            synchronized (ThreadStates.class) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        MyTask04 t4 = new MyTask04();
        t4.setName("Thread4");
        printLifeCycle(t4);

    }

    static void printLifeCycle(Thread t) {
        printState("thread before start()", t);
        t.start();
        printState("thread start() called", t);
        printState("main thread sleeping for 1/2 sec", t);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printState("main thread woke up", t);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> printState("shutting down", t)));
    }


    static void printState(String msg, Thread t) {
        System.out.printf("%s - %s state: %s%n", msg, t.getName(), t.getState());
    }

    private static class MyTask01 extends Thread {
        /*
         * Examples of:
         * NEW
         * RUNNABLE
         * TERMINATED
         */
        @Override
        public void run() {
            printState("thread run() started", this);
            for (int i = 0; i < 100; i++) {
                Math.random();
            }
            printState("thread is finishing", this);
        }
    }

    private static class MyTask02 extends Thread {
        /*
         * Example of:
         * TIMED_WAITING
         */
        @Override
        public void run() {
            printState("thread run() started", this);
            try {
                //this will put the thread in TIMED_WAITING state
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printState("thread is finishing", this);
        }
    }

    private static class MyTask03 extends Thread {
        /*
         * Example of:
         * WAITING
         */
        @Override
        public void run() {
            printState("thread run() started", this);
            synchronized (ThreadStates.class) {
                try {
                    //this will put the thread in WAITING state
                    ThreadStates.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printState("thread is finishing", this);
        }
    }

    private static class MyTask04 extends Thread {
        /*
         * Example of:
         * BLOCKED
         */
        @Override
        public void run() {
            printState("attempting to enter synchronized block", this);
            synchronized (ThreadStates.class) {
                printState("enter synchronized block", this);
                // do something
            }
            printState("thread is finishing", this);
        }
    }
}






