import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A1_BFS_Traversal {

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
            adj.get(u).add(v);
        }
    
        public void bfsTraversal(int start) {
            boolean[] visited = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();
    
            queue.add(start);
            visited[start] = true;
    
    
            while (queue.size() != 0) {
                int u = queue.poll();
                System.out.print(u);
    
                for (int v: adj.get(u)) {
                    if (!visited[v]) {
                        queue.add(v);
                        visited[v] = true;
                    } 
                }
            }
        }
    
        public void printList() {
            System.out.println(adj);
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

        g.bfsTraversal(2);
        g.printList();
    }
}