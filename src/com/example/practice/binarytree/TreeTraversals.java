package com.example.practice.binarytree;

public class TreeTraversals {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(5);
        root.right.right.right = new BinaryTreeNode(6);
        System.out.println("Pre order");
        preOrder(root);
        System.out.println("\nIn order");
        inOrder(root);
        System.out.println("\nPost order");
        postOrder(root);
    }

    public static void preOrder(BinaryTreeNode root) {
        if(root == null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(BinaryTreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    private static void postOrder(BinaryTreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
}
