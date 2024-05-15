package Graphs;
import java.util.*;
public class KahnsAlgorithm {
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

        //2 -> vertex
        graph[2].add(new Edge(2, 3));
        
        //3 -> vertex
        graph[3].add(new Edge(3, 1));

        //4 -> vertex
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        

        //5-> vertex
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        
    }
    public static void calculateInDegree(ArrayList<Edge> graph[], int inDegree[]) {
        for(int i=0;i<graph.length;i++) {
            int vertex = i;
            for(int j=0;j<graph[vertex].size();j++) {
                Edge e = graph[vertex].get(j);
                inDegree[e.dest]++;
            }
        }
    }
    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calculateInDegree(graph, inDegree);

        for(int i=0;i<inDegree.length;i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" "); //topological sort printinh

            for(int i=0;i<graph[curr].size();i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                
                if(inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSortBFS(graph);
    }
}
