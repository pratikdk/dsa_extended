import java.util.ArrayList;
import java.util.List;

public class A13_IsPathAtoBConnected {

    static class Graph {
        private int V;
        private List<List<Integer>> adj;
    
        public Graph (int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.adj.add(new ArrayList<>());
            }
        }
    
        public void addEdge(int u, int v) {
            adj.get(u).add(v);
        }
    
        private boolean dfsUtil(int u, boolean[] visited, int dst) {
            visited[u] = true;
            if (u == dst) {
                return true;
            }
            for (int v: adj.get(u)) {
                if (!visited[v]) {
                    if (dfsUtil(v, visited, dst) == true) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isConnected(int src, int dst) {
            boolean[] visited = new boolean[this.V];
            return dfsUtil(src, visited, dst);
        } 
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        System.out.println(g1.isConnected(0, 4));

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        System.out.println(g2.isConnected(0, 3));
    }
}
