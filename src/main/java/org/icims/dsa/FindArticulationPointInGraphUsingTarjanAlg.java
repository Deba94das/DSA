package org.icims.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindArticulationPointInGraphUsingTarjanAlg {
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
        
        graph[4].add(new Edge(4,3));
       
    }
    private static void getArticulationPoints(ArrayList<Edge>[] graph, int vertex) {
    	int dt[]= new int[vertex];
    	int low[]= new int[vertex];
    	int time=0;
    	boolean visited[]= new boolean[vertex];
    	boolean articulationPoint[]= new boolean[vertex];
    	for(int i=0;i<vertex;i++) {
    		if(!visited[i]) {
    			dfs(graph,i,-1,dt,low,visited,time,articulationPoint);
    		}
    	}
    	for(int i=0;i<vertex;i++) {
    		if(articulationPoint[i]) {
    			System.out.println("Articulation point in this graph is: "+i);
    		}
    	}
		
	}

    
	private static void dfs(ArrayList<Edge>[] graph, int curr, int parent, int[] dt, int[] low, boolean[] visited, int time,
			boolean[] articulationPoint) {
		visited[curr]=true;
		dt[curr]= low[curr]= ++time;
		int children=0;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e=graph[curr].get(i);
			int neighbour=e.dest;
			if(parent== neighbour) {
				continue;
			}else if(visited[neighbour]) {
				low[curr]=Math.min(low[curr], dt[neighbour]);
			}else {
				dfs(graph, neighbour, curr, dt, low, visited, time, articulationPoint);
				low[curr]=Math.min(low[curr], low[neighbour]);
				if(dt[curr]<= low[neighbour] && parent!=-1) {
					articulationPoint[curr]= true;
				}
				children++;
			}
		}
		if(parent== -1 && children>1) {
			articulationPoint[curr]=true;
		}
		
	}
	public static void main(String[] args) {
        int vertex=5;
        ArrayList<Edge> graph[] =new ArrayList[vertex];
        
        createGraph(graph);
        getArticulationPoints(graph,vertex);
    }



	

}
