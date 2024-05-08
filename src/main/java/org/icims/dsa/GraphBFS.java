package org.icims.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    static class Edge {
        int src;
        int dest;
       // int weight;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
           // this.weight=weight;
        }
    }
    //creating a graph
    private static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        //graph[0].add(new Edge(0,2));

       // graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,2));

       /* graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));*/

        //graph[2].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        /*graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));*/
    }
    //BFS
    public static void bfs(ArrayList<Edge>[] graph, int vertex,boolean visited[], int start){
        Queue<Integer> queue=new LinkedList<>();

        queue.add(start);
        while(!queue.isEmpty()){
            int curr=queue.remove();
            if(visited[curr]== false){
                System.out.print(curr+ " ");
                visited[curr]= true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertex=5;
        ArrayList<Edge> graph[] =new ArrayList[vertex];
        boolean visited[]= new boolean[vertex];
        createGraph(graph);
        for(int i=0;i<vertex;i++){
            if(visited[i] == false){
                bfs(graph,vertex,visited,i);
            }
        }

        //System.out.println();
    }


}
