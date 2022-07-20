package com.example.practice.binarytree;

public class CheckBST {

    public static boolean isBST(BinaryTreeNode node) {
        if (node == null)
            return true;

        /* False if left is > than node */
        if (node.left != null && node.left.value > node.value)
            return false;

        /* False if right is < than node */
        if (node.right != null && node.right.value < node.value)
            return false;

        /* False if, recursively, the left or right is not a BST */
        if (!isBST(node.left) || !isBST(node.right))
            return false;

        /* Passing all that, it's a BST */
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(5);
        root.right.right.right = new BinaryTreeNode(6);
        System.out.println("Valid BST - " + isBST(root));
    }
}
