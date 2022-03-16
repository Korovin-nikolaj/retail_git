package ru.retail.Threads;

public class SessionCounter {

    private static SessionCounter instance;
    public int counter;

    private SessionCounter() {
        counter = 0;
    }

    public static SessionCounter getInstance() {
        if (instance == null){
            instance = new SessionCounter();
        }
        return instance;
    }
}
