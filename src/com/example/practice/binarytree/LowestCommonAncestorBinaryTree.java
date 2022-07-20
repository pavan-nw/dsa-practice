package com.example.practice.binarytree;

public class LowestCommonAncestorBinaryTree {

    public static BinaryTreeNode lca(BinaryTreeNode root, int v1, int v2) {
        if(root == null) return null;
        if(root.value > v1 && root.value > v2) return lca(root.left, v1, v2);
        if(root.value < v1 && root.value < v2) return lca(root.right, v1, v2);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(5);
        root.right.right.right = new BinaryTreeNode(6);
        System.out.println("LCA of tree is " + lca(root, 3, 6));
    }
}
