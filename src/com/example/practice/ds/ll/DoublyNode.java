package com.example.practice.ds.ll;

public class DoublyNode {
    private int data;

    private DoublyNode previous;
    private DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public DoublyNode setNext(DoublyNode next) {
        this.next = next;
        return this.next;
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public DoublyNode setPrevious(DoublyNode previous) {
        this.previous = previous;
        return this.previous;
    }

    public void printAllNodes() {
        DoublyNode node = this;
        while (node != null) {
            System.out.print(node.data + "-->");
            node = node.next;
        }
    }

    public void printAllPreviousNodes() {
        DoublyNode node = this;
        while (node != null) {
            System.out.print(node.data + "-->");
            node = node.previous;
        }
    }
}
