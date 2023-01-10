package com.example.practice.tekion;


import java.util.*;

/**
 * Given a chess board of size n*m, A knight, is present at [sx, sy].
 * We are given a destination position [dx, dy].
 * We need to see if the knight can go from the starting position to the destination position,
 * if yes, then we need to return the minimum number of moves, if not return -1.
 */
public class Round1 {
    public static void main(String[] args) {
        System.out.println("Round starts...");
    }

    public int findMoves(Integer sx, Integer sy, Integer dx, Integer dy, Integer m, Integer n) {
        Queue<List<Integer>> positions = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        positions.add(Arrays.asList(sx, sy));
        List<Integer> currentPosition = null;
        while (!positions.isEmpty()) {
            List<Integer> prevPosition = currentPosition;
            String prevPos = prevPosition !=null ? prevPosition.get(0)+","+prevPosition.get(1) : "";

            currentPosition = positions.remove();
            Integer x = currentPosition.get(0);
            Integer y = currentPosition.get(1);
            String pos = x + "," + y;

            if (x.equals(dx) && y.equals(dy)) {
                return visited.getOrDefault(prevPos, -1) + 1;
            }

            Integer moveCount = visited.getOrDefault(prevPos, 0) + 1;
            boolean allowVisit = !visited.containsKey(pos) || visited.get(pos) > moveCount;
            boolean withInBoard = x > 0 && x < n && y > 0 && y < m;
            if(allowVisit && withInBoard) {
                visited.put(pos, moveCount);
                List<List<Integer>> neighbours = new ArrayList<>();
                neighbours.add(moveDown(currentPosition));
                neighbours.add(moveUp(currentPosition));
                neighbours.add(moveRight(currentPosition));
                neighbours.add(moveLeft(currentPosition));
                // There are other 4 moves possibilities
                positions.addAll(neighbours);
            }
        }
        return -1;
    }

    public List<Integer> moveDown(List<Integer> position) {
        return Arrays.asList(position.get(0)+2, position.get(1)+1);
    }

    public List<Integer> moveUp(List<Integer> position) {
        return Arrays.asList(position.get(0)-2, position.get(1)+1);
    }

    public List<Integer> moveRight(List<Integer> position) {
        return Arrays.asList(position.get(0)+1, position.get(1)+2);
    }

    public List<Integer> moveLeft(List<Integer> position) {
        return Arrays.asList(position.get(0)-1, position.get(1)+1);
    }
}
