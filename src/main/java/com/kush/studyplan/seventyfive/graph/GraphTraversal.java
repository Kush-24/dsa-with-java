package com.kush.studyplan.seventyfive.graph;
import java.util.*;

class GraphTraversal {
    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list

    GraphTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Function to perform Breadth First Traversal of the graph
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int adjacentVertex : adj[currentVertex]) {
            // it will give all the direct nodes with currentVertex ( V => List<Integer> )
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.offer(adjacentVertex);
                }
            }
        }
    }
    

    // Function to perform Depth First Traversal of the graph
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        //It will gives us all the neighbors of vertex v
        for (int n : adj[v]) {
        //if the neighbor is not visited yet, visit that
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int s) {
        boolean visited[] = new boolean[V];
        DFSUtil(s, visited);
    }

    public static void main(String args[]) {
        GraphTraversal g = new GraphTraversal(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS traversal starting from vertex 2:");
        g.BFS(2);
        System.out.println("\nDFS traversal starting from vertex 2:");
        g.DFS(2);
    }
}
