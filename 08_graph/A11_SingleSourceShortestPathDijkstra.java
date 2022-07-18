import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class A11_SingleSourceShortestPathDijkstra {
    static class Graph {
        private int V;
        private List<List<Edge>> adj;

        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        static class Edge {
            int u, v, weight;
            public Edge(int u, int v, int weight) {
                this.u = u;
                this.v = v;
                this.weight = weight;
            }
        }

        static class Path {
            int prev, value, curr;
            public Path(int prev, int curr, int value) {
                this.prev = prev;
                this.value = value;
                this.curr = curr;
            }
        }

        public void addEdge(int u, int v, int weight) {
            // this.adj.get(u).add(v);
            this.adj.get(u).add(new Edge(u, v, weight));
        }

        public List<Integer> shortestPath(int src, int dst) {
            List<Path> consumedQueue = new LinkedList<>();
            PriorityQueue<Path> priorityQueue = new PriorityQueue<>(new Comparator<Path>() {
                @Override
                public int compare(Path p1, Path p2) {
                    if (p1.value < p2.value) {
                        return -1;
                    } else if (p1.value > p2.value) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            priorityQueue.add(new Path(-1, src, 0));

            while (priorityQueue.size() != 0) { 
                Path PathU = priorityQueue.poll();
                consumedQueue.add(PathU);
                if (PathU.curr == dst) {
                    break;
                }
                for (Edge edge: adj.get(PathU.curr)) {
                    priorityQueue.add(new Path(edge.u, edge.v, edge.weight));
                }
            }
            // Traceback
            List<Integer> pathString = new ArrayList<>();
            // consumedQueue.stream().forEach(p -> System.out.println(p.prev + " " + p.curr));
            int pathLen = consumedQueue.size();
            if (consumedQueue.get(pathLen-1).curr == dst) {
                Path tail = consumedQueue.get(pathLen-1);
                pathString.add(tail.curr);
                int prev = tail.prev;
                for (int i = pathLen-2; i >= 0; i--) {
                    if (consumedQueue.get(i).curr == prev) {
                        tail = consumedQueue.get(i);
                        pathString.add(tail.curr);
                        prev = tail.prev;
                    }
                }
            }   
            return pathString;
        }
    }
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1, 10);
        g1.addEdge(0, 2, 5);
        g1.addEdge(0, 3, -4);
        g1.addEdge(1, 4, 1);
        g1.addEdge(2, 4, 20);
        g1.addEdge(3, 4, 40);
        g1.addEdge(2, 1, 0);
        System.out.println(g1.shortestPath(0, 4));
    }
}
