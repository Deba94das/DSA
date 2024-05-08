package org.icims.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDFS {
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
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    //DFS- Time complexity= O(V+E(vertex+edge))
    public static void dfs(ArrayList<Edge>[] graph, int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]= true;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e=graph[curr].get(i);
            if(visited[e.dest] == false)
            dfs(graph,e.dest,visited);
        }
    }

    //print all path- O(V*V)
    public static void printAllPath(ArrayList<Edge>[] graph, boolean visited[],int curr, String path,int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(visited[e.dest] == false){
                visited[curr] = true;
                printAllPath(graph,visited,e.dest,path+" "+e.dest,target);
                visited[curr] =false;
            }
        }
    }



    public static void main(String[] args) {
        int vertex=7;
        ArrayList<Edge> graph[] =new ArrayList[vertex];
        boolean visited[]= new boolean[vertex];
        createGraph(graph);
       /* for(int i=0;i<vertex;i++){
            if(visited[i] == false){
                dfs(graph,i,visited);
            }
        }*/
        int src=0, target=5;
        printAllPath(graph,visited,src,"0",target);

        //System.out.println();
    }


}
