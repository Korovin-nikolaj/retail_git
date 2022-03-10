package ru.retail.Threads;

import java.util.Random;

public class ClientSession extends Thread {

    public ClientSession(String threadName){
        super(threadName);

    }

    public void run(){
        System.out.println(currentThread().getName() + " started.");
        Random rand = new Random();
        try{
            Thread.sleep(rand.nextInt(1000));
            if (ThredsRun.getProduct()!= null){
                ThredsRun.setProduct(null);
                System.out.println(currentThread().getName() + " captured product.");
            }
        }catch (InterruptedException e){
            System.out.println("Thread has been interrupted.");
        }
        System.out.println(currentThread().getName() + " finished.");
    }
}
