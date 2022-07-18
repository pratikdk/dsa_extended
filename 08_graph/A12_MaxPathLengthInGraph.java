import java.util.ArrayList;
import java.util.List;

public class A12_MaxPathLengthInGraph {
    static class Graph {
        private int V;
        private List<List<Edge>> adj;

        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < this.V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Edge(u, v, weight));
        }

        static class Edge {
            int u, v, weight;
            public Edge(int u, int v, int weight) {
                this.u = u;
                this.v = v;
                this.weight = weight;
            }
        }

        private int dfsUtil(int u, boolean[] visited, int depth) {
            visited[u] = true;
            int max = 0;
            for (Edge edgeV: adj.get(u)) {
                if (!visited[edgeV.v]) {
                    max = Math.max(max, dfsUtil(edgeV.v, visited, depth+edgeV.weight));
                }
            }
            visited[u] = false;
            return max == 0 ? depth : max;
        }

        // Max length from single source
        public int getMaxLenFromSingleSource() {
            boolean[] visited = new boolean[this.V];
            return dfsUtil(0, visited, 0);
        }   

        // Max length from among all sources
        public int getMaxLenFromAllSources() {
            int max = Integer.MIN_VALUE;
            boolean[] visited = new boolean[this.V];
            for (int i = 0; i < this.V; i++) {
                max = Math.max(max, dfsUtil(i, visited, 0));
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1, 10);
        g1.addEdge(0, 2, 10);
        g1.addEdge(0, 3, 10);
        g1.addEdge(1, 4, 30);
        g1.addEdge(2, 4, 40);
        g1.addEdge(3, 4, 50);
        System.out.println(g1.getMaxLenFromAllSources());
    }
}
