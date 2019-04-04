package BT5;

import java.util.LinkedList;
import java.util.Queue;

class DijsktraAlgorithm {


    int minDist(int dist[], Boolean[] visited) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void dijkstra(int graph[][], int first) {

        int currentDist[] = new int[graph.length];
        Boolean visited[] = new Boolean[graph.length];
        for (int x = 0; x < graph.length; x++) {
            currentDist[x] = Integer.MAX_VALUE;
            visited[x] = false;
        }

        currentDist[first] = 0;
        Queue<Integer> toBeChecked = new LinkedList<>();
        for (int y = 0; y < graph.length; y++) {
            toBeChecked.add(currentDist[y]);

        }

        for (int c = 0; c < graph.length - 1; c++) {
            int v = minDist(currentDist, visited);

            visited[v] = true;
            for (int u = 0; u < graph.length; u++) {
                if (visited[u] == false && graph[v][u] != 0 && currentDist[v] + graph[v][u] < currentDist[u]
                        && graph[v][u] != 0) {
                    currentDist[u] = currentDist[v] + graph[v][u];
                }
            }
        }

        System.out.println("Các cạnh duyệt qua là:");

        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + " - " + currentDist[i]);
        }

    }


    public static void main(String[] args) {
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijsktraAlgorithm t = new DijsktraAlgorithm();
        t.dijkstra(graph, 0);


    }
}
