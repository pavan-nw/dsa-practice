package com.example.practice.ds.queue;

/**
 * Queue - linear DS
 * Operation - insert, remove
 * Properties - array, size, rear (addition end), front (deletion end)
 */
// First in first out
public class Queue {

    private int[] arr;

    private int size;

    private int rear; // To keep track where to insert

    private int front; // To keep track where to remove

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        rear = front = -1;
    }

    // size = 10
    //  front(1)  rear(1)
    //       20
    //     0  1  2  3  4  5  6  7  8  9

    /**
     * Inserting an element into Queue - rear end
     * @param element
     */
    public void insert(int element) {
        if(isFull()) {
            System.out.println("Queue is full, can't be inserted");
        } else {
            if(front == -1) {
                front = 0;
            }
            ++rear;
            arr[rear] = element;
        }
    }

    private boolean isFull() {
        return front == 0 && rear == size-1;
    }

    /**
     * Removing an element from the queue - front end
     * @return
     */
    public int remove() {
        if(isEmpty()) {
            System.out.println("Queue is empty, can't remove");
            System.exit(1);
            return -1;
        } else {
            int removedElement = arr[front];
            if(front == rear) { // there is only one element
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return removedElement;
        }
    }

    private boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void displayQueue() {
        System.out.println("----Queue-----");
        for (int i = front; i <= rear ; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Front element (Deletion) : " + arr[front]);
        System.out.println("Rear element (Insertion) : " + arr[rear]);
        System.out.println("----Queue-----");
    }
}
