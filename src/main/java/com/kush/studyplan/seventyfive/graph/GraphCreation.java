package com.kush.studyplan.seventyfive.graph;
import java.util.*;

public class GraphCreation {
	
	// Create a graph using adjacency list with List<List<Integer>>
    public static List<ArrayList<Integer>> createGraphAdjacencyList2(int[][] edges) {
        int n = getMaxNode(edges);// we should know the total number of nodes
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src); // For undirected graph
        }
        return graph;
    }
    
    // Helper function to get the maximum node number
    private static int getMaxNode(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        return maxNode;
    }
	

    // Create a graph using an adjacency list with MAP
    public static Map<Integer, List<Integer>> createGraphAdjacencyList(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
        }
        return graph;
    }

    // Create a graph using an adjacency matrix [n*n]
    public static int[][] createGraphAdjacencyMatrix(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u][v] = 1;
            graph[v][u] = 1; // For undirected graph
        }
        return graph;
    }
    
    // Create a graph using an edge list
    public static List<int[]> createGraphEdgeList(int[][] edges) {
        List<int[]> graph = new ArrayList<>();
        for (int[] edge : edges) {
            graph.add(edge);
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};

        // Creating graph using adjacency list representation
        Map<Integer, List<Integer>> adjacencyListGraph = createGraphAdjacencyList(edges);
        System.out.println("Graph created using adjacency list: Map<Node,<Neighbors>> " + adjacencyListGraph);

        // Number of nodes in the graph
        int numNodes = 5;

        // Creating graph using adjacency matrix representation
        int[][] adjacencyMatrixGraph = createGraphAdjacencyMatrix(numNodes, edges);
        System.out.println("Graph created using adjacency matrix:");
        for (int[] row : adjacencyMatrixGraph) {
            System.out.println(Arrays.toString(row));
        }
        
     // Creating graph using edge list representation
        List<int[]> edgeListGraph = createGraphEdgeList(edges);
        System.out.println("Graph created using edge list:");
        for (int[] edge : edgeListGraph) {
            System.out.println(Arrays.toString(edge));
        }
        
        // Creating graph using adjacency list representation with List<List<Integer>>
        System.out.println("Graph created using adjacency list (List<List<Integer>>): " + createGraphAdjacencyList2(edges));

    }
}
