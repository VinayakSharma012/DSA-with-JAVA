package Graphs;
import java.util.*;
public class CycleinUNdirectedGraph {
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
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        //4 -> vertex
        graph[4].add(new Edge(4, 3));

    }
    
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, i, vis, -1)) {
                    return true;
                    //cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[],int curr,boolean vis[], int parent) {
        //visit
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            //case 3 - vis curr is false
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, e.dest, vis, curr)) {
                    return true; 
                }
            } else if(vis[e.dest] && e.dest != parent) { // case 1 vis curr and parent true
                return true;
            }
            //case 2 - do nothing -> continue
        }

        return false;
    }
    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
