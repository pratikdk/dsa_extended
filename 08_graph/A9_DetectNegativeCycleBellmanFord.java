import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Weighted
public class A9_DetectNegativeCycleBellmanFord {
    static class Graph {
        private int V;
        // private List<List<Integer>> adj;
        private List<Edge> edges;

        public Graph(int V) {
            this.V = V;
            this.edges = new ArrayList<>();
            // this.adj = new ArrayList<>();
            // for (int i = 0; i < V; i++) {
            //     this.adj.add(new ArrayList<>());
            // }
        }

        static class Edge {
            int u, v, weight;
            public Edge(int u, int v, int weight) {
                this.u = u;
                this.v = v;
                this.weight = weight;
            }
        }

        public void addEdge(int u, int v, int weight) {
            // this.adj.get(u).add(v);
            this.edges.add(new Edge(u, v, weight));
        }

        public boolean detectNegativeCycle() {
            int[] dist = new int[this.V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;

            for (int i = 0; i < this.V-1; i++) {
                for (Edge edge: this.edges) {
                    if (dist[edge.u] + edge.weight < dist[edge.v]) {
                        dist[edge.v] = dist[edge.u] + edge.weight;
                    }
                }
            }

            for (Edge edge: this.edges) {
                if (dist[edge.u] + edge.weight < dist[edge.v]) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1, -1);
        g1.addEdge(0, 2, 4);
        g1.addEdge(1, 2, 3);
        g1.addEdge(1, 3, 2);
        g1.addEdge(1, 4, 2);
        g1.addEdge(3, 2, 5);
        g1.addEdge(3, 1, 1);
        g1.addEdge(4, 3, -3);
        System.out.println(g1.detectNegativeCycle());

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1, 5);
        g2.addEdge(1, 2, -5);
        g2.addEdge(2, 0, -1);
        g2.addEdge(2, 3, 20);
        System.out.println(g2.detectNegativeCycle());
    }
}
