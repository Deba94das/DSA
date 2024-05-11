package org.icims.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindBridgeInGraphUsingTarjanAlg {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    //creating a graph
    private static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[1].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
       // graph[3].add(new Edge(3,5));
        
        graph[4].add(new Edge(4,3));
       // graph[4].add(new Edge(4,5));
        
        //graph[5].add(new Edge(5,3));
        //graph[5].add(new Edge(5,4));
       
    }
 
	public static void main(String[] args) {
        int vertex=5;
        ArrayList<Edge> graph[] =new ArrayList[vertex];
        
        createGraph(graph);
        getBridge(graph,vertex);
    }

	private static void getBridge(ArrayList<Edge>[] graph, int vertex) {

		int dt[]= new int[vertex];
		int low[]= new int[vertex];
		int time=0;
		boolean vis[]= new boolean[vertex];
		for(int i=0;i<vertex;i++) {
			if(!vis[i]) {
				dfsToFindBridge(graph,i,vis,dt,low,time,-1);
			}
		}
	}

	private static void dfsToFindBridge(ArrayList<Edge>[] graph, int curr, boolean[] vis, int[] dt, int[] low, int time,
			int parent) {
		vis[curr]= true;
		dt[curr]= low[curr]=++time;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			if(e.dest== parent) {
				continue;
			}else if(!vis[e.dest]) {
				dfsToFindBridge(graph, e.dest, vis, dt, low, time, curr);
				low[curr]= Math.min(low[curr], low[e.dest]);
				if(dt[curr]<low[e.dest]) {
					System.out.println("bridge is: "+curr+"----"+e.dest);
				}
			}else {
				low[curr]= Math.min(low[curr], dt[e.dest]);
			}
		}
	}

}
