package Graphs;
import java.util.*;
public class PrimsAlgorithm {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        //1 -> vertex
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        //2 -> vertex
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        //3 -> vertex
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return  this.cost - p2.cost; //ascending
        }
    }
    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0; //MST cost/ total min weight

        //loop
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                //neighbours
                for(int i=0;i<graph[curr.vertex].size();i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        //finalcost or minimum possible weight is
        System.out.println("Minimum possible weight or cost is : "+finalCost);
    }
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
