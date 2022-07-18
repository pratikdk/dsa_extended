import java.util.ArrayList;
import java.util.List;

public class A2_DFS_Traversal {

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
    
        private void dfsUtil(int u, boolean[] visited) {
            visited[u] = true;
            System.out.print(u);
    
            for (int v: adj.get(u)) {
                if (!visited[v]) {
                    dfsUtil(v, visited);
                }
            }
        }
    
        public void dfsTraversal(int start) {
            boolean[] visited = new boolean[this.V];
            dfsUtil(start, visited);
        }
    
        public void printList() {
            System.out.println(this.adj);
        }
    }
    

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfsTraversal(2);
        g.printList();
    }
}