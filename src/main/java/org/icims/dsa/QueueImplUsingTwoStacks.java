package org.icims.dsa;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueImplUsingTwoStacks {
    static class QueueUsingStack{
    	static Stack<Integer> s1= new Stack<Integer>();
    	static Stack<Integer> s2= new Stack<Integer>();

    	public static boolean isEmpty() {
    		return s1.isEmpty();
    	}
    	
    	public static void add(int data) {
    		while(!s1.isEmpty()) {
    			s2.push(s1.pop());
    		}
    		s1.push(data);
    		
    		while(!s2.isEmpty()) {
    			s1.push(s2.pop());
    		}
    	}
    	public static int remove() {
    		if(s1.isEmpty()) {
    			System.out.println(" queue is empty");
    			return -1;
    			
    		}
    		return s1.pop();
    	}
    	public static int peek() {
    		if(s1.isEmpty()) {
    			System.out.println(" queue is empty");
    			return -1;
    			
    		}
    		return s1.peek();
    	}
    	
      
    }
    public static void main(String[] args) {
    // Queue queue= new Queue();
    //Queue<Integer> queue= new ArrayDeque<Integer>();
    	QueueUsingStack queue=new QueueUsingStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
        System.out.println("queue is:"+queue.peek());
    }
}
