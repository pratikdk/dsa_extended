import java.util.ArrayList;
import java.util.List;

public class A6_PrintNodeLevels {

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
    
        private void dfsUtil(int u, boolean[] visited, int level) {
            visited[u] = true;
            System.out.print(level);
    
            for (int v: adj.get(u)) {
                if (!visited[v]) {
                    dfsUtil(v, visited, level+1);
                }
            }
        }
    
        public void printNodeLevels(int start) {
            boolean[] visited = new boolean[this.V];
            dfsUtil(start, visited, 0);
        }
    
        public void printList() {
            System.out.println(this.adj);
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
        g1.printNodeLevels(2);

        System.out.println();

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.printNodeLevels(0);
    }
    
}
