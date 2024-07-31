package com.ecararus.algs.graph;

import java.util.*;


/**
 * Depth-First Search (DFS): Explores as far down a branch as possible before backtracking.
 * Useful for pathfinding and cycle detection.
 *
 *
 * Plan:
 * Define the DepthFirstSearch class.
 * Build a graph representation of the courses.
 * Detect cycles in the graph.
 * Perform a topological sort on the graph.
 * Check if the required courses are in the topological order.
 */
public class DfsApplication {

    public static void main(String[] args) {
        DfsApplication scheduler = new DfsApplication();
        Map<String, List<String>> courses = new HashMap<>();
        courses.put("CourseA", List.of("CourseB"));
        courses.put("CourseB", List.of("CourseC"));
        courses.put("CourseC", List.of("CourseG"));  // Circular dependency
        courses.put("CourseD", List.of("CourseB"));

        List<String> requiredCourses = List.of("CourseA", "CourseB", "CourseD");

        System.out.println(scheduler.gradCheck(courses, requiredCourses));  // Output: false
    }


    private Map<String, List<String>> buildGraph(Map<String, List<String>> courses) {
        // Step 1: Graph Representation
        // k = course name, v = list of prerequisites
        Map<String, List<String>> graph = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            graph.putIfAbsent(entry.getKey(), new ArrayList<>());
            for (String prereq : entry.getValue()) {
                graph.putIfAbsent(prereq, new ArrayList<>());
                graph.get(entry.getKey()).add(prereq);
            }
        }
        return graph;
    }

    private void cycleDetection(Map<String, List<String>> coursesGraph) {
        // cycle detection using DFS
        Set<String> visited = new HashSet<>();
        Set<String> recursion = new HashSet<>();

        for (String node : coursesGraph.keySet()) {
            if (depthFirstSearchRecursive(node, coursesGraph, visited, recursion)) {
                throw new IllegalStateException("The course graph is invalid as it contains a cycle recursion");
            }
        }
    }

    private boolean depthFirstSearchRecursive(String node, Map<String, List<String>> coursesGraph, Set<String> visited, Set<String> recursion) {
        if (recursion.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        recursion.add(node);

        for (String neighbour : coursesGraph.get(node)) {
            if (depthFirstSearchRecursive(neighbour, coursesGraph, visited, recursion)) {
                return true;
            }
        }
        recursion.remove(node);
        return false;
    }


    private List<String> topologicalSort(Map<String, List<String>> coursesGraph) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String node : coursesGraph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, coursesGraph, visited, stack);
            }
        }

        List<String> topologicalOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private void dfs(String node, Map<String, List<String>> coursesGraph, Set<String> visited, Stack<String> stack) {
        visited.add(node);
        for (String neighbour : coursesGraph.get(node)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, coursesGraph, visited, stack);
            }
        }
        stack.push(node);
    }

    private boolean gradCheck(Map<String, List<String>> courses, List<String> requiredCourses) {
        Map<String, List<String>> graph = buildGraph(courses);
        cycleDetection(graph);

        List<String> topologyOrdered = topologicalSort(graph);
        for (String course : requiredCourses) {
            if (!topologyOrdered.contains((course))) {
                return false;
            }
        }
        return true;
    }

}
