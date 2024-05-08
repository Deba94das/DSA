package org.icims.dsa;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindShotestPathUsingBellmanFord {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight=weight;
        }
    }
    private static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2, 4));
        graph[0].add(new Edge(0,1, 2));

        graph[1].add(new Edge(1,2, -4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge>[] graph,int src,int vertex) {
        int dist[] = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < vertex - 1; k++) {
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        // detecting -ve weight cycle
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                    System.out.println("-ve weight cycle exist");
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertex=5;
        ArrayList<Edge>[] graph =new ArrayList[vertex];
        createGraph(graph);
        bellmanFord(graph,0,vertex);
       /* int value=Integer.MAX_VALUE;
        System.out.println(value+1);*/
    }
}
