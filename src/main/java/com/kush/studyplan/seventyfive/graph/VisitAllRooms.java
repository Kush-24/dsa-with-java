package com.kush.studyplan.seventyfive.graph;
import java.util.*;
/*
Intuition:
Begin with room 0, mark it as visited, and collect keys available in room 0.
Use a traversal algorithm (DFS/BFS) to explore all rooms reachable from room 0 while keeping track of visited rooms and collecting keys along the way.
If all rooms are visited at the end or there's no unvisited room reachable from the keys collected so far, return true; otherwise, return false.

Time Complexity: O(V + E), where V is the number of rooms and E is the total number of keys in all rooms. 
It involves visiting each room and collecting keys from each room.

Space Complexity: O(V), where V is the number of rooms. 
It requires space to maintain a visited array to track the visited rooms.
 */
public class VisitAllRooms {
    // DFS approach to visit all rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true; // Start from room 0
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start with room 0
        
        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            List<Integer> keys = rooms.get(currentRoom);
            
            // Collect keys and visit rooms reachable from the current room
            for (int key : keys) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        
        // Check if all rooms are visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        VisitAllRooms var = new VisitAllRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(var.canVisitAllRooms(rooms)); // Output: true
    }
}
