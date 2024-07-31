package com.ecararus.algs.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Depth-First Search (DFS): Explores as far down a branch as possible before backtracking.
 * Useful for pathfinding and cycle detection.
 *
 *
 * Plan:
 * Define the DepthFirstSearch class.
 * Add a constructor to initialize the graph and visited array.
 * Implement the dfs method to perform the depth-first search.
 * Add a helper method dfsUtil to recursively visit nodes.
 */
public class DepthFirstSearch {

    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;

    public DepthFirstSearch(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.visited = new boolean[graph.size()];
    }

    public void dfs(int startNode) {
        dfsUtil(startNode);
    }

    private void dfsUtil(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor);
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

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(0);
    }

}
