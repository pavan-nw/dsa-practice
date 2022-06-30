package com.example.practice;

import java.util.HashSet;
import java.util.Set;

// https://www.structy.net/problems/island-count
public class CountIslands {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Number of islands is: " + countIslands(graph));
    }

    private static int countIslands(int[][] graph) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int r = 0; r < graph.length; r++) {
            for (int c = 0; c < graph[r].length; c++) {
                if (explore(graph, r, c, visited)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    private static boolean explore(int[][] graph, int row, int col, Set<String> visited) {
        boolean rowOutofBoundary = row < 0 || row >= graph.length;
        boolean colOutofBoundary = col < 0 || col >= graph[0].length;

        if(rowOutofBoundary || colOutofBoundary) return false;

        if(graph[row][col] == 0) return false;

        String pos = row + ","+ col;
        if(visited.contains(pos)) return false;

        visited.add(pos);

        explore(graph, row, col+1, visited);  // Right
        explore(graph, row+1, col, visited); // Down
        explore(graph, row, col-1, visited); // Left
        explore(graph, row-1, col, visited); // Up
//        explore(graph, row+1, col+1, visited); // Downward Right Diagonal
//        explore(graph, row+1, col-1, visited); // Downward Left Diagonal
//        explore(graph, row-1, col-1, visited); // Upward Left Diagonal
//        explore(graph, row-1, col+1, visited); // Upward Right Diagonal


        return true;
    }
}
