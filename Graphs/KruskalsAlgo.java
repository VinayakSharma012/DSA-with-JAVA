package Graphs;
import java.util.*;
public class KruskalsAlgo {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge p2) {
            return  this.wt - p2.wt; //ascending
        }
    }
    static void createGraph(ArrayList<Edge> edges) {
        
        //0 -> vertex
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
       

    }

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0;i<n;i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]); //path compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA; // A become parent of B
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int MSTcost = 0;
        int count = 0;

        for(int i=0;count<V-1;i++) { //for optimization count < v-1 used
            Edge e = edges.get(i);
            //(src,dest,wt)

            int parA = find(e.src); //src = a
            int parB = find(e.dest); //dest = b

            if(parA != parB) {
                union(e.src, e.dest);
                MSTcost += e.wt;
                count++;
            }
        }
        System.out.println(MSTcost);
    }
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
