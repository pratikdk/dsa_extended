import java.util.ArrayList;
import java.util.List;

public class A7_TopologicalSort {
    
    static class Graph {
        private int V;
        private List<List<Integer>> adj;
        private int[] indegree;

        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.adj.add(new ArrayList<>());
            }
            this.indegree = new int[this.V];
        }

        public void addEdge(int u, int v) {
            this.adj.get(u).add(v);
            indegree[v]++;
        }

        public List<Integer> topologicalSort() {
            List<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[this.V];

            while (res.size() != this.V) { 
                for (int i = 0; i < this.V; i++) {
                    if (!visited[i] && indegree[i] == 0) {
                        res.add(i);
                        visited[i] = true;
                        for (int v: adj.get(i)) {
                            indegree[v]--;
                        }
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(6, 1);
        System.out.println(g1.topologicalSort());

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 3);
        System.out.println(g2.topologicalSort());
    }
}
