package org.icims.dsa;

import java.util.ArrayList;

public class FindMSTUsingPrimsAlgorithm {
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
        graph[0].add(new Edge(0,2, 15));
        graph[0].add(new Edge(0,1, 10));
        graph[0].add(new Edge(0,3, 30));

        graph[1].add(new Edge(1,0, 10));
        graph[1].add(new Edge(1,3, 40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[4].add(new Edge(3,1,40));
        graph[4].add(new Edge(3,2,50));
    }
    public static void main(String[] args) {
        int vertex=4;
        ArrayList<Edge>[] graph =new ArrayList[vertex];
        createGraph(graph);

    }
}
