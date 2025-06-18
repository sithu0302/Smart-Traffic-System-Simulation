import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a road from one intersection to another
    public void addEdge(String from, String to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));

        // Bidirectional road
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(to).add(new Edge(from, weight));
    }

    // Display the graph structure
    public void displayGraph() {
        for (String node : adjList.keySet()) {
            System.out.print(node + " -> ");
            for (Edge e : adjList.get(node)) {
                System.out.print("[" + e.to + ", " + e.weight + "] ");
            }
            System.out.println();
        }
    }

    // Shortest path using Dijkstra's algorithm
    public void shortestPath(String start, String destination) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for (String node : adjList.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
            prev.put(node, null);
        }

        dist.put(start, 0);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Edge e : adjList.get(current.name)) {
                int newDist = current.distance + e.weight;
                if (newDist < dist.get(e.to)) {
                    dist.put(e.to, newDist);
                    prev.put(e.to, current.name);
                    pq.add(new Node(e.to, newDist));
                }
            }
        }

        // Print shortest time
        System.out.println("\nShortest time from " + start + " to " + destination + ": " + dist.get(destination));

        // Print path
        System.out.print("Path: ");
        printPath(prev, destination);
        System.out.println();
    }

    // Helper method to backtrack path
    private void printPath(Map<String, String> prev, String node) {
        if (node == null) return;
        printPath(prev, prev.get(node));
        System.out.print(node + " ");
    }

    // Inner classes
    private class Edge {
        String to;
        int weight;

        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private class Node {
        String name;
        int distance;

        public Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}
