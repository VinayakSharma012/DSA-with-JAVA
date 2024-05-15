package Graphs;
import java.util.*;
public class DijkstraAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        //0 -> vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        //1 -> vertex
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        //2 -> vertex
        graph[2].add(new Edge(2, 4, 3));

        //3 -> vertex
        graph[3].add(new Edge(3, 5, 1));

        //4 -> vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return  this.path - p2.path;
        }
    }
    public static void Dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; //dist[i] -> src to i
        for(int i=0;i<graph.length;i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE; //+infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop bfs
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                //neighbours
                for(int i=0;i<graph[curr.node].size();i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt < dist[v]) { //updste distance src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        //print all source to vertices shortest distance

        for(int i=0;i<dist.length;i++) {
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        Dijkstra(graph, src);
    }
}
