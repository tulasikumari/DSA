import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
// 1a

public class CheapestRouteWithTimeConstraint {
    // Edge class to represent an edge in the graph
    static class Edge {
        int source, destination, time;

        Edge(int s, int d, int t) {
            source = s;
            destination = d;
            time = t;
        }
    }

    // Node class to represent a node in the priority queue
    static class Node implements Comparable<Node> {
        int vertex, time, cost;

        Node(int v, int t, int c) {
            vertex = v;
            time = t;
            cost = c;
        }

        public int compareTo(Node n) {
            return cost - n.cost;
        }
    }

    static int findCheapestRouteWithTimeConstraint(List<Edge>[] graph, int[] charges, int source, int destination, int timeConstraint) {
        // Initialize distance array and visited array
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[graph.length];
        distance[source] = 0;

        // Initialize priority queue with source node
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0, charges[source]));

        while (!pq.isEmpty()) {
            // Remove and get the node with minimum cost
            Node node = pq.poll();
            int vertex = node.vertex;
            int time = node.time;
            int cost = node.cost;

            // Mark the node as visited
            visited[vertex] = true;

            // If the destination is reached within the time constraint, return the cost
            if (vertex == destination && time <= timeConstraint) {
                return cost;
            }

            // Traverse all the edges adjacent to the node
            for (Edge edge : graph[vertex]) {
                int neighbor = edge.destination;
                int neighborTime = time + edge.time;
                int neighborCost = cost + charges[neighbor];

                // If the neighbor is visited before with less cost, continue to next neighbor
                if (visited[neighbor] && (distance[neighbor] < neighborTime || (distance[neighbor] == neighborTime && neighborCost > charges[neighbor]))) {
                    continue;
                }

                // Update the distance and add the neighbor to the priority queue
                distance[neighbor] = neighborTime;
                pq.add(new Node(neighbor, neighborTime, neighborCost));
            }
        }

        // If the destination is not reachable within the time constraint, return -1
        return -1;
    }

    public static void main(String[] args) {
        List<Edge>[] graph = new ArrayList[6];
        for (int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 3, 2));
        graph[1].add(new Edge(1, 2, 5));
        graph[2].add(new Edge(2, 5, 5));
        graph[3].add(new Edge(3, 4, 5));
        graph[4].add(new Edge(4, 5, 6));
        int[] charges = {10, 2, 3, 25, 25, 4};

        int ans = findCheapestRouteWithTimeConstraint(graph, charges, 0, 5, 14);
        System.out.println(ans);

    }
}
