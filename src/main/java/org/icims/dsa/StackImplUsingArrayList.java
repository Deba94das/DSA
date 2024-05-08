package org.icims.dsa;

import java.util.ArrayList;

/**
 * Stack implementation using ArrayList
 */
public class StackImplUsingArrayList {
    public static class Stack{
      static ArrayList<Integer> al=new ArrayList<Integer>();

        public static boolean isEmpty(){
            return al.size() == 0;
        }
        public static void push(int data){
            al.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            return al.remove(al.size()-1);
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
          return al.get(al.size()-1);
        }

    }

    public static void main(String[] args) {
     Stack s = new Stack();
     s.push(1);
     s.push(2);
     s.push(3);
     s.push(4);

     while(!s.isEmpty()){
         System.out.print(s.peek()+" ");
         s.pop();
     }
    }
}
