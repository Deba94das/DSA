package org.icims.dsa;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindShotestPathUsingDijkstrasAlg {
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

        graph[1].add(new Edge(1,2, 1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node= node;
            this.distance= distance;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.distance-pair.distance;
        }
    }
    //time complexity will be O(E+ ElogV)
    public static void disjkstra(ArrayList<Edge>[] graph,int src,int vertex){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int distance[]= new int[vertex];
        for (int i=0; i<vertex;i++){
            if(i !=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }
        boolean visited[]= new boolean[vertex];

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]= true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u = e.src;
                    int v=e.dest;
                    if(distance[u]+e.weight< distance[v]){
                        distance[v]=distance[u]+e.weight;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        for(int i=0;i<vertex;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertex=6;
        ArrayList<Edge>[] graph =new ArrayList[vertex];
        createGraph(graph);
        disjkstra(graph,0,vertex);
    }
}
