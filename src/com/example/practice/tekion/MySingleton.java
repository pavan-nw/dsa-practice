package com.example.practice.tekion;

public class MySingleton {
    private static MySingleton instance = null;
    private MySingleton() {
    }
    public static MySingleton getInstance() {
        synchronized(MySingleton.class) {
            if(instance == null) {
                instance = new MySingleton();
            }
        }
        return instance;
    }
}
