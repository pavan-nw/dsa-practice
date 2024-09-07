package com.example.practice.ds.stack;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Stack example");
        Stack stack1 = new Stack(10);
        stack1.push(100);
        stack1.push(300);
        stack1.push(400);
        stack1.push(200);
        System.out.println("Initial stack");
        stack1.displayStack();
        stack1.pop(); // 200
        System.out.println("after poping once");
        stack1.displayStack();
        stack1.push(600);
        System.out.println("after pushing 600");
        stack1.displayStack();
        stack1.pop();
        stack1.pop();
        System.out.println("after poping twice");
        stack1.displayStack();

    }

}
