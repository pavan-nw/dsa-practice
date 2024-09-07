package com.example.practice.ds.ll;

public class Node {
    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this.next;
    }

    public void printAllNodes() {
        Node node = this;
        while (node != null) {
            System.out.print(node.data + "-->");
            node = node.next;
        }
    }
}
