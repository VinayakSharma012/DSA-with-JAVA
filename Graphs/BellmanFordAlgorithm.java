package Graphs;
import java.util.*;
public class BellmanFordAlgorithm {
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
        graph[1].add(new Edge(1, 2, -4));

        //2 -> vertex
        graph[2].add(new Edge(2, 3, 2));

        //3 -> vertex
        graph[3].add(new Edge(3, 4, 4));

        //4 -> vertex
        graph[4].add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0;i<dist.length;i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        //algorithm
        for(int i=0;i<V-1;i++) {
            //edges
            for(int j=0;j<graph.length;j++) {
                for(int k=0;k<graph[j].size();k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    //relaxation step
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
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
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        bellmanFord(graph, src);
    }
}
//note :- we can use array of edges also to calculate shortest path //
