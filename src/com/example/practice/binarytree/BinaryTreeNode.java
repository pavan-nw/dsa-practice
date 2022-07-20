package com.example.practice.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    private void dfs(BinaryTreeNode root) {
        if(root == null)
            return;
        System.out.println(root.value);
        dfs(root.left);
        dfs(root.right);
    }

    private void dfsIterative(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.println(node.value);
            stack.push(node.left);
            stack.push(node.right);
        }
    }

    private void bfs(BinaryTreeNode root) {
        Queue<BinaryTreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()) {
            BinaryTreeNode node = qu.remove();
            if(node != null) {
                System.out.println(node.value);
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
        }
    }

    public void depthFirstSearch() {
//        dfs(this);
        dfsIterative(this);
    }

    public void breadthFirstSearch() {
        bfs(this);
    }

    public static void main(String[] args) {
        System.out.println("Running main");
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(4);
        root.left.left = new BinaryTreeNode(8);
        root.left.right = new BinaryTreeNode(9);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(19);
        root.right.right = new BinaryTreeNode(10);
//        root.depthFirstSearch();
        root.breadthFirstSearch();
    }
}
