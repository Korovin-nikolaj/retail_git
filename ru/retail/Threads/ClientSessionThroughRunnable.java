package ru.retail.Threads;

public class ClientSessionThroughRunnable implements Runnable {

    SessionCounter sessionCounter;

    ClientSessionThroughRunnable(SessionCounter sessionCounter){
        this.sessionCounter = sessionCounter;
    }
    @Override
    public void run() {
        synchronized (sessionCounter) {
            ++sessionCounter.counter;
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + " finished. Counter = " + sessionCounter.counter);
        }
    }
}
