package com.example.practice;

import java.util.HashSet;
import java.util.Set;

// https://www.structy.net/problems/island-count
public class LargestIsland {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Largest island is: " + largestIsland(graph));
    }


    private static int largestIsland(int[][] graph) {
        int largest = 0;
        Set<String> visited = new HashSet<>();
        Set<String> largestIsland = new HashSet<>();
        for (int r = 0; r < graph.length; r++) {
            for (int c = 0; c < graph[r].length; c++) {
                Set<String> island = new HashSet<>();
                int size = explore(graph, r, c, visited, island);
                if (size > largest) {
                    largest = size;
                    largestIsland = island;
                }
            }
        }
        largestIsland.forEach(p -> System.out.print("["+p+"]"));
        return largest;
    }

    private static int explore(int[][] graph, int row, int col, Set<String> island, Set<String> visited) {
        boolean rowOutofBoundary = row < 0 || row >= graph.length;
        boolean colOutofBoundary = col < 0 || col >= graph[0].length;

        if(rowOutofBoundary || colOutofBoundary) return 0;

        if(graph[row][col] == 0) return 0;

        String pos = row + ","+ col;
        if(visited.contains(pos)) return 0;

        visited.add(pos);
        island.add(pos);
        int size = 1;

        size += explore(graph, row, col+1, visited, visited);  // Right
        size += explore(graph, row+1, col, visited, visited); // Down
        size += explore(graph, row, col-1, visited, visited); // Left
        size += explore(graph, row-1, col, visited, visited); // Up
//        explore(graph, row+1, col+1, visited); // Downward Right Diagonal
//        explore(graph, row+1, col-1, visited); // Downward Left Diagonal
//        explore(graph, row-1, col-1, visited); // Upward Left Diagonal
//        explore(graph, row-1, col+1, visited); // Upward Right Diagonal


        return size;
    }
}
