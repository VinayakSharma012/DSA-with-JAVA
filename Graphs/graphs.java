package Graphs;
import java.util.*;
public class graphs {
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
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        //1 -> vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2 -> vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3 -> vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        //4 -> vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //5-> vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //6-> vertex
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void BFS(ArrayList<Edge> graph[]) { 
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                BFSUtil(graph,vis);
            }
        }
    }
    public static void BFSUtil(ArrayList<Edge> graph[],boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0); //source = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) { //visit curr
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); //adding neighbours to queue
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                DFSUtil(graph,i,vis);
            }
        }

    }
    public static void DFSUtil(ArrayList<Edge> graph[],int curr,boolean vis[]) {
        //visit
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                DFSUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++) {
            Edge e = graph[src].get(i); //e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }
    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        BFS(graph);
        System.out.println();
        DFS(graph);
        System.out.println();
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
