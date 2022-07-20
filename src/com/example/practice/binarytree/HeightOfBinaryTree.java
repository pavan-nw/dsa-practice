package com.example.practice.binarytree;

public class HeightOfBinaryTree {

    public static int height(BinaryTreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(4);
        root.left.left = new BinaryTreeNode(8);
        root.left.right = new BinaryTreeNode(9);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(19);
        root.right.right = new BinaryTreeNode(10);
        System.out.println("Height of tree is " + height(root));
    }
}
