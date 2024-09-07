package com.example.practice.ds.stack;

/**
 * Stack is Linear DS
 * Operations -> push and pop
 * Properties -> array, top, size
 */
public class Stack {

    private int[] arr; // storing elements in stack
    private int top; // index of top element in a stack
    private int size; // size of the array

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    /**
     * Adding element into stack
     * @param element
     */
    public void push(int element) {
        if(isFull()) {
            System.out.println("Stack is full, element can't be pushed");
        } else {
            arr[++top] = element;
        }
    }

    private boolean isFull() {
        return top == size;
    }


    /**
     * Taking out an element from stack
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty, element can't be poped");
            System.exit(1);
            return -1;
        } else {
            int ele = arr[top];
            top--;
            return ele;
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void displayStack() {
        System.out.println("----Stack-----");
        for(int i=top;i>=0;i--) {
            System.out.println(arr[i]); // top element is printed first
        }
        System.out.println("--------------");
    }
}
