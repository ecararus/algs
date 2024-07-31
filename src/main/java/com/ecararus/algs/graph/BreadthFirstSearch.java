package com.ecararus.algs.graph;

import java.util.*;

/**
 * Breadth-First Search (BFS): Explores all neighbors at the present depth prior to moving on to nodes at the next depth level.
 * Useful for finding the shortest path in unweighted graphs.
 *
 * Plan:
 * Define the BreadthFirstSearch class.
 * Add a constructor to initialize the graph and visited array.
 * Implement the bfs method to perform the breadth-first search.
 */
public class BreadthFirstSearch {

    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;

    public BreadthFirstSearch(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.visited = new boolean[graph.size()];
    }

    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 4));
        graph.put(4, Arrays.asList(1, 2, 3));

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        bfs.bfs(0);
    }
}
