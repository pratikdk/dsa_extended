import java.util.List;
import java.util.ArrayList;

public class A3_DetectCycleDirectedGraph {

    static class Graph {
        private int V;
        private List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            this.adj.get(u).add(v);
        }

        private boolean dfsUtil(int u, boolean[] visited, boolean[] recstack) {
            visited[u] = true;
            recstack[u] = true;

            for (int v: adj.get(u)) {
                if (!visited[v]) {
                    if (dfsUtil(v, visited, recstack)) {
                        return true;
                    }
                } else if (recstack[v]) {
                    return true;
                }
            }

            recstack[u] = false;
            return false;
        }

        public boolean isCyclic() {
            boolean[] visited = new boolean[this.V];
            boolean[] recstack = new boolean[this.V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (dfsUtil(i, visited, recstack)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);
        System.out.println(g1.isCyclic());

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(4, 5);
        g2.addEdge(5, 6);
        g2.addEdge(6, 3);
        System.out.println(g2.isCyclic());
    }
}
