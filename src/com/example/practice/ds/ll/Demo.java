package com.example.practice.ds.ll;

public class Demo {
    public static void main(String[] args) {
        createSinglyLL();
        System.out.println("\n----");
        createDoublyLL();
    }

    private static void createSinglyLL() {
        // create LL
        Node head = new Node(100);
        Node secNode = new Node(200);
        Node thirdNode = new Node(300);
        Node fourthNode = new Node(400);
        Node fifthNode = new Node(500);

        head.setNext(secNode).setNext(thirdNode).setNext(fourthNode).setNext(fifthNode);

        head.printAllNodes();
    }

    private static void createDoublyLL() {

        DoublyNode head = new DoublyNode(100);
        DoublyNode secNode = new DoublyNode(200);
        DoublyNode thirdNode = new DoublyNode(300);
        DoublyNode fourthNode = new DoublyNode(400);
        DoublyNode fifthNode = new DoublyNode(500);

        head.setNext(secNode).setNext(thirdNode).setNext(fourthNode).setNext(fifthNode);
        fifthNode.setPrevious(fourthNode).setPrevious(thirdNode).setPrevious(secNode).setPrevious(head);

//        head.printAllNodes();
        fifthNode.printAllPreviousNodes();
    }

    private static void reverseLL(Node head) {

        if (head == null) {
            return;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

         //     curr
         // 1 -> 2 -> 3 -> 4 ======> (head) 4 -> 3 -> 2 -> 1 -> null
         //  null <- 1 <- 2 <- 3 <- 4 (head)
        while(current != null) {
            next = current.getNext(); // 3
            current.setNext(prev);
            prev = current; // prev = 2
            current = next; // curr = 3
        }
        head = prev;
    }

    private static boolean hasCycle(Node head) {
        if(head == null) return false;

        Node slow = head;
        Node fast = head.getNext();
        // 1->2->3->4->5
        // slow = 1
        // fast = 2
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == null || fast == null) {
                return false;
            }
        }
        return true;
    }

    // insert the element into specific position
    // 1 2 3 4 5 6 -> insert element after 4
    // - search for 4
    // - store 4's next into temp
    // - create node and set 4's next to new node
    // - new node's next should be temp

    /**
     * Find linked list intersection point   => Y shaped =>
     * head1 -> 1 -> 2 -> 3 -> 4 ->5
     * head2 -> -1 -> 3 -> 4 -> 5
     */



}
