package org.icims.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindSCCUsingKosarajuAlg {
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

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
       
    }
  public static void kosarajuAlgo(ArrayList<Edge>[] graph,int vertex) {
	  
	  //step-1, Time Complexity O(V+E)
	  Stack<Integer> stack=new Stack<Integer>();
	  boolean visited[]= new boolean[vertex];
	  for(int i=0;i<vertex;i++) {
		  if(!visited[i]) {
			  topologicalSort(graph,i,visited,stack);
		  }
	  }
	  
	  //step-2, Time Complexity O(V+E)
	  ArrayList<Edge> transposeGraph[]= new ArrayList[vertex];
	  for(int i=0;i<graph.length;i++) {
		  visited[i]= false;
		  transposeGraph[i]= new ArrayList<Edge>();
	  }
	  for(int i=0;i<vertex;i++) {
		  for(int j=0;j<graph[i].size();j++) {
			  Edge e= graph[i].get(j);
			  transposeGraph[e.dest].add(new Edge(e.dest, e.src));
		  }
	  }
	  
	  //step-3, Time Complexity O(V+E)
	  while(!stack.isEmpty()) {
		  int curr=stack.pop();
		  if(!visited[curr]) {
			   dfs(transposeGraph,curr,visited);
			  //System.out.print("SCC is:"+dfs);
			  System.out.println();
		  }
	  }
	  
  }

    private static void dfs(ArrayList<Edge>[] transposeGraph, int curr, boolean[] visited) {

    	visited[curr]= true;
		/*
		 * StringBuffer scc=new StringBuffer(); scc.append(curr);
		 */
    	System.out.print(curr+ " ");
    	for (int i=0;i<transposeGraph[curr].size();i++) {
    		Edge e=transposeGraph[curr].get(i);
    		if(!visited[e.dest]) {
    			dfs(transposeGraph,e.dest,visited);
    		}
    	}
		//return scc.toString();
}
	private static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {

    	visited[curr] = true;
    	for(int i=0;i<graph[curr].size();i++) {
    		Edge e=graph[curr].get(i);
    		if(!visited[e.dest]) {
    			topologicalSort(graph, e.dest, visited, stack);
    		}
    	}
    	stack.push(curr);
}
	public static void main(String[] args) {
        int vertex=5;
        ArrayList<Edge> graph[] =new ArrayList[vertex];
        
        createGraph(graph);
        kosarajuAlgo(graph,vertex);
    }

}
