package Graphs;
import java.util.*;
public class KosarajusAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        //0 -> vertex
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        //1 -> vertex
        graph[1].add(new Edge(1, 0));

        //2 -> vertex
        graph[2].add(new Edge(2, 1));
        
        //3-> vertex
        graph[3].add(new Edge(3, 4));
        
    }
    
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
    
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) { 
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void DFS(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;

        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) { 
                DFS(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        //stack
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        //step2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++) {
            for(int j=0;j<graph[i].size();j++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
            }
        }

        //step3
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC -> ");
                DFS(transpose, curr, vis); // strongly conectd component
                System.out.println();
            }
        }
    }
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);
    }
}
