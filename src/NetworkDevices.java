//1b

import java.util.*;

public class NetworkDevices {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0,1}, {0,2}, {1,3}, {1,6}, {2,4}, {4,6}, {4,5}, {5,7}};
        int startDevice = 0;
        int targetDevice = 4;
        List<Integer> impactedDevices = getImpactedDevices(edges, startDevice, targetDevice, n);
        System.out.println("Impacted Devices: " + impactedDevices);
    }

    public static List<Integer> getImpactedDevices(int[][] edges, int startDevice, int targetDevice, int n) {
        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(edges);
        Set<Integer> visited = new HashSet<>();
        visited.add(targetDevice);
        List<Integer> impactedDevices = new ArrayList<>();
        dfs(adjacencyList, visited, startDevice, impactedDevices);
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                impactedDevices.add(i);
            }
        }
        return impactedDevices;
    }

    private static Map<Integer, List<Integer>> buildAdjacencyList(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjacencyList.containsKey(from)) {
                adjacencyList.put(from, new ArrayList<>());
            }
            if (!adjacencyList.containsKey(to)) {
                adjacencyList.put(to, new ArrayList<>());
            }
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }
        return adjacencyList;
    }

    private static void dfs(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited, int current, List<Integer> impactedDevices) {
        visited.add(current);
        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(adjacencyList, visited, neighbor, impactedDevices);
            }
        }
    }
}

