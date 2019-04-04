package BT5;

class MST {
    // So dinh cua do thi
    private static final int V = 5;

    // Tim dinh voi trong so nho
    int minKey(int key[], Boolean mstSet[]) {
        // Gia tri nho nhat
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // De in cau truc MST duoc luu trong mang
    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" +
                    graph[i][parent[i]]);
    }

    // Xay dung va in MST cho mot do thi trinh bay bang ma tran ke
    void primMST(int graph[][]) {
        int parent[] = new int[V];

        int key[] = new int[V];

        Boolean mstSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            // Them dinh duoc chon vao MST
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // In ra cau truc cua MST
        printMST(parent, V, graph);
    }

    public static void main(String[] args) {
        MST t = new MST();
        int graph[][] = new int[][]{{0, 3, 0, 7, 0},
                {3, 0, 4, 9, 6},
                {0, 4, 0, 0, 8},
                {7, 9, 0, 0, 10},
                {0, 6, 8, 10, 0}};

        // Print the solution
        t.primMST(graph);
    }
}



