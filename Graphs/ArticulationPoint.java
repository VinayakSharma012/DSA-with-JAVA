package Graphs;
import java.util.*;
public class ArticulationPoint {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        //1 -> vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        //2 -> vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        //3 -> vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));


        //4 -> vertex
        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[],
    boolean vis[], boolean ap[], int time) {
        vis[curr] = true;
        int disChildren = 0;
        dt[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == par) {
                continue;
            } else if(vis[neigh]) { //backedge
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else { //not visited children
                dfs(graph, neigh, curr, dt, low, vis, ap, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                disChildren++;
            }

            if(par == -1 && disChildren > 1) {
                ap[curr] = true;
            }
        }
    }
   
    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs(graph,i,-1,dt,low,vis,ap,time);
            }
        }

        //print AP 
        for(int i=0;i<V;i++) {
            if(ap[i]) {
                System.out.println("AP : "+i);
            }
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}
