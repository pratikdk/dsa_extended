import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Weighted
public class A10_DetectNegativeCycleFloydWarshall {
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
            Double[][] dist = new Double[this.V][this.V];
            for (int i = 0; i < this.V; i++) {
                Arrays.fill(dist[i], Double.POSITIVE_INFINITY);
                dist[i][i] = 0d;
            }

            //System.out.println(Arrays.deepToString(dist));
            for (Edge edge: edges) {
                dist[edge.u][edge.v] = (double) edge.weight;
            }
            System.out.println(Arrays.deepToString(dist));
            for (int k = 0; k < this.V; ++k) {
                for (int i = 0; i < this.V; ++i) {
                    for (int j = 0; j < this.V; ++j) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(dist));
            for (int i = 0; i < this.V; i++) {
                if (dist[i][i] < 0) {
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
