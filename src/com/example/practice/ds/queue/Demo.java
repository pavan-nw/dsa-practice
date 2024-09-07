package com.example.practice.ds.queue;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Queue Demo...");
        Queue q1 = new Queue(10);
        q1.insert(10);
        q1.insert(20);
        q1.insert(30);
        q1.displayQueue();
        q1.remove();
        q1.displayQueue();
        q1.insert(40);
        q1.insert(50);
        q1.displayQueue();
        q1.remove();
        q1.displayQueue();
    }


}
