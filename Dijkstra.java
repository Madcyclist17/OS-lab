import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    
    // A utility method to find the vertex with the minimum distance value
    // that hasn't been processed yet.
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    // Method to find the shortest path using Dijkstra's algorithm
    public static void dijkstra(int graph[][], int src) {
        int V = graph.length; // Number of vertices in the graph
        int[] dist = new int[V]; // Distance array to store the shortest path from src
        
        // Priority Queue to select the vertex with the minimum distance
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // Initialize distances as infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance from source to itself is 0
        
        // Add the source node to the priority queue
        pq.add(new Node(src, 0));
        
        while (!pq.isEmpty()) {
            // Extract the node with the minimum distance
            Node node = pq.poll();
            int u = node.vertex;
            
            // Traverse all the adjacent vertices of the current node
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0) { // If there is an edge between u and v
                    // Calculate the new distance to the adjacent vertex v
                    int newDist = dist[u] + graph[u][v];
                    
                    // If a shorter path to v is found, update its distance and add it to the queue
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }
        
        // Print the shortest distances from the source to each vertex
        System.out.println("Shortest distances from source vertex " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + ": No path");
            } else {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        // Example graph (adjacency matrix representation)
        int[][] graph = {
            {0, 10, 0, 0, 0, 0},
            {10, 0, 20, 0, 0, 0},
            {0, 20, 0, 10, 0, 0},
            {0, 0, 10, 0, 30, 0},
            {0, 0, 0, 30, 0, 50},
            {0, 0, 0, 0, 50, 0}
        };
        
        // Run Dijkstra's algorithm from source vertex 0
        dijkstra(graph, 0);
    }
}

