import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Incorrect, Topological sort cannot resolve cyclic graphs
public class A8_AssignDirectionsToUnDirectedEdges {

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

        public void makeDirected() {
            List<Integer> sorted = topologicalSort();
            for (int u = 0; u < this.V; u++) {
                ListIterator<Integer> vIter = adj.get(u).listIterator();
                while (vIter.hasNext()) {
                    int v = vIter.next();
                    if (adj.get(v).contains(u)) {
                        if (sorted.indexOf(u) < sorted.indexOf(v)) {
                            adj.get(v).remove((Integer) u);
                        } else {
                            adj.get(u).remove((Integer) v);
                        }
                    }
                }
            }

        }

        public void printGraph() {
            System.out.println(this.adj);
        }
    }
    
    public static void main(String[] args) {
        Graph g1 = new Graph(3);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 1);
        g1.printGraph();
        g1.makeDirected();
        g1.printGraph();
    }
}
